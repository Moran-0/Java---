package database;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Types;

import javax.swing.JOptionPane;

import com.mysql.cj.jdbc.exceptions.MysqlDataTruncation;

/**
 * 完成库存更新等相关操作
 * @author 可恶
 *
 */
public class StockUpdate {
	
	/**
	 * 需求登记
	 * @param connection
	 * @param devId
	 * @param depId
	 * @param needNum
	 * @param startDate
	 */
	public void needRecord(Connection connection,String devId,String depId,Integer needNum,String startDate) {
		CallableStatement call;
		Integer isSuc;
		String strSql = "{call needRecord(?,?,?,?,?)}";
		
		try {
			call = connection.prepareCall(strSql);
			call.registerOutParameter(5, Types.INTEGER);//存储过程的输出参数
			call.setString(1, devId);
			call.setString(2, depId);
			call.setInt(3, needNum);
			call.setString(4, startDate);
			call.execute(); 
			isSuc = call.getInt(5);
			
			if (isSuc == 0)
				JOptionPane.showMessageDialog(null, "需求登记失败", "警告", JOptionPane.WARNING_MESSAGE);
			else
				JOptionPane.showMessageDialog(null, "需求登记成功", "通知", JOptionPane.WARNING_MESSAGE);
		} 
		catch (SQLIntegrityConstraintViolationException e) {
			JOptionPane.showMessageDialog(null, "数据不符合约束", "警告", JOptionPane.WARNING_MESSAGE);
		}catch (MysqlDataTruncation e) {
			JOptionPane.showMessageDialog(null, "数据错误", "警告", JOptionPane.WARNING_MESSAGE);
		}
		catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "请检查输入", "警告", JOptionPane.WARNING_MESSAGE);
		}
	}
	
	/**
	 * 设备采购
	 * @param connection
	 * @param devId
	 * @param depId
	 * @param pcDate
	 * @param empId
	 */
	public void decPc(Connection connection,String devId,String depId,String pcDate,String empId) {
		CallableStatement call;
		Integer isSuc;
		String strSql = "{call purchaseDev(?,?,?,?,?)}";
		
		try {
			call = connection.prepareCall(strSql);
			call.registerOutParameter(5, Types.INTEGER);//存储过程的输出参数
			call.setString(1, devId);
			call.setString(2, depId);
			call.setString(3, pcDate);
			call.setString(4, empId);
			call.execute();
			isSuc = call.getInt(5);
			if (isSuc == 0)
				JOptionPane.showMessageDialog(null, "设备无采购需求", "警告", JOptionPane.WARNING_MESSAGE);
			else
				JOptionPane.showMessageDialog(null, "设备采购成功", "通知", JOptionPane.WARNING_MESSAGE);
		}catch (SQLIntegrityConstraintViolationException e) {
			JOptionPane.showMessageDialog(null, "数据不符合约束", "警告", JOptionPane.WARNING_MESSAGE);
		}catch (MysqlDataTruncation e) {
			JOptionPane.showMessageDialog(null, "数据错误", "警告", JOptionPane.WARNING_MESSAGE);
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "请检查输入", "警告", JOptionPane.WARNING_MESSAGE);
		}
		
	}
	
	/**
	 * 设备入库
	 * @param connection
	 * @param devId
	 * @param inDate
	 * @param empId
	 */
	public void inStock(Connection connection,String devId,String inDate,String empId) {
		CallableStatement call;
		Integer isSuc;
		String strSql = "{call inStock(?,?,?,?)}";
		
		try {
			call = connection.prepareCall(strSql);
			call.registerOutParameter(4, Types.INTEGER);//存储过程的输出参数
			call.setString(1, devId);
			call.setString(2, inDate);
			call.setString(3, empId);
			call.execute();
			isSuc = call.getInt(4);
			if (isSuc == 0)
				JOptionPane.showMessageDialog(null, "设备未采购", "警告", JOptionPane.WARNING_MESSAGE);
			else
				JOptionPane.showMessageDialog(null, "设备入库成功", "通知", JOptionPane.WARNING_MESSAGE);
		}catch (SQLIntegrityConstraintViolationException e) {
			JOptionPane.showMessageDialog(null, "数据不符合约束", "警告", JOptionPane.WARNING_MESSAGE);
		}catch (MysqlDataTruncation e) {
			JOptionPane.showMessageDialog(null, "数据错误", "警告", JOptionPane.WARNING_MESSAGE);
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "请检查输入", "警告", JOptionPane.WARNING_MESSAGE);
		}
		
	}
	
	/**
	 * 设备出库
	 * @param connection
	 * @param devId
	 * @param depId
	 * @param outNum
	 * @param outDate
	 */
	public void outStock(Connection connection,String devId,String depId,Integer outNum,String outDate) {
		CallableStatement call;
		Integer isSuc;
		String strSql = "{call outStock(?,?,?,?,?)}";
		
		try {
			call = connection.prepareCall(strSql);
			call.registerOutParameter(5, Types.INTEGER);//存储过程的输出参数
			call.setString(1, devId);
			call.setString(2, depId);
			call.setInt(3, outNum);
			call.setString(4, outDate);
			call.execute();
			isSuc = call.getInt(5);
			
			if (isSuc == 0)
				JOptionPane.showMessageDialog(null, "设备出库失败，库存不足！", "警告", JOptionPane.WARNING_MESSAGE);
			else
				JOptionPane.showMessageDialog(null, "设备出库成功", "通知", JOptionPane.WARNING_MESSAGE);
		} 
		catch (SQLIntegrityConstraintViolationException e) {
			JOptionPane.showMessageDialog(null, "数据不符合约束", "警告", JOptionPane.WARNING_MESSAGE);
		}catch (MysqlDataTruncation e) {
			JOptionPane.showMessageDialog(null, "数据错误", "警告", JOptionPane.WARNING_MESSAGE);
		}
		catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "请检查输入", "警告", JOptionPane.WARNING_MESSAGE);
		}
	}
	
	/**
	 * 设备还库
	 * @param connection
	 * @param devId
	 * @param depId
	 * @param backDate
	 * @param empId
	 */
	public void backStock(Connection connection,String devId,String depId,String backDate,String empId) {
		CallableStatement call;
		Integer isSuc;
		String strSql = "{call backStock(?,?,?,?,?)}";
		
		try {
			call = connection.prepareCall(strSql);
			call.registerOutParameter(5, Types.INTEGER);//存储过程的输出参数
			call.setString(1, devId);
			call.setString(2, depId);
			call.setString(3, backDate);
			call.setString(4, empId);
			call.execute();
			isSuc = call.getInt(5);
			if (isSuc == 0)
				JOptionPane.showMessageDialog(null, "设备无出库记录，无法还库！", "警告", JOptionPane.WARNING_MESSAGE);
			else
				JOptionPane.showMessageDialog(null, "设备还库成功", "通知", JOptionPane.WARNING_MESSAGE);
		}catch (SQLIntegrityConstraintViolationException e) {
			JOptionPane.showMessageDialog(null, "数据不符合约束", "警告", JOptionPane.WARNING_MESSAGE);
		}catch (MysqlDataTruncation e) {
			JOptionPane.showMessageDialog(null, "数据错误", "警告", JOptionPane.WARNING_MESSAGE);
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "请检查输入", "警告", JOptionPane.WARNING_MESSAGE);
		}
		
	}
}
