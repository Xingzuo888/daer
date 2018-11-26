package UI;


import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

import Userdao.userdao;


public class MainFrame extends JFrame {

	private JPanel contentPane;
	
	private final JInternalFrame internalFrame_addbook = new JInternalFrame("增加图书");
	private final JInternalFrame internalFrame_setbook = new JInternalFrame("修改图书");
	private final JInternalFrame internalFrame_delbook = new JInternalFrame("删除图书");
	
	private final JInternalFrame internalFrame_addreader = new JInternalFrame("增加读者");
	private final JInternalFrame internalFrame_setreader = new JInternalFrame("修改读者");
	private final JInternalFrame internalFrame_delreader = new JInternalFrame("删除读者");
	
	private final JInternalFrame internalFrame_borrowbook = new JInternalFrame("借书");
	
	private final JInternalFrame internalFrame_returnbook = new JInternalFrame("还书");
	
	private final JInternalFrame internalFrame_querybook = new JInternalFrame("查询所有图书信息");
	private final JInternalFrame internalFrame_queryreader = new JInternalFrame("查询所有读者信息");
	private final JInternalFrame internalFrame_1 = new JInternalFrame("查询所有的借书记录");
	private final JInternalFrame internalFrame_2 = new JInternalFrame("查询超期借书记录");
	private final JInternalFrame internalFrame_3 = new JInternalFrame("查询已被借出的书本");
	private final JInternalFrame internalFrame_4 = new JInternalFrame("查询某出版社的书");
	private final JInternalFrame internalFrame_5 = new JInternalFrame("查询某读者借的书");
	private final JInternalFrame internalFrame_6 = new JInternalFrame("查询某读者归还某书的日期");
	private final JInternalFrame internalFrame_7 = new JInternalFrame("查询某读者被罚款的总额");
	
	private final JInternalFrame internalFrame_about = new JInternalFrame("关于我们");
	
	private Book book = new Book();
	private Reader reader = new Reader();
	
	getSql sql = new getSql();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrame frame = new MainFrame();
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
	public MainFrame() {
		setTitle("欢迎使用图书管理系统");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 670, 445);
		//创建菜单栏
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		//创建图书菜单
		JMenu menu_Book = new JMenu("图书维护");
		menuBar.add(menu_Book);
		
		//创建增加图书菜单项
		JMenuItem menuItem_addbook = new JMenuItem("增加图书");
		menuItem_addbook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getContentPane().add(internalFrame_addbook);
				internalFrame_addbook.getContentPane().setLayout(null);

				JLabel lblNewLabel_4 = new JLabel("请输入图书的信息");
				lblNewLabel_4.setFont(new Font("宋体", Font.BOLD, 15));
				lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
				lblNewLabel_4.setBounds(190, 20, 243, 36);
				internalFrame_addbook.getContentPane().add(lblNewLabel_4);
				
				JLabel lblNewLabel = new JLabel("书名：");
				lblNewLabel.setBounds(193, 66, 54, 15);
				internalFrame_addbook.getContentPane().add(lblNewLabel);
				
				JTextField textField_bookname = new JTextField();
				textField_bookname.setBounds(257, 63, 136, 21);
				internalFrame_addbook.getContentPane().add(textField_bookname);
				textField_bookname.setColumns(10);
				
				JLabel lblNewLabel_1 = new JLabel("出版社：");
				lblNewLabel_1.setBounds(193, 105, 54, 15);
				internalFrame_addbook.getContentPane().add(lblNewLabel_1);
				
				JTextField textField_bookpublish = new JTextField();
				textField_bookpublish.setBounds(257, 102, 136, 21);
				internalFrame_addbook.getContentPane().add(textField_bookpublish);
				textField_bookpublish.setColumns(10);
				
				JLabel lblNewLabel_2 = new JLabel("作者：");
				lblNewLabel_2.setBounds(193, 143, 54, 15);
				internalFrame_addbook.getContentPane().add(lblNewLabel_2);
				
				JTextField textField_bookauthor = new JTextField();
				textField_bookauthor.setBounds(257, 140, 136, 21);
				internalFrame_addbook.getContentPane().add(textField_bookauthor);
				textField_bookauthor.setColumns(10);
				
				JLabel lblNewLabel_3 = new JLabel("价格：");
				lblNewLabel_3.setBounds(193, 182, 54, 15);
				internalFrame_addbook.getContentPane().add(lblNewLabel_3);
				
				JTextField textField_bookprice = new JTextField();
				textField_bookprice.setBounds(257, 179, 136, 21);
				internalFrame_addbook.getContentPane().add(textField_bookprice);
				textField_bookprice.setColumns(10);
				
