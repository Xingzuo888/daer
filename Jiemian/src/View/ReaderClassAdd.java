package View;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.ResultSet;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import Model.ReaderModel;
import Model.SdeptTypeModel;
import UserDao.UserReader;
import UserDao.UserSdeptType;
import Util.IntegerUtil;
import Util.LianjieUtil;
import Util.StringUtil;

import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;

public class ReaderClassAdd extends JInternalFrame {
	private JTextField readerId_textField;
	private JTextField readerName_textField;
	private JTextField age_textField;
	private JRadioButton sex_man_radioButton;
	private JRadioButton sex_woman_radioButton;
	private JComboBox sdept_comboBox;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private LianjieUtil lianjieUtil=new LianjieUtil();
	private UserReader userReader=new UserReader();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BookClassAdd frame = new BookClassAdd();
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
	public ReaderClassAdd() {
		setTitle("\u8BFB\u8005\u6DFB\u52A0");
		setIconifiable(true);
		setClosable(true);
		setBounds(100, 100, 759, 518);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\u8BFB\u8005\u5B66\u53F7\uFF1A");
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 20));
		lblNewLabel.setBounds(49, 79, 109, 39);
		getContentPane().add(lblNewLabel);
		
		readerId_textField = new JTextField();
		readerId_textField.setText("\u8F93\u5165\u6574\u6570");
		readerId_textField.addMouseListener(new MouseListener() {
			public void mouseReleased(MouseEvent e) {
			}
			public void mousePressed(MouseEvent e) {
			}
			public void mouseExited(MouseEvent e) {
				if(readerId_textField.getText().equals("")){
					readerId_textField.setText("输入整数");
				}
			}
			public void mouseEntered(MouseEvent e) {
			}
			public void mouseClicked(MouseEvent e) {
				if(readerId_textField.getText().equals("输入整数")){
					readerId_textField.setText(null);
				}
			}
		});
		readerId_textField.setFont(new Font("宋体", Font.PLAIN, 20));
		readerId_textField.setBounds(168, 79, 185, 39);
		getContentPane().add(readerId_textField);
		readerId_textField.setColumns(10);
		
		JLabel label = new JLabel("\u8BFB\u8005\u59D3\u540D\uFF1A");
		label.setHorizontalAlignment(SwingConstants.RIGHT);
		label.setFont(new Font("宋体", Font.PLAIN, 20));
		label.setBounds(377, 79, 100, 39);
		getContentPane().add(label);
		
		JButton Add_button = new JButton("\u6DFB\u52A0");
		Add_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				readerAddActionPerformed(e);
			}
		});
		Add_button.setBackground(Color.LIGHT_GRAY);
		Add_button.setIcon(new ImageIcon("D:\\eclipse\u6587\u4EF6\\Jiemian\\src\\images\\add.png"));
		Add_button.setBounds(181, 378, 108, 34);
		getContentPane().add(Add_button);
		
		JButton Reset_button = new JButton("\u91CD\u7F6E");
		Reset_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				resetValueActionPerformed(e);
			}
		});
		Reset_button.setBackground(Color.LIGHT_GRAY);
		Reset_button.setIcon(new ImageIcon("D:\\eclipse\u6587\u4EF6\\Jiemian\\src\\images\\reset.png"));
		Reset_button.setBounds(438, 378, 108, 34);
		getContentPane().add(Reset_button);
		
		readerName_textField = new JTextField();
		readerName_textField.setFont(new Font("宋体", Font.PLAIN, 20));
		readerName_textField.setBounds(487, 79, 185, 39);
		getContentPane().add(readerName_textField);
		readerName_textField.setColumns(10);
		
		JLabel label_1 = new JLabel("\u8BFB\u8005\u6027\u522B\uFF1A");
		label_1.setHorizontalAlignment(SwingConstants.RIGHT);
		label_1.setFont(new Font("宋体", Font.PLAIN, 20));
		label_1.setBounds(49, 166, 109, 39);
		getContentPane().add(label_1);
		
		JLabel label_2 = new JLabel("\u8BFB\u8005\u7CFB\u522B\uFF1A");
		label_2.setHorizontalAlignment(SwingConstants.RIGHT);
		label_2.setFont(new Font("宋体", Font.PLAIN, 20));
		label_2.setBounds(49, 257, 109, 39);
		getContentPane().add(label_2);
		
		JLabel lblNian = new JLabel("\u8BFB\u8005\u5E74\u9F84\uFF1A");
		lblNian.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNian.setFont(new Font("宋体", Font.PLAIN, 20));
		lblNian.setBounds(377, 166, 100, 39);
		getContentPane().add(lblNian);
		
		age_textField = new JTextField();
		age_textField.setText("\u8F93\u5165\u6574\u6570");
		age_textField.addMouseListener(new MouseListener() {
			public void mouseReleased(MouseEvent e) {
			}
			public void mousePressed(MouseEvent e) {
			}
			public void mouseExited(MouseEvent e) {
				if(age_textField.getText().equals("")){
					age_textField.setText("输入整数");
				}
			}
			public void mouseEntered(MouseEvent e) {
			}
			public void mouseClicked(MouseEvent e) {
				if(age_textField.getText().equals("输入整数")){
					age_textField.setText(null);
				}
			}
		});
		age_textField.setFont(new Font("宋体", Font.PLAIN, 20));
		age_textField.setBounds(487, 166, 185, 39);
		getContentPane().add(age_textField);
		age_textField.setColumns(10);
		
		sex_man_radioButton = new JRadioButton("\u7537");
		buttonGroup.add(sex_man_radioButton);
		sex_man_radioButton.setSelected(true);
		sex_man_radioButton.setFont(new Font("宋体", Font.PLAIN, 20));
		sex_man_radioButton.setBounds(168, 174, 45, 23);
		getContentPane().add(sex_man_radioButton);
		
		sex_woman_radioButton = new JRadioButton("\u5973");
		buttonGroup.add(sex_woman_radioButton);
		sex_woman_radioButton.setFont(new Font("宋体", Font.PLAIN, 20));
		sex_woman_radioButton.setBounds(231, 174, 45, 23);
		getContentPane().add(sex_woman_radioButton);
		
		sdept_comboBox = new JComboBox();
		sdept_comboBox.setBounds(168, 261, 161, 34);
		getContentPane().add(sdept_comboBox);

		fillSdeptType();
	}

	/**
	 * 添加读者事件处理
	 * @param evt
	 */
	private void readerAddActionPerformed(ActionEvent evt) {
		String readerIdString=this.readerId_textField.getText();
		String readerName=this.readerName_textField.getText();
		Integer readerId=null;
		Integer age=null;
		if(StringUtil.isEmpty(readerIdString)){
			JOptionPane.showMessageDialog(null, "读者学号不能为空！");
			return;
		}
		if(StringUtil.isEmpty(readerName)){
			JOptionPane.showMessageDialog(null, "读者姓名不能为空！");
			return;
		}
		
		if(!IntegerUtil.isEmpty(readerIdString)){
			JOptionPane.showMessageDialog(null, "读者学号不合法！");
			return;
		}else{
			readerId=new Integer(readerIdString);
		}
		if(readerId<=0){
			JOptionPane.showMessageDialog(null, "读者学号不合法！");
			return;
		}
		
		if(!IntegerUtil.isEmpty(this.age_textField.getText())){
			JOptionPane.showMessageDialog(null, "读者年龄不合法！");
			return;
		}else{
			age=new Integer(this.age_textField.getText());
		}		
		if(age<=0){
			JOptionPane.showMessageDialog(null, "读者年龄不合法！");
			return;
		}
		
		String sex=null;
		if(this.sex_man_radioButton.isSelected()){
			sex=this.sex_man_radioButton.getText();
		}else{
			sex=this.sex_woman_radioButton.getText();
		}
		
		SdeptTypeModel sdeptTypeModel=(SdeptTypeModel) this.sdept_comboBox.getSelectedItem();
		String sdept=sdeptTypeModel.getSdeptName();
		
		Connection conn=lianjieUtil.GetConnection();
		ReaderModel readerModel=new ReaderModel(readerId,readerName,sex,age,sdept);
		try {
			if(userReader.selectReaderId(conn, readerModel) != null){
				JOptionPane.showMessageDialog(null, "该学号已存在！");
			}else{
				int addnum=userReader.add(conn, readerModel);
				if(addnum==1){
					JOptionPane.showMessageDialog(null, "添加成功");
				}else{
					JOptionPane.showMessageDialog(null, "添加失败");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "添加失败");
		}finally{
			lianjieUtil.Close(conn);
		}
	}

	/**
	 * 初始化下拉菜单
	 */
	private void fillSdeptType(){
		Connection conn=null;
		SdeptTypeModel sdeptTypeModel=null;
		try{
			conn=lianjieUtil.GetConnection();
			ResultSet rs=UserSdeptType.comboBoxList(conn, new SdeptTypeModel());
			while(rs.next()){
				sdeptTypeModel=new SdeptTypeModel();
				sdeptTypeModel.setSdeptId(rs.getInt("sdeptId"));
				sdeptTypeModel.setSdeptName(rs.getString("sdeptName"));
				this.sdept_comboBox.addItem(sdeptTypeModel);
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			lianjieUtil.Close(conn);
		}
	}
	
	/**
	 * 重置
	 * @param evt
	 */
	private void resetValueActionPerformed(ActionEvent evt) {
		this.readerId_textField.setText(null);
		this.readerName_textField.setText(null);
		this.age_textField.setText(null);
		this.sex_man_radioButton.setSelected(true);
		this.sex_woman_radioButton.setSelected(false);
		fillSdeptType();
		this.sdept_comboBox.setSelectedIndex(0);
	}
}
