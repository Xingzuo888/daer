package View;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Model.ReaderModel;
import Model.SdeptTypeModel;
import UserDao.UserReader;
import UserDao.UserSdeptType;
import Util.IntegerUtil;
import Util.LianjieUtil;
import Util.StringUtil;

import javax.swing.UIManager;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Vector;
import java.awt.event.ActionEvent;
import javax.swing.ButtonGroup;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ReaderClassWeihu extends JInternalFrame {
	private JTextField s_readerId_textField;
	private JTextField s_readerName_textField;
	private JTable reader_table;
	private JTextField readerId_textField;
	private JTextField readerName_textField;
	private JTextField age_textField;
	private JRadioButton s_sexNull_radioButton;
	private JRadioButton s_sexMan_radioButton;
	private JRadioButton s_sexWoman_radioButton;
	private JComboBox s_sdept_comboBox;
	private JRadioButton sexMan_radioButton;
	private JRadioButton sexWoman_radioButton;
	private JComboBox sdept_comboBox;
	private LianjieUtil lianjieUtil=new LianjieUtil();
	private UserReader userReader=new UserReader();
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private final ButtonGroup buttonGroup_1 = new ButtonGroup();
	private JTextField bamount_textField;
	private JTextField allFun_textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ReaderClassWeihu frame = new ReaderClassWeihu();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ReaderClassWeihu() {
		setTitle("\u8BFB\u8005\u7EF4\u62A4");
		setIconifiable(true);
		setClosable(true);
		setBounds(100, 100, 592, 728);
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "\u641C\u7D22\u6761\u4EF6", TitledBorder.LEADING, TitledBorder.TOP, null, Color.BLUE));
		panel.setBounds(28, 36, 517, 112);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel label = new JLabel("\u8BFB\u8005\u5B66\u53F7\uFF1A");
		label.setFont(new Font("宋体", Font.PLAIN, 15));
		label.setBounds(23, 32, 75, 25);
		panel.add(label);
		
		s_readerId_textField = new JTextField();
		s_readerId_textField.setBounds(108, 32, 108, 25);
		panel.add(s_readerId_textField);
		s_readerId_textField.setColumns(10);
		
		JLabel label_1 = new JLabel("\u8BFB\u8005\u59D3\u540D\uFF1A");
		label_1.setFont(new Font("宋体", Font.PLAIN, 15));
		label_1.setBounds(257, 32, 75, 25);
		panel.add(label_1);
		
		s_readerName_textField = new JTextField();
		s_readerName_textField.setBounds(342, 32, 119, 25);
		panel.add(s_readerName_textField);
		s_readerName_textField.setColumns(10);
		
		JLabel label_2 = new JLabel("\u6027\u522B\uFF1A");
		label_2.setFont(new Font("宋体", Font.PLAIN, 15));
		label_2.setBounds(23, 67, 45, 25);
		panel.add(label_2);
		
		s_sexNull_radioButton = new JRadioButton("\u5168\u90E8");
		s_sexNull_radioButton.setSelected(true);
		buttonGroup.add(s_sexNull_radioButton);
		s_sexNull_radioButton.setFont(new Font("宋体", Font.PLAIN, 15));
		s_sexNull_radioButton.setBounds(74, 68, 55, 23);
		panel.add(s_sexNull_radioButton);
		
		s_sexMan_radioButton = new JRadioButton("\u7537");
		buttonGroup.add(s_sexMan_radioButton);
		s_sexMan_radioButton.setFont(new Font("宋体", Font.PLAIN, 15));
		s_sexMan_radioButton.setBounds(131, 68, 45, 23);
		panel.add(s_sexMan_radioButton);
		
		s_sexWoman_radioButton = new JRadioButton("\u5973");
		buttonGroup.add(s_sexWoman_radioButton);
		s_sexWoman_radioButton.setFont(new Font("宋体", Font.PLAIN, 15));
		s_sexWoman_radioButton.setBounds(178, 68, 45, 23);
		panel.add(s_sexWoman_radioButton);
		
		JLabel label_3 = new JLabel("\u7CFB\u522B\uFF1A");
		label_3.setFont(new Font("宋体", Font.PLAIN, 15));
		label_3.setBounds(239, 67, 45, 25);
		panel.add(label_3);
		
		s_sdept_comboBox = new JComboBox();
		s_sdept_comboBox.setBounds(294, 67, 108, 25);
		panel.add(s_sdept_comboBox);
		
		JButton button = new JButton("\u67E5\u8BE2");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addSelectPerformed(e);
			}
		});
		button.setBackground(Color.LIGHT_GRAY);
		button.setIcon(new ImageIcon(ReaderClassWeihu.class.getResource("/images/search.png")));
		button.setFont(new Font("宋体", Font.PLAIN, 15));
		button.setBounds(414, 63, 93, 33);
		panel.add(button);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(28, 170, 517, 225);
		getContentPane().add(scrollPane);
		
		reader_table = new JTable();
		reader_table.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				readerTableMousePressed(e);
			}
		});
		reader_table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u8BFB\u8005\u5B66\u53F7", "\u8BFB\u8005\u59D3\u540D", "\u6027\u522B", "\u5E74\u9F84", "\u7CFB\u522B", "\u501F\u9605\u91CF", "\u7F5A\u6B3E\u603B\u989D"
			}
		));
		scrollPane.setViewportView(reader_table);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "\u8868\u5355\u64CD\u4F5C", TitledBorder.LEADING, TitledBorder.TOP, null, Color.RED));
		panel_1.setBounds(28, 421, 517, 236);
		getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JLabel label_4 = new JLabel("\u8BFB\u8005\u5B66\u53F7\uFF1A");
		label_4.setFont(new Font("宋体", Font.PLAIN, 15));
		label_4.setBounds(28, 28, 78, 27);
		panel_1.add(label_4);
		
		readerId_textField = new JTextField();
		readerId_textField.setEditable(false);
		readerId_textField.setBounds(116, 28, 104, 27);
		panel_1.add(readerId_textField);
		readerId_textField.setColumns(10);
		
		JLabel label_5 = new JLabel("\u8BFB\u8005\u59D3\u540D\uFF1A");
		label_5.setFont(new Font("宋体", Font.PLAIN, 15));
		label_5.setBounds(245, 28, 78, 27);
		panel_1.add(label_5);
		
		readerName_textField = new JTextField();
		readerName_textField.setBounds(333, 28, 144, 27);
		panel_1.add(readerName_textField);
		readerName_textField.setColumns(10);
		
		JLabel label_6 = new JLabel("\u6027\u522B\uFF1A");
		label_6.setFont(new Font("宋体", Font.PLAIN, 15));
		label_6.setBounds(28, 74, 45, 27);
		panel_1.add(label_6);
		
		sexMan_radioButton = new JRadioButton("\u7537");
		buttonGroup_1.add(sexMan_radioButton);
		sexMan_radioButton.setFont(new Font("宋体", Font.PLAIN, 15));
		sexMan_radioButton.setBounds(79, 76, 41, 23);
		panel_1.add(sexMan_radioButton);
		
		sexWoman_radioButton = new JRadioButton("\u5973");
		buttonGroup_1.add(sexWoman_radioButton);
		sexWoman_radioButton.setFont(new Font("宋体", Font.PLAIN, 15));
		sexWoman_radioButton.setBounds(122, 76, 41, 23);
		panel_1.add(sexWoman_radioButton);
		
		JLabel label_7 = new JLabel("\u5E74\u9F84\uFF1A");
		label_7.setFont(new Font("宋体", Font.PLAIN, 15));
		label_7.setBounds(184, 74, 45, 27);
		panel_1.add(label_7);
		
		age_textField = new JTextField();
		age_textField.setBounds(239, 74, 66, 27);
		panel_1.add(age_textField);
		age_textField.setColumns(10);
		
		JLabel label_9 = new JLabel("\u7CFB\u522B\uFF1A");
		label_9.setFont(new Font("宋体", Font.PLAIN, 15));
		label_9.setBounds(28, 121, 45, 27);
		panel_1.add(label_9);
		
		sdept_comboBox = new JComboBox();
		sdept_comboBox.setBounds(79, 121, 98, 27);
		panel_1.add(sdept_comboBox);
		
		JButton button_1 = new JButton("\u4FEE\u6539");
		button_1.setBackground(Color.YELLOW);
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				readerUpdate(e);
			}
		});
		button_1.setIcon(new ImageIcon(ReaderClassWeihu.class.getResource("/images/modify.png")));
		button_1.setFont(new Font("宋体", Font.PLAIN, 15));
		button_1.setBounds(27, 182, 93, 33);
		panel_1.add(button_1);
		
		JButton button_2 = new JButton("\u5220\u9664");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				readerDelete(e);
			}
		});
		button_2.setBackground(Color.RED);
		button_2.setIcon(new ImageIcon(ReaderClassWeihu.class.getResource("/images/delete.png")));
		button_2.setFont(new Font("宋体", Font.PLAIN, 15));
		button_2.setBounds(149, 182, 93, 33);
		panel_1.add(button_2);
		
		JLabel label_8 = new JLabel("\u501F\u9605\u91CF\uFF1A");
		label_8.setFont(new Font("宋体", Font.PLAIN, 15));
		label_8.setBounds(195, 121, 60, 27);
		panel_1.add(label_8);
		
		bamount_textField = new JTextField();
		bamount_textField.setEditable(false);
		bamount_textField.setBounds(265, 121, 45, 27);
		panel_1.add(bamount_textField);
		bamount_textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("\u7F5A\u6B3E\u603B\u989D\uFF1A");
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 15));
		lblNewLabel.setBounds(333, 121, 75, 27);
		panel_1.add(lblNewLabel);
		
		allFun_textField = new JTextField();
		allFun_textField.setEditable(false);
		allFun_textField.setBounds(418, 121, 59, 27);
		panel_1.add(allFun_textField);
		allFun_textField.setColumns(10);

		this.fillSdeptType("search");
		this.fillTable(new ReaderModel());
	}
	
	/**
	 * 删除数据
	 * @param evt
	 */
	private void readerDelete(ActionEvent evt) {
		String readerIdString=this.readerId_textField.getText();
		if(StringUtil.isEmpty(readerIdString)){
			JOptionPane.showMessageDialog(null, "请选择要删除的记录！");
			return;
		}
		int n=JOptionPane.showConfirmDialog(null, "确定要删除该记录吗？");
		if(n==0){
			Integer readerId=new Integer(readerIdString);
			Connection  conn=null;
			try {
				conn=lianjieUtil.GetConnection();
				int deletenum=userReader.delete(conn, readerId);
				if(deletenum==1){
					JOptionPane.showMessageDialog(null, "删除成功");
					this.resetValue();
					this.fillTable(new ReaderModel());
				}else{
					JOptionPane.showMessageDialog(null, "删除失败");
				}
			} catch (Exception e) {
				e.printStackTrace();
				JOptionPane.showMessageDialog(null, "删除失败");
			}finally{
				lianjieUtil.Close(conn);
			}
		}
	}

	/**
	 * 修改数据
	 * @param evt
	 */
	private void readerUpdate(ActionEvent evt) {
		String readerIdString=this.readerId_textField.getText();
		String readerName=this.readerName_textField.getText();
		String ageString=this.age_textField.getText();
		Integer readerId=null;
		Integer age=null;
		if(StringUtil.isEmpty(readerIdString)){
			JOptionPane.showMessageDialog(null, "请选择要修改的记录！");
			return;
		}
		if(StringUtil.isEmpty(readerName)){
			JOptionPane.showMessageDialog(null, "读者姓名不能为空！");
			return;
		}
		if(StringUtil.isEmpty(ageString)){
			JOptionPane.showMessageDialog(null, "年龄不能为空！");
			return;
		}
		readerId=new Integer(readerIdString);
		if(!IntegerUtil.isEmpty(ageString)){
			JOptionPane.showMessageDialog(null, "读者年龄不合法！");
			return;
		}else{
			age=new Integer(ageString);
		}
		if(age<=0){
			JOptionPane.showMessageDialog(null, "读者年龄不合法！");
			return;
		}
		String sex=null;
		if(this.sexMan_radioButton.isSelected()){
			sex=this.sexMan_radioButton.getText();
		}else{
			sex=this.sexWoman_radioButton.getText();
		}
		
		SdeptTypeModel sdeptTypeModel=(SdeptTypeModel) this.sdept_comboBox.getSelectedItem();
		String sdept=sdeptTypeModel.getSdeptName();
		
		Connection conn=lianjieUtil.GetConnection();
		ReaderModel readerModel=new ReaderModel(readerId,readerName,sex,age,sdept);
		try {
			int updatenum=userReader.update(conn, readerModel);
			if(updatenum==1){
				JOptionPane.showMessageDialog(null, "修改成功");
				this.resetValue();
				this.fillTable(new ReaderModel());
			}else{
				JOptionPane.showMessageDialog(null, "修改失败");
			}
		} catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "修改失败");
		}finally{
			lianjieUtil.Close(conn);
		}
	}

	/**
	 * 表格行事件处理
	 * @param evt
	 */
	private void readerTableMousePressed(MouseEvent evt) {
		int row=reader_table.getSelectedRow();
		readerId_textField.setText((String) reader_table.getValueAt(row, 0));
		readerName_textField.setText((String) reader_table.getValueAt(row, 1));
		String sex=(String) reader_table.getValueAt(row, 2);
		if("男 ".equals(sex)){
			sexMan_radioButton.setSelected(true);
		}else if("女 ".equals(sex)){
			sexWoman_radioButton.setSelected(true);
		}
		age_textField.setText((String) reader_table.getValueAt(row, 3));
		String sdept=(String) reader_table.getValueAt(row, 4);
		this.fillSdeptType("modify");
		int n=this.sdept_comboBox.getItemCount();
		for(int i=0;i<n;i++){
			SdeptTypeModel sdeptTypeModel=(SdeptTypeModel) sdept_comboBox.getItemAt(i);
			if(sdeptTypeModel.getSdeptName().equals(sdept)){
				sdept_comboBox.setSelectedIndex(i);
			}
		}
		bamount_textField.setText(String.valueOf(reader_table.getValueAt(row, 5)));
		allFun_textField.setText(String.valueOf(reader_table.getValueAt(row, 6)));
	}

	/**
	 * 查询按钮事件处理
	 * @param evt
	 */
	private void addSelectPerformed(ActionEvent evt) {
		String readerIdString=this.s_readerId_textField.getText();
		String readerName=this.s_readerName_textField.getText();
		String sex = null;
		Integer readerId=null;
		
		if(StringUtil.isNotEmpty(readerIdString)){
			if(IntegerUtil.isEmpty(readerIdString)){
				readerId=new Integer(readerIdString);
			}
		}
		
		if(this.s_sexNull_radioButton.isSelected()){
			sex=null;
		}else if(this.s_sexMan_radioButton.isSelected()){
			sex=this.s_sexMan_radioButton.getText();
		}else if(this.s_sexWoman_radioButton.isSelected()){
			sex=this.s_sexWoman_radioButton.getText();
		}
		
		SdeptTypeModel sdeptTypeModel=(SdeptTypeModel) this.s_sdept_comboBox.getSelectedItem();
		String sdept=sdeptTypeModel.getSdeptName();
		if(sdept.equals("请选择...")){
			sdept=null;
		}
		
		ReaderModel readerModel=new ReaderModel(readerId,readerName,sex,sdept);
		this.fillTable(readerModel);
	}

	/**
	 * 初始化表格
	 * @param readerModel
	 */
	public void fillTable(ReaderModel readerModel){
		DefaultTableModel dtm=(DefaultTableModel)reader_table.getModel();
		dtm.setRowCount(0);
		Connection conn=null;
		try {
			conn=lianjieUtil.GetConnection();
			ResultSet rs=userReader.select_Table(conn, readerModel);
			while(rs.next()){
				Vector v=new Vector();
				v.add(rs.getString("readerId"));
				v.add(rs.getString("readerName"));
				v.add(rs.getString("sex"));
				v.add(rs.getString("age"));
				v.add(rs.getString("sdept"));
				v.add(rs.getInt("bamount"));
				v.add(rs.getDouble("allFun"));
				dtm.addRow(v);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			lianjieUtil.Close(conn);
		}
	}
	
	/**
	 * 初始化下拉菜单
	 */
	private void fillSdeptType(String Type){
		Connection conn=null;
		SdeptTypeModel sdeptTypeModel=null;
		try{
			conn=lianjieUtil.GetConnection();
			ResultSet rs=UserSdeptType.comboBoxList(conn, new SdeptTypeModel());
			if("search".equals(Type)){
				sdeptTypeModel=new SdeptTypeModel();
				sdeptTypeModel.setSdeptId(-1);
				sdeptTypeModel.setSdeptName("请选择...");
				this.s_sdept_comboBox.addItem(sdeptTypeModel);
			}
			while(rs.next()){
				sdeptTypeModel=new SdeptTypeModel();
				sdeptTypeModel.setSdeptId(rs.getInt("sdeptId"));
				sdeptTypeModel.setSdeptName(rs.getString("sdeptName"));
				if("search".equals(Type)){
					this.s_sdept_comboBox.addItem(sdeptTypeModel);
				}else if("modify".equals(Type)){
					this.sdept_comboBox.addItem(sdeptTypeModel);
				}
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			lianjieUtil.Close(conn);
		}
	}
	
	/**
	 * 重置
	 */
	private void resetValue(){
		this.readerId_textField.setText(null);
		this.readerName_textField.setText(null);
		this.sexMan_radioButton.setSelected(true);
		this.sexWoman_radioButton.setSelected(false);
		this.age_textField.setText(null);
		this.sdept_comboBox.setSelectedIndex(-1);
		this.bamount_textField.setText(null);
		this.allFun_textField.setText(null);
	}
}
