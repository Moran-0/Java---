package ui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTabbedPane;
import java.awt.Font;
import java.awt.Image;
import java.awt.BorderLayout;
import java.awt.Rectangle;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.border.TitledBorder;
import javax.swing.Icon;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.JLayeredPane;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.SystemColor;
import java.util.Vector;

import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import database.InfoSelect;

import javax.swing.JScrollPane;
import javax.swing.JCheckBox;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.awt.event.ActionEvent;
import javax.swing.ScrollPaneConstants;
import java.awt.Toolkit;
import javax.swing.DropMode;
/**
 * 普通用户的仓库管理系统界面
 * @author 可恶
 *
 */
public class NormalInterface extends JFrame {
	
	Connection connection;//数据库连接
	
	private JPanel contentPane;
	private JTextField textField;
	private JTable table;
	private JTabbedPane tabbedPane;
	private JPanel panel;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLayeredPane panel_1;
	private JComboBox comboBox;
	private JCheckBox ckbCheckBox;
	private JButton btnNewButton;
	
	private DefaultTableModel devModel;//设备
	private DefaultTableModel vendModel;//供应商
	private DefaultTableModel devRmModel;//库存
	private DefaultTableModel devAndVndModel;//连接查询设备基本信息和供应商信息
	private DefaultTableModel devRmANdModel;//设备基本信息，库存和需求
	private DefaultTableModel devInModell;//入库综合信息

