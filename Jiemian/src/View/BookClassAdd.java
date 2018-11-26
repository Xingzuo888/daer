package View;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

import Model.BookModel;
import UserDao.UserBook;
import Util.DateUtil;
import Util.DoubleUtil;
import Util.IntegerUtil;
import Util.LianjieUtil;
import Util.StringUtil;

public class BookClassAdd extends JInternalFrame {
	private JTextField bookId_textField;
	private JTextField bookName_textField;
	private JTextField publish_textField;
	private JTextField pubDate_textField;
	private JTextField author_textField;
	private JTextField price_textField;
	private LianjieUtil lianjieUtil=new LianjieUtil();
	private UserBook userBook=new UserBook();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BookClassAdd frame = new BookClassAdd();
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
	public BookClassAdd() {
		setTitle("\u56FE\u4E66\u6DFB\u52A0");
		setIconifiable(true);
		setClosable(true);
		setBounds(100, 100, 759, 518);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\u4E66\u53F7\uFF1A");
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 20));
		lblNewLabel.setBounds(49, 79, 94, 39);
		getContentPane().add(lblNewLabel);
		
		bookId_textField = new JTextField();
		bookId_textField.setText("\u8F93\u5165\u6574\u6570");
		bookId_textField.addMouseListener(new MouseListener() {
			public void mouseReleased(MouseEvent e) {				
			}
			public void mousePressed(MouseEvent e) {
			}
			public void mouseExited(MouseEvent e) {
				if(bookId_textField.getText().equals("")){
					bookId_textField.setText("输入整数");
				}
			}
			public void mouseEntered(MouseEvent e) {			
			}
			public void mouseClicked(MouseEvent e) {
				if(bookId_textField.getText().equals("输入整数")){
					bookId_textField.setText(null);
				}
			}
		});
		bookId_textField.setFont(new Font("宋体", Font.PLAIN, 20));
		bookId_textField.setBounds(153, 79, 185, 39);
		getContentPane().add(bookId_textField);
		bookId_textField.setColumns(10);
		
		JLabel label = new JLabel("\u4E66\u540D\uFF1A");
		label.setHorizontalAlignment(SwingConstants.RIGHT);
		label.setFont(new Font("宋体", Font.PLAIN, 20));
		label.setBounds(377, 79, 100, 39);
		getContentPane().add(label);
		
		JButton Add_button = new JButton("\u6DFB\u52A0");
		Add_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bookAddActionPerformed(e);
			}
		});
		Add_button.setBackground(Color.LIGHT_GRAY);
		Add_button.setIcon(new ImageIcon("D:\\eclipse\u6587\u4EF6\\Jiemian\\src\\images\\add.png"));
		Add_button.setBounds(181, 378, 108, 34);
		getContentPane().add(Add_button);
		
		JButton Reset_button = new JButton("\u91CD\u7F6E");
		Reset_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				resetValueActionPerformed(e);
			}
		});
		Reset_button.setBackground(Color.LIGHT_GRAY);
		Reset_button.setIcon(new ImageIcon("D:\\eclipse\u6587\u4EF6\\Jiemian\\src\\images\\reset.png"));
		Reset_button.setBounds(438, 378, 108, 34);
		getContentPane().add(Reset_button);
		
		bookName_textField = new JTextField();
		bookName_textField.setFont(new Font("宋体", Font.PLAIN, 20));
		bookName_textField.setBounds(496, 79, 185, 39);
		getContentPane().add(bookName_textField);
		bookName_textField.setColumns(10);
		
		JLabel label_1 = new JLabel("\u51FA\u7248\u793E\uFF1A");
		label_1.setFont(new Font("宋体", Font.PLAIN, 20));
		label_1.setBounds(63, 166, 80, 39);
		getContentPane().add(label_1);
		
		publish_textField = new JTextField();
		publish_textField.setFont(new Font("宋体", Font.PLAIN, 20));
		publish_textField.setBounds(153, 168, 185, 39);
		getContentPane().add(publish_textField);
		publish_textField.setColumns(10);
		
		JLabel label_2 = new JLabel("\u51FA\u7248\u65E5\u671F\uFF1A");
		label_2.setFont(new Font("宋体", Font.PLAIN, 20));
		label_2.setBounds(377, 166, 108, 39);
		getContentPane().add(label_2);
		
		pubDate_textField = new JTextField();
		pubDate_textField.setText("\u5982:yyyy-MM-dd");
		pubDate_textField.addMouseListener(new MouseListener() {
			public void mouseReleased(MouseEvent e) {
			}
			public void mousePressed(MouseEvent e) {
			}
			public void mouseExited(MouseEvent e) {
				if(pubDate_textField.getText().equals("")){
					pubDate_textField.setText("如:yyyy-MM-dd");
				}
			}
			public void mouseEntered(MouseEvent e) {
			}
			public void mouseClicked(MouseEvent e) {
				if(pubDate_textField.getText().equals("如:yyyy-MM-dd")){
					pubDate_textField.setText(null);
				}
			}
		});
		pubDate_textField.setFont(new Font("宋体", Font.PLAIN, 20));
		pubDate_textField.setBounds(496, 168, 185, 39);
		getContentPane().add(pubDate_textField);
		pubDate_textField.setColumns(10);
		
		JLabel label_3 = new JLabel("\u4F5C\u8005\uFF1A");
		label_3.setHorizontalAlignment(SwingConstants.RIGHT);
		label_3.setFont(new Font("宋体", Font.PLAIN, 20));
		label_3.setBounds(49, 269, 94, 39);
		getContentPane().add(label_3);
		
		author_textField = new JTextField();
		author_textField.setFont(new Font("宋体", Font.PLAIN, 20));
		author_textField.setBounds(153, 269, 185, 39);
		getContentPane().add(author_textField);
		author_textField.setColumns(10);
		
		JLabel label_4 = new JLabel("\u4EF7\u683C\uFF1A");
		label_4.setHorizontalAlignment(SwingConstants.RIGHT);
		label_4.setFont(new Font("宋体", Font.PLAIN, 20));
		label_4.setBounds(377, 271, 100, 34);
		getContentPane().add(label_4);
		
		price_textField = new JTextField();
		price_textField.setText("\u8F93\u5165\u6D6E\u70B9\u6570");
		price_textField.addMouseListener(new MouseListener() {
			public void mouseReleased(MouseEvent e) {
			}
			public void mousePressed(MouseEvent e) {
			}
			public void mouseExited(MouseEvent e) {
				if(price_textField.getText().equals("")){
					price_textField.setText("输入浮点数");
				}
			}
			public void mouseEntered(MouseEvent e) {
			}
			public void mouseClicked(MouseEvent e) {
				if(price_textField.getText().equals("输入浮点数")){
					price_textField.setText(null);
				}
			}
		});
		price_textField.setFont(new Font("宋体", Font.PLAIN, 20));
		price_textField.setBounds(496, 269, 185, 39);
		getContentPane().add(price_textField);
		price_textField.setColumns(10);

	}

	/**
	 * 添加图书
	 * @param evt
	 */
	private void bookAddActionPerformed(ActionEvent evt) {
		String bookIdString=this.bookId_textField.getText();
		String bookName=this.bookName_textField.getText();
		String author=this.author_textField.getText();
		String publish=this.publish_textField.getText();
		String pubDate=this.pubDate_textField.getText();
		String priceString=this.price_textField.getText();
		Integer bookId=null;
		Double price=null;
		if(StringUtil.isEmpty(bookIdString)){
			JOptionPane.showMessageDialog(null, "书号不能为空！");
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
		
		if(!IntegerUtil.isEmpty(bookIdString)){
			JOptionPane.showMessageDialog(null, "书号不合法！");
			return;
		}else{
			bookId=new Integer(bookIdString);
		}
		if(bookId<=0){
			JOptionPane.showMessageDialog(null, "书号不合法！");
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
		
		BookModel bookModel=new BookModel(bookId,bookName,author,publish,pubDate,price);
		Connection conn=null;
		conn=lianjieUtil.GetConnection();
		try {
			if(userBook.selectAdd(conn, bookModel)){
				int addnum=userBook.addStock(conn, bookModel);
				if(addnum==1){
					JOptionPane.showMessageDialog(null, "添加成功");
				}else{
					JOptionPane.showMessageDialog(null, "添加失败");
				}
			}else if(userBook.selectBookId(conn, bookModel) != null){
				JOptionPane.showMessageDialog(null, "该书号已存在！");
			}
			else{
				int addnum=userBook.add(conn, bookModel);
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
			lianjieUtil.Close(conn);
		}
		
	}

	

	/**
	 * 重置
	 * @param evt
	 */
	private void resetValueActionPerformed(ActionEvent evt) {
		this.bookId_textField.setText(null);
		this.bookName_textField.setText(null);
		this.publish_textField.setText(null);
		this.pubDate_textField.setText(null);
		this.author_textField.setText(null);
		this.price_textField.setText(null);
	}
}
