package View;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Vector;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Model.SdeptTypeModel;
import UserDao.UserSdeptType;
import Util.LianjieUtil;
import Util.StringUtil;

import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;
import java.awt.Color;
import javax.swing.JTextArea;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class SdeptTypeClassWeihu extends JInternalFrame {
	private JTextField s_sdeptName_textField;
	private JTable sdeptType_table;
	private LianjieUtil lianjieUtil=new LianjieUtil();
	private UserSdeptType userSdeptType=new UserSdeptType();
	private JTextField sdeptId_textField;
	private JTextField sdeptName_textField;
	private JTextArea sdeptDes_textArea;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SdeptTypeClassWeihu frame = new SdeptTypeClassWeihu();
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
	public SdeptTypeClassWeihu() {
		setTitle("\u7CFB\u522B\u7BA1\u7406\u7EF4\u62A4");
		setIconifiable(true);
		setClosable(true);
		setBounds(100, 100, 565, 612);
		getContentPane().setLayout(null);
		
		JLabel label = new JLabel("\u7CFB\u522B\u540D\u79F0\uFF1A");
		label.setFont(new Font("宋体", Font.PLAIN, 18));
		label.setBounds(50, 44, 101, 32);
		getContentPane().add(label);
		
		s_sdeptName_textField = new JTextField();
		s_sdeptName_textField.addKeyListener(new KeyListener() {
			public void keyTyped(KeyEvent e) {
			}
			public void keyReleased(KeyEvent e) {
			}
			public void keyPressed(KeyEvent e) {
				addSelectPerformed(e);
			}
		});
		s_sdeptName_textField.setFont(new Font("宋体", Font.PLAIN, 20));
		s_sdeptName_textField.setBounds(155, 44, 215, 32);
		getContentPane().add(s_sdeptName_textField);
		s_sdeptName_textField.setColumns(10);
		
		JButton select_button = new JButton("\u67E5\u8BE2");
		select_button.setBackground(Color.LIGHT_GRAY);
		select_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addSelectPerformed(e);
			}
		});
		select_button.setIcon(new ImageIcon(SdeptTypeClassWeihu.class.getResource("/images/search.png")));
		select_button.setFont(new Font("宋体", Font.PLAIN, 15));
		select_button.setBounds(400, 44, 90, 32);
		getContentPane().add(select_button);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(71, 113, 402, 175);
		getContentPane().add(scrollPane);
		
		sdeptType_table = new JTable();
		sdeptType_table.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				sdeptTypeTableMousePressed(e);
			}
		});
		sdeptType_table.setFont(new Font("宋体", Font.PLAIN, 12));
		sdeptType_table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u7F16\u53F7", "\u7CFB\u522B\u540D\u79F0", "\u7CFB\u522B\u63CF\u8FF0"
			}
		));
		sdeptType_table.getColumnModel().getColumn(0).setPreferredWidth(57);
		sdeptType_table.getColumnModel().getColumn(1).setPreferredWidth(94);
		sdeptType_table.getColumnModel().getColumn(2).setPreferredWidth(120);
		scrollPane.setViewportView(sdeptType_table);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "\u8868\u5355\u64CD\u4F5C", TitledBorder.LEADING, TitledBorder.TOP, null, Color.RED));
		panel.setBounds(71, 323, 402, 215);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel label_1 = new JLabel("\u7F16\u53F7\uFF1A");
		label_1.setFont(new Font("宋体", Font.PLAIN, 15));
		label_1.setBounds(23, 30, 45, 31);
		panel.add(label_1);
		
		sdeptId_textField = new JTextField();
		sdeptId_textField.setEditable(false);
		sdeptId_textField.setBounds(78, 30, 93, 31);
		panel.add(sdeptId_textField);
		sdeptId_textField.setColumns(10);
		
		JLabel label_2 = new JLabel("\u540D\u79F0\uFF1A");
		label_2.setFont(new Font("宋体", Font.PLAIN, 15));
		label_2.setBounds(181, 30, 45, 31);
		panel.add(label_2);
		
		sdeptName_textField = new JTextField();
		sdeptName_textField.setBounds(236, 30, 133, 31);
		panel.add(sdeptName_textField);
		sdeptName_textField.setColumns(10);
		
		JLabel label_3 = new JLabel("\u63CF\u8FF0\uFF1A");
		label_3.setFont(new Font("宋体", Font.PLAIN, 15));
		label_3.setBounds(23, 71, 45, 31);
		panel.add(label_3);
		
		JButton update_button = new JButton("\u4FEE\u6539");
		update_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sdeptTypeUpdate(e);
			}
		});
		update_button.setBackground(Color.YELLOW);
		update_button.setIcon(new ImageIcon(SdeptTypeClassWeihu.class.getResource("/images/modify.png")));
		update_button.setBounds(23, 174, 93, 31);
		panel.add(update_button);
		
		JButton delete_button = new JButton("\u5220\u9664");
		delete_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sdeptTypeDelete(e);
			}
		});
		delete_button.setBackground(Color.RED);
		delete_button.setIcon(new ImageIcon(SdeptTypeClassWeihu.class.getResource("/images/delete.png")));
		delete_button.setBounds(126, 173, 93, 32);
		panel.add(delete_button);
		
		sdeptDes_textArea = new JTextArea();
		sdeptDes_textArea.setBounds(78, 78, 291, 76);
		panel.add(sdeptDes_textArea);

		this.fillTable(new SdeptTypeModel());
	}
	
	/**
	 * 删除事件处理
	 * @param evt
	 */
	private void sdeptTypeDelete(ActionEvent evt) {
		String sdeptIdString=sdeptId_textField.getText();
		if(StringUtil.isEmpty(sdeptIdString)){
			JOptionPane.showMessageDialog(null, "请选择要删除的记录！");
			return;
		}
		int n=JOptionPane.showConfirmDialog(null, "确定要删除该记录吗？");
		if(n==0){
			Integer sdeptId=new Integer(sdeptIdString);
			Connection  conn=null;
			try {
				conn=lianjieUtil.GetConnection();
				int deletenum=userSdeptType.delete(conn, sdeptId);
				if(deletenum==1){
					JOptionPane.showMessageDialog(null, "删除成功");
					this.resetValue();
					this.fillTable(new SdeptTypeModel());
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
	 * 修改事件处理
	 * @param evt
	 */
	private void sdeptTypeUpdate(ActionEvent evt) {
		String sdeptIdString=sdeptId_textField.getText();
		String sdeptName=sdeptName_textField.getText();
		String sdeptDes=sdeptDes_textArea.getText();
		if(StringUtil.isEmpty(sdeptIdString)){
			JOptionPane.showMessageDialog(null, "请选择要修改的记录！");
			return;
		}
		if(StringUtil.isEmpty(sdeptName)){
			JOptionPane.showMessageDialog(null, "系别名称不能为空！");
			return;
		}
		Integer sdeptId=new Integer(sdeptIdString);
		SdeptTypeModel sdeptTypeModel=new SdeptTypeModel(sdeptId,sdeptName,sdeptDes);
		Connection  conn=null;
		try {
			conn=lianjieUtil.GetConnection();
			int updatenum=userSdeptType.update(conn, sdeptTypeModel);
			if(updatenum==1){
				JOptionPane.showMessageDialog(null, "修改成功");
				this.resetValue();
				this.fillTable(new SdeptTypeModel());
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
	private void sdeptTypeTableMousePressed(MouseEvent evt) {
		int row=sdeptType_table.getSelectedRow();
		sdeptId_textField.setText((String)sdeptType_table.getValueAt(row, 0));
		sdeptName_textField.setText((String)sdeptType_table.getValueAt(row, 1));
		sdeptDes_textArea.setText((String)sdeptType_table.getValueAt(row, 2));
	}

	/**
	 * enter键事件处理
	 */
	private void addSelectPerformed(KeyEvent evt) {
		String s_sdeptName=this.s_sdeptName_textField.getText();
		SdeptTypeModel sdeptTypeModel=new SdeptTypeModel();
		sdeptTypeModel.setSdeptName(s_sdeptName);
		this.fillTable(sdeptTypeModel);
	}
	
	/**
	 * 查询按钮事件处理
	 * @param evt
	 */
	private void addSelectPerformed(ActionEvent evt) {
		String s_sdeptName=this.s_sdeptName_textField.getText();
		SdeptTypeModel sdeptTypeModel=new SdeptTypeModel();
		sdeptTypeModel.setSdeptName(s_sdeptName);
		this.fillTable(sdeptTypeModel);
	}

	/**
	 * 初始化表格
	 * @param sdeptTypeModel
	 */
	private void fillTable(SdeptTypeModel sdeptTypeModel){
		DefaultTableModel dtm=(DefaultTableModel)sdeptType_table.getModel();
		dtm.setRowCount(0);
		Connection conn=null;
		try {
			conn=lianjieUtil.GetConnection();
			ResultSet rs=userSdeptType.select_Table(conn, sdeptTypeModel);
			while(rs.next()){
				Vector v=new Vector();
				v.add(rs.getString("sdeptId"));
				v.add(rs.getString("sdeptName"));
				v.add(rs.getString("sdeptDes"));
				dtm.addRow(v);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			lianjieUtil.Close(conn);
		}
	}
	
	/**
	 * 重置表单
	 */
	private void resetValue(){
		this.sdeptId_textField.setText(null);
		this.sdeptName_textField.setText(null);
		this.sdeptDes_textArea.setText(null);
	}
}
