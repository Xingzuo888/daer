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

import Model.BookModel;
import UserDao.UserBook;
import Util.DateUtil;
import Util.DoubleUtil;
import Util.IntegerUtil;
import Util.LianjieUtil;
import Util.StringUtil;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class BookClassWeihu extends JInternalFrame {
	private JTable book_table;
	private LianjieUtil lianjieUtil=new LianjieUtil();
	private UserBook userBook=new UserBook();
	private JTextField s_bookId_textField;
	private JTextField s_bookName_textField;
	private JTextField s_publish_textField;
	private JTextField s_author_textField;
	private JTextField bookId_textField;
	private JTextField bookName_textField;
	private JTextField author_textField;
	private JTextField publish_textField;
	private JTextField pubDate_textField;
	private JTextField price_textField;
	private JTextField stock_textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BookClassWeihu frame = new BookClassWeihu();
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
	public BookClassWeihu() {
		setTitle("\u56FE\u4E66\u7EF4\u62A4");
		setClosable(true);
		setIconifiable(true);
		setBounds(100, 100, 651, 808);
		getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(58, 172, 523, 288);
		getContentPane().add(scrollPane);
		
		book_table = new JTable();
		book_table.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				bookTableMousePressed(e);
			}
		});
		book_table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u56FE\u4E66\u7F16\u53F7", "\u56FE\u4E66\u540D\u79F0", "\u4F5C\u8005", "\u51FA\u7248\u793E", "\u51FA\u7248\u65E5\u671F", "\u4EF7\u683C", "\u5E93\u5B58\u91CF"
			}
		));
		scrollPane.setViewportView(book_table);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "\u641C\u7D22\u6761\u4EF6", TitledBorder.LEADING, TitledBorder.TOP, null, Color.BLUE));
		panel.setBounds(58, 39, 523, 116);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\u56FE\u4E66\u7F16\u53F7\uFF1A");
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 15));
		lblNewLabel.setBounds(25, 23, 76, 25);
		panel.add(lblNewLabel);
		
		s_bookId_textField = new JTextField();
		s_bookId_textField.setBounds(111, 21, 76, 25);
		panel.add(s_bookId_textField);
		s_bookId_textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("\u56FE\u4E66\u540D\u79F0\uFF1A");
		lblNewLabel_1.setFont(new Font("宋体", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(224, 23, 76, 25);
		panel.add(lblNewLabel_1);
		
		s_bookName_textField = new JTextField();
		s_bookName_textField.setBounds(305, 23, 115, 25);
		panel.add(s_bookName_textField);
		s_bookName_textField.setColumns(10);
		
		JLabel label = new JLabel("\u51FA\u7248\u793E\uFF1A");
		label.setFont(new Font("宋体", Font.PLAIN, 15));
		label.setBounds(180, 70, 60, 25);
		panel.add(label);
		
		s_publish_textField = new JTextField();
		s_publish_textField.setBounds(247, 69, 115, 25);
		panel.add(s_publish_textField);
		s_publish_textField.setColumns(10);
		
		JLabel label_1 = new JLabel("\u4F5C\u8005\uFF1A");
		label_1.setFont(new Font("宋体", Font.PLAIN, 15));
		label_1.setBounds(26, 67, 54, 25);
		panel.add(label_1);
		
		JButton button = new JButton("\u67E5\u8BE2");
		button.setBackground(Color.LIGHT_GRAY);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addSelectPerformed(e);
			}
		});
		button.setIcon(new ImageIcon(BookClassWeihu.class.getResource("/images/search.png")));
		button.setFont(new Font("宋体", Font.PLAIN, 15));
		button.setBounds(390, 63, 93, 34);
		panel.add(button);
		
		s_author_textField = new JTextField();
		s_author_textField.setBounds(78, 68, 76, 25);
		panel.add(s_author_textField);
		s_author_textField.setColumns(10);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "\u8868\u5355\u64CD\u4F5C", TitledBorder.LEADING, TitledBorder.TOP, null, Color.RED));
		panel_1.setBounds(58, 489, 528, 261);
		getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JLabel label_2 = new JLabel("\u56FE\u4E66\u7F16\u53F7\uFF1A");
		label_2.setFont(new Font("宋体", Font.PLAIN, 15));
		label_2.setBounds(38, 36, 75, 27);
		panel_1.add(label_2);
		
		bookId_textField = new JTextField();
		bookId_textField.setEditable(false);
		bookId_textField.setBounds(123, 36, 83, 27);
		panel_1.add(bookId_textField);
		bookId_textField.setColumns(10);
		
		JLabel label_3 = new JLabel("\u56FE\u4E66\u540D\u79F0\uFF1A");
		label_3.setFont(new Font("宋体", Font.PLAIN, 15));
		label_3.setBounds(248, 36, 75, 27);
		panel_1.add(label_3);
		
		bookName_textField = new JTextField();
		bookName_textField.setBounds(333, 36, 113, 27);
		panel_1.add(bookName_textField);
		bookName_textField.setColumns(10);
		
		JLabel label_4 = new JLabel("\u4F5C\u8005\uFF1A");
		label_4.setFont(new Font("宋体", Font.PLAIN, 15));
		label_4.setBounds(38, 141, 45, 27);
		panel_1.add(label_4);
		
		author_textField = new JTextField();
		author_textField.setBounds(93, 141, 75, 27);
		panel_1.add(author_textField);
		author_textField.setColumns(10);
		
		JLabel label_5 = new JLabel("\u51FA\u7248\u793E\uFF1A");
		label_5.setFont(new Font("宋体", Font.PLAIN, 15));
		label_5.setBounds(38, 89, 60, 27);
		panel_1.add(label_5);
		
		publish_textField = new JTextField();
		publish_textField.setBounds(108, 89, 130, 27);
		panel_1.add(publish_textField);
		publish_textField.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("\u51FA\u7248\u65E5\u671F\uFF1A");
		lblNewLabel_2.setFont(new Font("宋体", Font.PLAIN, 15));
		lblNewLabel_2.setBounds(248, 89, 75, 27);
		panel_1.add(lblNewLabel_2);
		
		pubDate_textField = new JTextField();
		pubDate_textField.setBounds(333, 89, 113, 27);
		panel_1.add(pubDate_textField);
		pubDate_textField.setColumns(10);
		
		JLabel label_6 = new JLabel("\u4EF7\u683C\uFF1A");
		label_6.setFont(new Font("宋体", Font.PLAIN, 15));
		label_6.setBounds(188, 141, 45, 27);
		panel_1.add(label_6);
		
		price_textField = new JTextField();
		price_textField.setBounds(238, 141, 54, 27);
		panel_1.add(price_textField);
		price_textField.setColumns(10);
		
		JLabel label_7 = new JLabel("\u5E93\u5B58\u91CF\uFF1A");
		label_7.setFont(new Font("宋体", Font.PLAIN, 15));
		label_7.setBounds(314, 141, 60, 27);
		panel_1.add(label_7);
		
		stock_textField = new JTextField();
		stock_textField.setBounds(380, 141, 66, 27);
		panel_1.add(stock_textField);
		stock_textField.setColumns(10);
		
		JButton button_1 = new JButton("\u4FEE\u6539");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bookUpdate(e);
			}
		});
		button_1.setBackground(Color.YELLOW);
		button_1.setIcon(new ImageIcon(BookClassWeihu.class.getResource("/images/modify.png")));
		button_1.setFont(new Font("宋体", Font.PLAIN, 15));
		button_1.setBounds(38, 187, 95, 33);
		panel_1.add(button_1);
		
		JButton button_2 = new JButton("\u5220\u9664");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bookDelete(e);
			}
		});
		button_2.setBackground(Color.RED);
		button_2.setIcon(new ImageIcon(BookClassWeihu.class.getResource("/images/delete.png")));
		button_2.setFont(new Font("宋体", Font.PLAIN, 15));
		button_2.setBounds(154, 187, 95, 33);
		panel_1.add(button_2);

		this.fillTable(new BookModel());
	}

	/**
	 * 删除数据
	 * @param evt
	 */
	private void bookDelete(ActionEvent evt) {
		String bookIdString=this.bookId_textField.getText();
		if(StringUtil.isEmpty(bookIdString)){
			JOptionPane.showMessageDialog(null, "请选择要删除的记录！");
			return;
		}
		int n=JOptionPane.showConfirmDialog(null, "确定要删除该记录吗？");
		if(n==0){
			Integer bookId=new Integer(bookIdString);
			Connection  conn=null;
			try {
				conn=lianjieUtil.GetConnection();
				int deletenum=userBook.delete(conn, bookId);
				if(deletenum==1){
					JOptionPane.showMessageDialog(null, "删除成功");
					this.resetValue();
					this.fillTable(new BookModel());
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
	 * 删除数据
	 * @param evt
	 */
	private void bookUpdate(ActionEvent evt) {
		String bookIdString=this.bookId_textField.getText();
		String bookName=this.bookName_textField.getText();
		String author=this.author_textField.getText();
		String publish=this.publish_textField.getText();
		String pubDate=this.pubDate_textField.getText();
		String priceString=this.price_textField.getText();
		String stockString=this.stock_textField.getText();
		Integer bookId=null;
		Double price=null;
		Integer stock=null;
		if(StringUtil.isEmpty(bookIdString)){
			JOptionPane.showMessageDialog(null, "请选择要修改的记录！");
			return;
		}
		if(StringUtil.isEmpty(bookName)){
			JOptionPane.showMessageDialog(null, "书名不能为空！");
			return;
		}
		if(StringUtil.isEmpty(publish)){
			JOptionPane.showMessageDialog(null, "出版社不能为空！");
			return;
		}
		if(StringUtil.isEmpty(pubDate)){
			JOptionPane.showMessageDialog(null, "出版日期不能为空！");
			return;
		}
		if(StringUtil.isEmpty(author)){
			JOptionPane.showMessageDialog(null, "作者不能为空！");
			return;
		}
		if(StringUtil.isEmpty(priceString)){
			JOptionPane.showMessageDialog(null, "价格不能为空！");
			return;
		}
		if(StringUtil.isEmpty(stockString)){
			JOptionPane.showMessageDialog(null, "价格不能为空！");
			return;
		}

		if(!DateUtil.SimpleDateFormat(pubDate)){
			JOptionPane.showMessageDialog(null, "日期格式不对！");
			return;
		}
		
		if(!DoubleUtil.isEmpty(priceString)){
			JOptionPane.showMessageDialog(null, "价格不合法！");
			return;
		}else{
			price=new Double(priceString);
		}
		if(price<=0){
			JOptionPane.showMessageDialog(null, "价格不合法！");
			return;
		}
		
		if(!IntegerUtil.isEmpty(stockString)){
			JOptionPane.showMessageDialog(null, "库存量不合法！");
			return;
		}else{
			stock=new Integer(stockString);
		}
		if(stock<=0){
			JOptionPane.showMessageDialog(null, "库存量不合法！");
			return;
		}
		
		bookId=new Integer(bookIdString);
		BookModel bookModel=new BookModel(bookId, bookName, author, publish, pubDate, price,stock);
		Connection conn=null;
		try {
			conn=lianjieUtil.GetConnection();
			int updatenum=userBook.update(conn, bookModel);
			if(updatenum==1){
				JOptionPane.showMessageDialog(null, "修改成功");
				this.resetValue();
				this.fillTable(new BookModel());
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
	private void bookTableMousePressed(MouseEvent evt) {
		int row=book_table.getSelectedRow();
		bookId_textField.setText((String) book_table.getValueAt(row, 0));
		bookName_textField.setText((String) book_table.getValueAt(row, 1));
		author_textField.setText((String) book_table.getValueAt(row, 2));
		publish_textField.setText((String) book_table.getValueAt(row, 3));
		pubDate_textField.setText((String) book_table.getValueAt(row, 4));
		price_textField.setText(String.valueOf(book_table.getValueAt(row, 5)));
		stock_textField.setText(String.valueOf(book_table.getValueAt(row, 6)));
	}

	/**
	 * 查询按钮事件处理
	 * @param evt
	 */
	private void addSelectPerformed(ActionEvent evt) {
		String bookIdString=this.s_bookId_textField.getText();
		String bookName=this.s_bookName_textField.getText();
		String author=this.s_author_textField.getText();
		String publish=this.s_publish_textField.getText();
		Integer bookId=null;
		if(StringUtil.isNotEmpty(bookIdString)){
			if(IntegerUtil.isEmpty(bookIdString)){
				bookId=new Integer(bookIdString);
			}
		}
		
		BookModel bookModel=new BookModel(bookId, bookName, author, publish);
		this.fillTable(bookModel);
	}

	/**
	 * 初始化表格
	 * @param str
	 */
	private void fillTable(BookModel bookModel){
		DefaultTableModel dtm=(DefaultTableModel)book_table.getModel();
		dtm.setRowCount(0);
		Connection conn=null;
		try {
			conn=lianjieUtil.GetConnection();
			ResultSet rs=UserBook.select_Table(conn, bookModel);
			while(rs.next()){
				Vector v=new Vector();
				v.add(rs.getString("bookId"));
				v.add(rs.getString("bookName"));
				v.add(rs.getString("author"));
				v.add(rs.getString("publish"));
				v.add(rs.getString("pubDate"));
				v.add(rs.getDouble("price"));
				v.add(rs.getInt("stock"));
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
	private void resetValue() {
		this.bookId_textField.setText(null);
		this.bookName_textField.setText(null);
		this.author_textField.setText(null);
		this.publish_textField.setText(null);
		this.pubDate_textField.setText(null);
		this.price_textField.setText(null);
		this.stock_textField.setText(null);
	}

}
