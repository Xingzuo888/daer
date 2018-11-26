package Ui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;

import UserDao_dengluxitong.UserDao_dengluxitong;
import User_dengluxitong.User_dengluxitong;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;
import java.awt.event.ActionEvent;

public class Denglu extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Denglu frame = new Denglu();
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
	public Denglu() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("用户名：");
		lblNewLabel.setBounds(83, 61, 54, 15);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("密  码：");
		lblNewLabel_1.setBounds(83, 105, 54, 15);
		contentPane.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(147, 58, 179, 21);
		contentPane.add(textField);
		textField.setColumns(10);
		
		
		JPasswordField password = new JPasswordField();
		password.setBounds(147, 102, 179, 21);
		contentPane.add(password);
		password.setEchoChar('*');
		password.setColumns(10);
		
		JButton btnNewButton = new JButton("登录");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					UserDao_dengluxitong userdao = new UserDao_dengluxitong();
					List<User_dengluxitong> user=userdao.query();
					//转换密码框的信息
					String pass = String.valueOf(password.getPassword());	
					//验证用户名、密码都没有输入的情况
					if(textField.getText().equals("")&&pass.equals("")){
						JOptionPane.showMessageDialog(getParent(), "请填写用户名和密码！", "信息提示框", JOptionPane.INFORMATION_MESSAGE);
						return ;
					}
					//验证没有输入密码的情况
					else if(!textField.getText().equals("")&&pass.equals("")){
						JOptionPane.showMessageDialog(getParent(), "请填写密码！", "信息提示框", JOptionPane.INFORMATION_MESSAGE);
						return ;
					}
					else{
						int i=0;
						for (User_dengluxitong u : user) {	
							//验证密码是否与数据库匹配的情况
							if(textField.getText().equals(u.getID())){
								if(pass.equals(u.getCODE())){
									if(u.getNUM()==1){
										Student student=new Student();
										student.setVisible(true);
										return ;
									}else{
										Teacher teacher=new Teacher();
										teacher.setVisible(true);
										return ;
									}
								}
								else{	
									JOptionPane.showMessageDialog(getParent(), "输入密码名错误！", "信息提示框", JOptionPane.INFORMATION_MESSAGE);
									password.setText(null);
									return ;
								}
							}
							i++;
						}
					
						//验证用户名和密码是否与数据库匹配的情况
						if(user.size()==i){
							JOptionPane.showMessageDialog(getParent(), "输入用户名和密码错误！", "信息提示框", JOptionPane.INFORMATION_MESSAGE);
							textField.setText(null);
							password.setText(null);
							return ;
						}

					
					}
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnNewButton.setBounds(86, 185, 93, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("注册");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Zhuce z=new Zhuce();
				z.setVisible(true);	
				dispose();
			}
		});
		btnNewButton_1.setBounds(236, 185, 93, 23);
		contentPane.add(btnNewButton_1);
	}
}
