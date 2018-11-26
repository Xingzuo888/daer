package View;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.sql.Connection;
import java.sql.ResultSet;
import java.text.ParseException;
import java.util.Vector;

import javax.swing.JTextField;
import javax.swing.UIDefaults.LazyInputMap;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Model.BookModel;
import Model.BrModel;
import Model.ReaderModel;
import UserDao.UserBook;
import UserDao.UserBr;
import UserDao.UserReader;
import Util.DateUtil;
import Util.IntegerUtil;
import Util.LianjieUtil;
import Util.StringUtil;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class BrClassWeihu extends JInternalFrame {
	private JTextField s_readerId_textField;
	private JTextField s_readerName_textField;
	private JTextField s_bookId_textField;
	private JTextField s_bookName_textField;
	private JTable br_table;
	private JTextField readerId_textField;
	private JTextField readerName_textField;
	private JTextField bookId_textField;
	private JTextField bookName_textField;
	private JTextField bdate_textField;
	private LianjieUtil lianjieUtil=new LianjieUtil();
	private UserBr userBr=new UserBr();
	private JTextField brId_textField;
	private String rdate=null;
	private UserReader userReader=new UserReader();
	private UserBook userBook=new UserBook();
	private double fun;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BrClassWeihu frame = new BrClassWeihu();
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
	public BrClassWeihu() {
		setTitle("\u501F\u9605\u7EF4\u62A4");
		setIconifiable(true);
		setClosable(true);
		setBounds(100, 100, 578, 733);
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "\u641C\u7D22\u6761\u4EF6", TitledBorder.LEADING, TitledBorder.TOP, null, Color.BLUE));
		panel.setBounds(24, 29, 510, 127);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel label = new JLabel("\u8BFB\u8005\u5B66\u53F7\uFF1A");
		label.setFont(new Font("宋体", Font.PLAIN, 15));
		label.setBounds(27, 35, 80, 25);
		panel.add(label);
		
		s_readerId_textField = new JTextField();
		s_readerId_textField.setBounds(117, 35, 74, 25);
		panel.add(s_readerId_textField);
		s_readerId_textField.setColumns(10);
		
		JLabel label_1 = new JLabel("\u8BFB\u8005\u59D3\u540D\uFF1A");
		label_1.setFont(new Font("宋体", Font.PLAIN, 15));
		label_1.setBounds(211, 35, 80, 25);
		panel.add(label_1);
		
		s_readerName_textField = new JTextField();
		s_readerName_textField.setBounds(301, 35, 80, 25);
		panel.add(s_readerName_textField);
		s_readerName_textField.setColumns(10);
		
		JLabel label_2 = new JLabel("\u56FE\u4E66\u7F16\u53F7\uFF1A");
		label_2.setFont(new Font("宋体", Font.PLAIN, 15));
		label_2.setBounds(27, 81, 80, 25);
		panel.add(label_2);
		
		s_bookId_textField = new JTextField();
		s_bookId_textField.setBounds(117, 81, 74, 25);
		panel.add(s_bookId_textField);
		s_bookId_textField.setColumns(10);
		
		JLabel label_3 = new JLabel("\u56FE\u4E66\u540D\u79F0\uFF1A");
		label_3.setFont(new Font("宋体", Font.PLAIN, 15));
		label_3.setBounds(211, 81, 80, 25);
		panel.add(label_3);
		
		s_bookName_textField = new JTextField();
		s_bookName_textField.setBounds(301, 81, 80, 25);
		panel.add(s_bookName_textField);
		s_bookName_textField.setColumns(10);
		
		JButton button = new JButton("\u67E5\u8BE2");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addSelectPerformed(e);
			}
		});
		button.setBackground(Color.LIGHT_GRAY);
		button.setIcon(new ImageIcon(BrClassWeihu.class.getResource("/images/search.png")));
		button.setFont(new Font("宋体", Font.PLAIN, 15));
		button.setBounds(403, 52, 93, 33);
		panel.add(button);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(24, 186, 510, 212);
		getContentPane().add(scrollPane);
		
		br_table = new JTable();
		br_table.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				brTableMousePressed(e);
			}
		});
		br_table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u501F\u9605\u7F16\u53F7", "\u8BFB\u8005\u5B66\u53F7", "\u8BFB\u8005\u59D3\u540D", "\u56FE\u4E66\u7F16\u53F7", "\u56FE\u4E66\u540D\u79F0", "\u501F\u4E66\u65E5\u671F", "\u8FD8\u4E66\u65E5\u671F", "\u7F5A\u6B3E\u91D1\u989D"
			}
		));
		scrollPane.setViewportView(br_table);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "\u8868\u5355\u64CD\u4F5C", TitledBorder.LEADING, TitledBorder.TOP, null, Color.RED));
		panel_1.setBounds(24, 428, 510, 248);
		getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JLabel label_4 = new JLabel("\u8BFB\u8005\u5B66\u53F7\uFF1A");
		label_4.setFont(new Font("宋体", Font.PLAIN, 15));
		label_4.setBounds(34, 32, 79, 30);
		panel_1.add(label_4);
		
		readerId_textField = new JTextField();
		readerId_textField.setEditable(false);
		readerId_textField.setBounds(123, 33, 106, 30);
		panel_1.add(readerId_textField);
		readerId_textField.setColumns(10);
		
		JLabel label_5 = new JLabel("\u8BFB\u8005\u59D3\u540D\uFF1A");
		label_5.setFont(new Font("宋体", Font.PLAIN, 15));
		label_5.setBounds(274, 33, 79, 30);
		panel_1.add(label_5);
		
		readerName_textField = new JTextField();
		readerName_textField.setEditable(false);
		readerName_textField.setBounds(363, 34, 106, 30);
		panel_1.add(readerName_textField);
		readerName_textField.setColumns(10);
		
		JLabel label_6 = new JLabel("\u56FE\u4E66\u7F16\u53F7\uFF1A");
		label_6.setFont(new Font("宋体", Font.PLAIN, 15));
		label_6.setBounds(34, 85, 79, 30);
		panel_1.add(label_6);
		
		bookId_textField = new JTextField();
		bookId_textField.setEditable(false);
		bookId_textField.setBounds(123, 86, 106, 30);
		panel_1.add(bookId_textField);
		bookId_textField.setColumns(10);
		
		JLabel label_7 = new JLabel("\u56FE\u4E66\u540D\u79F0\uFF1A");
		label_7.setFont(new Font("宋体", Font.PLAIN, 15));
		label_7.setBounds(274, 85, 79, 30);
		panel_1.add(label_7);
		
		bookName_textField = new JTextField();
		bookName_textField.setEditable(false);
		bookName_textField.setBounds(363, 85, 106, 30);
		panel_1.add(bookName_textField);
		bookName_textField.setColumns(10);
		
		JLabel label_8 = new JLabel("\u501F\u4E66\u65E5\u671F\uFF1A");
		label_8.setFont(new Font("宋体", Font.PLAIN, 15));
		label_8.setBounds(34, 139, 79, 30);
		panel_1.add(label_8);
		
		bdate_textField = new JTextField();
		bdate_textField.setEditable(false);
		bdate_textField.setBounds(123, 139, 106, 30);
		panel_1.add(bdate_textField);
		bdate_textField.setColumns(10);
		
		JButton button_1 = new JButton("\u8FD8\u4E66");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				brUpdate(e);
			}
		});
		button_1.setBackground(Color.YELLOW);
		button_1.setIcon(new ImageIcon(BrClassWeihu.class.getResource("/images/modify.png")));
		button_1.setFont(new Font("宋体", Font.PLAIN, 15));
		button_1.setBounds(34, 195, 93, 30);
		panel_1.add(button_1);
		
		JButton button_2 = new JButton("\u5220\u9664\u8BB0\u5F55");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				brDelete(e);
			}
		});
		button_2.setBackground(Color.RED);
		button_2.setIcon(new ImageIcon(BrClassWeihu.class.getResource("/images/delete.png")));
		button_2.setFont(new Font("宋体", Font.PLAIN, 15));
		button_2.setBounds(188, 195, 121, 30);
		panel_1.add(button_2);
		
		JLabel label_9 = new JLabel("\u501F\u9605\u7F16\u53F7\uFF1A");
		label_9.setFont(new Font("宋体", Font.PLAIN, 15));
		label_9.setBounds(274, 139, 79, 30);
		panel_1.add(label_9);
		
		brId_textField = new JTextField();
		brId_textField.setEditable(false);
		brId_textField.setBounds(363, 140, 106, 30);
		panel_1.add(brId_textField);
		brId_textField.setColumns(10);

		this.fillTable(new ReaderModel(), new BookModel(), new BrModel());
	}
	
	/**
	 * 删除记录事件处理
	 * @param evt
	 */
	private void brDelete(ActionEvent evt) {
		String brIdString=this.brId_textField.getText();
		if(StringUtil.isEmpty(brIdString)){
			JOptionPane.showMessageDialog(null, "请选择要删除的记录！");
			return;
		}
		if(StringUtil.isEmpty(rdate)){
			JOptionPane.showMessageDialog(null, "该书未还，无法删除该记录!");
			return;
		}
		Integer brId=new Integer(brIdString);
		Integer readerId=new Integer(this.readerId_textField.getText());
		Connection conn=lianjieUtil.GetConnection();
		ReaderModel readerModel=new ReaderModel(readerId,fun);
		if(fun>0){
			int n=JOptionPane.showConfirmDialog(null, "该同学是否已还罚款金额？");
			if(n==0){
				try {
					int brnum=userBr.delete(conn, brId);
					int readernum=userReader.SubAllFun(conn, readerModel);
					if(brnum==1 && readernum==1){
						JOptionPane.showMessageDialog(null, "删除成功");
						this.fillTable(new ReaderModel(), new BookModel(), new BrModel());
						this.resetValue();
					}else{
						JOptionPane.showMessageDialog(null, "删除失败");
					}
				} catch (Exception e) {
					e.printStackTrace();
					JOptionPane.showMessageDialog(null, "删除失败");
				}finally{
					lianjieUtil.Close(conn);
				}
			}else if(n==1){
				JOptionPane.showMessageDialog(null, "该同学罚款金额未还，无法删除该记录!");
				return;
			}
		}else{
			try {
				int brnum=userBr.delete(conn, brId);
				int readernum=userReader.SubAllFun(conn, readerModel);
				if(brnum==1 && readernum==1){
					JOptionPane.showMessageDialog(null, "删除成功");
					this.fillTable(new ReaderModel(), new BookModel(), new BrModel());
					this.resetValue();
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
	 * 还书按钮事件处理
	 * @param evt
	 */
	private void brUpdate(ActionEvent evt) {
		String brIdString=this.brId_textField.getText();
		if(StringUtil.isEmpty(brIdString)){
			JOptionPane.showMessageDialog(null, "请选择要还书的记录！");
			return;
		}
		if(StringUtil.isNotEmpty(rdate)){
			JOptionPane.showMessageDialog(null, "该书已还!");
			return;
		}
		
		Integer brId=new Integer(brIdString);
		Integer readerId=new Integer(this.readerId_textField.getText());
		Integer bookId=new Integer(this.bookId_textField.getText());
		String rdateString=DateUtil.gainDate();
		double funBr;
		try {
			int day=DateUtil.daysBetween(this.bdate_textField.getText(), rdateString);
			if(day<=30){
				funBr=0;
			}else{
				funBr=(day-30)*0.5;
			}
			Connection conn=lianjieUtil.GetConnection();
			ReaderModel readerModel=new ReaderModel(readerId,funBr);
			BookModel bookModel=new BookModel(bookId);
			BrModel brModel=new BrModel(brId, rdateString, funBr);
			try {
				int brnum=userBr.update(conn, brModel);
				int readernum=userReader.SubBamountAndAllFun(conn, readerModel);
				int booknum=userBook.addStock(conn, bookModel);
				if(brnum==1 && readernum==1 && booknum==1){
					JOptionPane.showMessageDialog(null, "还书成功");
					JOptionPane.showMessageDialog(null, "该同学被罚款"+funBr+"元");
					this.fillTable(new ReaderModel(), new BookModel(), new BrModel());
					this.resetValue();
				}else{
					JOptionPane.showMessageDialog(null, "还书失败");
				}
			} catch (Exception e) {
				e.printStackTrace();
				JOptionPane.showMessageDialog(null, "还书失败");
			}finally{
				lianjieUtil.Close(conn);
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 表格行事件处理
	 * @param evt
	 */
	private void brTableMousePressed(MouseEvent evt) {
		int row=br_table.getSelectedRow();
		this.brId_textField.setText((String) this.br_table.getValueAt(row, 0));
		this.readerId_textField.setText((String) this.br_table.getValueAt(row, 1));
		this.readerName_textField.setText((String) this.br_table.getValueAt(row, 2));
		this.bookId_textField.setText((String) this.br_table.getValueAt(row, 3));
		this.bookName_textField.setText((String) this.br_table.getValueAt(row, 4));
		this.bdate_textField.setText((String) this.br_table.getValueAt(row, 5));
		this.rdate=(String) this.br_table.getValueAt(row, 6);
		this.fun=(double) this.br_table.getValueAt(row, 7);
	}

	/**
	 * 查询按钮事件处理
	 * @param evt
	 */
	private void addSelectPerformed(ActionEvent evt) {
		String readerIdString=this.s_readerId_textField.getText();
		String readerName=this.s_readerName_textField.getText();
		String bookIdString=this.s_bookId_textField.getText();
		String bookName=this.s_bookName_textField.getText();
		Integer readerId=null;
		Integer bookId=null;
		
		if(StringUtil.isNotEmpty(readerIdString)){
			if(IntegerUtil.isEmpty(readerIdString)){
				readerId=new Integer(readerIdString);
			}
		}
		if(StringUtil.isNotEmpty(bookIdString)){
			if(IntegerUtil.isEmpty(bookIdString)){
				bookId=new Integer(bookIdString);
			}
		}
		
		ReaderModel readerModel=new ReaderModel(readerId, readerName);
		BookModel bookModel=new BookModel(bookId, bookName);
		BrModel brModel=new BrModel(readerId, bookId);
		this.fillTable(readerModel, bookModel, brModel);
	}

	/**
	 * 初始化表格
	 * @param readerModel
	 */
	public void fillTable(ReaderModel readerModel,BookModel bookModel,BrModel brModel){
		DefaultTableModel dtm=(DefaultTableModel)br_table.getModel();
		dtm.setRowCount(0);
		Connection conn=null;
		try {
			conn=lianjieUtil.GetConnection();
			ResultSet rs=userBr.select_Table(conn, readerModel, bookModel, brModel);
			while(rs.next()){
				Vector v=new Vector();
				v.add(rs.getString("brId"));
				v.add(rs.getString("readerId"));
				v.add(rs.getString("readerName"));
				v.add(rs.getString("bookId"));
				v.add(rs.getString("bookName"));
				v.add(rs.getString("bdate"));
				v.add(rs.getString("rdate"));
				v.add(rs.getDouble("fun"));
				dtm.addRow(v);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			lianjieUtil.Close(conn);
		}
	}
	
	/**
	 * 重置
	 */
	public void resetValue(){
		this.readerId_textField.setText(null);
		this.readerName_textField.setText(null);
		this.bookId_textField.setText(null);
		this.bookName_textField.setText(null);
		this.bdate_textField.setText(null);
		this.brId_textField.setText(null);
	}
}
