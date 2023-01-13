package database;
import java.sql.*;

import javax.swing.JOptionPane;

/**
 * 登录连接数据库
 * @author 可恶
 *
 */
public class ConnectDatabase {
	
	public Connection connection;
	
	/**
	 * 连接数据库
	 * @param user 用户名
	 * @param password 密码
	 * @return 
	 */
	public int connect(String user,String password) {
		
		final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
		final String URL = "jdbc:mysql://localhost:3306/course_design?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";
		final String USER1 = "root";
		final String USER2 = "normal";
		final String PASSWORD1 = "cyf0709fzy";
		final String PASSWORD2 = "123456789";
		
		if (!(USER1.equals(user)||USER2.equals(user))) //用户名错误
			return 0;
		if ((user.equals(USER1)&&!password.equals(PASSWORD1))||(user.equals(USER2)&&!password.equals(PASSWORD2)))
			return 1;//密码错误
		
		try {
			/*加载驱动*/
			Class.forName(JDBC_DRIVER);
			/*连接操作*/
			connection = DriverManager.getConnection(URL,user,password);//待修改
			//connection.close();
			
		} catch (ClassNotFoundException e) {
			// 处理异常
			JOptionPane.showMessageDialog(null, "驱动加载失败！", "警告", JOptionPane.WARNING_MESSAGE);
			e.printStackTrace();
			return 2;
		
		}catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "数据库连接异常！", "警告", JOptionPane.WARNING_MESSAGE);
			e.printStackTrace();
			return 3;
		}
		
		return -1;
		
	}

}