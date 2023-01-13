package database;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.Arrays;
import java.util.Vector;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import com.mysql.cj.xdevapi.PreparableStatement;

public class InfoSelect {
	
	/**
	 * 查询所有设备的基本信息
	 * @param id
	 * @param connection
	 */
	public void deviceSelectAll(Connection connection,DefaultTableModel model) {
		
		Statement stmt;
		try {
			stmt = connection.createStatement();
			String select = "select * from devices";
			ResultSet res = stmt.executeQuery(select);
			boolean isFind = false;
			model.setRowCount(0);
			
			while (res.next()) {
				isFind = true;
				String devId = res.getString("device_id");
				String devName = res.getNString("device_name");
				Integer devPri = res.getInt("device_price");
				String vendId = res.getString("vendor_id");
				model.addRow(new Vector<>(Arrays.asList(devId,devName,devPri,vendId)));
				
			}
			if (!isFind) {
				JOptionPane.showMessageDialog(null, "设备表为空", "警告", JOptionPane.WARNING_MESSAGE);
			}
			res.close();
			stmt.close();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "查询异常", "警告", JOptionPane.WARNING_MESSAGE);
			e.printStackTrace();
		}
		
	}
	
	
	/**
	 * 查询设备id为deviceId的设备基本信息
	 * @param connection
	 * @param model 表格模式
	 * @param deviceId 设备id
	 */
	public void deviceSelect(Connection connection,DefaultTableModel model,String deviceId) {
		PreparedStatement preSql;
		ResultSet res;
		String sqlStr = "select * from devices where device_id = ?";
		
		try {
			preSql = connection.prepareStatement(sqlStr);
			preSql.setString(1, deviceId);
			res = preSql.executeQuery();
			boolean isFind = false;
			model.setRowCount(0);
			
			while (res.next()) {
				isFind = true;
				String devId = res.getString("device_id");
				String devName = res.getNString("device_name");
				Integer devPri = res.getInt("device_price");
				String vendId = res.getString("vendor_id");
				model.addRow(new Vector<>(Arrays.asList(devId,devName,devPri,vendId)));
			}
			if (!isFind) {
				JOptionPane.showMessageDialog(null, "设备不存在", "警告", JOptionPane.WARNING_MESSAGE);
			}
			res.close();
			preSql.close();
			
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "查询异常", "警告", JOptionPane.WARNING_MESSAGE);
			e.printStackTrace();
		}
	}
	
	
	/**
	 * 查询所有供应商的信息
	 * @param connection
	 * @param model
	 */
	public void vendSelectAll(Connection connection,DefaultTableModel model) {
		Statement stmt;
		try {
			stmt = connection.createStatement();
			String select = "select * from vendors";
			ResultSet res = stmt.executeQuery(select);
			boolean isFind = false;
			model.setRowCount(0);
			
			while (res.next()) {
				isFind = true;
				String vendId = res.getString("vendor_id");
				String vendName = res.getString("vendor_name");
				String vendAdr = res.getString("vendor_address");
				String vendCtr = res.getString("vendor_country");
				model.addRow(new Vector<>(Arrays.asList(vendId,vendName,vendAdr,vendCtr)));
				
			}
			if (!isFind) {
				JOptionPane.showMessageDialog(null, "供应商表为空", "警告", JOptionPane.WARNING_MESSAGE);
			}
			res.close();
			stmt.close();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "查询异常", "警告", JOptionPane.WARNING_MESSAGE);
			e.printStackTrace();
		}
		
	}
	
	
	/**
	 * 查询特定供应商
	 * @param connection
	 * @param model
	 * @param vendorId 供应商id
	 */
	public void vendSelect(Connection connection, DefaultTableModel model, String vendorId) {
		PreparedStatement preSql;
		ResultSet res;
		String sqlStr = "select * from vendors where vendor_id = ?";
		
		try {
			preSql = connection.prepareStatement(sqlStr);
			preSql.setString(1, vendorId);
			res = preSql.executeQuery();
			boolean isFind = false;
			model.setRowCount(0);//清空原表
			while (res.next()) {
				isFind = true;
				String vendId = res.getString("vendor_id");
				String vendName = res.getString("vendor_name");
				String vendAdr = res.getString("vendor_address");
				String vendCtr = res.getString("vendor_country");
				model.addRow(new Vector<>(Arrays.asList(vendId,vendName,vendAdr,vendCtr)));
			}
			if (!isFind) {
				JOptionPane.showMessageDialog(null, "供应商表不存在", "警告", JOptionPane.WARNING_MESSAGE);
			}
			res.close();
			preSql.close();
			
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "查询异常", "警告", JOptionPane.WARNING_MESSAGE);
			e.printStackTrace();
		}
		
	}

	
	/**
	 * 查询所有设备的综合信息
	 * @param connection
	 * @param model
	 */
	public void devAndVendSelectAll(Connection connection,DefaultTableModel model) {
		Statement stmt;
		try {
			stmt = connection.createStatement();
			String select = "select * from devAndVend";
			ResultSet res = stmt.executeQuery(select);
			boolean isFind = false;
			model.setRowCount(0);
			
			while (res.next()) {
				isFind = true;
				String devId = res.getString("device_id");
				String devName = res.getString("device_name");
				Integer devPri = res.getInt("device_price");
				String vendId = res.getString("vendor_id");
				String vendName = res.getString("vendor_name");
				String vendAdr = res.getString("vendor_address");
				String vendCtr = res.getString("vendor_country");
				model.addRow(new Vector<>(Arrays.asList(devId,devName,devPri,vendId,vendName,vendAdr,vendCtr)));
				
			}
			if (!isFind) {
				JOptionPane.showMessageDialog(null, "数据为空", "警告", JOptionPane.WARNING_MESSAGE);
			}
			res.close();
			stmt.close();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "查询异常", "警告", JOptionPane.WARNING_MESSAGE);
			e.printStackTrace();
		}
		
	}
	
	
	/**
	 * 查询某一特定设备的综合信息
	 * @param connection
	 * @param model
	 * @param deviceId 设备id
	 */
	public void devAndVendSelect(Connection connection, DefaultTableModel model,String deviceId) {
		PreparedStatement preSql;
		ResultSet res;
		String sqlStr = "select * from devAndVend where device_id = ?";
		
		try {
			preSql = connection.prepareStatement(sqlStr);
			preSql.setString(1,deviceId);
			res = preSql.executeQuery();
			boolean isFind = false;
			model.setRowCount(0);
			
			while (res.next()) {
				isFind = true;
				String devId = res.getString("device_id");
				String devName = res.getString("device_name");
				Integer devPri = res.getInt("device_price");
				String vendId = res.getString("vendor_id");
				String vendName = res.getString("vendor_name");
				String vendAdr = res.getString("vendor_address");
				String vendCtr = res.getString("vendor_country");
				model.addRow(new Vector<>(Arrays.asList(devId,devName,devPri,vendId,vendName,vendAdr,vendCtr)));
				
			}
			if (!isFind) {
				JOptionPane.showMessageDialog(null, "设备不存在", "警告", JOptionPane.WARNING_MESSAGE);
			}
			res.close();
			preSql.close();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "查询异常", "警告", JOptionPane.WARNING_MESSAGE);
			e.printStackTrace();
		}
	}
	
	/**
	 * 查询所有设备的库存信息（root）
	 * @param connection
	 * @param model
	 */
	public void devRmSelectAll(Connection connection,DefaultTableModel model) {
		Statement stmt;
		try {
			stmt = connection.createStatement();
			String select = "select * from devices_Remain order by all_num desc";
			ResultSet res = stmt.executeQuery(select);
			boolean isFind = false;
			model.setRowCount(0);
			
			while (res.next()) {
				isFind = true;
				String devId = res.getString("device_id");
				Integer remaNum = res.getInt("rema_num");
				Integer allNum = res.getInt("all_num");
				model.addRow(new Vector<>(Arrays.asList(devId,remaNum,allNum)));
				
			}
			if (!isFind) {
				JOptionPane.showMessageDialog(null, "库存表为空", "警告", JOptionPane.WARNING_MESSAGE);
			}
			res.close();
			stmt.close();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "查询异常", "警告", JOptionPane.WARNING_MESSAGE);
			e.printStackTrace();
		}
		
	}
	
	/**
	 * 查询特定设备的库存信息
	 * @param connection
	 * @param model
	 * @param deviceId
	 */
	public void devRmSelect(Connection connection, DefaultTableModel model, String deviceId) {
		PreparedStatement preSql;
		ResultSet res;
		String strSql = "select * from devices_remain where device_id = ? order by all_num desc";
		
		try {
			preSql = connection.prepareStatement(strSql);
			preSql.setString(1, deviceId);
			res = preSql.executeQuery();
			boolean isFind = false;
			model.setRowCount(0);
			
			while(res.next()) {
				isFind = true;
				String devId = res.getString("device_id");
				Integer remaNum = res.getInt("rema_num");
				Integer allNum = res.getInt("all_num");
				model.addRow(new Vector<>(Arrays.asList(devId,remaNum,allNum)));
			}
			if (!isFind) {
				JOptionPane.showMessageDialog(null, "设备不存在", "警告", JOptionPane.WARNING_MESSAGE);
			}
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "查询异常", "警告", JOptionPane.WARNING_MESSAGE);
			e.printStackTrace();
		}
		
	}
	
	/**
	 * 查询所有设备的库存详细信息
	 * @param connection
	 * @param model
	 */
	public void devRmNedSelectAll(Connection connection,DefaultTableModel model) {
		Statement stmt;
		try {
			stmt = connection.createStatement();
			String select = "select * from allInfoOfDev order by rema_num desc";
			ResultSet res = stmt.executeQuery(select);
			boolean isFind = false;
			model.setRowCount(0);
			
			while (res.next()) {
				isFind = true;
				String devId = res.getString("device_id");
				String devName = res.getString("device_name");
				Integer remaNum = res.getInt("rema_num");
				Integer allNum = res.getInt("all_num");
				Integer needNum = res.getInt("need_num");
				model.addRow(new Vector<>(Arrays.asList(devId,devName,remaNum,allNum,needNum)));
				
			}
			if (!isFind) {
				JOptionPane.showMessageDialog(null, "设备不存在", "警告", JOptionPane.WARNING_MESSAGE);
			}
			res.close();
			stmt.close();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "查询异常", "警告", JOptionPane.WARNING_MESSAGE);
			e.printStackTrace();
		}
	}
	
	/**
	 * 查找特定设备的详细库存信息
	 * @param connection
	 * @param model
	 * @param deviceId
	 */
	public void devRmNedSelect(Connection connection,DefaultTableModel model, String deviceId) {
		PreparedStatement preSql;
		ResultSet res;
		String strSql = "select * from allInfoOfDev where device_id = ? order by rema_num desc";
		
		try {
			preSql = connection.prepareStatement(strSql);
			preSql.setString(1, deviceId);
			res = preSql.executeQuery();
			boolean isFind = false;
			model.setRowCount(0);
			
			while(res.next()) {
				isFind = true;
				String devId = res.getString("device_id");
				String devName = res.getString("device_name");
				Integer remaNum = res.getInt("rema_num");
				Integer allNum = res.getInt("all_num");
				Integer needNum = res.getInt("need_num");
				model.addRow(new Vector<>(Arrays.asList(devId,devName,remaNum,allNum,needNum)));
			}
			if (!isFind) {
				JOptionPane.showMessageDialog(null, "设备不存在", "警告", JOptionPane.WARNING_MESSAGE);
			}
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "查询异常", "警告", JOptionPane.WARNING_MESSAGE);
			e.printStackTrace();
		}
	}
	
	
	
	/**
	 * 查询所有设备入库综合信息（root）
	 * @param connection
	 * @param model
	 */
	public void inDevInfoSelectAll(Connection connection,DefaultTableModel model) {
		Statement stmt;
		try {
			stmt = connection.createStatement();
			String select = "select * from inDevInfo order by in_date";
			ResultSet res = stmt.executeQuery(select);
			boolean isFind = false;
			model.setRowCount(0);
			
			while (res.next()) {
				isFind = true;
				String devId = res.getString("device_id");
				String devName = res.getString("device_name");
				String inDate = res.getString("in_date");
				Integer inNum = res.getInt("in_num");
				String empId = res.getString("emp_id");
				String empName = res.getString("emp_name");
				String empPhone = res.getString("emp_phone");
				String departId = res.getString("depart_id");
				model.addRow(new Vector<>(Arrays.asList(devId,devName,inDate,inNum,empId,empName,empPhone,departId)));
				
			}
			if (!isFind) {
				JOptionPane.showMessageDialog(null, "入库信息为空", "警告", JOptionPane.WARNING_MESSAGE);
			}
			res.close();
			stmt.close();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "查询异常", "警告", JOptionPane.WARNING_MESSAGE);
			e.printStackTrace();
		}
	}
	
	
	/**
	 * 查找特定设备的入库综合信息(root)
	 * @param connection
	 * @param model
	 * @param deviceId
	 */
	public void inDevInfoSelect(Connection connection,DefaultTableModel model,String deviceId) {
		PreparedStatement preSql;
		ResultSet res;
		String strSql = "select * from inDevInfo where device_id = ? order by in_date";
		
		try {
			preSql = connection.prepareStatement(strSql);
			preSql.setString(1,deviceId);
			res = preSql.executeQuery();
			boolean isFind = false;
			
			while(res.next()) {
				isFind = true;
				String devId = res.getString("device_id");
				String devName = res.getString("device_name");
				String inDate = res.getString("in_date");
				Integer inNum = res.getInt("in_num");
				String empId = res.getString("emp_id");
				String empName = res.getString("emp_name");
				String empPhone = res.getString("emp_phone");
				String departId = res.getString("depart_id");
				model.addRow(new Vector<>(Arrays.asList(devId,devName,inDate,inNum,empId,empName,empPhone,departId)));
			}
			if (!isFind) {
				JOptionPane.showMessageDialog(null, "无此设备入库信息", "警告", JOptionPane.WARNING_MESSAGE);
			}
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "查询异常", "警告", JOptionPane.WARNING_MESSAGE);
			e.printStackTrace();
		}
		
	}
	
	
	/**
	 * 查询所有设备的综合出库信息
	 * @param connection
	 * @param model
	 */
	public void outDevInfoSelectAll(Connection connection ,DefaultTableModel model) {
		Statement stmt;
		try {
			stmt = connection.createStatement();
			String select = "select * from outDevInfo order by out_date";
			ResultSet res = stmt.executeQuery(select);
			boolean isFind = false;
			model.setRowCount(0);
			
			while (res.next()) {
				isFind = true;
				String devId = res.getString("device_id");
				String devName = res.getString("device_name");
				String outDate = res.getString("out_date");
				Integer outNum = res.getInt("out_num");
				String depId = res.getString("depart_id");
				String depName = res.getString("depart_name");
				Integer depPerson = res.getInt("depart_per");
				String depWork = res.getString("depart_work");
				model.addRow(new Vector<>(Arrays.asList(devId,devName,outDate,outNum,depId,depName,depPerson,depWork)));
				
			}
			if (!isFind) {
				JOptionPane.showMessageDialog(null, "出库信息为空", "警告", JOptionPane.WARNING_MESSAGE);
			}
			res.close();
			stmt.close();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "查询异常", "警告", JOptionPane.WARNING_MESSAGE);
			e.printStackTrace();
		}
	}
	
	/**
	 * 查询特定设备的出库详细信息
	 * @param connection
	 * @param model
	 * @param deviceId
	 */
	public void outDevInfoSelect(Connection connection, DefaultTableModel model, String deviceId) {
		PreparedStatement preSql;
		ResultSet res;
		String strSql = "select * from outDevInfo where device_id = ? order by out_date";
		
		try {
			preSql = connection.prepareStatement(strSql);
			preSql.setString(1,deviceId);
			res = preSql.executeQuery();
			boolean isFind = false;
			
			while (res.next()) {
				isFind = true;
				String devId = res.getString("device_id");
				String devName = res.getString("device_name");
				String outDate = res.getString("out_date");
				Integer outNum = res.getInt("out_num");
				String depId = res.getString("depart_id");
				String depName = res.getString("depart_name");
				Integer depPerson = res.getInt("depart_per");
				String depWork = res.getString("depart_work");
				model.addRow(new Vector<>(Arrays.asList(devId,devName,outDate,outNum,depId,depName,depPerson,depWork)));
				
			}
			if (!isFind) {
				JOptionPane.showMessageDialog(null, "无该设备出库信息", "警告", JOptionPane.WARNING_MESSAGE);
			}
			res.close();
			preSql.close();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "查询异常", "警告", JOptionPane.WARNING_MESSAGE);
			e.printStackTrace();
		}
	}
	
	public void backDevInfoSelectAll(Connection connection ,DefaultTableModel model) {
		Statement stmt;
		try {
			stmt = connection.createStatement();
			String select = "select * from backDevInfo order by back_date";
			ResultSet res = stmt.executeQuery(select);
			boolean isFind = false;
			model.setRowCount(0);
			
			while (res.next()) {
				isFind = true;
				String devId = res.getString("device_id");
				String devName = res.getString("device_name");
				String backDate = res.getString("back_date");
				Integer backNum = res.getInt("back_num");
				String depId = res.getString("depart_id");
				String depName = res.getString("depart_name");
				Integer depPerson = res.getInt("depart_per");
				String depWork = res.getString("depart_work");
				model.addRow(new Vector<>(Arrays.asList(devId,devName,backDate,backNum,depId,depName,depPerson,depWork)));
				
			}
			if (!isFind) {
				JOptionPane.showMessageDialog(null, "还库信息为空", "警告", JOptionPane.WARNING_MESSAGE);
			}
			res.close();
			stmt.close();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "查询异常", "警告", JOptionPane.WARNING_MESSAGE);
			e.printStackTrace();
		}
	}
	
	/**
	 * 查询还库信息
	 * @param connection
	 * @param model
	 * @param deviceId
	 */
	public void backDevInfoSelect(Connection connection, DefaultTableModel model, String deviceId) {
		PreparedStatement preSql;
		ResultSet res;
		String strSql = "select * from backDevInfo where device_id = ? order by back_date";
		
		try {
			preSql = connection.prepareStatement(strSql);
			preSql.setString(1,deviceId);
			res = preSql.executeQuery();
			boolean isFind = false;
			
			while (res.next()) {
				isFind = true;
				String devId = res.getString("device_id");
				String devName = res.getString("device_name");
				String backDate = res.getString("back_date");
				Integer backNum = res.getInt("back_num");
				String depId = res.getString("depart_id");
				String depName = res.getString("depart_name");
				Integer depPerson = res.getInt("depart_per");
				String depWork = res.getString("depart_work");
				model.addRow(new Vector<>(Arrays.asList(devId,devName,backDate,backNum,depId,depName,depPerson,depWork)));
				
			}
			if (!isFind) {
				JOptionPane.showMessageDialog(null, "无此设备还库信息", "警告", JOptionPane.WARNING_MESSAGE);
			}
			res.close();
			preSql.close();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "查询异常", "警告", JOptionPane.WARNING_MESSAGE);
			e.printStackTrace();
		}
	}
	
	/**
	 * 信息统计
	 * @param connection
	 * @return
	 */
	public int[] statisGet(Connection connection) {
		CallableStatement call;
		int[] Num = new int[4];
		String strSql = "{call statisGet(?,?,?,?)}";
		try {
			call = connection.prepareCall(strSql);
			call.registerOutParameter(1, Types.INTEGER);
			call.registerOutParameter(2, Types.INTEGER);
			call.registerOutParameter(3, Types.INTEGER);
			call.registerOutParameter(4, Types.INTEGER);//存储过程的输出参数
			call.execute();
			Num[0] = call.getInt(1);
			Num[1] = call.getInt(2);
			Num[2] = call.getInt(3);
			Num[3] = call.getInt(4);
			
			
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "查询异常", "警告", JOptionPane.WARNING_MESSAGE);
			e.printStackTrace();
		}
		return Num;
		
	}
	
}
