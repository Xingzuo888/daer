package View;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;

import Model.SdeptTypeModel;
import UserDao.UserSdeptType;
import Util.LianjieUtil;
import Util.StringUtil;

import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.awt.event.ActionEvent;

public class SdeptTypeClassAdd extends JInternalFrame {
	private JTextField sdeptName_textField;
	private JTextArea sdeptDes_textArea;
	private LianjieUtil lianjieutil=new LianjieUtil();
	private UserSdeptType userSdeptType=new UserSdeptType();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SdeptTypeClassAdd frame = new SdeptTypeClassAdd();
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
	public SdeptTypeClassAdd() {
		setTitle("\u7CFB\u522B\u6DFB\u52A0");
		setClosable(true);
		setIconifiable(true);
		setBounds(100, 100, 584, 484);
		getContentPane().setLayout(null);
		
		JLabel label_1 = new JLabel("\u7CFB\u522B\u540D\u79F0\uFF1A");
		label_1.setFont(new Font("宋体", Font.PLAIN, 20));
		label_1.setBounds(76, 67, 105, 40);
		getContentPane().add(label_1);
		
		sdeptName_textField = new JTextField();
		sdeptName_textField.setFont(new Font("宋体", Font.PLAIN, 20));
		sdeptName_textField.setBounds(184, 67, 279, 40);
		getContentPane().add(sdeptName_textField);
		sdeptName_textField.setColumns(10);
		
		JLabel label_2 = new JLabel("\u7CFB\u522B\u63CF\u8FF0\uFF1A");
		label_2.setFont(new Font("宋体", Font.PLAIN, 20));
		label_2.setBounds(76, 152, 105, 40);
		getContentPane().add(label_2);
		
		JButton button = new JButton("\u6DFB\u52A0");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sdeptAddActionPerformed(e);
			}
		});
		button.setBackground(Color.LIGHT_GRAY);
		button.setIcon(new ImageIcon("D:\\eclipse\u6587\u4EF6\\Jiemian\\src\\images\\add.png"));
		button.setFont(new Font("宋体", Font.PLAIN, 18));
		button.setBounds(76, 381, 105, 40);
		getContentPane().add(button);
		
		JButton button_1 = new JButton("\u91CD\u7F6E");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				resetValueActionPerformed(e);
			}
		});
		button_1.setIcon(new ImageIcon("D:\\eclipse\u6587\u4EF6\\Jiemian\\src\\images\\reset.png"));
		button_1.setFont(new Font("宋体", Font.PLAIN, 18));
		button_1.setBackground(Color.LIGHT_GRAY);
		button_1.setBounds(216, 381, 105, 40);
		getContentPane().add(button_1);
		
		sdeptDes_textArea = new JTextArea();
		sdeptDes_textArea.setFont(new Font("宋体", Font.PLAIN, 20));
		sdeptDes_textArea.setBounds(184, 163, 279, 156);
		getContentPane().add(sdeptDes_textArea);

	}

	/**
	 * 添加系别
	 * @param evt
	 */
	private void sdeptAddActionPerformed(ActionEvent evt) {
		String sdeptName=this.sdeptName_textField.getText();
		String sdeptDes=this.sdeptDes_textArea.getText();
		
		if(StringUtil.isEmpty(sdeptName)){
			JOptionPane.showMessageDialog(null, "名称不能为空！");
			return;
		}
		SdeptTypeModel sdeptType=new SdeptTypeModel(sdeptName,sdeptDes);
		Connection conn=null;
		conn=lianjieutil.GetConnection();
		try {
			if(userSdeptType.select(conn, sdeptType)){
				JOptionPane.showMessageDialog(null, "该名称已存在！");
			}else{
				int addnum=userSdeptType.add(conn, sdeptType);
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
			lianjieutil.Close(conn);
		}
		
	}

	/**
	 * 重置
	 * @param evt
	 */
	private void resetValueActionPerformed(ActionEvent evt) {
		this.sdeptName_textField.setText(null);
		this.sdeptDes_textArea.setText(null);
	}
}
