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
		
		JLabel lblNewLabel = new JLabel("�û�����");
		lblNewLabel.setBounds(83, 61, 54, 15);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("��  �룺");
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
		
		JButton btnNewButton = new JButton("��¼");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					UserDao_dengluxitong userdao = new UserDao_dengluxitong();
					List<User_dengluxitong> user=userdao.query();
					//ת����������Ϣ
					String pass = String.valueOf(password.getPassword());	
					//��֤�û��������붼û����������
					if(textField.getText().equals("")&&pass.equals("")){
						JOptionPane.showMessageDialog(getParent(), "����д�û��������룡", "��Ϣ��ʾ��", JOptionPane.INFORMATION_MESSAGE);
						return ;
					}
					//��֤û��������������
					else if(!textField.getText().equals("")&&pass.equals("")){
						JOptionPane.showMessageDialog(getParent(), "����д���룡", "��Ϣ��ʾ��", JOptionPane.INFORMATION_MESSAGE);
						return ;
					}
					else{
						int i=0;
						for (User_dengluxitong u : user) {	
							//��֤�����Ƿ������ݿ�ƥ������
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
									JOptionPane.showMessageDialog(getParent(), "��������������", "��Ϣ��ʾ��", JOptionPane.INFORMATION_MESSAGE);
									password.setText(null);
									return ;
								}
							}
							i++;
						}
					
						//��֤�û����������Ƿ������ݿ�ƥ������
						if(user.size()==i){
							JOptionPane.showMessageDialog(getParent(), "�����û������������", "��Ϣ��ʾ��", JOptionPane.INFORMATION_MESSAGE);
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
		
		JButton btnNewButton_1 = new JButton("ע��");
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
