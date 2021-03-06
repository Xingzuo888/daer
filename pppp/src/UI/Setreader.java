package UI;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import Model.Reader;
import User.getSql;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Setreader extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JLabel lblNewLabel_4;
	private JButton btnNewButton;
	private JButton btnNewButton_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Reader reader = null;
					Setreader frame = new Setreader(reader);
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
	public Setreader(Reader reader) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		lblNewLabel_4 = new JLabel("请修改读者的信息");
		lblNewLabel_4.setFont(new Font("宋体", Font.PLAIN, 15));
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setBounds(93, 10, 243, 36);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel = new JLabel("姓名：");
		lblNewLabel.setBounds(93, 56, 54, 15);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setText(reader.getRname().trim());//显示出将要修改的人的姓名
		textField.setBounds(157, 53, 136, 21);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("性别：");
		lblNewLabel_1.setBounds(93, 95, 54, 15);
		contentPane.add(lblNewLabel_1);
		
		textField_1 = new JTextField();
		textField_1.setText(reader.getRsex().trim());//显示出将要修改人的性别
		textField_1.setBounds(157, 92, 136, 21);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("年龄：");
		lblNewLabel_2.setBounds(93, 133, 54, 15);
		contentPane.add(lblNewLabel_2);
		
		textField_2 = new JTextField();
		textField_2.setText(String.valueOf(reader.getRage()));
		textField_2.setBounds(157, 130, 136, 21);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("职业：");
		lblNewLabel_3.setBounds(93, 172, 54, 15);
		contentPane.add(lblNewLabel_3);
		
		textField_3 = new JTextField();
		textField_3.setText(reader.getRjob());
		textField_3.setBounds(157, 169, 136, 21);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		btnNewButton = new JButton("修改");
		btnNewButton.setBounds(91, 217, 93, 23);
		btnNewButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				reader.setRname(textField.getText());
				reader.setRsex(textField_1.getText());
				reader.setRage(Integer.parseInt(textField_2.getText()));
				reader.setRjob(textField_3.getText());
				getSql sql = new getSql();
				if(sql.updateReader(reader)) {
					JOptionPane.showMessageDialog(null, "修改成功");
				}else {
					JOptionPane.showMessageDialog(null, "修改失败");
				}
				sql.closeSql();
			}
		});
		contentPane.add(btnNewButton);
		
		btnNewButton_1 = new JButton("重置");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText(null);
				textField_1.setText(null);
				textField_2.setText(null);
				textField_3.setText(null);
			}
		});
		btnNewButton_1.setBounds(243, 217, 93, 23);
		contentPane.add(btnNewButton_1);
		
	}

}