				JButton btnNewButton = new JButton("添加");
				btnNewButton.setBounds(191, 227, 93, 23);
				btnNewButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						book.setBname(textField_bookname.getText());
						book.setBpublish(textField_bookpublish.getText());
						book.setBauthor(textField_bookauthor.getText());
						book.setBprice(Float.parseFloat((textField_bookprice.getText())));
						//判断下添加信息是否成功
						if(sql.addBook(book)) { JOptionPane.showMessageDialog(null, "增加图书成功");}
						else { JOptionPane.showMessageDialog(null, "增加图书失败");}
						textField_bookname.setText(null);
						textField_bookpublish.setText(null);
						textField_bookauthor.setText(null);
						textField_bookprice.setText(null);
					}
				});	
				internalFrame_addbook.getContentPane().add(btnNewButton);
				
				JButton btnNewButton_1 = new JButton("重置");
				btnNewButton_1.setBounds(343, 227, 93, 23);
				btnNewButton_1.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						textField_bookname.setText(null);
						textField_bookpublish.setText(null);
						textField_bookauthor.setText(null);
						textField_bookprice.setText(null);
					}
				});
				internalFrame_addbook.getContentPane().add(btnNewButton_1);
				
				internalFrame_addbook.setVisible(true);
				internalFrame_setbook.dispose();
				internalFrame_delbook.dispose();
				internalFrame_addreader.dispose();
				internalFrame_setreader.dispose();
				internalFrame_delreader.dispose();
				internalFrame_borrowbook.dispose();
				internalFrame_returnbook.dispose();
				internalFrame_querybook.dispose();
				internalFrame_queryreader.dispose();
				internalFrame_1.dispose();
				internalFrame_2.dispose();
				internalFrame_3.dispose();
				internalFrame_4.dispose();
				internalFrame_5.dispose();
				internalFrame_6.dispose();
				internalFrame_7.dispose();
				internalFrame_about.dispose();
			}
		});
		menu_Book.add(menuItem_addbook);
		
		//创建修改图书菜单项
		JMenuItem menuItem_setbook = new JMenuItem("修改图书");
		menuItem_setbook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getContentPane().add(internalFrame_setbook);
				internalFrame_setbook.getContentPane().setLayout(null);
				
				JLabel lblNewLabel = new JLabel("请输入要修改图书的书名");
				lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
				lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 18));
				lblNewLabel.setBounds(200, 10, 211, 40);
				internalFrame_setbook.getContentPane().add(lblNewLabel);
				
				JLabel lblNewLabel_1 = new JLabel("书名：");
				lblNewLabel_1.setFont(new Font("宋体", Font.PLAIN, 15));
				lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
				lblNewLabel_1.setBounds(88, 68, 111, 32);
				internalFrame_setbook.getContentPane().add(lblNewLabel_1);
				
				JTextField textField = new JTextField();
				textField.setBounds(195, 69, 209, 32);
				internalFrame_setbook.getContentPane().add(textField);
				textField.setColumns(10);
				
				JTable table = null;
				JButton btnNewButton = new JButton("查询");
				btnNewButton.setBounds(429, 68, 86, 32);
				btnNewButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {//点击了查询
					
					}
				});
				internalFrame_setbook.getContentPane().add(btnNewButton);
				
				table = new JTable(20,6);   //创建表格
				table.getColumnModel().getColumn(table.getColumnCount()-1).setCellRenderer(new TableCellRenderer() {
					
					@Override
					public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
							int row, int column) {
						JCheckBox jc=new JCheckBox();
						jc.setSelected(isSelected);
						jc.setHorizontalAlignment((int) 0.5f);
						return jc;
					}
				});  //添加复选框
				JScrollPane jScrollPane=new JScrollPane(table);   //将表格添加到滚动条中
				jScrollPane.setBounds(48, 110, 555, 150);
				internalFrame_setbook.getContentPane().add(jScrollPane);
				
				JButton btnNewButton_1 = new JButton("修改");
				btnNewButton_1.setBounds(500, 280, 86, 32);
				internalFrame_setbook.getContentPane().add(btnNewButton_1);
				
				internalFrame_addbook.dispose();
				internalFrame_setbook.setVisible(true);
				internalFrame_delbook.dispose();
				internalFrame_addreader.dispose();
				internalFrame_setreader.dispose();
				internalFrame_delreader.dispose();
				internalFrame_borrowbook.dispose();
				internalFrame_returnbook.dispose();
				internalFrame_querybook.dispose();
				internalFrame_queryreader.dispose();
				internalFrame_1.dispose();
				internalFrame_2.dispose();
				internalFrame_3.dispose();
				internalFrame_4.dispose();
				internalFrame_5.dispose();
				internalFrame_6.dispose();
				internalFrame_7.dispose();
				internalFrame_about.dispose();
			}
		});
		menu_Book.add(menuItem_setbook);
		
		//创建删除图书菜单项
		JMenuItem menuItem_delbook = new JMenuItem("删除图书");
		menuItem_delbook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getContentPane().add(internalFrame_delbook);
				internalFrame_delbook.getContentPane().setLayout(null);
				
				JLabel lblNewLabel = new JLabel("请输入要删除图书的书名");
				lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
				lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 18));
				lblNewLabel.setBounds(200, 10, 211, 40);
				internalFrame_delbook.getContentPane().add(lblNewLabel);
				
				JLabel lblNewLabel_1 = new JLabel("书名：");
				lblNewLabel_1.setFont(new Font("宋体", Font.PLAIN, 15));
				lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
				lblNewLabel_1.setBounds(88, 68, 111, 32);
				internalFrame_delbook.getContentPane().add(lblNewLabel_1);
				
				JTextField textField = new JTextField();
				textField.setBounds(195, 69, 209, 32);
				internalFrame_delbook.getContentPane().add(textField);
				textField.setColumns(10);
				
				JButton btnNewButton = new JButton("查询");
				btnNewButton.setBounds(429, 68, 86, 32);
				internalFrame_delbook.getContentPane().add(btnNewButton);
				
				JTable table = new JTable(20,6);   //创建表格
				table.getColumnModel().getColumn(table.getColumnCount()-1).setCellRenderer(new TableCellRenderer() {
					
					@Override
					public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
							int row, int column) {
						JCheckBox jc=new JCheckBox();
						jc.setSelected(isSelected);
						jc.setHorizontalAlignment((int) 0.5f);
						return jc;
					}
				});  //添加复选框
				JScrollPane jScrollPane=new JScrollPane(table);   //将表格添加到滚动条中
				jScrollPane.setBounds(48, 110, 555, 150);
				internalFrame_delbook.getContentPane().add(jScrollPane);
				
				JButton btnNewButton_1 = new JButton("删除");
				btnNewButton_1.setBounds(500, 280, 86, 32);
				internalFrame_delbook.getContentPane().add(btnNewButton_1);
				
				internalFrame_addbook.dispose();
				internalFrame_setbook.dispose();
				internalFrame_delbook.setVisible(true);
				internalFrame_addreader.dispose();
				internalFrame_setreader.dispose();
				internalFrame_delreader.dispose();
				internalFrame_borrowbook.dispose();
				internalFrame_returnbook.dispose();
				internalFrame_querybook.dispose();
				internalFrame_queryreader.dispose();
				internalFrame_1.dispose();
				internalFrame_2.dispose();
				internalFrame_3.dispose();
				internalFrame_4.dispose();
				internalFrame_5.dispose();
				internalFrame_6.dispose();
				internalFrame_7.dispose();
				internalFrame_about.dispose();
			}
		});
		menu_Book.add(menuItem_delbook);
		
		//创建读者菜单
		JMenu menu_reader = new JMenu("读者维护");
		menuBar.add(menu_reader);
		
		//创建增加读者菜单项
		JMenuItem menuItem_addreader = new JMenuItem("增加读者");
		menuItem_addreader.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getContentPane().add(internalFrame_addreader);
				internalFrame_addreader.getContentPane().setLayout(null);

				JLabel lblNewLabel_4 = new JLabel("请输入读者的信息");
				lblNewLabel_4.setFont(new Font("宋体", Font.BOLD, 15));
				lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
				lblNewLabel_4.setBounds(190, 20, 243, 36);
				internalFrame_addreader.getContentPane().add(lblNewLabel_4);
				
				JLabel lblNewLabel = new JLabel("姓名：");
				lblNewLabel.setBounds(193, 66, 54, 15);
				internalFrame_addreader.getContentPane().add(lblNewLabel);
				
				JTextField textField_readername = new JTextField();
				textField_readername.setBounds(257, 63, 136, 21);
				internalFrame_addreader.getContentPane().add(textField_readername);
				textField_readername.setColumns(10);
				
				JLabel lblNewLabel_1 = new JLabel("性别：");
				lblNewLabel_1.setBounds(193, 105, 54, 15);
				internalFrame_addreader.getContentPane().add(lblNewLabel_1);
				
				JTextField textField_readersex = new JTextField();
				textField_readersex.setBounds(257, 102, 136, 21);
				internalFrame_addreader.getContentPane().add(textField_readersex);
				textField_readersex.setColumns(10);
				
				JLabel lblNewLabel_2 = new JLabel("年龄：");
				lblNewLabel_2.setBounds(193, 143, 54, 15);
				internalFrame_addreader.getContentPane().add(lblNewLabel_2);
				
				JTextField textField_readerage = new JTextField();
				textField_readerage.setBounds(257, 140, 136, 21);
				internalFrame_addreader.getContentPane().add(textField_readerage);
				textField_readerage.setColumns(10);
				
				JLabel lblNewLabel_3 = new JLabel("职业：");
				lblNewLabel_3.setBounds(193, 182, 54, 15);
				internalFrame_addreader.getContentPane().add(lblNewLabel_3);
				
				JTextField textField_readerprofession = new JTextField();
				textField_readerprofession.setBounds(257, 179, 136, 21);
				internalFrame_addreader.getContentPane().add(textField_readerprofession);
				textField_readerprofession.setColumns(10);
				
				JButton btnNewButton = new JButton("添加");
				btnNewButton.setBounds(191, 227, 93, 23);
				btnNewButton.addActionListener(new ActionListener() {//当用户点击添加时的反应事件
					public void actionPerformed(ActionEvent e) {
						reader.setRname(textField_readername.getText());//设置读者名字
						reader.setRsex(textField_readersex.getText());//设置读者性别
						reader.setRage(Integer.parseInt(textField_readerage.getText()));//设置读者年龄并转化为Int型
						reader.setRjob(textField_readerprofession.getText());//设置读者工作
						//判断下添加信息是否成功
						if(sql.addReader(reader)) { JOptionPane.showMessageDialog(null, "增加读者成功");}
						else { JOptionPane.showMessageDialog(null, "增加读者失败");}
						textField_readername.setText(null);//清空
						textField_readersex.setText(null);
						textField_readerage.setText(null);
						textField_readerprofession.setText(null);
					}
				});	
				internalFrame_addreader.getContentPane().add(btnNewButton);
				
				JButton btnNewButton_1 = new JButton("重置");
				btnNewButton_1.setBounds(343, 227, 93, 23);
				btnNewButton_1.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						textField_readername.setText(null);
						textField_readersex.setText(null);
						textField_readerage.setText(null);
						textField_readerprofession.setText(null);
					}
				});
				internalFrame_addreader.getContentPane().add(btnNewButton_1);
				
				internalFrame_addbook.dispose();
				internalFrame_setbook.dispose();
				internalFrame_delbook.dispose();
				internalFrame_addreader.setVisible(true);
				internalFrame_setreader.dispose();
				internalFrame_delreader.dispose();
				internalFrame_borrowbook.dispose();
				internalFrame_returnbook.dispose();
				internalFrame_querybook.dispose();
				internalFrame_queryreader.dispose();
				internalFrame_1.dispose();
				internalFrame_2.dispose();
				internalFrame_3.dispose();
				internalFrame_4.dispose();
				internalFrame_5.dispose();
				internalFrame_6.dispose();
				internalFrame_7.dispose();
				internalFrame_about.dispose();
			}
		});
		menu_reader.add(menuItem_addreader);
		
		//创建修改读者菜单项
		JMenuItem menuItem_setreader = new JMenuItem("修改读者");
		menuItem_setreader.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getContentPane().add(internalFrame_setreader);
				internalFrame_setreader.getContentPane().setLayout(null);
				
				JLabel lblNewLabel = new JLabel("请输入要修改读者的姓名");
				lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
				lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 18));
				lblNewLabel.setBounds(200, 10, 211, 40);
				internalFrame_setreader.getContentPane().add(lblNewLabel);
				
				JLabel lblNewLabel_1 = new JLabel("姓名：");
				lblNewLabel_1.setFont(new Font("宋体", Font.PLAIN, 15));
				lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
				lblNewLabel_1.setBounds(88, 68, 111, 32);
				internalFrame_setreader.getContentPane().add(lblNewLabel_1);
				
				JTextField textField = new JTextField();
				textField.setBounds(195, 69, 209, 32);
				internalFrame_setreader.getContentPane().add(textField);
				textField.setColumns(10);
				
				JButton btnNewButton = new JButton("查询");
				btnNewButton.setBounds(429, 68, 86, 32);
				internalFrame_setreader.getContentPane().add(btnNewButton);
				
				JTable table = new JTable(20,6);   //创建表格
				table.getColumnModel().getColumn(table.getColumnCount()-1).setCellRenderer(new TableCellRenderer() {
					
					@Override
					public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
							int row, int column) {
						JCheckBox jc=new JCheckBox();
						jc.setSelected(isSelected);
						jc.setHorizontalAlignment((int) 0.5f);
						return jc;
					}
				});  //添加复选框
				JScrollPane jScrollPane=new JScrollPane(table);   //将表格添加到滚动条中
				jScrollPane.setBounds(48, 110, 555, 150);
				internalFrame_setreader.getContentPane().add(jScrollPane);
				
				JButton btnNewButton_1 = new JButton("修改");
				btnNewButton_1.setBounds(500, 280, 86, 32);
				internalFrame_setreader.getContentPane().add(btnNewButton_1);
				
				internalFrame_addbook.dispose();
				internalFrame_setbook.dispose();
				internalFrame_delbook.dispose();
				internalFrame_addreader.dispose();
				internalFrame_setreader.setVisible(true);
				internalFrame_delreader.dispose();
				internalFrame_borrowbook.dispose();
				internalFrame_returnbook.dispose();
				internalFrame_querybook.dispose();
				internalFrame_queryreader.dispose();
				internalFrame_1.dispose();
				internalFrame_2.dispose();
				internalFrame_3.dispose();
				internalFrame_4.dispose();
				internalFrame_5.dispose();
				internalFrame_6.dispose();
				internalFrame_7.dispose();
				internalFrame_about.dispose();
			}
		});
		menu_reader.add(menuItem_setreader);
		
		//创建删除读者菜单项
		JMenuItem menuItem_delreader = new JMenuItem("删除读者");
		menuItem_delreader.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getContentPane().add(internalFrame_delreader);
				internalFrame_delreader.getContentPane().setLayout(null);
				
				JLabel lblNewLabel = new JLabel("请输入要删除读者的姓名");
				lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
				lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 18));
				lblNewLabel.setBounds(200, 10, 211, 40);
				internalFrame_delreader.getContentPane().add(lblNewLabel);
				
				JLabel lblNewLabel_1 = new JLabel("姓名：");
				lblNewLabel_1.setFont(new Font("宋体", Font.PLAIN, 15));
				lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
				lblNewLabel_1.setBounds(88, 68, 111, 32);
				internalFrame_delreader.getContentPane().add(lblNewLabel_1);
				
				JTextField textField = new JTextField();
				textField.setBounds(195, 69, 209, 32);
				internalFrame_delreader.getContentPane().add(textField);
				textField.setColumns(10);
				
				JButton btnNewButton = new JButton("查询");
				btnNewButton.setBounds(429, 68, 86, 32);
				internalFrame_delreader.getContentPane().add(btnNewButton);
				
				JTable table = new JTable(20,6);   //创建表格
				table.getColumnModel().getColumn(table.getColumnCount()-1).setCellRenderer(new TableCellRenderer() {
					
					@Override
					public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
							int row, int column) {
						JCheckBox jc=new JCheckBox();
						jc.setSelected(isSelected);
						jc.setHorizontalAlignment((int) 0.5f);
						return jc;
					}
				});  //添加复选框
				JScrollPane jScrollPane=new JScrollPane(table);   //将表格添加到滚动条中
				jScrollPane.setBounds(48, 110, 555, 150);
				internalFrame_delreader.getContentPane().add(jScrollPane);
				
				JButton btnNewButton_1 = new JButton("删除");
				btnNewButton_1.setBounds(500, 280, 86, 32);
				internalFrame_delreader.getContentPane().add(btnNewButton_1);
				
				internalFrame_addbook.dispose();
				internalFrame_setbook.dispose();
				internalFrame_delbook.dispose();
				internalFrame_addreader.dispose();
				internalFrame_setreader.dispose();
				internalFrame_delreader.setVisible(true);
				internalFrame_borrowbook.dispose();
				internalFrame_returnbook.dispose();
				internalFrame_querybook.dispose();
				internalFrame_queryreader.dispose();
				internalFrame_1.dispose();
				internalFrame_2.dispose();
				internalFrame_3.dispose();
				internalFrame_4.dispose();
				internalFrame_5.dispose();
				internalFrame_6.dispose();
				internalFrame_7.dispose();
				internalFrame_about.dispose();
			}
		});
		menu_reader.add(menuItem_delreader);
		
		//创建借还菜单
		JMenu menu_brbook= new JMenu("借还书");
		menuBar.add(menu_brbook);
		
		//创建借书菜单项
		JMenuItem mntmNewMenuItem_borrowbook = new JMenuItem("借书");
		mntmNewMenuItem_borrowbook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getContentPane().add(internalFrame_borrowbook);
				internalFrame_borrowbook.getContentPane().setLayout(null);
				
				JLabel lblNewLabel = new JLabel("请输入读者的编号和姓名");
				lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
				lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 18));
				lblNewLabel.setBounds(200, 23, 211, 40);
				internalFrame_borrowbook.getContentPane().add(lblNewLabel);
				
				JLabel lblNewLabel_1 = new JLabel("编号：");
				lblNewLabel_1.setFont(new Font("宋体", Font.PLAIN, 15));
				lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
				lblNewLabel_1.setBounds(101, 75, 64, 26);
				internalFrame_borrowbook.getContentPane().add(lblNewLabel_1);
				
				JTextField textField = new JTextField();
				textField.setBounds(168, 73, 117, 26);
				internalFrame_borrowbook.getContentPane().add(textField);
				textField.setColumns(10);
				
				JLabel lblNewLabel_2 = new JLabel("姓名：");
				lblNewLabel_2.setFont(new Font("宋体", Font.PLAIN, 15));
				lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
				lblNewLabel_2.setBounds(295, 75, 64, 26);
				internalFrame_borrowbook.getContentPane().add(lblNewLabel_2);
				
				JTextField textField_1 = new JTextField();
				textField_1.setEditable(false);
				textField_1.setBounds(367, 73, 117, 26);
				internalFrame_borrowbook.getContentPane().add(textField_1);
				textField_1.setColumns(10);
				
				JLabel lblNewLabel_3 = new JLabel("请输入书的编号和书名");
				lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
				lblNewLabel_3.setFont(new Font("宋体", Font.PLAIN, 18));
				lblNewLabel_3.setBounds(200, 129, 211, 40);
				internalFrame_borrowbook.getContentPane().add(lblNewLabel_3);
				
				JLabel lblNewLabel_4 = new JLabel("编号：");
				lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
				lblNewLabel_4.setFont(new Font("宋体", Font.PLAIN, 15));
				lblNewLabel_4.setBounds(101, 178, 64, 26);
				internalFrame_borrowbook.getContentPane().add(lblNewLabel_4);
				
				JTextField textField_2 = new JTextField();
				textField_2.setBounds(168, 179, 117, 26);
				internalFrame_borrowbook.getContentPane().add(textField_2);
				textField_2.setColumns(10);
				
				JLabel lblNewLabel_5 = new JLabel("书名：");
				lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
				lblNewLabel_5.setFont(new Font("宋体", Font.PLAIN, 15));
				lblNewLabel_5.setBounds(295, 179, 64, 26);
				internalFrame_borrowbook.getContentPane().add(lblNewLabel_5);
				 
				JTextField textField_3 = new JTextField();
				textField_3.setEditable(false);
				textField_3.setBounds(367, 179, 117, 26);
				internalFrame_borrowbook.getContentPane().add(textField_3);
				textField_3.setColumns(10);

				JButton btnNewButton = new JButton("借书");
				btnNewButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if(textField.getText() == "" || textField_2.getText() =="")
						{
							JOptionPane.showMessageDialog(null, "请输入如完整信息");
						}
						else {
							if(sql.borrow(Integer.parseInt(textField.getText()),Integer.parseInt(textField_2.getText())))
							{
								JOptionPane.showMessageDialog(null, "借书成功");
								textField.setText(null);
								textField_1.setText(null);
								textField_2.setText(null);
								textField_3.setText(null);
							}else {
								JOptionPane.showMessageDialog(null, "借书失败");
							}
						}
					}
				});
				btnNewButton.setBounds(260, 240, 73, 26);
				internalFrame_borrowbook.getContentPane().add(btnNewButton);
				
				KeyListener key_Listener = new KeyListener()  //当用户借书输入的编号按下Enter键
		        {  
		            public void keyTyped(KeyEvent e) {}  
		            public void keyReleased(KeyEvent e){}  
		            public void keyPressed(KeyEvent e){  
		                if(e.getKeyChar() == KeyEvent.VK_ENTER )  
		                {  
		                	if(textField.getText() == "")
		                	{
		                		JOptionPane.showMessageDialog(null, "请输入读者编号");
		                	}else {
			                	reader = sql.selectReaderId(Integer.parseInt(textField.getText()));
			                	if(reader == null)
			                	{
			                		JOptionPane.showMessageDialog(null, "未找到该读者");
			                		textField.setText("");
			                	}else if(reader.getRnumber() ==5) {
			                		JOptionPane.showMessageDialog(null, "该用户已经借了五本书了");
			                		textField.setText("");
			                	}
			                	else {
			                		textField_1.setText(reader.getRname());
			                   }
		                	}
		                }  
		            }  
		        };
		        KeyListener key_Listener_1 = new KeyListener()  
		        {  
		            public void keyTyped(KeyEvent e) {}  
		            public void keyReleased(KeyEvent e){}  
		            public void keyPressed(KeyEvent e){  
		                if(e.getKeyChar() == KeyEvent.VK_ENTER )  
		                {  
		                	if(textField_2.getText() == "")
		                	{
		                		JOptionPane.showMessageDialog(null, "请输入图书编号");
		                	}else {
			                	book = sql.selectBookId(Integer.parseInt(textField_2.getText()));
			                	if(book == null) {
			                		JOptionPane.showMessageDialog(null, "未找到该图书");
			                		textField_2.setText("");
			                	}else if(book.getBborrow() == 0){
			                		JOptionPane.showMessageDialog(null, "该图书已借出");
			                		textField_2.setText("");
			                	}
			                	else {
			                		textField_3.setText(book.getBname());
			                	}
		                	}
		                }  
		            }  
		        };
		        
		        textField.addKeyListener(key_Listener);  
		        textField_2.addKeyListener(key_Listener_1);
		        
				internalFrame_addbook.dispose();
				internalFrame_setbook.dispose();
				internalFrame_delbook.dispose();
				internalFrame_addreader.dispose();
				internalFrame_setreader.dispose();
				internalFrame_delreader.dispose();
				internalFrame_borrowbook.setVisible(true);
				internalFrame_returnbook.dispose();
				internalFrame_querybook.dispose();
				internalFrame_queryreader.dispose();
				internalFrame_1.dispose();
				internalFrame_2.dispose();
				internalFrame_3.dispose();
				internalFrame_4.dispose();
				internalFrame_5.dispose();
				internalFrame_6.dispose();
				internalFrame_7.dispose();
				internalFrame_about.dispose();
			}
		});
		menu_brbook.add(mntmNewMenuItem_borrowbook);
		
		//创建还书菜单项
		JMenuItem mntmNewMenuItem_returnbook = new JMenuItem("还书");
		mntmNewMenuItem_returnbook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getContentPane().add(internalFrame_returnbook);
				internalFrame_returnbook.getContentPane().setLayout(null);
				
				JLabel lblNewLabel = new JLabel("请输入读者的编号和姓名");
				lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
				lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 18));
				lblNewLabel.setBounds(200, 23, 211, 40);
				internalFrame_returnbook.getContentPane().add(lblNewLabel);
				
				JLabel lblNewLabel_1 = new JLabel("编号：");
				lblNewLabel_1.setFont(new Font("宋体", Font.PLAIN, 15));
				lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
				lblNewLabel_1.setBounds(101, 75, 64, 26);
				internalFrame_returnbook.getContentPane().add(lblNewLabel_1);
				
				JTextField textField = new JTextField();
				textField.setBounds(168, 73, 117, 26);
				internalFrame_returnbook.getContentPane().add(textField);
				textField.setColumns(10);
				
				JLabel lblNewLabel_2 = new JLabel("姓名：");
				lblNewLabel_2.setFont(new Font("宋体", Font.PLAIN, 15));
				lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
				lblNewLabel_2.setBounds(295, 75, 64, 26);
				internalFrame_returnbook.getContentPane().add(lblNewLabel_2);
				
				JTextField textField_1 = new JTextField();
				textField_1.setEditable(false);
				textField_1.setBounds(367, 73, 117, 26);
				internalFrame_returnbook.getContentPane().add(textField_1);
				textField_1.setColumns(10);
				
				JLabel lblNewLabel_3 = new JLabel("请输入书的编号和书名");
				lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
				lblNewLabel_3.setFont(new Font("宋体", Font.PLAIN, 18));
				lblNewLabel_3.setBounds(200, 129, 211, 40);
				internalFrame_returnbook.getContentPane().add(lblNewLabel_3);
				
				JLabel lblNewLabel_4 = new JLabel("编号：");
				lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
				lblNewLabel_4.setFont(new Font("宋体", Font.PLAIN, 15));
				lblNewLabel_4.setBounds(101, 178, 64, 26);
				internalFrame_returnbook.getContentPane().add(lblNewLabel_4);
				
				JTextField textField_2 = new JTextField();
				textField_2.setBounds(168, 179, 117, 26);
				internalFrame_returnbook.getContentPane().add(textField_2);
				textField_2.setColumns(10);
				
				JLabel lblNewLabel_5 = new JLabel("书名：");
				lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
				lblNewLabel_5.setFont(new Font("宋体", Font.PLAIN, 15));
				lblNewLabel_5.setBounds(295, 179, 64, 26);
				internalFrame_returnbook.getContentPane().add(lblNewLabel_5);
				
				JTextField textField_3 = new JTextField();
				textField_3.setEditable(false);
				textField_3.setBounds(367, 179, 117, 26);
				internalFrame_returnbook.getContentPane().add(textField_3);
				textField_3.setColumns(10);

				JButton btnNewButton = new JButton("还书");
				btnNewButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if(textField.getText() == "" || textField_2.getText() =="")
						{
							JOptionPane.showMessageDialog(null, "请输入如完整信息");
						}
						else {
							if(sql.reBook(Integer.parseInt(textField.getText()),Integer.parseInt(textField_2.getText())))
							{
								JOptionPane.showMessageDialog(null, "还书成功");
								textField.setText(null);
								textField_1.setText(null);
								textField_2.setText(null);
								textField_3.setText(null);
							}else {
								JOptionPane.showMessageDialog(null, "还书失败");
							}
						}
					}
				});
				btnNewButton.setBounds(260, 240, 73, 26);
				internalFrame_returnbook.getContentPane().add(btnNewButton);
				
				KeyListener key_Listener = new KeyListener()  //当用户借书输入的编号按下Enter键
				        {  
				            public void keyTyped(KeyEvent e) {}  
				            public void keyReleased(KeyEvent e){}  
				            public void keyPressed(KeyEvent e){  
				                if(e.getKeyChar() == KeyEvent.VK_ENTER )  
				                {  
				                	if(textField.getText() == "")
				                	{
				                		JOptionPane.showMessageDialog(null, "请输入读者编号");
				                	}else {
					                	reader = sql.selectReaderId(Integer.parseInt(textField.getText()));
					                	if(reader == null)
					                	{
					                		JOptionPane.showMessageDialog(null, "未找到该读者");
					                		textField.setText("");
					                	}else {
					                		textField_1.setText(reader.getRname());
					                   }
				                	}
				                }  
				            }  
				        };
				        KeyListener key_Listener_1 = new KeyListener()  
				        {  
				            public void keyTyped(KeyEvent e) {}  
				            public void keyReleased(KeyEvent e){}  
				            public void keyPressed(KeyEvent e){  
				                if(e.getKeyChar() == KeyEvent.VK_ENTER )  
				                {  
				                	if(textField_2.getText() == "")
				                	{
				                		JOptionPane.showMessageDialog(null, "请输入图书编号");
				                	}else {
					                	book = sql.selectBookId(Integer.parseInt(textField_2.getText()));
					                	if(book == null) {
					                		JOptionPane.showMessageDialog(null, "未找到该图书");
					                		textField_2.setText("");
					                	}else {
					                		textField_3.setText(book.getBname());
					                	}
				                	}
				                }  
				            }  
				        };
				        
				        textField.addKeyListener(key_Listener);  
				        textField_2.addKeyListener(key_Listener_1);
				
				internalFrame_addbook.dispose();
				internalFrame_setbook.dispose();
				internalFrame_delbook.dispose();
				internalFrame_addreader.dispose();
				internalFrame_setreader.dispose();
				internalFrame_delreader.dispose();
				internalFrame_borrowbook.dispose();
				internalFrame_returnbook.setVisible(true);
				internalFrame_querybook.dispose();
				internalFrame_queryreader.dispose();
				internalFrame_1.dispose();
				internalFrame_2.dispose();
				internalFrame_3.dispose();
				internalFrame_4.dispose();
				internalFrame_5.dispose();
				internalFrame_6.dispose();
				internalFrame_7.dispose();
				internalFrame_about.dispose();
			}
		});
		menu_brbook.add(mntmNewMenuItem_returnbook);
		
		//创建信息查询菜单
		JMenu menu_sertch = new JMenu("信息查询");
		menuBar.add(menu_sertch);
		
		//查询所有图书信息
		JMenuItem menuItem_querybook = new JMenuItem("查询所有图书信息");
		menuItem_querybook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getContentPane().add(internalFrame_querybook);
				internalFrame_querybook.getContentPane().setLayout(null);
				
				JScrollPane jScrollPane=new JScrollPane();   //将表格添加到滚动条中
				jScrollPane.setBounds(48, 25, 555, 300);
				internalFrame_querybook.getContentPane().add(jScrollPane);
				
				JTable table = new JTable();
				table.setModel(new DefaultTableModel(
					new Object[][] {
					},
					new String[] {
						"bno", "name", "publish", "author", "price", "borrowbook"
					}
				));
				jScrollPane.setViewportView(table);
				//初始化表格
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				userdao u=new userdao();
				try {
					ResultSet rs =u.query();
					
					while(rs.next()){
						Vector v=new Vector<>();
						v.add(rs.getInt("Bid"));
						v.add(rs.getString("Bname"));
						v.add(rs.getString("publish"));
						v.add(rs.getString("author"));
						v.add(rs.getFloat("price"));
						v.add(rs.getInt("borrowed"));
						model.addRow(v);
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				internalFrame_addbook.dispose();
				internalFrame_setbook.dispose();
				internalFrame_delbook.dispose();
				internalFrame_addreader.dispose();
				internalFrame_setreader.dispose();
				internalFrame_delreader.dispose();
				internalFrame_borrowbook.dispose();
				internalFrame_returnbook.dispose();
				internalFrame_querybook.setVisible(true);
				internalFrame_queryreader.dispose();
				internalFrame_1.dispose();
				internalFrame_2.dispose();
				internalFrame_3.dispose();
				internalFrame_4.dispose();
				internalFrame_5.dispose();
				internalFrame_6.dispose();
				internalFrame_7.dispose();
				internalFrame_about.dispose();
			}
		});
		menu_sertch.add(menuItem_querybook);
		
		//查询所有读者信息
		JMenuItem menuItem_queryreader = new JMenuItem("查询所有读者信息");
		menuItem_queryreader.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getContentPane().add(internalFrame_queryreader);
				internalFrame_queryreader.getContentPane().setLayout(null);
				
				JTable table = new JTable();   //创建表格
				JScrollPane jScrollPane=new JScrollPane(table);   //将表格添加到滚动条中
				jScrollPane.setBounds(48, 25, 555, 300);
				internalFrame_queryreader.getContentPane().add(jScrollPane);
				
				internalFrame_addbook.dispose();
				internalFrame_setbook.dispose();
				internalFrame_delbook.dispose();
				internalFrame_addreader.dispose();
				internalFrame_setreader.dispose();
				internalFrame_delreader.dispose();
				internalFrame_borrowbook.dispose();
				internalFrame_returnbook.dispose();
				internalFrame_querybook.dispose();
				internalFrame_queryreader.setVisible(true);
				internalFrame_1.dispose();
				internalFrame_2.dispose();
				internalFrame_3.dispose();
				internalFrame_4.dispose();
				internalFrame_5.dispose();
				internalFrame_6.dispose();
				internalFrame_7.dispose();
				internalFrame_about.dispose();
			}
		});
		menu_sertch.add(menuItem_queryreader);
		
		//创建查询所有的借书记录菜单项
		JMenuItem menuItem_1 = new JMenuItem("查询所有的借书记录");
		menuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getContentPane().add(internalFrame_1);
				internalFrame_1.getContentPane().setLayout(null);
				
				JTable table = new JTable();   //创建表格
				JScrollPane jScrollPane=new JScrollPane(table);   //将表格添加到滚动条中
				jScrollPane.setBounds(48, 25, 555, 300);
				internalFrame_1.getContentPane().add(jScrollPane);
				
				internalFrame_addbook.dispose();
				internalFrame_setbook.dispose();
				internalFrame_delbook.dispose();
				internalFrame_addreader.dispose();
				internalFrame_setreader.dispose();
				internalFrame_delreader.dispose();
				internalFrame_borrowbook.dispose();
				internalFrame_returnbook.dispose();
				internalFrame_querybook.dispose();
				internalFrame_queryreader.dispose();
				internalFrame_1.setVisible(true);
				internalFrame_2.dispose();
				internalFrame_3.dispose();
				internalFrame_4.dispose();
				internalFrame_5.dispose();
				internalFrame_6.dispose();
				internalFrame_7.dispose();
				internalFrame_about.dispose();
			}
		});
		menu_sertch.add(menuItem_1);
		
		//创建查询超期借书记录菜单项
		JMenuItem menuItem_2 = new JMenuItem("查询超期借书记录");
		menuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getContentPane().add(internalFrame_2);
				internalFrame_2.getContentPane().setLayout(null);
				
				JTable table = new JTable();   //创建表格
				JScrollPane jScrollPane=new JScrollPane(table);   //将表格添加到滚动条中
				jScrollPane.setBounds(48, 25, 555, 300);
				internalFrame_2.getContentPane().add(jScrollPane);
				
				internalFrame_addbook.dispose();
				internalFrame_setbook.dispose();
				internalFrame_delbook.dispose();
				internalFrame_addreader.dispose();
				internalFrame_setreader.dispose();
				internalFrame_delreader.dispose();
				internalFrame_borrowbook.dispose();
				internalFrame_returnbook.dispose();
				internalFrame_querybook.dispose();
				internalFrame_queryreader.dispose();
				internalFrame_1.dispose();
				internalFrame_2.setVisible(true);
				internalFrame_3.dispose();
				internalFrame_4.dispose();
				internalFrame_5.dispose();
				internalFrame_6.dispose();
				internalFrame_7.dispose();
				internalFrame_about.dispose();
			}
		});
		menu_sertch.add(menuItem_2);
		
		//创建查询已被借出的书本菜单项
		JMenuItem menuItem_3 = new JMenuItem("查询已被借出的书本");
		menuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getContentPane().add(internalFrame_3);
				internalFrame_3.getContentPane().setLayout(null);
				
				JTable table = new JTable();   //创建表格
				JScrollPane jScrollPane=new JScrollPane(table);   //将表格添加到滚动条中
				jScrollPane.setBounds(48, 25, 555, 300);
				internalFrame_3.getContentPane().add(jScrollPane);
				
				internalFrame_addbook.dispose();
				internalFrame_setbook.dispose();
				internalFrame_delbook.dispose();
				internalFrame_addreader.dispose();
				internalFrame_setreader.dispose();
				internalFrame_delreader.dispose();
				internalFrame_borrowbook.dispose();
				internalFrame_returnbook.dispose();
				internalFrame_querybook.dispose();
				internalFrame_queryreader.dispose();
				internalFrame_1.dispose();
				internalFrame_2.dispose();
				internalFrame_3.setVisible(true);
				internalFrame_4.dispose();
				internalFrame_5.dispose();
				internalFrame_6.dispose();
				internalFrame_7.dispose();
				internalFrame_about.dispose();
			}
		});
		menu_sertch.add(menuItem_3);
		
		//创建查询某出版社的书菜单项
		JMenuItem menuItem_4 = new JMenuItem("查询某出版社的书");
		menuItem_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getContentPane().add(internalFrame_4);
				internalFrame_4.getContentPane().setLayout(null);
				
				JLabel lblNewLabel = new JLabel("出版社名称：");
				lblNewLabel.setFont(new Font("宋体", Font.BOLD, 15));
				lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
				lblNewLabel.setBounds(88, 28, 111, 32);
				internalFrame_4.getContentPane().add(lblNewLabel);
				
				JTextField textField = new JTextField();
				textField.setBounds(195, 29, 209, 32);
				internalFrame_4.getContentPane().add(textField);
				textField.setColumns(10);
				
				JButton btnNewButton = new JButton("查询");
				btnNewButton.setFont(new Font("宋体", Font.BOLD, 12));
				btnNewButton.setBounds(429, 28, 86, 32);
				internalFrame_4.getContentPane().add(btnNewButton);
				
				JTable table = new JTable();   //创建表格
				JScrollPane jScrollPane=new JScrollPane(table);   //将表格添加到滚动条中
				jScrollPane.setBounds(48, 70, 555, 250);
				internalFrame_4.getContentPane().add(jScrollPane);
				
				internalFrame_addbook.dispose();
				internalFrame_setbook.dispose();
				internalFrame_delbook.dispose();
				internalFrame_addreader.dispose();
				internalFrame_setreader.dispose();
				internalFrame_delreader.dispose();
				internalFrame_borrowbook.dispose();
				internalFrame_returnbook.dispose();
				internalFrame_querybook.dispose();
				internalFrame_queryreader.dispose();
				internalFrame_1.dispose();
				internalFrame_2.dispose();
				internalFrame_3.dispose();
				internalFrame_4.setVisible(true);
				internalFrame_5.dispose();
				internalFrame_6.dispose();
				internalFrame_7.dispose();
				internalFrame_about.dispose();
			}
		});
		menu_sertch.add(menuItem_4);
		
		//创建查询某读者借的书菜单项
		JMenuItem menuItem_5 = new JMenuItem("查询某读者借的书");
		menuItem_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getContentPane().add(internalFrame_5);
				internalFrame_5.getContentPane().setLayout(null);
				
				JLabel lblNewLabel = new JLabel("读者姓名：");
				lblNewLabel.setFont(new Font("宋体", Font.BOLD, 15));
				lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
				lblNewLabel.setBounds(88, 28, 111, 32);
				internalFrame_5.getContentPane().add(lblNewLabel);
				
				JTextField textField = new JTextField();
				textField.setBounds(195, 29, 209, 32);
				internalFrame_5.getContentPane().add(textField);
				textField.setColumns(10);
				
				JButton btnNewButton = new JButton("查询");
				btnNewButton.setFont(new Font("宋体", Font.BOLD, 12));
				btnNewButton.setBounds(429, 28, 86, 32);
				internalFrame_5.getContentPane().add(btnNewButton);
				
				JTable table = new JTable();   //创建表格
				JScrollPane jScrollPane=new JScrollPane(table);   //将表格添加到滚动条中
				jScrollPane.setBounds(48, 70, 555, 250);
				internalFrame_5.getContentPane().add(jScrollPane);
				
				internalFrame_addbook.dispose();
				internalFrame_setbook.dispose();
				internalFrame_delbook.dispose();
				internalFrame_addreader.dispose();
				internalFrame_setreader.dispose();
				internalFrame_delreader.dispose();
				internalFrame_borrowbook.dispose();
				internalFrame_returnbook.dispose();
				internalFrame_querybook.dispose();
				internalFrame_queryreader.dispose();
				internalFrame_1.dispose();
				internalFrame_2.dispose();
				internalFrame_3.dispose();
				internalFrame_4.dispose();
				internalFrame_5.setVisible(true);
				internalFrame_6.dispose();
				internalFrame_7.dispose();
				internalFrame_about.dispose();
			}
		});
		menu_sertch.add(menuItem_5);
		
		//创建查询某读者归还某书的日期菜单项
		JMenuItem menuItem_6 = new JMenuItem("查询某读者归还某书的日期");
		menuItem_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getContentPane().add(internalFrame_6);
				internalFrame_6.getContentPane().setLayout(null);
				
				JLabel lblNewLabel = new JLabel("读者姓名：");
				lblNewLabel.setFont(new Font("宋体", Font.BOLD, 15));
				lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
				lblNewLabel.setBounds(48, 28, 97, 32);
				internalFrame_6.getContentPane().add(lblNewLabel);
				
				JTextField textField = new JTextField();
				textField.setBounds(144, 29, 131, 32);
				internalFrame_6.getContentPane().add(textField);
				textField.setColumns(10);
				
				JLabel lblNewLabel_1 = new JLabel("书名：");
				lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
				lblNewLabel_1.setFont(new Font("宋体", Font.BOLD, 15));
				lblNewLabel_1.setBounds(274, 28, 97, 32);
				internalFrame_6.getContentPane().add(lblNewLabel_1);
				
				JTextField textField_1 = new JTextField();
				textField_1.setBounds(353, 29, 131, 32);
				internalFrame_6.getContentPane().add(textField_1);
				textField_1.setColumns(10);
				
				JButton btnNewButton = new JButton("查询");
				btnNewButton.setFont(new Font("宋体", Font.BOLD, 12));
				btnNewButton.setBounds(517, 28, 86, 32);
				internalFrame_6.getContentPane().add(btnNewButton);
				
				JTable table = new JTable();   //创建表格
				JScrollPane jScrollPane=new JScrollPane(table);   //将表格添加到滚动条中
				jScrollPane.setBounds(48, 70, 555, 250);
				internalFrame_6.getContentPane().add(jScrollPane);
				
				internalFrame_addbook.dispose();
				internalFrame_setbook.dispose();
				internalFrame_delbook.dispose();
				internalFrame_addreader.dispose();
				internalFrame_setreader.dispose();
				internalFrame_delreader.dispose();
				internalFrame_borrowbook.dispose();
				internalFrame_returnbook.dispose();
				internalFrame_querybook.dispose();
				internalFrame_queryreader.dispose();
				internalFrame_1.dispose();
				internalFrame_2.dispose();
				internalFrame_3.dispose();
				internalFrame_4.dispose();
				internalFrame_5.dispose();
				internalFrame_6.setVisible(true);
				internalFrame_7.dispose();
				internalFrame_about.dispose();
			}
		});
		menu_sertch.add(menuItem_6);
		
		//创建查询某读者被罚款的总额菜单项
		JMenuItem menuItem_7 = new JMenuItem("查询某读者被罚款的总额");
		menuItem_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getContentPane().add(internalFrame_7);
				internalFrame_7.getContentPane().setLayout(null);
				
				JLabel lblNewLabel = new JLabel("读者姓名：");
				lblNewLabel.setFont(new Font("宋体", Font.BOLD, 15));
				lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
				lblNewLabel.setBounds(88, 28, 111, 32);
				internalFrame_7.getContentPane().add(lblNewLabel);
				
				JTextField textField = new JTextField();
				textField.setBounds(195, 29, 209, 32);
				internalFrame_7.getContentPane().add(textField);
				textField.setColumns(10);
				
				JButton btnNewButton = new JButton("查询");
				btnNewButton.setFont(new Font("宋体", Font.BOLD, 12));
				btnNewButton.setBounds(429, 28, 86, 32);
				internalFrame_7.getContentPane().add(btnNewButton);
				
				JTable table = new JTable();   //创建表格
				JScrollPane jScrollPane=new JScrollPane(table);   //将表格添加到滚动条中
				jScrollPane.setBounds(48, 70, 555, 250);
				internalFrame_7.getContentPane().add(jScrollPane);
				
				internalFrame_addbook.dispose();
				internalFrame_setbook.dispose();
				internalFrame_delbook.dispose();
				internalFrame_addreader.dispose();
				internalFrame_setreader.dispose();
				internalFrame_delreader.dispose();
				internalFrame_borrowbook.dispose();
				internalFrame_returnbook.dispose();
				internalFrame_querybook.dispose();
				internalFrame_queryreader.dispose();
				internalFrame_1.dispose();
				internalFrame_2.dispose();
				internalFrame_3.dispose();
				internalFrame_4.dispose();
				internalFrame_5.dispose();
				internalFrame_6.dispose();
				internalFrame_7.setVisible(true);
				internalFrame_about.dispose();
			}
		});
		menu_sertch.add(menuItem_7);
		
		//创建帮助菜单
		JMenu menu_help= new JMenu("帮助");
		menuBar.add(menu_help);
		
		//创建关于我们菜单项
		JMenuItem mntmNewMenuItem_about = new JMenuItem("关于我们");
		mntmNewMenuItem_about.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getContentPane().add(internalFrame_about);
				internalFrame_about.getContentPane().setLayout(null);
				
				JLabel lblNewLabel = new JLabel("软件作者：唐亿、韦星佐、田茂鑫");
				lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
				lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 18));
				lblNewLabel.setBounds(72, 108, 302, 40);
				internalFrame_about.getContentPane().add(lblNewLabel);
				
				internalFrame_addbook.dispose();
				internalFrame_setbook.dispose();
				internalFrame_delbook.dispose();
				internalFrame_addreader.dispose();
				internalFrame_setreader.dispose();
				internalFrame_delreader.dispose();
				internalFrame_borrowbook.dispose();
				internalFrame_returnbook.dispose();
				internalFrame_querybook.dispose();
				internalFrame_queryreader.dispose();
				internalFrame_1.dispose();
				internalFrame_2.dispose();
				internalFrame_3.dispose();
				internalFrame_4.dispose();
				internalFrame_5.dispose();
				internalFrame_6.dispose();
				internalFrame_7.dispose();
				internalFrame_about.setVisible(true);
			}
		});
		menu_help.add(mntmNewMenuItem_about);
		
		//创建退出菜单项
		JMenuItem mntmNewMenuItem_out = new JMenuItem("退出");
		mntmNewMenuItem_out.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(mntmNewMenuItem_out.getText().equals("退出")){
					JOptionPane.showMessageDialog(getParent(), "感谢使用", "关闭", JOptionPane.INFORMATION_MESSAGE);
					sql.closeSql();
					System.exit(0);
					return ;
				}
			}
		});
		menu_help.add(mntmNewMenuItem_out);
			
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
	}

}

