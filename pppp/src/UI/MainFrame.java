package UI;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
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

import Model.Book;
import Model.Br;
import Model.Reader;
import User.getSql;


public class MainFrame extends JFrame {

	private JPanel contentPane;
	
	private final JInternalFrame internalFrame_addbook = new JInternalFrame("����ͼ��");
	private final JInternalFrame internalFrame_setbook = new JInternalFrame("�޸�ͼ��");
	private final JInternalFrame internalFrame_delbook = new JInternalFrame("ɾ��ͼ��");
	
	private final JInternalFrame internalFrame_addreader = new JInternalFrame("���Ӷ���");
	private final JInternalFrame internalFrame_setreader = new JInternalFrame("�޸Ķ���");
	private final JInternalFrame internalFrame_delreader = new JInternalFrame("ɾ������");
	
	private final JInternalFrame internalFrame_borrowbook = new JInternalFrame("����");
	
	private final JInternalFrame internalFrame_returnbook = new JInternalFrame("����");
	
	private final JInternalFrame internalFrame_querybook = new JInternalFrame("��ѯ����ͼ����Ϣ");
	private final JInternalFrame internalFrame_queryreader = new JInternalFrame("��ѯ���ж�����Ϣ");
	private final JInternalFrame internalFrame_1 = new JInternalFrame("��ѯ���еĽ����¼");
	private final JInternalFrame internalFrame_2 = new JInternalFrame("��ѯ���ڽ����¼");
	private final JInternalFrame internalFrame_3 = new JInternalFrame("��ѯ�ѱ�������鱾");
	private final JInternalFrame internalFrame_4 = new JInternalFrame("��ѯĳ���������");
	private final JInternalFrame internalFrame_5 = new JInternalFrame("��ѯĳ���߽����");
	private final JInternalFrame internalFrame_6 = new JInternalFrame("��ѯĳ���߹黹ĳ�������");
	private final JInternalFrame internalFrame_7 = new JInternalFrame("��ѯĳ���߱�������ܶ�");
	
	private final JInternalFrame internalFrame_about = new JInternalFrame("��������");
	