	/**
	 * 创建窗体
	 */
	public NormalInterface() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("IconImage\\BugBoch.png"));
		
		setResizable(false);
		setTitle("设备库存管理系统（normal）");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(new Rectangle(200, 100, 1050, 700));
		
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		/*多层面板---------------------*/
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setUI(new MyTabbedPaneUI_2());
		tabbedPane.setForeground(SystemColor.desktop);
		tabbedPane.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		tabbedPane.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
		tabbedPane.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		
		contentPane.add(tabbedPane);//
		
		/*主界面面板----------------*/
		panel = new JPanel();
		panel.setForeground(new Color(255, 255, 255));
		panel.setBorder(null);
		tabbedPane.addTab("主界面", (Icon) null, panel, null);
		tabbedPane.setBackgroundAt(0, Color.LIGHT_GRAY);
		panel.setLayout(null);
		
		lblNewLabel_1 = new JLabel("企业设备库存管理系统");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setFont(new Font("宋体", Font.PLAIN, 45));
		lblNewLabel_1.setBounds(0, 0, this.getWidth(), this.getHeight());
		panel.add(lblNewLabel_1);
		
		lblNewLabel = new JLabel();
		lblNewLabel.setFont(new Font("幼圆", Font.PLAIN, 30));
		lblNewLabel.setBounds(0, 0,this.getWidth(), this.getHeight());
		ImageIcon imageIcon = new ImageIcon("IconImage\\vlada-cXahzradqMQ-unsplash.jpg");
		imageIcon.setImage(imageIcon.getImage().getScaledInstance(this.getWidth(),this.getHeight(), Image.SCALE_SMOOTH));
		lblNewLabel.setIcon(imageIcon);
		panel.add(lblNewLabel);
		
		
		/*查询界面面板----------------------------------*/
		panel_1 = new JLayeredPane();
		panel_1.setBorder(null);
		tabbedPane.addTab("查询信息", null, panel_1, null);
		ImageIcon imageIcon2 = new ImageIcon("IconImage\\black-1072366_640.jpg");
		imageIcon2.setImage(imageIcon2.getImage().getScaledInstance(this.getWidth(), this.getHeight(), Image.SCALE_SMOOTH));
		
		comboBox = new JComboBox();
		comboBox.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		comboBox.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		comboBox.setBackground(new Color(255, 255, 255));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"查询设备基本信息","查询供应商信息", "查询设备和供应商信息"}));
		comboBox.setBounds(60, 112, 260, 60);
		panel_1.add(comboBox);
		
		textField = new JTextField();
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setCaretColor(new Color(0, 0, 0));
		textField.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		textField.setFont(new Font("宋体", Font.PLAIN, 30));
		textField.setForeground(new Color(0, 0, 0));
		textField.setBounds(408, 112, 160, 60);
		panel_1.add(textField);
		textField.setColumns(10);
		
		/*复选框*/
		ckbCheckBox = new JCheckBox("查找全部");
		ckbCheckBox.setHorizontalAlignment(SwingConstants.CENTER);
		ckbCheckBox.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		ckbCheckBox.setFont(new Font("宋体", Font.BOLD, 20));
		ckbCheckBox.setBounds(833, 114, 160, 60);
		panel_1.add(ckbCheckBox);
		
		/*查询按钮*/
		btnNewButton = new JButton("查询");
		addEvent();
				
		btnNewButton.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		btnNewButton.setOpaque(false);
		btnNewButton.setFont(new Font("宋体", Font.BOLD, 25));
		btnNewButton.setBounds(626, 112, 160, 60);
		panel_1.add(btnNewButton);
		
		
		/*背景*/
		
		
		
		/*表格模式*/
		//查询设备信息
		devModel = new DefaultTableModel();
		devModel.addColumn("设备Id", new Vector<Integer>());
		devModel.addColumn("设备名", new Vector<Integer>());
		devModel.addColumn("设备价格", new Vector<Integer>());
		devModel.addColumn("供应商Id", new Vector<Integer>());
		
		//查询供应商信息
		vendModel = new DefaultTableModel();
		vendModel.addColumn("供应商Id", new Vector<Integer>());
		vendModel.addColumn("供应商名", new Vector<Integer>());
		vendModel.addColumn("供应商地址", new Vector<Integer>());
		vendModel.addColumn("所属国家", new Vector<Integer>());
				
		//查询设备基本信息和供应商消息
		devAndVndModel = new DefaultTableModel();
		devAndVndModel.addColumn("设备Id", new Vector<Integer>());
		devAndVndModel.addColumn("设备名", new Vector<Integer>());
		devAndVndModel.addColumn("设备价格", new Vector<Integer>());
		devAndVndModel.addColumn("供应商Id", new Vector<Integer>());
		devAndVndModel.addColumn("供应商名", new Vector<Integer>());
		devAndVndModel.addColumn("供应商地址", new Vector<Integer>());
		devAndVndModel.addColumn("所属国家", new Vector<Integer>());
		
		//查询库存信息
		devRmModel = new DefaultTableModel();
		devRmModel.addColumn("设备Id", new Vector<Integer>());
		devRmModel.addColumn("库存数量", new Vector<Integer>());
		devRmModel.addColumn("总数量", new Vector<Integer>());
		
		//查询设备基本信息，库存信息，和需求信息
		devRmANdModel = new DefaultTableModel();
		devRmANdModel.addColumn("设备Id", new Vector<Integer>());
		devRmANdModel.addColumn("设备名", new Vector<Integer>());
		devRmANdModel.addColumn("库存数量", new Vector<Integer>());
		devRmANdModel.addColumn("总数", new Vector<Integer>());
		devRmANdModel.addColumn("需求数量", new Vector<Integer>());
		
		//查询入库设备基本信息，入库信息，和入库员工信息
		devInModell = new DefaultTableModel();
		devInModell.addColumn("设备Id", new Vector<Integer>());
		devInModell.addColumn("设备名", new Vector<Integer>());
		devInModell.addColumn("入库时间", new Vector<Integer>());
		devInModell.addColumn("入库数量", new Vector<Integer>());
		devInModell.addColumn("入库员工id", new Vector<Integer>());
		devInModell.addColumn("员工姓名", new Vector<Integer>());
		devInModell.addColumn("员工电话", new Vector<Integer>());
		devInModell.addColumn("员工部门id", new Vector<Integer>());
		
		table = new JTable(devModel);
		
		JTableHeader head = table.getTableHeader();		
		head.setPreferredSize(new Dimension(head.getWidth(), 30));
		// 设置表头字体大小
		head.setFont(new Font("宋体", Font.BOLD, 20));
		// head.setForeground(Color.cyan);
		head.setBackground(Color.cyan);
		
		// 设置表格的行宽
		table.setRowHeight(30);
		// 设置表格行中字体大小
		table.setFont(new Font("宋体", Font.ROMAN_BASELINE, 17));
		/* 设置表格中的内容居中 */
		DefaultTableCellRenderer renderer = new DefaultTableCellRenderer();
		renderer.setHorizontalAlignment(DefaultTableCellRenderer.CENTER);
		table.setDefaultRenderer(Object.class, renderer);
		
		/*表格所属滚动面板*/
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(60, 217, 933, 365);
		scrollPane.setRowHeaderView(head);
		panel_1.add(scrollPane);
		
		JLabel lblNewLabel_2 = new JLabel();
		lblNewLabel_2.setBounds(0, 0,this.getWidth(), this.getHeight());
		lblNewLabel_2.setIcon(imageIcon2);
		panel_1.add(lblNewLabel_2);
			
	}
	
	public void setConnect(Connection connection) {
		this.connection = connection;
		if (this.connection==null) 
			System.out.println("出错！");
	}
	
	public void addEvent() {
		/*查询动作事件*/
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent select) {
				int index = comboBox.getSelectedIndex();
				InfoSelect infoSelect = new InfoSelect();
				
				switch (index) {
				   case 0:
					   /*设备信息*/
					   table.setModel(devModel);
						if (ckbCheckBox.isSelected())
							infoSelect.deviceSelectAll(connection,devModel);
						else {
							String deviceId = textField.getText();
							infoSelect.deviceSelect(connection, devModel, deviceId);
						}
						break;
				   case 1:
					   /*供应商信息*/
					   table.setModel(vendModel);
						if (ckbCheckBox.isSelected()) {
							infoSelect.vendSelectAll(connection, vendModel);
						}
						else {
							String vendorId = textField.getText();
							infoSelect.vendSelect(connection, vendModel, vendorId);
						}
						break;
				   case 2:
					   /*设备综合信息*/
					   table.setModel(devAndVndModel);
						if (ckbCheckBox.isSelected()) {
							infoSelect.devAndVendSelectAll(connection, devAndVndModel);
						}
						else {
							String deviceId = textField.getText();
							infoSelect.devAndVendSelect(connection, devAndVndModel,deviceId );
						}
						break;
					default:
						break;
				}
			}
		});
	}
	
	
}
