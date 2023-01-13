package ui;

import database.ConnectDatabase;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

import javax.swing.border.LineBorder;

@SuppressWarnings("serial")
public class Landing extends JFrame {

	private JPanel landPane;
	RootInterface rootInterface;
	NormalInterface normalInterface;
	String[] list;

	/**
	 * 运行程序
	 */
	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Landing frame = new Landing();
					frame.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	

	/**
	 * 构造器，对登录界面进行初始化
	 */
	public Landing() {
		
		setTitle("登录界面");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ImageIcon landIcon = new ImageIcon("IconImage\\Box.png");
		setIconImage(landIcon.getImage());
		setBounds(100, 100, 700, 500);
		list = new String[] {"普通用户","仓库管理员"};
		
		/*面板*/
		landPane = new JPanel();
		JPanel pane1 = new JPanel();
		JPanel pane2 = new JPanel();
		JPanel pane3 = new JPanel();
		JPanel pane4 = new JPanel();
		pane4.setToolTipText("");
		
		
		
		JLabel label1 = new JLabel("企业设备库存管理系统");
		JLabel label2 = new JLabel("用 户 名 ：");
		label2.setHorizontalAlignment(SwingConstants.RIGHT);
		JLabel label3 = new JLabel("密 码 ：");
		
		
		
		JButton button = new JButton("登 录");
		button.setLocation(249,20);
		button.setFont(new Font("微软雅黑", Font.BOLD, 20));
		button.setSize(new Dimension(160, 56));
		
		
		
		//JComboBox<String> userField = new JComboBox<>(list);
		JComboBox userField = new JComboBox(list);
		userField.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		userField.setMaximumRowCount(2);
		userField.setFont(new Font("微软雅黑", Font.PLAIN, 30));
		JPasswordField  passwordField = new JPasswordField();
		passwordField.setBorder(new LineBorder(new Color(171, 173, 179), 2, true));
		passwordField.setToolTipText("请输入密码");
		passwordField.setFont(new Font("微软雅黑", Font.PLAIN, 30));
		
		
		GridLayout gl_landPane = new GridLayout(0,1);
		gl_landPane.setHgap(10);
		gl_landPane.setVgap(20);
		landPane.setLayout(gl_landPane);
		landPane.setBorder(new EmptyBorder(5, 20, 5, 30));
		setContentPane(landPane);
		
		
		
		pane1.setBackground(SystemColor.menu);
		pane1.setLayout(new BorderLayout(0, 0));
		label1.setHorizontalAlignment(SwingConstants.CENTER);
		label1.setFont(new Font("黑体", Font.BOLD, 30));
		pane1.add(label1, BorderLayout.CENTER);
		
		
		GridLayout gl_pane2 = new GridLayout(0,2);
		gl_pane2.setHgap(20);
		pane2.setLayout(gl_pane2);
		label2.setFont(new Font("微软雅黑", Font.PLAIN, 25));
		pane2.add(label2);
		userField.setPreferredSize(new Dimension(200,4000));;
		pane2.add(userField);
		
		GridLayout gl_pane3 = new GridLayout(0,2);
		gl_pane3.setHgap(20);
		pane3.setLayout(gl_pane3);	
		label3.setFont(new Font("微软雅黑", Font.PLAIN, 25));
		label3.setHorizontalAlignment(SwingConstants.RIGHT);
		pane3.add(label3);
		pane3.add(passwordField);
		
		
		pane4.setLayout(null);
		
		
		/*添加登录事件*/
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int index = userField.getSelectedIndex();
				String user= "normal";
				if (index == 1)
					user = "root";
				String password = new String(passwordField.getPassword());
				ConnectDatabase cnctDataBs = new ConnectDatabase();
				int resOfCon = cnctDataBs.connect(user, password);
				
				/*处理连接情况*/
				if (resOfCon == -1) {
					dispose();//关闭窗体
					//打开主界面
					if (index == 1)
						launchRoot(cnctDataBs.connection);
					else
						launchNormal(cnctDataBs.connection);
						
				}
				else if (resOfCon == 0){
					//用户名错误
					JOptionPane.showMessageDialog(null, "用户名错误！", "警告", JOptionPane.WARNING_MESSAGE);
				}
				else if (resOfCon == 1) {
					//密码错误
					//passwordField.setEchoChar((char)0);
					JOptionPane.showMessageDialog(null, "密码错误！", "警告", JOptionPane.WARNING_MESSAGE);
				}
				
			}
		});
		
		pane4.add(button);
		
		
		landPane.add(pane1);
		landPane.add(pane2);
		landPane.add(pane3);
		landPane.add(pane4);
	}
	
	/**
	 * 运行主界面root用户
	 */
	public void launchRoot(Connection connection) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					rootInterface = new RootInterface();
					rootInterface.setConnect(connection);
					rootInterface.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	/**
	 * 运行主界面（normal）
	 * @param connection
	 */
	public void launchNormal(Connection connection) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					normalInterface = new NormalInterface();
					normalInterface.setConnect(connection);
					normalInterface.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
	}

}