	private Book book = new Book();//����ͼ����Ϣ
	private Reader reader = new Reader();//����������Ϣ
	private ArrayList<Book> bookArray = new ArrayList<>();//����ͼ����Ϣ�б�
	private ArrayList<Reader> readerArray = new ArrayList<>();//����������Ϣ�б�
	private ArrayList<Br> BrArray = new ArrayList<>();//����������¼�б�
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
		setTitle("��ӭʹ��ͼ�����ϵͳ");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 670, 445);
		//�����˵���
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		//����ͼ��˵�
		JMenu menu_Book = new JMenu("ͼ��ά��");
		menuBar.add(menu_Book);
		
		//��������ͼ��˵���
		JMenuItem menuItem_addbook = new JMenuItem("����ͼ��");
		menuItem_addbook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getContentPane().add(internalFrame_addbook);
				internalFrame_addbook.getContentPane().setLayout(null);

				JLabel lblNewLabel_4 = new JLabel("������ͼ�����Ϣ");
				lblNewLabel_4.setFont(new Font("����", Font.BOLD, 15));
				lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
				lblNewLabel_4.setBounds(190, 20, 243, 36);
				internalFrame_addbook.getContentPane().add(lblNewLabel_4);
				
				JLabel lblNewLabel = new JLabel("������");
				lblNewLabel.setBounds(193, 66, 54, 15);
				internalFrame_addbook.getContentPane().add(lblNewLabel);
				
				JTextField textField_bookname = new JTextField();
				textField_bookname.setBounds(257, 63, 136, 21);
				internalFrame_addbook.getContentPane().add(textField_bookname);
				textField_bookname.setColumns(10);
				
				JLabel lblNewLabel_1 = new JLabel("�����磺");
				lblNewLabel_1.setBounds(193, 105, 54, 15);
				internalFrame_addbook.getContentPane().add(lblNewLabel_1);
				
				JTextField textField_bookpublish = new JTextField();
				textField_bookpublish.setBounds(257, 102, 136, 21);
				internalFrame_addbook.getContentPane().add(textField_bookpublish);
				textField_bookpublish.setColumns(10);
				
				JLabel lblNewLabel_2 = new JLabel("���ߣ�");
				lblNewLabel_2.setBounds(193, 143, 54, 15);
				internalFrame_addbook.getContentPane().add(lblNewLabel_2);
				
				JTextField textField_bookauthor = new JTextField();
				textField_bookauthor.setBounds(257, 140, 136, 21);
				internalFrame_addbook.getContentPane().add(textField_bookauthor);
				textField_bookauthor.setColumns(10);
				
				JLabel lblNewLabel_3 = new JLabel("�۸�");
				lblNewLabel_3.setBounds(193, 182, 54, 15);
				internalFrame_addbook.getContentPane().add(lblNewLabel_3);
				
				JTextField textField_bookprice = new JTextField();
				textField_bookprice.setBounds(257, 179, 136, 21);
				internalFrame_addbook.getContentPane().add(textField_bookprice);
				textField_bookprice.setColumns(10);
				
				JButton btnNewButton = new JButton("���");
				btnNewButton.setBounds(191, 227, 93, 23);
				btnNewButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						book.setBname(textField_bookname.getText());
						book.setBpublish(textField_bookpublish.getText());
						book.setBauthor(textField_bookauthor.getText());
						book.setBprice(Float.parseFloat((textField_bookprice.getText())));
						//�ж��������Ϣ�Ƿ�ɹ�
						if(sql.addBook(book)) { JOptionPane.showMessageDialog(null, "����ͼ��ɹ�");}
						else { JOptionPane.showMessageDialog(null, "����ͼ��ʧ��");}
						textField_bookname.setText(null);
						textField_bookpublish.setText(null);
						textField_bookauthor.setText(null);
						textField_bookprice.setText(null);
					}
				});	
				internalFrame_addbook.getContentPane().add(btnNewButton);
				
				JButton btnNewButton_1 = new JButton("����");
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
		
		//�����޸�ͼ��˵���
		JMenuItem menuItem_setbook = new JMenuItem("�޸�ͼ��");
		menuItem_setbook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getContentPane().add(internalFrame_setbook);
				internalFrame_setbook.getContentPane().setLayout(null);
				
				JLabel lblNewLabel = new JLabel("������Ҫ�޸�ͼ�������");
				lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
				lblNewLabel.setFont(new Font("����", Font.PLAIN, 18));
				lblNewLabel.setBounds(200, 10, 211, 40);
				internalFrame_setbook.getContentPane().add(lblNewLabel);
				
				JLabel lblNewLabel_1 = new JLabel("������");
				lblNewLabel_1.setFont(new Font("����", Font.PLAIN, 15));
				lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
				lblNewLabel_1.setBounds(88, 68, 111, 32);
				internalFrame_setbook.getContentPane().add(lblNewLabel_1);
				
				JTextField textField = new JTextField();
				textField.setBounds(195, 69, 209, 32);
				internalFrame_setbook.getContentPane().add(textField);
				textField.setColumns(10);
				textField.setText("");
					
				JTable table = new JTable();
				JScrollPane jScrollPane=new JScrollPane();   //�������ӵ���������
				jScrollPane.setBounds(48, 110, 555, 150);
				internalFrame_setbook.getContentPane().add(jScrollPane);
				
				table.setModel(new DefaultTableModel(
					new Object[][] {
					},
					new String[] {
						"ͼ����", "����", "������", "����", "�۸�", "ѡ��"
					}
				));
				jScrollPane.setViewportView(table);
				
				JButton btnNewButton = new JButton("��ѯ");
				btnNewButton.setBounds(429, 68, 86, 32);
				btnNewButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {//����˲�ѯ
						DefaultTableModel model = (DefaultTableModel) table.getModel();//��ӿ���Jtable
						model.setRowCount(0);//���ñ��Ϊ0��
						bookArray = sql.selectBookName(textField.getText());//ͨ��������ȡͼ����Ϣ
						if(bookArray.isEmpty()) {
							JOptionPane.showMessageDialog(null, "δ�ҵ���ͼ��");
						}else {
							Vector v = null;
							for(int i = 0; i < bookArray.size(); i ++) {
								v = new Vector<>();
								v.add(bookArray.get(i).getBno());
								v.add(bookArray.get(i).getBname());
								v.add(bookArray.get(i).getBpublish());
								v.add(bookArray.get(i).getBauthor());
								v.add(bookArray.get(i).getBprice());
								model.addRow(v);//����һ����Ϣ
							}
						}
					}
				});
				internalFrame_setbook.getContentPane().add(btnNewButton);
				
				table.getColumnModel().getColumn(table.getColumnCount()-1).setCellRenderer(new TableCellRenderer() {
					
					@Override
					public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
							int row, int column) {
						JCheckBox jc=new JCheckBox();
						jc.setSelected(isSelected);
						jc.setHorizontalAlignment((int) 0.5f);
						return jc;
					}
				});
				
				
				
				
				JButton btnNewButton_1 = new JButton("�޸�");
				btnNewButton_1.setBounds(500, 280, 86, 32);
				btnNewButton_1.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						int index=table.getSelectedRow(); //��ȡ����е�����
						int id = (int) table.getValueAt(index, 0);
						book = sql.selectBookId(id);
						Setbook setBook  = new Setbook(book);
						setBook.setVisible(true);
					}
				});
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
		
		//����ɾ��ͼ��˵���
		JMenuItem menuItem_delbook = new JMenuItem("ɾ��ͼ��");
		menuItem_delbook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getContentPane().add(internalFrame_delbook);
				internalFrame_delbook.getContentPane().setLayout(null);
				
				JLabel lblNewLabel = new JLabel("������Ҫɾ��ͼ�������");
				lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
				lblNewLabel.setFont(new Font("����", Font.PLAIN, 18));
				lblNewLabel.setBounds(200, 10, 211, 40);
				internalFrame_delbook.getContentPane().add(lblNewLabel);
				
				JLabel lblNewLabel_1 = new JLabel("������");
				lblNewLabel_1.setFont(new Font("����", Font.PLAIN, 15));
				lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
				lblNewLabel_1.setBounds(88, 68, 111, 32);
				internalFrame_delbook.getContentPane().add(lblNewLabel_1);
				
				JTextField textField = new JTextField();
				textField.setBounds(195, 69, 209, 32);
				internalFrame_delbook.getContentPane().add(textField);
				textField.setColumns(10);
				textField.setText("");
				
				JTable table = new JTable();   //�������
				JScrollPane jScrollPane=new JScrollPane(table);   //�������ӵ���������
				jScrollPane.setBounds(48, 110, 555, 150);
				internalFrame_delbook.getContentPane().add(jScrollPane);
				
				table.setModel(new DefaultTableModel(
						new Object[][] {
						},
						new String[] {
							"ͼ����", "����", "������", "����", "�۸�", "���", "ѡ��"
						}
					));
				
				JButton btnNewButton = new JButton("��ѯ");
				btnNewButton.setBounds(429, 68, 86, 32);
				btnNewButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						DefaultTableModel model = (DefaultTableModel) table.getModel();//��ӿ���Jtable
						model.setRowCount(0);//���ñ��Ϊ0��
						bookArray = sql.selectBookName(textField.getText());//ͨ��������ȡͼ����Ϣ
						if(bookArray.isEmpty()) {
							JOptionPane.showMessageDialog(null, "δ�ҵ���ͼ��");
						}else {
							Vector v = null;
							for(int i = 0; i < bookArray.size(); i ++) {
								v = new Vector<>();
								v.add(bookArray.get(i).getBno());
								v.add(bookArray.get(i).getBname());
								v.add(bookArray.get(i).getBpublish());
								v.add(bookArray.get(i).getBauthor());
								v.add(bookArray.get(i).getBprice());
								v.add(bookArray.get(i).getBborrow());
								model.addRow(v);//����һ����Ϣ
							}
						}
					}
				});
				internalFrame_delbook.getContentPane().add(btnNewButton);
				
				JButton btnNewButton_1 = new JButton("ɾ��");
				btnNewButton_1.setBounds(500, 280, 86, 32);
				btnNewButton_1.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						int index = table.getSelectedRow();
						int id = (int) table.getValueAt(index, 0);
						if(sql.deleteBook(id)) {
							JOptionPane.showMessageDialog(null, "ɾ���ɹ�");
						}else {
							JOptionPane.showMessageDialog(null, "ɾ��ʧ��");
						}
					}
				});
				internalFrame_delbook.getContentPane().add(btnNewButton_1);
				
				table.getColumnModel().getColumn(table.getColumnCount()-1).setCellRenderer(new TableCellRenderer() {
					
					@Override
					public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
							int row, int column) {
						JCheckBox jc=new JCheckBox();
						jc.setSelected(isSelected);
						jc.setHorizontalAlignment((int) 0.5f);
						return jc;
					}
				});  //��Ӹ�ѡ��
				
				
				
				
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
		
		//�������߲˵�
		JMenu menu_reader = new JMenu("����ά��");
		menuBar.add(menu_reader);
		
		//�������Ӷ��߲˵���
		JMenuItem menuItem_addreader = new JMenuItem("���Ӷ���");
		menuItem_addreader.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getContentPane().add(internalFrame_addreader);
				internalFrame_addreader.getContentPane().setLayout(null);

				JLabel lblNewLabel_4 = new JLabel("��������ߵ���Ϣ");
				lblNewLabel_4.setFont(new Font("����", Font.BOLD, 15));
				lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
				lblNewLabel_4.setBounds(190, 20, 243, 36);
				internalFrame_addreader.getContentPane().add(lblNewLabel_4);
				
				JLabel lblNewLabel = new JLabel("������");
				lblNewLabel.setBounds(193, 66, 54, 15);
				internalFrame_addreader.getContentPane().add(lblNewLabel);
				
				JTextField textField_readername = new JTextField();
				textField_readername.setBounds(257, 63, 136, 21);
				internalFrame_addreader.getContentPane().add(textField_readername);
				textField_readername.setColumns(10);
				
				JLabel lblNewLabel_1 = new JLabel("�Ա�");
				lblNewLabel_1.setBounds(193, 105, 54, 15);
				internalFrame_addreader.getContentPane().add(lblNewLabel_1);
				
				JTextField textField_readersex = new JTextField();
				textField_readersex.setBounds(257, 102, 136, 21);
				internalFrame_addreader.getContentPane().add(textField_readersex);
				textField_readersex.setColumns(10);
				
				JLabel lblNewLabel_2 = new JLabel("���䣺");
				lblNewLabel_2.setBounds(193, 143, 54, 15);
				internalFrame_addreader.getContentPane().add(lblNewLabel_2);
				
				JTextField textField_readerage = new JTextField();
				textField_readerage.setBounds(257, 140, 136, 21);
				internalFrame_addreader.getContentPane().add(textField_readerage);
				textField_readerage.setColumns(10);
				
				JLabel lblNewLabel_3 = new JLabel("ְҵ��");
				lblNewLabel_3.setBounds(193, 182, 54, 15);
				internalFrame_addreader.getContentPane().add(lblNewLabel_3);
				
				JTextField textField_readerprofession = new JTextField();
				textField_readerprofession.setBounds(257, 179, 136, 21);
				internalFrame_addreader.getContentPane().add(textField_readerprofession);
				textField_readerprofession.setColumns(10);
				
				JButton btnNewButton = new JButton("���");
				btnNewButton.setBounds(191, 227, 93, 23);
				btnNewButton.addActionListener(new ActionListener() {//���û�������ʱ�ķ�Ӧ�¼�
					public void actionPerformed(ActionEvent e) {
						if(textField_readersex.getText().equals("��") || textField_readersex.getText().equals("Ů")) {
							reader.setRname(textField_readername.getText());//���ö�������
						reader.setRsex(textField_readersex.getText());//���ö����Ա�
						reader.setRage(Integer.parseInt(textField_readerage.getText()));//���ö������䲢ת��ΪInt��
						reader.setRjob(textField_readerprofession.getText());//���ö��߹���
						//�ж��������Ϣ�Ƿ�ɹ�.
						if(sql.addReader(reader)) { JOptionPane.showMessageDialog(null, "���Ӷ��߳ɹ�");}
						else { JOptionPane.showMessageDialog(null, "���Ӷ���ʧ��");}
						textField_readername.setText(null);//���
						textField_readersex.setText(null);
						textField_readerage.setText(null);
						textField_readerprofession.setText(null);
						}else {
							JOptionPane.showMessageDialog(null, "�Ա�ֻ����Ů");
						}
						
					}
				});	
				internalFrame_addreader.getContentPane().add(btnNewButton);
				
				JButton btnNewButton_1 = new JButton("����");
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
		
		//�����޸Ķ��߲˵���
		JMenuItem menuItem_setreader = new JMenuItem("�޸Ķ���");
		menuItem_setreader.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getContentPane().add(internalFrame_setreader);
				internalFrame_setreader.getContentPane().setLayout(null);
				
				JLabel lblNewLabel = new JLabel("������Ҫ�޸Ķ��ߵ�����");
				lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
				lblNewLabel.setFont(new Font("����", Font.PLAIN, 18));
				lblNewLabel.setBounds(200, 10, 211, 40);
				internalFrame_setreader.getContentPane().add(lblNewLabel);
				
				JLabel lblNewLabel_1 = new JLabel("������");
				lblNewLabel_1.setFont(new Font("����", Font.PLAIN, 15));
				lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
				lblNewLabel_1.setBounds(88, 68, 111, 32);
				internalFrame_setreader.getContentPane().add(lblNewLabel_1);
				
				JTextField textField = new JTextField();
				textField.setBounds(195, 69, 209, 32);
				internalFrame_setreader.getContentPane().add(textField);
				textField.setColumns(10);
				textField.setText("");
				
				JTable table = new JTable();
				JScrollPane jScrollPane=new JScrollPane();   //�������ӵ���������
				jScrollPane.setBounds(48, 110, 555, 150);
				internalFrame_setreader.getContentPane().add(jScrollPane);	
				
				table.setModel(new DefaultTableModel(
					new Object[][] {
					},
					new String[] {
						"ѧ�����", "����", "�Ա�", "����", "����", "�ѽ�����"
					}
				));
				jScrollPane.setViewportView(table);
				
				JButton btnNewButton = new JButton("��ѯ");
				btnNewButton.setBounds(429, 68, 86, 32);
				btnNewButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {//����˲�ѯ
						DefaultTableModel model = (DefaultTableModel) table.getModel();//��ӿ���Jtable
						model.setRowCount(0);//���б��ʼ��0��
						readerArray = sql.selectReaderName(textField.getText());//ͨ��������ȡͼ����Ϣ
						if(readerArray.isEmpty()) {
							JOptionPane.showMessageDialog(null, "δ�ҵ���ѧ��");
						}else {
							Vector v = null;
							for(int i = 0; i < readerArray.size(); i ++) {
								v = new Vector<>();
								v.add(readerArray.get(i).getRid());
								v.add(readerArray.get(i).getRname());
								v.add(readerArray.get(i).getRsex());
								v.add(readerArray.get(i).getRage());
								v.add(readerArray.get(i).getRjob());
								v.add(readerArray.get(i).getRnumber());
								model.addRow(v);//����һ����Ϣ
							}
						}
					}
				});
				internalFrame_setreader.getContentPane().add(btnNewButton);
				
				table.getColumnModel().getColumn(table.getColumnCount()-1).setCellRenderer(new TableCellRenderer() {
					
					@Override
					public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
							int row, int column) {
						JCheckBox jc=new JCheckBox();
						jc.setSelected(isSelected);
						jc.setHorizontalAlignment((int) 0.5f);
						return jc;
					}
				});  //��Ӹ�ѡ��
				
				JButton btnNewButton_1 = new JButton("�޸�");
				btnNewButton_1.setBounds(500, 280, 86, 32);
				btnNewButton_1.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						int index=table.getSelectedRow(); //��ȡ����е�����
						int id = (int) table.getValueAt(index, 0);
						reader = sql.selectReaderId(id);
						Setreader setReader  = new Setreader(reader);
						setReader.setVisible(true);
					}
				});
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
		
		//����ɾ�����߲˵���
		JMenuItem menuItem_delreader = new JMenuItem("ɾ������");
		menuItem_delreader.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getContentPane().add(internalFrame_delreader);
				internalFrame_delreader.getContentPane().setLayout(null);
				
				JLabel lblNewLabel = new JLabel("������Ҫɾ�����ߵ�����");
				lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
				lblNewLabel.setFont(new Font("����", Font.PLAIN, 18));
				lblNewLabel.setBounds(200, 10, 211, 40);
				internalFrame_delreader.getContentPane().add(lblNewLabel);
				
				JLabel lblNewLabel_1 = new JLabel("������");
				lblNewLabel_1.setFont(new Font("����", Font.PLAIN, 15));
				lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
				lblNewLabel_1.setBounds(88, 68, 111, 32);
				internalFrame_delreader.getContentPane().add(lblNewLabel_1);
				
				JTextField textField = new JTextField();
				textField.setBounds(195, 69, 209, 32);
				internalFrame_delreader.getContentPane().add(textField);
				textField.setColumns(10);
				textField.setText("");
				
				JTable table = new JTable();   //�������
				JScrollPane jScrollPane=new JScrollPane(table);   //�������ӵ���������
				jScrollPane.setBounds(48, 110, 555, 150);
				internalFrame_delbook.getContentPane().add(jScrollPane);
				
				table.setModel(new DefaultTableModel(
						new Object[][] {
						},
						new String[] {
							"ѧ�����", "����", "�Ա�", "����", "����", "�ѽ�����"
						}
					));
				JButton btnNewButton = new JButton("��ѯ");
				btnNewButton.setBounds(429, 68, 86, 32);
				btnNewButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						DefaultTableModel model = (DefaultTableModel) table.getModel();//��ӿ���Jtable
						model.setRowCount(0);//���ñ��Ϊ0��
						readerArray = sql.selectReaderName(textField.getText());//ͨ��������ȡͼ����Ϣ
						if(readerArray.isEmpty()) {
							JOptionPane.showMessageDialog(null, "δ�ҵ���ѧ��");
						}else {
							Vector v = null;
							for(int i = 0; i < readerArray.size(); i ++) {
								v = new Vector<>();
								v.add(readerArray.get(i).getRid());
								v.add(readerArray.get(i).getRname());
								v.add(readerArray.get(i).getRsex());
								v.add(readerArray.get(i).getRage());
								v.add(readerArray.get(i).getRjob());
								v.add(readerArray.get(i).getRnumber());
								model.addRow(v);//����һ����Ϣ
							}
						}
					}
				});
				internalFrame_delreader.getContentPane().add(btnNewButton);
				
				table.getColumnModel().getColumn(table.getColumnCount()-1).setCellRenderer(new TableCellRenderer() {
					
					@Override
					public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
							int row, int column) {
						JCheckBox jc=new JCheckBox();
						jc.setSelected(isSelected);
						jc.setHorizontalAlignment((int) 0.5f);
						return jc;
					}
				});  //��Ӹ�ѡ��
				
				internalFrame_delreader.getContentPane().add(jScrollPane);
				
				JButton btnNewButton_1 = new JButton("ɾ��");
				btnNewButton_1.setBounds(500, 280, 86, 32);
				btnNewButton_1.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						int index = table.getSelectedRow();
						int id = (int) table.getValueAt(index, 0);
						if(sql.deleteReader(id)) {
							JOptionPane.showMessageDialog(null, "ɾ���ɹ�");
						}else {
							JOptionPane.showMessageDialog(null, "ɾ��ʧ��");
						}
					}
				});
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
		
		//�����軹�˵�
		JMenu menu_brbook= new JMenu("�軹��");
		menuBar.add(menu_brbook);
		
		//��������˵���
		JMenuItem mntmNewMenuItem_borrowbook = new JMenuItem("����");
		mntmNewMenuItem_borrowbook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getContentPane().add(internalFrame_borrowbook);
				internalFrame_borrowbook.getContentPane().setLayout(null);
				
				JLabel lblNewLabel = new JLabel("��������ߵı�ź�����");
				lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
				lblNewLabel.setFont(new Font("����", Font.PLAIN, 18));
				lblNewLabel.setBounds(200, 23, 211, 40);
				internalFrame_borrowbook.getContentPane().add(lblNewLabel);
				
				JLabel lblNewLabel_1 = new JLabel("��ţ�");
				lblNewLabel_1.setFont(new Font("����", Font.PLAIN, 15));
				lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
				lblNewLabel_1.setBounds(101, 75, 64, 26);
				internalFrame_borrowbook.getContentPane().add(lblNewLabel_1);
				
				JTextField textField = new JTextField();
				textField.setBounds(168, 73, 117, 26);
				internalFrame_borrowbook.getContentPane().add(textField);
				textField.setColumns(10);
				
				JLabel lblNewLabel_2 = new JLabel("������");
				lblNewLabel_2.setFont(new Font("����", Font.PLAIN, 15));
				lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
				lblNewLabel_2.setBounds(295, 75, 64, 26);
				internalFrame_borrowbook.getContentPane().add(lblNewLabel_2);
				
				JTextField textField_1 = new JTextField();
				textField_1.setEditable(false);
				textField_1.setBounds(367, 73, 117, 26);
				internalFrame_borrowbook.getContentPane().add(textField_1);
				textField_1.setColumns(10);
				
				JLabel lblNewLabel_3 = new JLabel("��������ı�ź�����");
				lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
				lblNewLabel_3.setFont(new Font("����", Font.PLAIN, 18));
				lblNewLabel_3.setBounds(200, 129, 211, 40);
				internalFrame_borrowbook.getContentPane().add(lblNewLabel_3);
				
				JLabel lblNewLabel_4 = new JLabel("��ţ�");
				lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
				lblNewLabel_4.setFont(new Font("����", Font.PLAIN, 15));
				lblNewLabel_4.setBounds(101, 178, 64, 26);
				internalFrame_borrowbook.getContentPane().add(lblNewLabel_4);
				
				JTextField textField_2 = new JTextField();
				textField_2.setBounds(168, 179, 117, 26);
				internalFrame_borrowbook.getContentPane().add(textField_2);
				textField_2.setColumns(10);
				
				JLabel lblNewLabel_5 = new JLabel("������");
				lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
				lblNewLabel_5.setFont(new Font("����", Font.PLAIN, 15));
				lblNewLabel_5.setBounds(295, 179, 64, 26);
				internalFrame_borrowbook.getContentPane().add(lblNewLabel_5);
				 
				JTextField textField_3 = new JTextField();
				textField_3.setEditable(false);
				textField_3.setBounds(367, 179, 117, 26);
				internalFrame_borrowbook.getContentPane().add(textField_3);
				textField_3.setColumns(10);

				JButton btnNewButton = new JButton("����");
				btnNewButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if(textField.getText() == "" || textField_2.getText() =="")
						{
							JOptionPane.showMessageDialog(null, "��������������Ϣ");
						}
						else {
							if(sql.borrow(Integer.parseInt(textField.getText()),Integer.parseInt(textField_2.getText())))
							{
								JOptionPane.showMessageDialog(null, "����ɹ�");
								textField.setText(null);
								textField_1.setText(null);
								textField_2.setText(null);
								textField_3.setText(null);
							}else {
								JOptionPane.showMessageDialog(null, "����ʧ��");
							}
						}
					}
				});
				btnNewButton.setBounds(260, 240, 73, 26);
				internalFrame_borrowbook.getContentPane().add(btnNewButton);
				
				KeyListener key_Listener = new KeyListener()  //���û���������ı�Ű���Enter��
		        {  
		            public void keyTyped(KeyEvent e) {}  
		            public void keyReleased(KeyEvent e){}  
		            public void keyPressed(KeyEvent e){  
		                if(e.getKeyChar() == KeyEvent.VK_ENTER )  
		                {  
		                	if(textField.getText().isEmpty())
		                	{
		                		JOptionPane.showMessageDialog(null, "��������߱��");
		                	}else {
			                	reader = sql.selectReaderId(Integer.parseInt(textField.getText()));
			                	if(reader == null)
			                	{
			                		JOptionPane.showMessageDialog(null, "δ�ҵ��ö���");
			                		textField.setText("");
			                		textField_1.setText("");
			                	}else if(reader.getRnumber() == 5) {
			                		JOptionPane.showMessageDialog(null, "���û��Ѿ������屾����");
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
		                	if(textField_2.getText().isEmpty())
		                	{
		                		JOptionPane.showMessageDialog(null, "������ͼ����");
		                	}else {
			                	book = sql.selectBookId(Integer.parseInt(textField_2.getText()));
			                	if(book == null) {
			                		JOptionPane.showMessageDialog(null, "δ�ҵ���ͼ��");
			                		textField_2.setText("");
			                		textField_3.setText("");
			                	}else if(book.getBborrow() == 0){
			                		JOptionPane.showMessageDialog(null, "��ͼ���ѽ��");
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
		
		//��������˵���
		JMenuItem mntmNewMenuItem_returnbook = new JMenuItem("����");
		mntmNewMenuItem_returnbook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getContentPane().add(internalFrame_returnbook);
				internalFrame_returnbook.getContentPane().setLayout(null);
				
				JLabel lblNewLabel = new JLabel("��������ߵı�ź�����");
				lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
				lblNewLabel.setFont(new Font("����", Font.PLAIN, 18));
				lblNewLabel.setBounds(200, 23, 211, 40);
				internalFrame_returnbook.getContentPane().add(lblNewLabel);
				
				JLabel lblNewLabel_1 = new JLabel("��ţ�");
				lblNewLabel_1.setFont(new Font("����", Font.PLAIN, 15));
				lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
				lblNewLabel_1.setBounds(101, 75, 64, 26);
				internalFrame_returnbook.getContentPane().add(lblNewLabel_1);
				
				JTextField textField = new JTextField();
				textField.setBounds(168, 73, 117, 26);
				internalFrame_returnbook.getContentPane().add(textField);
				textField.setColumns(10);
				
				JLabel lblNewLabel_2 = new JLabel("������");
				lblNewLabel_2.setFont(new Font("����", Font.PLAIN, 15));
				lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
				lblNewLabel_2.setBounds(295, 75, 64, 26);
				internalFrame_returnbook.getContentPane().add(lblNewLabel_2);
				
				JTextField textField_1 = new JTextField();
				textField_1.setEditable(false);
				textField_1.setBounds(367, 73, 117, 26);
				internalFrame_returnbook.getContentPane().add(textField_1);
				textField_1.setColumns(10);
				
				JLabel lblNewLabel_3 = new JLabel("��������ı�ź�����");
				lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
				lblNewLabel_3.setFont(new Font("����", Font.PLAIN, 18));
				lblNewLabel_3.setBounds(200, 129, 211, 40);
				internalFrame_returnbook.getContentPane().add(lblNewLabel_3);
				
				JLabel lblNewLabel_4 = new JLabel("��ţ�");
				lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
				lblNewLabel_4.setFont(new Font("����", Font.PLAIN, 15));
				lblNewLabel_4.setBounds(101, 178, 64, 26);
				internalFrame_returnbook.getContentPane().add(lblNewLabel_4);
				
				JTextField textField_2 = new JTextField();
				textField_2.setBounds(168, 179, 117, 26);
				internalFrame_returnbook.getContentPane().add(textField_2);
				textField_2.setColumns(10);
				
				JLabel lblNewLabel_5 = new JLabel("������");
				lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
				lblNewLabel_5.setFont(new Font("����", Font.PLAIN, 15));
				lblNewLabel_5.setBounds(295, 179, 64, 26);
				internalFrame_returnbook.getContentPane().add(lblNewLabel_5);
				
				JTextField textField_3 = new JTextField();
				textField_3.setEditable(false);
				textField_3.setBounds(367, 179, 117, 26);
				internalFrame_returnbook.getContentPane().add(textField_3);
				textField_3.setColumns(10);

				JButton btnNewButton = new JButton("����");
				btnNewButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if(textField.getText() == "" || textField_2.getText() =="")
						{
							JOptionPane.showMessageDialog(null, "��������������Ϣ");
						}
						else {
							if(sql.reBook(Integer.parseInt(textField.getText()),Integer.parseInt(textField_2.getText())))
							{
								JOptionPane.showMessageDialog(null, "����ɹ�");
								textField.setText(null);
								textField_1.setText(null);
								textField_2.setText(null);
								textField_3.setText(null);
							}else {
								JOptionPane.showMessageDialog(null, "����ʧ��");
							}
						}
					}
				});
				btnNewButton.setBounds(260, 240, 73, 26);
				internalFrame_returnbook.getContentPane().add(btnNewButton);
				
				KeyListener key_Listener = new KeyListener()  //���û���������ı�Ű���Enter��
				        {  
				            public void keyTyped(KeyEvent e) {}  
				            public void keyReleased(KeyEvent e){}  
				            public void keyPressed(KeyEvent e){  
				                if(e.getKeyChar() == KeyEvent.VK_ENTER )  
				                {  
				                	if(textField.getText() == "")
				                	{
				                		JOptionPane.showMessageDialog(null, "��������߱��");
				                	}else {
					                	reader = sql.selectReaderId(Integer.parseInt(textField.getText()));
					                	if(reader == null)
					                	{
					                		JOptionPane.showMessageDialog(null, "δ�ҵ��ö���");
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
				                		JOptionPane.showMessageDialog(null, "������ͼ����");
				                	}else {
				                		Br br = new Br();
					                	br = sql.selectBr(Integer.parseInt(textField.getText()),Integer.parseInt(textField_2.getText()));
					                	if(br == null) {
					                		JOptionPane.showMessageDialog(null, "�ö���δ�����");
					                		textField_2.setText("");
					                	}else {
					                		textField_3.setText(br.getBname());
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
		
		//������Ϣ��ѯ�˵�
		JMenu menu_sertch = new JMenu("��Ϣ��ѯ");
		menuBar.add(menu_sertch);

		//��ѯ����ͼ����Ϣ
		JMenuItem menuItem_querybook = new JMenuItem("��ѯ����ͼ����Ϣ");
		menuItem_querybook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getContentPane().add(internalFrame_querybook);
				internalFrame_querybook.getContentPane().setLayout(null);
				
				JButton btnNewButton = new JButton("��ѯ");
				btnNewButton.setFont(new Font("����", Font.BOLD, 12));
				btnNewButton.setBounds(300, 10, 60, 30);
				internalFrame_querybook.getContentPane().add(btnNewButton);
				
				JTable table = new JTable();
				JScrollPane jScrollPane=new JScrollPane();   //�������ӵ���������
				jScrollPane.setBounds(48, 50, 555, 250);
				internalFrame_querybook.getContentPane().add(jScrollPane);
				
				
				table.setModel(new DefaultTableModel(
					new Object[][] {
					},
					new String[] {
						"ͼ����", "����", "������", "����", "�۸�", "���"
					}
				));
				jScrollPane.setViewportView(table);
				
				btnNewButton.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						DefaultTableModel model = (DefaultTableModel) table.getModel();
						model.setRowCount(0);
						bookArray = sql.selectAllBook(); //��ȡͼ����Ϣ
						Vector v=null;//����ͼ����Ϣ
						for(int i=0;i<bookArray.size();i++){
							v=new Vector<>();
							v.add(bookArray.get(i).getBno());
							v.add(bookArray.get(i).getBname());
							v.add(bookArray.get(i).getBpublish());
							v.add(bookArray.get(i).getBauthor());
							v.add(bookArray.get(i).getBprice());
							v.add(bookArray.get(i).getBborrow());
							model.addRow(v);
						}
					}
				});
				//��ʼ�����
				
				
				
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
		
		//��ѯ���ж�����Ϣ
		JMenuItem menuItem_queryreader = new JMenuItem("��ѯ���ж�����Ϣ");
		menuItem_queryreader.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getContentPane().add(internalFrame_queryreader);
				internalFrame_queryreader.getContentPane().setLayout(null);
				
				JButton btnNewButton = new JButton("��ѯ");
				btnNewButton.setFont(new Font("����", Font.BOLD, 12));
				btnNewButton.setBounds(300, 10, 60, 30);
				internalFrame_queryreader.getContentPane().add(btnNewButton);
				
				JTable table = new JTable();   //�������
				JScrollPane jScrollPane=new JScrollPane(table);   //�������ӵ���������
				jScrollPane.setBounds(48, 50, 555, 250);
				internalFrame_queryreader.getContentPane().add(jScrollPane);
				
				table.setModel(new DefaultTableModel(
						new Object[][] {
						},
						new String[] {
							 "����", "�Ա�", "����", "ְҵ", "������"
						}
					));
				jScrollPane.setViewportView(table);
				btnNewButton.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						//��ʼ�����
						DefaultTableModel model = (DefaultTableModel) table.getModel();
						model.setRowCount(0);
						readerArray = sql.getAllReader(); //��ȡͼ����Ϣ
						Vector v=null;//����ͼ����Ϣ
						for(int i=0;i<readerArray.size();i++){
							v=new Vector<>();
							v.add(readerArray.get(i).getRname());
							v.add(readerArray.get(i).getRsex());
							v.add(readerArray.get(i).getRage());
							v.add(readerArray.get(i).getRjob());
							v.add(readerArray.get(i).getRnumber());
							v.add(readerArray.get(i).getRid());
							model.addRow(v);
						}
					}
				});
					
							
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
		
		//������ѯ���еĽ����¼�˵���
		JMenuItem menuItem_1 = new JMenuItem("��ѯ���еĽ����¼");
		menuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getContentPane().add(internalFrame_1);
				internalFrame_1.getContentPane().setLayout(null);
				
				JButton btnNewButton = new JButton("��ѯ");
				btnNewButton.setFont(new Font("����", Font.BOLD, 12));
				btnNewButton.setBounds(300, 10, 60, 30);
				internalFrame_1.getContentPane().add(btnNewButton);
				
				JTable table = new JTable();   //�������
				JScrollPane jScrollPane=new JScrollPane(table);   //�������ӵ���������
				jScrollPane.setBounds(48, 50, 555, 250);
				internalFrame_1.getContentPane().add(jScrollPane);
				
				table.setModel(new DefaultTableModel(
						new Object[][] {
						},
						new String[] {
							"ѧ��", "���", "��������", "��������", "������"
						}
					));
				jScrollPane.setViewportView(table);
				
				btnNewButton.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						//��ʼ�����
						DefaultTableModel model = (DefaultTableModel) table.getModel();
						model.setRowCount(0);
						BrArray = sql.getAllBr(); //��ȡ������Ϣ
						Vector v=null;//��������Ϣ
						for(int i=0;i<BrArray.size();i++)
						{
							v=new Vector<>();
							v.add(BrArray.get(i).getRid());
							v.add(BrArray.get(i).getBid());
							v.add(BrArray.get(i).getBdate());
							v.add(BrArray.get(i).getRdate());
							v.add(BrArray.get(i).getFun());
							model.addRow(v);
						}
					}
				});
					
				
				
				
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
		
		//������ѯ���ڽ����¼�˵���
		JMenuItem menuItem_2 = new JMenuItem("��ѯ���ڽ����¼");
		menuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getContentPane().add(internalFrame_2);
				internalFrame_2.getContentPane().setLayout(null);
				
				JButton btnNewButton = new JButton("��ѯ");
				btnNewButton.setFont(new Font("����", Font.BOLD, 12));
				btnNewButton.setBounds(300, 10, 60, 30);
				internalFrame_2.getContentPane().add(btnNewButton);
				
				JTable table = new JTable();   //�������
				JScrollPane jScrollPane=new JScrollPane(table);   //�������ӵ���������
				jScrollPane.setBounds(48, 50, 555, 250);
				internalFrame_2.getContentPane().add(jScrollPane);
				
				table.setModel(new DefaultTableModel(
						new Object[][] {
						},
						new String[] {
							"ѧ��","����","���", "����", "��������", "��������", "������"
						}
					));
				jScrollPane.setViewportView(table);
				
				btnNewButton.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						//��ʼ�����
						DefaultTableModel model = (DefaultTableModel) table.getModel();
						model.setRowCount(0);
						BrArray = sql.selectFun(); //��ȡ������Ϣ
						Vector v=null;//��������Ϣ
						for(int i = 0; i < BrArray.size(); i++) {
							v = new Vector<>();
							v.add(BrArray.get(i).getRid());
							v.add(BrArray.get(i).getRname());
							v.add(BrArray.get(i).getBid());
							v.add(BrArray.get(i).getBname());
							v.add(BrArray.get(i).getBdate());
							v.add(BrArray.get(i).getRdate());
							v.add(BrArray.get(i).getFun());
							model.addRow(v);
						}
					}
				});
					
	
				
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
		
		//������ѯ�ѱ�������鱾�˵���
		JMenuItem menuItem_3 = new JMenuItem("��ѯ�ѱ�������鱾");
		menuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getContentPane().add(internalFrame_3);
				internalFrame_3.getContentPane().setLayout(null);
				
				JButton btnNewButton = new JButton("��ѯ");
				btnNewButton.setFont(new Font("����", Font.BOLD, 12));
				btnNewButton.setBounds(300, 10, 60, 30);
				internalFrame_3.getContentPane().add(btnNewButton);
				
				JTable table = new JTable();   //�������
				JScrollPane jScrollPane=new JScrollPane();   //�������ӵ���������
				jScrollPane.setBounds(48, 50, 555, 250);
				internalFrame_3.getContentPane().add(jScrollPane);
				

				table.setModel(new DefaultTableModel(
						new Object[][] {
						},
						new String[] {
							"���", "����" }
					));
				jScrollPane.setViewportView(table);
				
				btnNewButton.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						//��ʼ�����
						DefaultTableModel model = (DefaultTableModel) table.getModel();
						model.setRowCount(0);
						BrArray = sql.borrowed(); //��ȡ������Ϣ
						Vector v=null;//��������Ϣ
						for(int i = 0; i < BrArray.size(); i++) {
							v = new Vector<>();
							v.add(BrArray.get(i).getRid());
							v.add(BrArray.get(i).getRname());
							v.add(BrArray.get(i).getBid());
							v.add(BrArray.get(i).getBname());
							v.add(BrArray.get(i).getBdate());
							model.addRow(v);
						}
					}
				});
				
				
				
				
				
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
		
		//������ѯĳ���������˵���
		JMenuItem menuItem_4 = new JMenuItem("��ѯĳ���������");
		menuItem_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getContentPane().add(internalFrame_4);
				internalFrame_4.getContentPane().setLayout(null);
				
				JLabel lblNewLabel = new JLabel("���������ƣ�");
				lblNewLabel.setFont(new Font("����", Font.BOLD, 15));
				lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
				lblNewLabel.setBounds(88, 28, 111, 32);
				internalFrame_4.getContentPane().add(lblNewLabel);
				
				
				
				
				JTextField textField = new JTextField();
				textField.setBounds(195, 29, 209, 32);
				internalFrame_4.getContentPane().add(textField);
				textField.setColumns(10);
				textField.setText("");
				
				JButton btnNewButton = new JButton("��ѯ");
				btnNewButton.setFont(new Font("����", Font.BOLD, 12));
				btnNewButton.setBounds(429, 28, 86, 32);
				
				
				
				JTable table = new JTable();   //�������
				JScrollPane jScrollPane=new JScrollPane();   //�������ӵ���������
				jScrollPane.setBounds(48, 70, 555, 250);
				internalFrame_4.getContentPane().add(jScrollPane);
				
				table.setModel(new DefaultTableModel(
						new Object[][] {
						},
						new String[] {
							"���","����","������", "����", "�۸�"  }
					));jScrollPane.setViewportView(table);
				btnNewButton.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						bookArray = sql.selectPublish(textField.getText());
						if(bookArray.isEmpty()) {
							JOptionPane.showMessageDialog(null, "δ�ҵ��ó�����");
						}else {
							
							//��ʼ�����	
							DefaultTableModel model = (DefaultTableModel) table.getModel();
							model.setRowCount(0);
							for(int i = 0; i < bookArray.size(); i++) {
								Vector v = new Vector<>();
								v.add(bookArray.get(i).getBno());
								v.add(bookArray.get(i).getBname());
								v.add(bookArray.get(i).getBpublish());
								v.add(bookArray.get(i).getBauthor());
								v.add(bookArray.get(i).getBprice());
								model.addRow(v);
							}
						}
						
					}
				});
				internalFrame_4.getContentPane().add(btnNewButton);
			
		
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
		
		//������ѯĳ���߽����˵���
		JMenuItem menuItem_5 = new JMenuItem("��ѯĳ���߽����");
		menuItem_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getContentPane().add(internalFrame_5);
				internalFrame_5.getContentPane().setLayout(null);
				
				JLabel lblNewLabel = new JLabel("����������");
				lblNewLabel.setFont(new Font("����", Font.BOLD, 15));
				lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
				lblNewLabel.setBounds(88, 28, 111, 32);
				internalFrame_5.getContentPane().add(lblNewLabel);
				
				JTextField textField = new JTextField();
				textField.setBounds(195, 29, 209, 32);
				internalFrame_5.getContentPane().add(textField);
				textField.setColumns(10);
				textField.setText("");
				
				JButton btnNewButton = new JButton("��ѯ");
				btnNewButton.setFont(new Font("����", Font.BOLD, 12));
				btnNewButton.setBounds(429, 28, 86, 32);
				internalFrame_5.getContentPane().add(btnNewButton);
				
				JTable table = new JTable();   //�������
				JScrollPane jScrollPane=new JScrollPane();   //�������ӵ���������
				jScrollPane.setBounds(48, 70, 555, 250);
				internalFrame_5.getContentPane().add(jScrollPane);
				table.setModel(new DefaultTableModel(
						new Object[][] {
						},
						new String[] {
							"����","ѧ��","���", "����", "��������","��������"  }	));
				jScrollPane.setViewportView(table);
				
				btnNewButton.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						BrArray = sql.selectredaerbook(textField.getText());
						readerArray = sql.selectReaderName(textField.getText());
						if(readerArray.isEmpty()) {
							JOptionPane.showMessageDialog(null, "��ͬѧ������");
						}else if(BrArray.isEmpty()) {
							JOptionPane.showMessageDialog(null, "��ѧ��δ����");							
						}else {
							
							//��ʼ�����	
							DefaultTableModel model = (DefaultTableModel) table.getModel();
							model.setRowCount(0);
							for(int i = 0; i < BrArray.size(); i++) {
								Vector v = new Vector<>();
								v.add(BrArray.get(i).getRname());
								v.add(BrArray.get(i).getRid());
								v.add(BrArray.get(i).getBid());
								v.add(BrArray.get(i).getBname());
								v.add(BrArray.get(i).getBdate());
								v.add(BrArray.get(i).getRdate());
								model.addRow(v);
							}
						}
						
					}
				});
				
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
		
		//������ѯĳ���߹黹ĳ������ڲ˵���
		JMenuItem menuItem_6 = new JMenuItem("��ѯĳ���߹黹ĳ�������");
		menuItem_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getContentPane().add(internalFrame_6);
				internalFrame_6.getContentPane().setLayout(null);
				
				JLabel lblNewLabel = new JLabel("����������");
				lblNewLabel.setFont(new Font("����", Font.BOLD, 15));
				lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
				lblNewLabel.setBounds(48, 28, 97, 32);
				internalFrame_6.getContentPane().add(lblNewLabel);
				
				JTextField textField = new JTextField();
				textField.setBounds(144, 29, 131, 32);
				internalFrame_6.getContentPane().add(textField);
				textField.setColumns(10);
				textField.setText("");
				
				JLabel lblNewLabel_1 = new JLabel("������");
				lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
				lblNewLabel_1.setFont(new Font("����", Font.BOLD, 15));
				lblNewLabel_1.setBounds(274, 28, 97, 32);
				internalFrame_6.getContentPane().add(lblNewLabel_1);
				
				JTextField textField_1 = new JTextField();
				textField_1.setBounds(353, 29, 131, 32);
				internalFrame_6.getContentPane().add(textField_1);
				textField_1.setColumns(10);
				textField.setText("");
				
				JButton btnNewButton = new JButton("��ѯ");
				btnNewButton.setFont(new Font("����", Font.BOLD, 12));
				btnNewButton.setBounds(517, 28, 86, 32);
				internalFrame_6.getContentPane().add(btnNewButton);
				
				JTable table = new JTable();   //�������
				JScrollPane jScrollPane=new JScrollPane();   //�������ӵ���������
				jScrollPane.setBounds(48, 70, 555, 250);
				internalFrame_6.getContentPane().add(jScrollPane);
				
				table.setModel(new DefaultTableModel(
						new Object[][] {
						},
						new String[] {
							"����","ѧ��", "����", "��������","��������"  }	));
				jScrollPane.setViewportView(table);
				
				btnNewButton.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						if(textField.getText().isEmpty()) {
							JOptionPane.showMessageDialog(null, "����������");
						}else if(textField_1.getText().isEmpty()) {
							JOptionPane.showMessageDialog(null, "����������");
						}else {
						BrArray = sql.selectrdate(textField.getText(),textField_1.getText());
						if(BrArray.isEmpty()) {
							JOptionPane.showMessageDialog(null, "��ѧ��δ�����");
						}else {
							DefaultTableModel model = (DefaultTableModel) table.getModel();
							model.setRowCount(0);
							for(int i = 0; i < BrArray.size(); i++) {
								Vector v = new Vector<>();
								v.add(BrArray.get(i).getRname());
								v.add(BrArray.get(i).getRid());
								v.add(BrArray.get(i).getBname());
								v.add(BrArray.get(i).getBdate());
								v.add(BrArray.get(i).getRdate());
								model.addRow(v);
							}
						}
						}
					}
				});

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
		
		//������ѯĳ���߱�������ܶ�˵���
		JMenuItem menuItem_7 = new JMenuItem("��ѯĳ���߱�������ܶ�");
		menuItem_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getContentPane().add(internalFrame_7);
				internalFrame_7.getContentPane().setLayout(null);
				
				JLabel lblNewLabel = new JLabel("����������");
				lblNewLabel.setFont(new Font("����", Font.BOLD, 15));
				lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
				lblNewLabel.setBounds(88, 28, 111, 32);
				internalFrame_7.getContentPane().add(lblNewLabel);
				
				JTextField textField = new JTextField();
				textField.setBounds(195, 29, 209, 32);
				internalFrame_7.getContentPane().add(textField);
				textField.setColumns(10);
				textField.setText("");
				
				JButton btnNewButton = new JButton("��ѯ");
				btnNewButton.setFont(new Font("����", Font.BOLD, 12));
				btnNewButton.setBounds(429, 28, 86, 32);
				internalFrame_7.getContentPane().add(btnNewButton);
				
				
				JTable table = new JTable();   //�������
				JScrollPane jScrollPane=new JScrollPane();   //�������ӵ���������
				jScrollPane.setBounds(48, 70, 555, 250);
				internalFrame_7.getContentPane().add(jScrollPane);
				
				table.setModel(new DefaultTableModel(
						new Object[][] {
						},
						new String[] {
							"����","ѧ��","�����ܶ�"  }
					));
				jScrollPane.setViewportView(table);
				
					btnNewButton.addActionListener(new ActionListener() {
						@Override
						public void actionPerformed(ActionEvent e) {
							// TODO Auto-generated method stub
							if(textField.getText().isEmpty()) 
							JOptionPane.showMessageDialog(null, "����������");
							BrArray = sql.sumfun(textField.getText());
							if(BrArray.isEmpty()) {
								JOptionPane.showMessageDialog(null, "��ѧ��δ�����");
							}else {
								
								//��ʼ�����	
								DefaultTableModel model = (DefaultTableModel) table.getModel();
								model.setRowCount(0);
								for(int i = 0; i < BrArray.size(); i++) {
									Vector v = new Vector<>();
									v.add(BrArray.get(i).getRname());
									v.add(BrArray.get(i).getRid());
									v.add(BrArray.get(i).getFun());
									model.addRow(v);
								}
							}
							}
						
					});
					
					
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
		
		//���������˵�
		JMenu menu_help= new JMenu("����");
		menuBar.add(menu_help);
		
		//�����������ǲ˵���
		JMenuItem mntmNewMenuItem_about = new JMenuItem("��������");
		mntmNewMenuItem_about.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getContentPane().add(internalFrame_about);
				internalFrame_about.getContentPane().setLayout(null);
				
				JLabel lblNewLabel = new JLabel("������ߣ����ڡ�Τ��������ï��");
				lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
				lblNewLabel.setFont(new Font("����", Font.PLAIN, 18));
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
		
		//�����˳��˵���
		JMenuItem mntmNewMenuItem_out = new JMenuItem("�˳�");
		mntmNewMenuItem_out.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(mntmNewMenuItem_out.getText().equals("�˳�")){
					JOptionPane.showMessageDialog(getParent(), "��лʹ��", "�ر�", JOptionPane.INFORMATION_MESSAGE);
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
