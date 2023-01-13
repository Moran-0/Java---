package ui;

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
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.util.Vector;

import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import database.InfoModify;
import database.InfoSelect;
import database.StockUpdate;

import javax.swing.JScrollPane;
import javax.swing.JCheckBox;
import java.awt.event.ActionListener;
import java.security.KeyStore.PrivateKeyEntry;
import java.sql.Connection;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import java.awt.Component;
import javax.swing.border.TitledBorder;
import javax.swing.border.MatteBorder;
import javax.swing.border.CompoundBorder;
import java.awt.Toolkit;

public class RootInterface extends JFrame {
	
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
	private JComboBox comboBox_2;
	private JCheckBox ckbCheckBox;
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	private JButton btnNewButton_6;
	private JButton btnNewButton_7;
	private JButton btnNewButton_8;
	
	private DefaultTableModel devModel;//设备
	private DefaultTableModel vendModel;//供应商
	private DefaultTableModel devAndVndModel;//设备基本信息和供应商信息
	private DefaultTableModel devRmModel;//库存
	private DefaultTableModel devRmANdModel;//设备基本信息，库存和需求
	private DefaultTableModel devInModel;//入库综合信息
	private DefaultTableModel devOutModel;//出库详细信息
	private DefaultTableModel devBackModel;//还库详细信息
	private JLayeredPane panel_4;
	private JLabel lblNewLabel_31;
	private JButton btnNewButton_9;
	private JLabel lblNewLabel_32;
	private JTextField textField_27;
	private JLabel lblNewLabel_33;
	private JTextField textField_28;
	private JLabel lblNewLabel_34;
	private JTextField textField_29;
	private JLabel lblNewLabel_35;
	private JTextField textField_30;
	private JLayeredPane layeredPane;
	private JLayeredPane layeredPane_1;
	private JLayeredPane layeredPane_2;
	private JLayeredPane layeredPane_3;
	private JLayeredPane layeredPane_4;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JLabel lblNewLabel_7;
	private JTextField textField_5;
	private JLabel lblNewLabel_8;
	private JTextField textField_6;
	private JLabel lblNewLabel_9;
	private JTextField textField_7;
	private JLabel lblNewLabel_11;
	private JTextField textField_8;
	private JButton btnNewButton_2;
	private JLabel lblNewLabel_12;
	private JTextField textField_9;
	private JLabel lblNewLabel_13;
	private JTextField textField_10;
	private JLabel lblNewLabel_14;
	private JTextField textField_11;
	private JButton btnNewButton_3;
	private JLabel lblNewLabel_16;
	private JTextField textField_13;
	private JLabel lblNewLabel_17;
	private JTextField textField_14;
	private JLabel lblNewLabel_18;
	private JTextField textField_15;
	private JLabel lblNewLabel_19;
	private JTextField textField_16;
	private JButton btnNewButton_4;
	private JLabel lblNewLabel_20;
	private JTextField textField_17;
	private JLabel lblNewLabel_21;
	private JTextField textField_18;
	private JLabel lblNewLabel_22;
	private JTextField textField_19;
	private JLabel lblNewLabel_23;
	private JTextField textField_20;
	private JButton btnNewButton_5;
	private JTabbedPane tabbedPane_2;
	private JLayeredPane layeredPane_5;
	private JLayeredPane layeredPane_6;
	private JLayeredPane layeredPane_7;
	private JComboBox comboBox_1;
	private JTextField textField_12;
	private JTextField textField_21;
	private JTextField textField_22;
	private JTextField textField_23;
	private JTextField textField_24;
	private JTextField textField_25;
	private JTextField textField_26;

