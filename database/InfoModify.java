package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

import javax.swing.JOptionPane;
import java.sql.CallableStatement;

/**
 * 修改信息
 * @author 可恶
 *
 */
public class InfoModify {
	
	/**
	 * 更新员工信息
	 * @param connection
	 * @param empId
	 * @param newInfo
	 * @param index
	 */
	public void modifyEmp(Connection connection,String empId,String newInfo,int index) {
		PreparedStatement preSql;
		boolean isSuc = true;
		int affectedRows = 0;
		String strSql = "update employee set emp_phone = ? where emp_id = ?";
		if (index == 1)
			strSql = "update employee set depart_id = ? where emp_id = ?";
		
		try {
			preSql = connection.prepareStatement(strSql);
			preSql.setString(1, newInfo);
			preSql.setString(2,empId);
			affectedRows = preSql.executeUpdate();
		} catch (SQLException e) {
			isSuc = false;
			JOptionPane.showMessageDialog(null, "更新失败", "警告", JOptionPane.WARNING_MESSAGE);
		}
		if (isSuc&&affectedRows!=0)
			JOptionPane.showMessageDialog(null, "更新成功", "通知", JOptionPane.WARNING_MESSAGE);
	}
	
	
	/**
	 * 修改供应商信息
	 * @param connection
	 * @param vendId
	 * @param newInfo
	 * @param index 判断修改数据
	 */
	public void modifyVend(Connection connection,String vendId,String newInfo,int index) {
		PreparedStatement preSql;
		boolean isSuc = true;
		int affectedRows = 0;
		String strSql = "update vendors set vendor_name = ? where vendor_id = ?";
		if (index == 1)
			strSql = "update vendors set vendor_address = ? where vendor_id = ?";
		
		try {
			preSql = connection.prepareStatement(strSql);
			preSql.setString(1, newInfo);
			preSql.setString(2,vendId);
			affectedRows = preSql.executeUpdate();
			System.out.print(affectedRows);
		} catch (SQLException e) {
			isSuc = false;
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "更新失败", "警告", JOptionPane.WARNING_MESSAGE);
		}
		if (isSuc&&affectedRows!=0)
			JOptionPane.showMessageDialog(null, "更新成功", "通知", JOptionPane.WARNING_MESSAGE);
		else
			JOptionPane.showMessageDialog(null, "更新失败", "警告", JOptionPane.WARNING_MESSAGE);
	}
	
	
	/**
	 * 需求注销
	 * @param connection
	 * @param devId
	 * @param depId
	 * @param startDate
	 */
	public void delNeed(Connection connection,String devId,String depId,String startDate) {
		CallableStatement call;
		int isCplt;
		String strSql = "{call delNeed(?,?,?,?)}";
		
		try {
			call = connection.prepareCall(strSql);
			call.registerOutParameter(4, Types.INTEGER);
			call.setString(1,devId);
			call.setString(2,depId);
			call.setString(3,startDate);
			call.execute();
			isCplt = call.getInt(4);
			if (isCplt == -1)
				JOptionPane.showMessageDialog(null, "无此需求", "警告", JOptionPane.WARNING_MESSAGE);
			else if (isCplt == 1)
				JOptionPane.showMessageDialog(null, "需求已完成，无法删除", "警告", JOptionPane.WARNING_MESSAGE);
			else
				JOptionPane.showMessageDialog(null, "需求撤销成功", "通知", JOptionPane.WARNING_MESSAGE);
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "输入数据异常", "警告", JOptionPane.WARNING_MESSAGE);
		}
	}

}
