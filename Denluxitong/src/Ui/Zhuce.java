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
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;
import java.awt.event.ActionEvent;

public class Zhuce extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Zhuce frame = new Zhuce();
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
	public Zhuce() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("�û�����");
		lblNewLabel.setBounds(64, 50, 74, 15);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("��  �룺");
		lblNewLabel_1.setBounds(64, 90, 74, 15);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("ȷ�����룺");
		lblNewLabel_2.setBounds(64, 130, 74, 15);
		contentPane.add(lblNewLabel_2);
		
		textField = new JTextField();
		textField.setBounds(148, 47, 190, 21);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JPasswordField password_1 = new JPasswordField();
		password_1.setBounds(148, 87, 190, 21);
		contentPane.add(password_1);
		password_1.setEchoChar('*');
		password_1.setColumns(10);
		
		JPasswordField password_2 = new JPasswordField();
		password_2.setBounds(148, 127, 190, 21);
		contentPane.add(password_2);
		password_2.setEchoChar('*');
		password_2.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("��ݣ�");
		lblNewLabel_3.setBounds(64, 171, 74, 15);
		contentPane.add(lblNewLabel_3);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("��ʦ");
		rdbtnNewRadioButton.setBounds(147, 167, 74, 23);
		contentPane.add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("ѧ��");
		rdbtnNewRadioButton_1.setBounds(223, 167, 75, 23);
		contentPane.add(rdbtnNewRadioButton_1);
		
		//����ͬ�����
		ButtonGroup Group = new ButtonGroup();
		Group.add(rdbtnNewRadioButton);
		Group.add(rdbtnNewRadioButton_1);
		
		JButton btnNewButton = new JButton("�ύ");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UserDao_dengluxitong userDao=new UserDao_dengluxitong();
				List<User_dengluxitong> user;
				String pass_1 = String.valueOf(password_1.getPassword());
				String pass_2 = String.valueOf(password_2.getPassword());
				try {
					user = userDao.query();
					//��֤�Ƿ������û���
					if(textField.getText().equals("")){
						JOptionPane.showMessageDialog(getParent(),"����д�û���", "��Ϣ��ʾ��", JOptionPane.INFORMATION_MESSAGE);
						return ;
					}
					//��֤�����������ٴ����������Ƿ�һ��
					if(!pass_1.equals("")&&!pass_2.equals("")){
						if(!pass_1.equals(pass_2)&&!textField.getText().equals("")){
							JOptionPane.showMessageDialog(getParent(),"�������벻һ��", "��Ϣ��ʾ��", JOptionPane.INFORMATION_MESSAGE);
							password_1.setText(null);
							password_2.setText(null);
							return ;
						}
					}
					else{
						JOptionPane.showMessageDialog(getParent(),"����д����", "��Ϣ��ʾ��", JOptionPane.INFORMATION_MESSAGE);
						return ;
					}
					//��֤�����Ƿ�ѡ��
					if(!rdbtnNewRadioButton.isSelected() && !rdbtnNewRadioButton_1.isSelected()){
						JOptionPane.showMessageDialog(getParent(),"û��ѡ�����", "��Ϣ��ʾ��", JOptionPane.INFORMATION_MESSAGE);
						return ;
					}
					
					//��֤��ѧ���Ƿ����
					for (User_dengluxitong u : user) {
						
						if(textField.getText().equals(u.getID())){
							JOptionPane.showMessageDialog(getParent(),"��ѧ���Ѵ���", "��Ϣ��ʾ��", JOptionPane.INFORMATION_MESSAGE);
							textField.setText(null);
							password_1.setText(null);
							password_2.setText(null);
							return ;
						}
						
					}
					
					User_dengluxitong us=new User_dengluxitong();
					us.setID(textField.getText());
					us.setCODE(pass_1);
					if(rdbtnNewRadioButton.isSelected()&&!rdbtnNewRadioButton_1.isSelected()){
						us.setMOLD(rdbtnNewRadioButton.getText());
						us.setNUM(0);
					}
					if(!rdbtnNewRadioButton.isSelected()&&rdbtnNewRadioButton_1.isSelected()){
						us.setMOLD(rdbtnNewRadioButton_1.getText());
						us.setNUM(1);
					}
					userDao.Add_dengluxitong(us);
					if(userDao.query().size()>user.size()){
						JOptionPane.showMessageDialog(getParent(),"ע��ɹ���", "��Ϣ��ʾ��", JOptionPane.INFORMATION_MESSAGE);						
					}
					Denglu denglu=new Denglu();
					denglu.setVisible(true);
					dispose();
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton.setBounds(68, 214, 93, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("����");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText(null);
				password_1.setText(null);
				password_2.setText(null);
			}
		});
		btnNewButton_1.setBounds(205, 214, 93, 23);
		contentPane.add(btnNewButton_1);
	}

	protected static void setDefaultLookAndFeelDecorated(int disposeOnClose) {
		// TODO Auto-generated method stub
		
	}
}