	/**
	 * 创建窗体
	 */
	public RootInterface() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("IconImage\\Boch.jpg"));
		
		setForeground(new Color(192, 192, 192));
		setBackground(new Color(255, 255, 255));	
		setResizable(false);
		setTitle("设备库存管理系统（root）");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(new Rectangle(200, 100, 1050, 700));
		
		
		/*窗口图标*/
		ImageIcon mainIcon =  new ImageIcon("IconImage\\mobile-devices-2017980_1280.png");
		mainIcon.setImage(mainIcon.getImage().getScaledInstance(20, 20,Image.SCALE_DEFAULT ));
		
		ImageIcon selectIcon = new ImageIcon("IconImage\\clues-150586_1280.png");
		selectIcon.setImage(selectIcon.getImage().getScaledInstance(20, 20,Image.SCALE_DEFAULT ));
		
		ImageIcon editIcon = new ImageIcon("IconImage\\gene-editing-2375732_640.png");
		editIcon.setImage(editIcon.getImage().getScaledInstance(20, 20,Image.SCALE_DEFAULT ));
		
		ImageIcon sumIcon = new ImageIcon("IconImage\\circle-39522_640.png");
		sumIcon.setImage(sumIcon.getImage().getScaledInstance(20, 20,Image.SCALE_DEFAULT ));
		
		ImageIcon updateIcon = new ImageIcon("IconImage\\synchronize-150123_640.png");
		updateIcon.setImage(updateIcon.getImage().getScaledInstance(20, 20,Image.SCALE_DEFAULT ));
		
		ImageIcon recIcon = new ImageIcon("IconImage\\folder-303891_640.png");
		recIcon.setImage(recIcon.getImage().getScaledInstance(20, 20,Image.SCALE_DEFAULT ));
		
		ImageIcon pcIcon = new ImageIcon("IconImage\\shopping-cart-309592_640.png");
		pcIcon.setImage(pcIcon.getImage().getScaledInstance(20, 20,Image.SCALE_DEFAULT ));
		
		ImageIcon inIcon = new ImageIcon("IconImage\\door-150323_640.png");
		inIcon.setImage(inIcon.getImage().getScaledInstance(20, 20,Image.SCALE_DEFAULT ));
		
		ImageIcon outIcon = new ImageIcon("IconImage\\exit-1699614_640.png");
		outIcon.setImage(outIcon.getImage().getScaledInstance(20, 20,Image.SCALE_DEFAULT ));
		
		ImageIcon backIcon = new ImageIcon("IconImage\\back-158491_640.png");
		backIcon.setImage(backIcon.getImage().getScaledInstance(20, 20,Image.SCALE_DEFAULT ));
		
		ImageIcon userIcon = new ImageIcon("IconImage\\icon-1633249_1280.png");
		userIcon.setImage(userIcon.getImage().getScaledInstance(20, 20,Image.SCALE_DEFAULT ));
		
		ImageIcon vendIcon = new ImageIcon("IconImage\\craft-1141796_1280.png");
		vendIcon.setImage(vendIcon.getImage().getScaledInstance(20, 20,Image.SCALE_DEFAULT ));
		
		ImageIcon delIcon = new ImageIcon("IconImage\\clear-1727486_1280.png");
		delIcon.setImage(delIcon.getImage().getScaledInstance(20, 20,Image.SCALE_DEFAULT ));
		
		//mainIcon = selectIcon = editIcon = sumIcon = updateIcon = recIcon = pcIcon = inIcon = outIcon = backIcon = userIcon = vendIcon = delIcon = null;
		
		
		
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		/*多层面板---------------------*/
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBackground(new Color(255, 255, 255));
		tabbedPane.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		tabbedPane.setUI(new MyTabbedPaneUI_2());
		tabbedPane.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
		tabbedPane.setFont(new Font("微软雅黑", Font.PLAIN, 22));
		
		contentPane.add(tabbedPane);//
		
		/*主界面面板----------------*/
		panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBorder(new LineBorder(new Color(0, 0, 0), 0, true));
		tabbedPane.addTab("主界面",mainIcon,panel, null);
		//tabbedPane.addTab("主界面",null,panel, null);
		panel.setLayout(null);
		
		lblNewLabel_1 = new JLabel("企业设备库存管理系统");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
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
		
		tabbedPane.addTab("查询信息", selectIcon, panel_1, null);
		
		
		comboBox = new JComboBox();
		comboBox.setFont(new Font("黑体", Font.PLAIN, 18));
		comboBox.setBackground(new Color(255, 255, 255));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"查询设备基本信息","查询供应商信息", "查询设备和供应商信息",  "查询库存信息",
				"查询设备信息&库存&需求信息", "查询入库综合信息","查询出库综合信息","查询还库综合信息"}));
		comboBox.setBounds(41, 116, 265, 60);
		panel_1.add(comboBox);
		
		textField = new JTextField();
		textField.setSelectedTextColor(new Color(0, 0, 0));
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setCaretColor(new Color(0, 0, 0));
		textField.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		textField.setFont(new Font("宋体", Font.PLAIN, 30));
		textField.setForeground(new Color(0, 0, 0));
		textField.setBounds(391, 116, 160, 60);
		panel_1.add(textField);
		textField.setColumns(10);
		
		/*复选框*/
		ckbCheckBox = new JCheckBox("查找全部");
		ckbCheckBox.setHorizontalAlignment(SwingConstants.CENTER);
		ckbCheckBox.setFont(new Font("宋体", Font.BOLD, 20));
		ckbCheckBox.setBounds(837, 116, 150, 60);
		panel_1.add(ckbCheckBox);
		
		/*查询按钮*/
		btnNewButton = new JButton("查询");
		
				
		btnNewButton.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		btnNewButton.setFont(new Font("黑体", Font.BOLD, 25));
		btnNewButton.setBounds(617, 116, 160, 60);
		panel_1.add(btnNewButton);
		
		
		/*背景*/
		ImageIcon imageIcon2 = new ImageIcon("IconImage\\black-1072366_640.jpg");
		imageIcon2.setImage(imageIcon2.getImage().getScaledInstance(this.getWidth(), this.getHeight(), Image.SCALE_SMOOTH));
		
		
		
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
		devInModel = new DefaultTableModel();
		devInModel.addColumn("入库设备Id", new Vector<Integer>());
		devInModel.addColumn("入库设备名", new Vector<Integer>());
		devInModel.addColumn("入库时间", new Vector<Integer>());
		devInModel.addColumn("入库数量", new Vector<Integer>());
		devInModel.addColumn("入库员工id", new Vector<Integer>());
		devInModel.addColumn("员工姓名", new Vector<Integer>());
		devInModel.addColumn("员工电话", new Vector<Integer>());
		devInModel.addColumn("员工部门id", new Vector<Integer>());
		
		//查询出库设备大分基本信息，出库信息，和出库部门信息
		devOutModel = new DefaultTableModel();
		devOutModel.addColumn("设备Id", new Vector<Integer>());
		devOutModel.addColumn("设备名", new Vector<Integer>());
		devOutModel.addColumn("出库时间", new Vector<Integer>());
		devOutModel.addColumn("出库数量", new Vector<Integer>());
		devOutModel.addColumn("出库部门id", new Vector<Integer>());
		devOutModel.addColumn("部门名字", new Vector<Integer>());
		devOutModel.addColumn("部门人数", new Vector<Integer>());
		devOutModel.addColumn("部门职责", new Vector<Integer>());
		
		//查询还库设备基本信息，还库信息，和还库部门信息
		devBackModel = new DefaultTableModel();
		devBackModel.addColumn("还库设备Id", new Vector<Integer>());
		devBackModel.addColumn("还库设备名", new Vector<Integer>());
		devBackModel.addColumn("还库时间", new Vector<Integer>());
		devBackModel.addColumn("还库数量", new Vector<Integer>());
		devBackModel.addColumn("还库部门id", new Vector<Integer>());
		devBackModel.addColumn("部门名字", new Vector<Integer>());
		devBackModel.addColumn("部门人数", new Vector<Integer>());
		devBackModel.addColumn("部门职责", new Vector<Integer>());
		
		
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
		scrollPane.setBounds(41, 217, 946, 381);
		scrollPane.setRowHeaderView(head);
		panel_1.add(scrollPane);
		
		JLabel lblNewLabel_2 = new JLabel();
		lblNewLabel_2.setBounds(0, 0,this.getWidth(), this.getHeight());
		lblNewLabel_2.setIcon(imageIcon2);
		panel_1.add(lblNewLabel_2);
		
		/*背景*/
		
		panel_4 = new JLayeredPane();
		tabbedPane.addTab("信息统计", sumIcon, panel_4, null);
		
		ImageIcon imageIcon5 = new ImageIcon("IconImage\\stack-g738e13cb5_1920.jpg");
		imageIcon5.setImage(imageIcon5.getImage().getScaledInstance(this.getWidth(), this.getHeight(), Image.SCALE_SMOOTH));
		
		btnNewButton_9 = new JButton("统计");
		btnNewButton_9.setFont(new Font("黑体", Font.BOLD, 30));
		btnNewButton_9.setBounds(417, 43, 180, 60);
		panel_4.add(btnNewButton_9);
		
		lblNewLabel_32 = new JLabel("设备数");
		lblNewLabel_32.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		lblNewLabel_32.setOpaque(true);
		lblNewLabel_32.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_32.setFont(new Font("黑体", Font.BOLD, 20));
		lblNewLabel_32.setBackground(Color.WHITE);
		lblNewLabel_32.setBounds(154, 154, 150, 55);
		panel_4.add(lblNewLabel_32);
		
		textField_27 = new JTextField();
		textField_27.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		textField_27.setEditable(false);
		textField_27.setHorizontalAlignment(SwingConstants.CENTER);
		textField_27.setFont(new Font("黑体", Font.PLAIN, 20));
		textField_27.setColumns(10);
		textField_27.setBounds(350, 154, 150, 55);
		panel_4.add(textField_27);
		
		lblNewLabel_33 = new JLabel("设备类型数");
		lblNewLabel_33.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		lblNewLabel_33.setOpaque(true);
		lblNewLabel_33.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_33.setFont(new Font("黑体", Font.BOLD, 20));
		lblNewLabel_33.setBackground(Color.WHITE);
		lblNewLabel_33.setBounds(555, 154, 150, 55);
		panel_4.add(lblNewLabel_33);
		
		textField_28 = new JTextField();
		textField_28.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		textField_28.setEditable(false);
		textField_28.setHorizontalAlignment(SwingConstants.CENTER);
		textField_28.setFont(new Font("黑体", Font.PLAIN, 20));
		textField_28.setColumns(10);
		textField_28.setBounds(769, 154, 150, 55);
		panel_4.add(textField_28);
		
		lblNewLabel_34 = new JLabel("部门数");
		lblNewLabel_34.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		lblNewLabel_34.setOpaque(true);
		lblNewLabel_34.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_34.setFont(new Font("黑体", Font.BOLD, 20));
		lblNewLabel_34.setBackground(Color.WHITE);
		lblNewLabel_34.setBounds(154, 257, 150, 55);
		panel_4.add(lblNewLabel_34);
		
		textField_29 = new JTextField();
		textField_29.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		textField_29.setEditable(false);
		textField_29.setHorizontalAlignment(SwingConstants.CENTER);
		textField_29.setFont(new Font("黑体", Font.PLAIN, 20));
		textField_29.setColumns(10);
		textField_29.setBounds(350, 257, 150, 55);
		panel_4.add(textField_29);
		
		lblNewLabel_35 = new JLabel("供应商数");
		lblNewLabel_35.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		lblNewLabel_35.setOpaque(true);
		lblNewLabel_35.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_35.setFont(new Font("黑体", Font.BOLD, 20));
		lblNewLabel_35.setBackground(Color.WHITE);
		lblNewLabel_35.setBounds(555, 257, 150, 55);
		panel_4.add(lblNewLabel_35);
		
		textField_30 = new JTextField();
		textField_30.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		textField_30.setEditable(false);
		textField_30.setHorizontalAlignment(SwingConstants.CENTER);
		textField_30.setFont(new Font("黑体", Font.PLAIN, 20));
		textField_30.setColumns(10);
		textField_30.setBounds(769, 257, 150, 55);
		panel_4.add(textField_30);
		lblNewLabel_31 = new JLabel();
		lblNewLabel_31.setBackground(SystemColor.inactiveCaption);
		lblNewLabel_31.setOpaque(true);
		lblNewLabel_31.setBounds(0, 0,this.getWidth(), this.getHeight());
		lblNewLabel_31.setIcon(imageIcon5);
		panel_4.add(lblNewLabel_31);
		
		JTabbedPane tabbedPane_1 = new JTabbedPane(JTabbedPane.RIGHT);
		tabbedPane_1.setBorder(null);
		tabbedPane_1.setForeground(new Color(0, 0, 0));
		tabbedPane_1.setBackground(SystemColor.menu);
		tabbedPane_1.setUI(new MyTabbedPaneUI_1());
		tabbedPane_1.setFocusCycleRoot(true);
		tabbedPane_1.setFont(new Font("微软雅黑", Font.PLAIN, 37));
		tabbedPane.addTab("库存更新", updateIcon, tabbedPane_1, null);
		
		layeredPane = new JLayeredPane();
		layeredPane.setBorder(null);
		layeredPane.setOpaque(true);
		layeredPane.setForeground(new Color(192, 192, 192));
		layeredPane.setBackground(SystemColor.menu);
		tabbedPane_1.addTab("需求登记", recIcon, layeredPane, null);
		
		JLabel lblNewLabel_4 = new JLabel("设备Id");
		lblNewLabel_4.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		lblNewLabel_4.setOpaque(true);
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setForeground(new Color(0, 0, 0));
		lblNewLabel_4.setFont(new Font("黑体", Font.BOLD, 20));
		lblNewLabel_4.setBackground(SystemColor.scrollbar);
		lblNewLabel_4.setBounds(168, 52, 150, 55);
		layeredPane.add(lblNewLabel_4);
		
		textField_1 = new JTextField();
		textField_1.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		textField_1.setHorizontalAlignment(SwingConstants.CENTER);
		textField_1.setFont(new Font("黑体", Font.PLAIN, 20));
		textField_1.setColumns(10);
		textField_1.setBounds(392, 52, 150, 55);
		layeredPane.add(textField_1);
		
		JLabel lblNewLabel_5 = new JLabel("部门Id");
		lblNewLabel_5.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		lblNewLabel_5.setOpaque(true);
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5.setForeground(new Color(0, 0, 0));
		lblNewLabel_5.setFont(new Font("黑体", Font.BOLD, 20));
		lblNewLabel_5.setBackground(SystemColor.scrollbar);
		lblNewLabel_5.setBounds(168, 183, 150, 55);
		layeredPane.add(lblNewLabel_5);
		
		textField_2 = new JTextField();
		textField_2.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		textField_2.setHorizontalAlignment(SwingConstants.CENTER);
		textField_2.setFont(new Font("黑体", Font.PLAIN, 20));
		textField_2.setColumns(10);
		textField_2.setBounds(392, 183, 150, 55);
		layeredPane.add(textField_2);
		
		JLabel lblNewLabel_6 = new JLabel("需求数量");
		lblNewLabel_6.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		lblNewLabel_6.setOpaque(true);
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_6.setForeground(new Color(0, 0, 0));
		lblNewLabel_6.setFont(new Font("黑体", Font.BOLD, 20));
		lblNewLabel_6.setBackground(SystemColor.scrollbar);
		lblNewLabel_6.setBounds(168, 330, 150, 55);
		layeredPane.add(lblNewLabel_6);
		
		textField_3 = new JTextField();
		textField_3.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		textField_3.setHorizontalAlignment(SwingConstants.CENTER);
		textField_3.setFont(new Font("黑体", Font.PLAIN, 20));
		textField_3.setColumns(10);
		textField_3.setBounds(392, 330, 150, 55);
		layeredPane.add(textField_3);
		
		JLabel lblNewLabel_10 = new JLabel("开始时间");
		lblNewLabel_10.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		lblNewLabel_10.setOpaque(true);
		lblNewLabel_10.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_10.setForeground(new Color(0, 0, 0));
		lblNewLabel_10.setFont(new Font("黑体", Font.BOLD, 20));
		lblNewLabel_10.setBackground(SystemColor.scrollbar);
		lblNewLabel_10.setBounds(168, 470, 150, 55);
		layeredPane.add(lblNewLabel_10);
		
		textField_4 = new JTextField();
		textField_4.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		textField_4.setHorizontalAlignment(SwingConstants.CENTER);
		textField_4.setFont(new Font("黑体", Font.PLAIN, 20));
		textField_4.setColumns(10);
		textField_4.setBounds(392, 470, 150, 55);
		layeredPane.add(textField_4);
		
		btnNewButton_1 = new JButton("登记需求");
		btnNewButton_1.setFont(new Font("黑体", Font.BOLD, 20));
		btnNewButton_1.setBounds(636, 257, 150, 55);
		layeredPane.add(btnNewButton_1);
		
		layeredPane_1 = new JLayeredPane();
		layeredPane_1.setOpaque(true);
		tabbedPane_1.addTab("设备采购", pcIcon, layeredPane_1, null);
		
		lblNewLabel_7 = new JLabel("设备Id");
		lblNewLabel_7.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		lblNewLabel_7.setOpaque(true);
		lblNewLabel_7.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_7.setForeground(new Color(0, 0, 0));
		lblNewLabel_7.setFont(new Font("黑体", Font.BOLD, 20));
		lblNewLabel_7.setBackground(SystemColor.scrollbar);
		lblNewLabel_7.setBounds(170, 55, 150, 55);
		layeredPane_1.add(lblNewLabel_7);
		
		textField_5 = new JTextField();
		textField_5.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		textField_5.setHorizontalAlignment(SwingConstants.CENTER);
		textField_5.setFont(new Font("黑体", Font.PLAIN, 20));
		textField_5.setColumns(10);
		textField_5.setBounds(430, 55, 150, 55);
		layeredPane_1.add(textField_5);
		
		lblNewLabel_8 = new JLabel("部门Id");
		lblNewLabel_8.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		lblNewLabel_8.setOpaque(true);
		lblNewLabel_8.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_8.setForeground(new Color(0, 0, 0));
		lblNewLabel_8.setFont(new Font("黑体", Font.BOLD, 20));
		lblNewLabel_8.setBackground(SystemColor.scrollbar);
		lblNewLabel_8.setBounds(170, 185, 150, 55);
		layeredPane_1.add(lblNewLabel_8);
		
		textField_6 = new JTextField();
		textField_6.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		textField_6.setHorizontalAlignment(SwingConstants.CENTER);
		textField_6.setFont(new Font("黑体", Font.PLAIN, 20));
		textField_6.setColumns(10);
		textField_6.setBounds(430, 185, 150, 55);
		layeredPane_1.add(textField_6);
		
		lblNewLabel_9 = new JLabel("采购时间");
		lblNewLabel_9.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		lblNewLabel_9.setOpaque(true);
		lblNewLabel_9.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_9.setForeground(new Color(0, 0, 0));
		lblNewLabel_9.setFont(new Font("黑体", Font.BOLD, 20));
		lblNewLabel_9.setBackground(SystemColor.scrollbar);
		lblNewLabel_9.setBounds(170, 314, 150, 55);
		layeredPane_1.add(lblNewLabel_9);
		
		textField_7 = new JTextField();
		textField_7.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		textField_7.setHorizontalAlignment(SwingConstants.CENTER);
		textField_7.setFont(new Font("黑体", Font.PLAIN, 20));
		textField_7.setColumns(10);
		textField_7.setBounds(430, 314, 150, 55);
		layeredPane_1.add(textField_7);
		
		lblNewLabel_11 = new JLabel("采购员工");
		lblNewLabel_11.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		lblNewLabel_11.setOpaque(true);
		lblNewLabel_11.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_11.setForeground(new Color(0, 0, 0));
		lblNewLabel_11.setFont(new Font("黑体", Font.BOLD, 20));
		lblNewLabel_11.setBackground(SystemColor.scrollbar);
		lblNewLabel_11.setBounds(170, 448, 150, 55);
		layeredPane_1.add(lblNewLabel_11);
		
		textField_8 = new JTextField();
		textField_8.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		textField_8.setHorizontalAlignment(SwingConstants.CENTER);
		textField_8.setFont(new Font("黑体", Font.PLAIN, 20));
		textField_8.setColumns(10);
		textField_8.setBounds(430, 449, 150, 55);
		layeredPane_1.add(textField_8);
		
		btnNewButton_2 = new JButton("设备采购");
		btnNewButton_2.setFont(new Font("黑体", Font.BOLD, 20));
		btnNewButton_2.setBounds(645, 250, 150, 55);
		layeredPane_1.add(btnNewButton_2);
		
		layeredPane_2 = new JLayeredPane();
		layeredPane_2.setOpaque(true);
		tabbedPane_1.addTab("设备入库", inIcon, layeredPane_2, null);
		
		lblNewLabel_12 = new JLabel("设备Id");
		lblNewLabel_12.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		lblNewLabel_12.setOpaque(true);
		lblNewLabel_12.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_12.setForeground(new Color(0, 0, 0));
		lblNewLabel_12.setFont(new Font("黑体", Font.BOLD, 20));
		lblNewLabel_12.setBackground(SystemColor.scrollbar);
		lblNewLabel_12.setBounds(172, 74, 150, 55);
		layeredPane_2.add(lblNewLabel_12);
		
		textField_9 = new JTextField();
		textField_9.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		textField_9.setHorizontalAlignment(SwingConstants.CENTER);
		textField_9.setFont(new Font("黑体", Font.PLAIN, 20));
		textField_9.setColumns(10);
		textField_9.setBounds(433, 74, 150, 55);
		layeredPane_2.add(textField_9);
		
		lblNewLabel_13 = new JLabel("入库时间");
		lblNewLabel_13.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		lblNewLabel_13.setOpaque(true);
		lblNewLabel_13.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_13.setForeground(new Color(0, 0, 0));
		lblNewLabel_13.setFont(new Font("黑体", Font.BOLD, 20));
		lblNewLabel_13.setBackground(SystemColor.scrollbar);
		lblNewLabel_13.setBounds(172, 250, 150, 55);
		layeredPane_2.add(lblNewLabel_13);
		
		textField_10 = new JTextField();
		textField_10.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		textField_10.setHorizontalAlignment(SwingConstants.CENTER);
		textField_10.setFont(new Font("黑体", Font.PLAIN, 20));
		textField_10.setColumns(10);
		textField_10.setBounds(433, 250, 150, 55);
		layeredPane_2.add(textField_10);
		
		lblNewLabel_14 = new JLabel("入库员工");
		lblNewLabel_14.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		lblNewLabel_14.setOpaque(true);
		lblNewLabel_14.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_14.setForeground(new Color(0, 0, 0));
		lblNewLabel_14.setFont(new Font("黑体", Font.BOLD, 20));
		lblNewLabel_14.setBackground(SystemColor.scrollbar);
		lblNewLabel_14.setBounds(172, 430, 150, 55);
		layeredPane_2.add(lblNewLabel_14);
		
		textField_11 = new JTextField();
		textField_11.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		textField_11.setHorizontalAlignment(SwingConstants.CENTER);
		textField_11.setFont(new Font("黑体", Font.PLAIN, 20));
		textField_11.setColumns(10);
		textField_11.setBounds(433, 430, 150, 55);
		layeredPane_2.add(textField_11);
		
		btnNewButton_3 = new JButton("设备入库");
		btnNewButton_3.setFont(new Font("黑体", Font.BOLD, 20));
		btnNewButton_3.setBounds(616, 251, 150, 55);
		layeredPane_2.add(btnNewButton_3);
		
		layeredPane_3 = new JLayeredPane();
		layeredPane_3.setOpaque(true);
		tabbedPane_1.addTab("设备出库", outIcon, layeredPane_3, null);
		
		lblNewLabel_16 = new JLabel("设备Id");
		lblNewLabel_16.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		lblNewLabel_16.setOpaque(true);
		lblNewLabel_16.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_16.setForeground(new Color(0, 0, 0));
		lblNewLabel_16.setFont(new Font("黑体", Font.BOLD, 20));
		lblNewLabel_16.setBackground(SystemColor.scrollbar);
		lblNewLabel_16.setBounds(170, 55, 150, 55);
		layeredPane_3.add(lblNewLabel_16);
		
		textField_13 = new JTextField();
		textField_13.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		textField_13.setHorizontalAlignment(SwingConstants.CENTER);
		textField_13.setFont(new Font("黑体", Font.PLAIN, 20));
		textField_13.setColumns(10);
		textField_13.setBounds(411, 55, 150, 55);
		layeredPane_3.add(textField_13);
		
		lblNewLabel_17 = new JLabel("部门Id");
		lblNewLabel_17.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		lblNewLabel_17.setOpaque(true);
		lblNewLabel_17.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_17.setForeground(new Color(0, 0, 0));
		lblNewLabel_17.setFont(new Font("黑体", Font.BOLD, 20));
		lblNewLabel_17.setBackground(SystemColor.scrollbar);
		lblNewLabel_17.setBounds(170, 193, 150, 55);
		layeredPane_3.add(lblNewLabel_17);
		
		textField_14 = new JTextField();
		textField_14.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		textField_14.setHorizontalAlignment(SwingConstants.CENTER);
		textField_14.setFont(new Font("黑体", Font.PLAIN, 20));
		textField_14.setColumns(10);
		textField_14.setBounds(411, 193, 150, 55);
		layeredPane_3.add(textField_14);
		
		lblNewLabel_18 = new JLabel("出库数量");
		lblNewLabel_18.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		lblNewLabel_18.setOpaque(true);
		lblNewLabel_18.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_18.setForeground(new Color(0, 0, 0));
		lblNewLabel_18.setFont(new Font("黑体", Font.BOLD, 20));
		lblNewLabel_18.setBackground(SystemColor.scrollbar);
		lblNewLabel_18.setBounds(170, 322, 150, 55);
		layeredPane_3.add(lblNewLabel_18);
		
		textField_15 = new JTextField();
		textField_15.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		textField_15.setHorizontalAlignment(SwingConstants.CENTER);
		textField_15.setFont(new Font("黑体", Font.PLAIN, 20));
		textField_15.setColumns(10);
		textField_15.setBounds(411, 322, 150, 55);
		layeredPane_3.add(textField_15);
		
		lblNewLabel_19 = new JLabel("出库时间");
		lblNewLabel_19.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		lblNewLabel_19.setOpaque(true);
		lblNewLabel_19.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_19.setForeground(new Color(0, 0, 0));
		lblNewLabel_19.setFont(new Font("黑体", Font.BOLD, 20));
		lblNewLabel_19.setBackground(SystemColor.scrollbar);
		lblNewLabel_19.setBounds(170, 459, 150, 55);
		layeredPane_3.add(lblNewLabel_19);
		
		textField_16 = new JTextField();
		textField_16.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		textField_16.setHorizontalAlignment(SwingConstants.CENTER);
		textField_16.setFont(new Font("黑体", Font.PLAIN, 20));
		textField_16.setColumns(10);
		textField_16.setBounds(411, 459, 150, 55);
		layeredPane_3.add(textField_16);
		
		btnNewButton_4 = new JButton("设备出库");
		btnNewButton_4.setFont(new Font("黑体", Font.BOLD, 20));
		btnNewButton_4.setBounds(618, 258, 150, 55);
		layeredPane_3.add(btnNewButton_4);
		
		layeredPane_4 = new JLayeredPane();
		layeredPane_4.setOpaque(true);
		tabbedPane_1.addTab("设备还库", backIcon, layeredPane_4, null);
		
		lblNewLabel_20 = new JLabel("设备Id");
		lblNewLabel_20.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		lblNewLabel_20.setOpaque(true);
		lblNewLabel_20.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_20.setForeground(new Color(0, 0, 0));
		lblNewLabel_20.setFont(new Font("黑体", Font.BOLD, 20));
		lblNewLabel_20.setBackground(SystemColor.scrollbar);
		lblNewLabel_20.setBounds(173, 45, 150, 55);
		layeredPane_4.add(lblNewLabel_20);
		
		textField_17 = new JTextField();
		textField_17.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		textField_17.setHorizontalAlignment(SwingConstants.CENTER);
		textField_17.setFont(new Font("黑体", Font.PLAIN, 20));
		textField_17.setColumns(10);
		textField_17.setBounds(426, 45, 150, 55);
		layeredPane_4.add(textField_17);
		
		lblNewLabel_21 = new JLabel("部门Id");
		lblNewLabel_21.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		lblNewLabel_21.setOpaque(true);
		lblNewLabel_21.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_21.setForeground(new Color(0, 0, 0));
		lblNewLabel_21.setFont(new Font("黑体", Font.BOLD, 20));
		lblNewLabel_21.setBackground(SystemColor.scrollbar);
		lblNewLabel_21.setBounds(173, 188, 150, 55);
		layeredPane_4.add(lblNewLabel_21);
		
		textField_18 = new JTextField();
		textField_18.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		textField_18.setHorizontalAlignment(SwingConstants.CENTER);
		textField_18.setFont(new Font("黑体", Font.PLAIN, 20));
		textField_18.setColumns(10);
		textField_18.setBounds(426, 188, 150, 55);
		layeredPane_4.add(textField_18);
		
		lblNewLabel_22 = new JLabel("还库日期");
		lblNewLabel_22.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		lblNewLabel_22.setOpaque(true);
		lblNewLabel_22.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_22.setForeground(new Color(0, 0, 0));
		lblNewLabel_22.setFont(new Font("黑体", Font.BOLD, 20));
		lblNewLabel_22.setBackground(SystemColor.scrollbar);
		lblNewLabel_22.setBounds(173, 319, 150, 55);
		layeredPane_4.add(lblNewLabel_22);
		
		textField_19 = new JTextField();
		textField_19.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		textField_19.setHorizontalAlignment(SwingConstants.CENTER);
		textField_19.setFont(new Font("黑体", Font.PLAIN, 20));
		textField_19.setColumns(10);
		textField_19.setBounds(426, 319, 150, 55);
		layeredPane_4.add(textField_19);
		
		lblNewLabel_23 = new JLabel("还库员工");
		lblNewLabel_23.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		lblNewLabel_23.setOpaque(true);
		lblNewLabel_23.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_23.setForeground(new Color(0, 0, 0));
		lblNewLabel_23.setFont(new Font("黑体", Font.BOLD, 20));
		lblNewLabel_23.setBackground(SystemColor.scrollbar);
		lblNewLabel_23.setBounds(173, 460, 150, 55);
		layeredPane_4.add(lblNewLabel_23);
		
		textField_20 = new JTextField();
		textField_20.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		textField_20.setHorizontalAlignment(SwingConstants.CENTER);
		textField_20.setFont(new Font("黑体", Font.PLAIN, 20));
		textField_20.setColumns(10);
		textField_20.setBounds(426, 460, 150, 55);
		layeredPane_4.add(textField_20);
		
		btnNewButton_5 = new JButton("设备还库");
		btnNewButton_5.setFont(new Font("黑体", Font.BOLD, 20));
		btnNewButton_5.setBounds(645, 245, 150, 55);
		layeredPane_4.add(btnNewButton_5);
		
		tabbedPane_2 = new JTabbedPane(JTabbedPane.RIGHT);
		tabbedPane_2.setFont(new Font("微软雅黑", Font.PLAIN, 37));
		tabbedPane_2.setBackground(SystemColor.menu);
		tabbedPane_2.setUI(new MyTabbedPaneUI_1());
		tabbedPane.addTab("信息修改", editIcon, tabbedPane_2, null);
		
		layeredPane_5 = new JLayeredPane();
		layeredPane_5.setOpaque(true);
		layeredPane_5.setBackground(SystemColor.menu);
		tabbedPane_2.addTab("员工信息", userIcon, layeredPane_5, null);
		
		comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"联系电话", "所属部门"}));
		comboBox_1.setFont(new Font("黑体", Font.BOLD, 20));
		comboBox_1.setBounds(210, 111, 181, 50);
		layeredPane_5.add(comboBox_1);
		
		JLabel lblNewLabel_24 = new JLabel("员工Id");
		lblNewLabel_24.setOpaque(true);
		lblNewLabel_24.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_24.setFont(new Font("黑体", Font.BOLD, 20));
		lblNewLabel_24.setBorder(new LineBorder(new Color(0, 0, 0), 0, true));
		lblNewLabel_24.setBackground(Color.WHITE);
		lblNewLabel_24.setBounds(210, 211, 181, 61);
		layeredPane_5.add(lblNewLabel_24);
		
		textField_12 = new JTextField();
		textField_12.setHorizontalAlignment(SwingConstants.CENTER);
		textField_12.setFont(new Font("黑体", Font.PLAIN, 20));
		textField_12.setColumns(10);
		textField_12.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		textField_12.setBounds(481, 211, 161, 61);
		layeredPane_5.add(textField_12);
		
		JLabel lblNewLabel_25 = new JLabel("修改信息");
		lblNewLabel_25.setOpaque(true);
		lblNewLabel_25.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_25.setFont(new Font("黑体", Font.BOLD, 20));
		lblNewLabel_25.setBorder(new LineBorder(new Color(0, 0, 0), 0, true));
		lblNewLabel_25.setBackground(Color.WHITE);
		lblNewLabel_25.setBounds(210, 299, 181, 61);
		layeredPane_5.add(lblNewLabel_25);
		
		textField_21 = new JTextField();
		textField_21.setHorizontalAlignment(SwingConstants.CENTER);
		textField_21.setFont(new Font("黑体", Font.PLAIN, 20));
		textField_21.setColumns(10);
		textField_21.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		textField_21.setBounds(481, 299, 161, 61);
		layeredPane_5.add(textField_21);
		
		btnNewButton_6 = new JButton("更新员工信息");
		btnNewButton_6.setFont(new Font("黑体", Font.BOLD, 20));
		btnNewButton_6.setBorder(new LineBorder(new Color(0, 0, 0), 0, true));
		btnNewButton_6.setBounds(210, 406, 181, 61);
		layeredPane_5.add(btnNewButton_6);
		
		layeredPane_6 = new JLayeredPane();
		layeredPane_6.setOpaque(true);
		layeredPane_6.setBackground(SystemColor.menu);
		tabbedPane_2.addTab("供应商信息", vendIcon, layeredPane_6, null);
		
		comboBox_2 = new JComboBox();
		comboBox_2.setModel(new DefaultComboBoxModel(new String[] {"供应商名", "供应商地址"}));
		comboBox_2.setFont(new Font("黑体", Font.BOLD, 20));
		comboBox_2.setBounds(216, 103, 181, 50);
		layeredPane_6.add(comboBox_2);
		
		JLabel lblNewLabel_26 = new JLabel("供应商Id");
		lblNewLabel_26.setOpaque(true);
		lblNewLabel_26.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_26.setFont(new Font("黑体", Font.BOLD, 20));
		lblNewLabel_26.setBorder(new LineBorder(new Color(0, 0, 0), 0, true));
		lblNewLabel_26.setBackground(Color.WHITE);
		lblNewLabel_26.setBounds(216, 200, 181, 60);
		layeredPane_6.add(lblNewLabel_26);
		
		textField_22 = new JTextField();
		textField_22.setHorizontalAlignment(SwingConstants.CENTER);
		textField_22.setFont(new Font("黑体", Font.PLAIN, 20));
		textField_22.setColumns(10);
		textField_22.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		textField_22.setBounds(540, 200, 150, 60);
		layeredPane_6.add(textField_22);
		
		btnNewButton_7 = new JButton("更新供应信息");
		btnNewButton_7.setFont(new Font("黑体", Font.BOLD, 20));
		btnNewButton_7.setBorder(new LineBorder(new Color(0, 0, 0), 0, true));
		btnNewButton_7.setBounds(216, 417, 181, 60);
		layeredPane_6.add(btnNewButton_7);
		
		JLabel lblNewLabel_27 = new JLabel("修改信息");
		lblNewLabel_27.setOpaque(true);
		lblNewLabel_27.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_27.setFont(new Font("黑体", Font.BOLD, 20));
		lblNewLabel_27.setBorder(new LineBorder(new Color(0, 0, 0), 0, true));
		lblNewLabel_27.setBackground(Color.WHITE);
		lblNewLabel_27.setBounds(216, 287, 181, 60);
		layeredPane_6.add(lblNewLabel_27);
		
		textField_23 = new JTextField();
		textField_23.setHorizontalAlignment(SwingConstants.CENTER);
		textField_23.setFont(new Font("黑体", Font.PLAIN, 20));
		textField_23.setColumns(10);
		textField_23.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		textField_23.setBounds(540, 287, 150, 60);
		layeredPane_6.add(textField_23);
		
		layeredPane_7 = new JLayeredPane();
		layeredPane_7.setOpaque(true);
		layeredPane_7.setBackground(SystemColor.menu);
		tabbedPane_2.addTab("需求信息", delIcon, layeredPane_7, null);
		
		JLabel lblNewLabel_29 = new JLabel("设备Id");
		lblNewLabel_29.setOpaque(true);
		lblNewLabel_29.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_29.setFont(new Font("黑体", Font.BOLD, 20));
		lblNewLabel_29.setBorder(new LineBorder(new Color(0, 0, 0), 0, true));
		lblNewLabel_29.setBackground(Color.WHITE);
		lblNewLabel_29.setBounds(205, 60, 145, 55);
		layeredPane_7.add(lblNewLabel_29);
		
		textField_24 = new JTextField();
		textField_24.setHorizontalAlignment(SwingConstants.CENTER);
		textField_24.setFont(new Font("黑体", Font.PLAIN, 20));
		textField_24.setColumns(10);
		textField_24.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		textField_24.setBounds(423, 60, 145, 55);
		layeredPane_7.add(textField_24);
		
		JLabel lblNewLabel_28 = new JLabel("部门Id");
		lblNewLabel_28.setOpaque(true);
		lblNewLabel_28.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_28.setFont(new Font("黑体", Font.BOLD, 20));
		lblNewLabel_28.setBorder(new LineBorder(new Color(0, 0, 0), 0, true));
		lblNewLabel_28.setBackground(Color.WHITE);
		lblNewLabel_28.setBounds(205, 199, 145, 55);
		layeredPane_7.add(lblNewLabel_28);
		
		textField_25 = new JTextField();
		textField_25.setHorizontalAlignment(SwingConstants.CENTER);
		textField_25.setFont(new Font("黑体", Font.PLAIN, 20));
		textField_25.setColumns(10);
		textField_25.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		textField_25.setBounds(423, 199, 145, 55);
		layeredPane_7.add(textField_25);
		
		JLabel lblNewLabel_30 = new JLabel("开始时间");
		lblNewLabel_30.setOpaque(true);
		lblNewLabel_30.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_30.setFont(new Font("黑体", Font.BOLD, 20));
		lblNewLabel_30.setBorder(new LineBorder(new Color(0, 0, 0), 0, true));
		lblNewLabel_30.setBackground(Color.WHITE);
		lblNewLabel_30.setBounds(205, 330, 145, 55);
		layeredPane_7.add(lblNewLabel_30);
		
		textField_26 = new JTextField();
		textField_26.setHorizontalAlignment(SwingConstants.CENTER);
		textField_26.setFont(new Font("黑体", Font.PLAIN, 20));
		textField_26.setColumns(10);
		textField_26.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		textField_26.setBounds(423, 330, 145, 55);
		layeredPane_7.add(textField_26);
		
		btnNewButton_8 = new JButton("撤销需求");
		btnNewButton_8.setFont(new Font("黑体", Font.BOLD, 20));
		btnNewButton_8.setBorder(new LineBorder(new Color(0, 0, 0), 0, true));
		btnNewButton_8.setBounds(304, 451, 166, 55);
		layeredPane_7.add(btnNewButton_8);
		
		
		addEvent();
	}
	
	public void setConnect(Connection connection) {
		this.connection = connection;
		if (this.connection==null) 
			System.out.println("出错！");
	}
	
	
	/**
	 * 为按钮添加事件
	 */
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
				   case 3:
					   /*库存信息*/
					   table.setModel(devRmModel);
						if (ckbCheckBox.isSelected()) {
							infoSelect.devRmSelectAll(connection, devRmModel);
						}
						else {
							String deviceId = textField.getText();
							infoSelect.devRmSelect(connection, devRmModel,deviceId );
						}
						break;
				   case 4:
					   /*库存详细信息*/
					   table.setModel(devRmANdModel);
						if (ckbCheckBox.isSelected()) {
							infoSelect.devRmNedSelectAll(connection, devRmANdModel);
						}
						else {
							String deviceId = textField.getText();
							infoSelect.devRmNedSelect(connection, devRmANdModel,deviceId );
						}
						break;
				   case 5:
					   /*入库综合信息*/
					   table.setModel(devInModel);
					   if (ckbCheckBox.isSelected()) {
							infoSelect.inDevInfoSelectAll(connection, devInModel);
						}
						else {
							String deviceId = textField.getText();
							infoSelect.inDevInfoSelect(connection, devInModel,deviceId );
						}
						break;
				   case 6:
					   /*出库综合信息*/
					   table.setModel(devOutModel);
					   if (ckbCheckBox.isSelected()) {
							infoSelect.outDevInfoSelectAll(connection, devOutModel);
						}
						else {
							String deviceId = textField.getText();
							infoSelect.outDevInfoSelect(connection, devOutModel,deviceId );
						}
						break;
				   case 7:
					   /*还库综合信息*/
					   table.setModel(devBackModel);
					   if (ckbCheckBox.isSelected()) {
							infoSelect.backDevInfoSelectAll(connection, devBackModel);
						}
						else {
							String deviceId = textField.getText();
							infoSelect.backDevInfoSelect(connection, devBackModel,deviceId );
						}
						break;
					   
					default:
						break;
				}
			}
		});
		
		
		/*需求登记*/
		btnNewButton_1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent needRcord) {
				try {
					StockUpdate stockUpdate = new StockUpdate();
					String devId = textField_1.getText();
					String depId = textField_2.getText();
					String temp = textField_3.getText();
					Integer needNum = Integer.parseInt(temp);
					String startDate = textField_4.getText();
					if (devId.length()!=6||depId.length()!=5||needNum<=0)
						JOptionPane.showMessageDialog(null, "数据格式错误", "警告", JOptionPane.WARNING_MESSAGE);
					else
						stockUpdate.needRecord(connection, devId, depId, needNum, startDate);
					
				}catch (NumberFormatException e) {
					JOptionPane.showMessageDialog(null, "需求数量输入错误", "警告", JOptionPane.WARNING_MESSAGE);
				}
				catch (Exception e) {
					JOptionPane.showMessageDialog(null, "数据输入错误", "警告", JOptionPane.WARNING_MESSAGE);
				}
				
			}
		});
		
		
		/*设备采购*/
		btnNewButton_2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent devPc) {
				StockUpdate stockUpdate = new StockUpdate();
				String devId = textField_5.getText();
				String depId = textField_6.getText();
				String pcDate = textField_7.getText();
				String empId = textField_8.getText();
				stockUpdate.decPc(connection, devId, depId, pcDate, empId);
			}
		});
		
		/*设备入库*/
		btnNewButton_3.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent inStock) {
				StockUpdate stockUpdate = new StockUpdate();
				String devId = textField_9.getText();
				String inDate = textField_10.getText();
				String empId = textField_11.getText();
				stockUpdate.inStock(connection, devId, inDate, empId);
			}
		});
		
		/*设备出库*/
		btnNewButton_4.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent outStock) {
				try {
					StockUpdate stockUpdate = new StockUpdate();
					String devId = textField_13.getText();
					String depId = textField_14.getText();
					Integer outNum = Integer.parseInt(textField_15.getText());
					String outDate = textField_16.getText();
					stockUpdate.outStock(connection, devId, depId, outNum, outDate);		
				}catch (NumberFormatException e) {
					JOptionPane.showMessageDialog(null, "需求数量输入错误", "警告", JOptionPane.WARNING_MESSAGE);
				}
				catch (Exception e) {
					JOptionPane.showMessageDialog(null, "数据输入错误", "警告", JOptionPane.WARNING_MESSAGE);
				}
				
				
			}
		});
		
		
		/*设备还库*/
		btnNewButton_5.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent devBack) {
				StockUpdate stockUpdate = new StockUpdate();
				String devId = textField_17.getText();
				String depId = textField_18.getText();
				String backDate = textField_19.getText();
				String empId = textField_20.getText();
				stockUpdate.backStock(connection, devId, depId, backDate, empId);
			}
		});
		

		/*修改员工信息*/
		btnNewButton_6.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent empMdfy) {
				InfoModify infoModify = new InfoModify();
				int index = comboBox_1.getSelectedIndex();
				String empId = textField_12.getText();
				String newInfo = textField_21.getText();
				int test = index + newInfo.length();
				if ((test!=11&&test!=6)||(empId.length()!=6))
					JOptionPane.showMessageDialog(null, "数据格式错误", "警告", JOptionPane.WARNING_MESSAGE);
				else
					infoModify.modifyEmp(connection, empId, newInfo, index);
			}
		});
		
		/*修改供应商信息*/
		btnNewButton_7.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent vendMdfy) {
				InfoModify infoModify = new InfoModify();
				int index = comboBox_2.getSelectedIndex();
				String vendId = textField_22.getText();
				String newInfo = textField_23.getText();
				int len = newInfo.length();	
				
				if ((index==0&&len>25)||(index==1&&len>50)||vendId.length()!=6||len == 0)
					JOptionPane.showMessageDialog(null, "数据格式错误", "警告", JOptionPane.WARNING_MESSAGE);
				else
					infoModify.modifyVend(connection, vendId, newInfo, index);
			}
		});
		
		/*删除需求信息*/
		btnNewButton_8.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent delNeed) {
				InfoModify infoModify = new InfoModify();
				String devId = textField_24.getText();
				String depId = textField_25.getText();
				String startDate = textField_26.getText();
				
				if (devId.length() != 6||depId.length() != 5 )
					JOptionPane.showMessageDialog(null, "数据格式错误", "警告", JOptionPane.WARNING_MESSAGE);
				else
					infoModify.delNeed(connection, devId, depId, startDate);
			}
		});
		
		/*统计按钮事件*/
		btnNewButton_9.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent tj) {
				InfoSelect infoSelect = new InfoSelect();
				int[] num = infoSelect.statisGet(connection);
				textField_27.setText(""+num[0]);
				textField_28.setText(""+num[1]);
				textField_29.setText(""+num[2]);
				textField_30.setText(""+num[3]);
			}
		});
		
	}
}


