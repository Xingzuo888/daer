package View;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

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

import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.awt.event.ActionEvent;

public class BrClassAdd extends JInternalFrame {
	private JTextField readerId_textField;
	private JTextField readerName_textField;
	private JTextField bookId_textField;
	private JTextField bookName_textField;
	private LianjieUtil lianjieUtil=new LianjieUtil();
	private UserBook userBook=new UserBook();
	private UserReader userReader=new UserReader();
	private UserBr userBr=new UserBr();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BrClassAdd frame = new BrClassAdd();
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
	public BrClassAdd() {
		setTitle("\u501F\u9605\u6DFB\u52A0");
		setIconifiable(true);
		setClosable(true);
		setBounds(100, 100, 526, 451);
		getContentPane().setLayout(null);
		
		JLabel label = new JLabel("\u8BFB\u8005\u5B66\u53F7\uFF1A");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("宋体", Font.PLAIN, 20));
		label.setBounds(82, 54, 100, 37);
		getContentPane().add(label);
		
		readerId_textField = new JTextField();
		readerId_textField.setText("\u8F93\u5165\u6574\u6570");
		readerId_textField.addMouseListener(new MouseListener() {
			public void mouseReleased(MouseEvent e) {
			}
			public void mousePressed(MouseEvent e) {
			}
			public void mouseExited(MouseEvent e) {
				if(readerId_textField.getText().equals("")){
					readerId_textField.setText("输入整数");
					readerName_textField.setText(null);
				}
			}
			public void mouseEntered(MouseEvent e) {
			}
			public void mouseClicked(MouseEvent e) {
				if(readerId_textField.getText().equals("输入整数")){
					readerId_textField.setText(null);
				}
			}
		});
		readerId_textField.addKeyListener(new KeyListener() {
			public void keyTyped(KeyEvent e) {
			}
			public void keyReleased(KeyEvent e) {
			}
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode()==KeyEvent.VK_ENTER){
					addReaderIdKey(e);
				}
			}
		});
		readerId_textField.setFont(new Font("宋体", Font.PLAIN, 20));
		readerId_textField.setBounds(192, 56, 220, 37);
		getContentPane().add(readerId_textField);
		readerId_textField.setColumns(10);
		
		JLabel label_1 = new JLabel("\u8BFB\u8005\u59D3\u540D\uFF1A");
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setFont(new Font("宋体", Font.PLAIN, 20));
		label_1.setBounds(82, 133, 100, 37);
		getContentPane().add(label_1);
		
		readerName_textField = new JTextField();
		readerName_textField.setEditable(false);
		readerName_textField.setFont(new Font("宋体", Font.PLAIN, 20));
		readerName_textField.setBounds(192, 133, 220, 37);
		getContentPane().add(readerName_textField);
		readerName_textField.setColumns(10);
		
		JLabel label_2 = new JLabel("\u56FE\u4E66\u7F16\u53F7\uFF1A");
		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		label_2.setFont(new Font("宋体", Font.PLAIN, 20));
		label_2.setBounds(82, 214, 100, 37);
		getContentPane().add(label_2);
		
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
					bookName_textField.setText(null);
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
		bookId_textField.addKeyListener(new KeyListener() {
			public void keyTyped(KeyEvent e) {
			}
			public void keyReleased(KeyEvent e) {
			}
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode()==KeyEvent.VK_ENTER){
					addBookIdKey(e);
				}
			}
		});
		bookId_textField.setFont(new Font("宋体", Font.PLAIN, 20));
		bookId_textField.setBounds(192, 214, 220, 37);
		getContentPane().add(bookId_textField);
		bookId_textField.setColumns(10);
		
		JLabel label_3 = new JLabel("\u56FE\u4E66\u540D\u79F0\uFF1A");
		label_3.setHorizontalAlignment(SwingConstants.CENTER);
		label_3.setFont(new Font("宋体", Font.PLAIN, 20));
		label_3.setBounds(82, 293, 100, 37);
		getContentPane().add(label_3);
		
		bookName_textField = new JTextField();
		bookName_textField.setFont(new Font("宋体", Font.PLAIN, 20));
		bookName_textField.setEditable(false);
		bookName_textField.setBounds(192, 293, 220, 37);
		getContentPane().add(bookName_textField);
		bookName_textField.setColumns(10);
		
		JButton button = new JButton("\u501F\u4E66");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				brAddAvtionPerformed(e);
			}
		});
		button.setBackground(Color.PINK);
		button.setIcon(new ImageIcon(BrClassAdd.class.getResource("/images/add.png")));
		button.setFont(new Font("宋体", Font.PLAIN, 18));
		button.setBounds(107, 371, 92, 29);
		getContentPane().add(button);
		
		JButton button_1 = new JButton("\u91CD\u7F6E");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				resetValueActionPerformed(e);
			}
		});
		button_1.setIcon(new ImageIcon(BrClassAdd.class.getResource("/images/reset.png")));
		button_1.setBackground(Color.LIGHT_GRAY);
		button_1.setFont(new Font("宋体", Font.PLAIN, 18));
		button_1.setBounds(270, 371, 93, 29);
		getContentPane().add(button_1);

	}

	/**
	 * 添加图书书号enter键事件处理
	 * @param e
	 */
	private void addBookIdKey(KeyEvent e) {
		Integer bookId=null;
		if(!IntegerUtil.isEmpty(this.bookId_textField.getText())){
			JOptionPane.showMessageDialog(null, "图书编号不合法！");
			return;
		}else{
			bookId=new Integer(this.bookId_textField.getText());
		}
		
		if(bookId<=0){
			JOptionPane.showMessageDialog(null, "图书编号不合法！");
			return;
		}
		
		BookModel bookModel=new BookModel(bookId);
		Connection conn=lianjieUtil.GetConnection();
		try {
			BookModel bm=userBook.selectBookId(conn, bookModel);
			if(bm==null){
				JOptionPane.showMessageDialog(null, "该编号不存在！");
			}else{
				this.bookName_textField.setText(bm.getBookName());
			}
		} catch (Exception e1) {
			e1.printStackTrace();
		}finally{
			lianjieUtil.Close(conn);
		}
		
	}

	/**
	 * 添加读者学号enter键事件处理
	 * @param evt
	 */
	private void addReaderIdKey(KeyEvent evt) {
		
		Integer readerId=null;
		if(!IntegerUtil.isEmpty(this.readerId_textField.getText())){
			JOptionPane.showMessageDialog(null, "学号不合法！");
			return;
		}else{
			readerId=new Integer(this.readerId_textField.getText());
		}
		
		if(readerId<=0){
			JOptionPane.showMessageDialog(null, "学号不合法！");
			return;
		}
		
		ReaderModel readerModel=new ReaderModel(readerId);
		Connection conn=lianjieUtil.GetConnection();
		try {
			ReaderModel rm=userReader.selectReaderId(conn, readerModel);
			if(rm==null){
				JOptionPane.showMessageDialog(null, "该学号不存在！");
			}else{
				this.readerName_textField.setText(rm.getReaderName());
			}
		} catch (Exception e1) {
			e1.printStackTrace();
		}finally{
			lianjieUtil.Close(conn);
		}
		
	}

	/**
	 * 借书按钮事件处理
	 * @param evt
	 */
	private void brAddAvtionPerformed(ActionEvent evt) {
		String readerIdString=this.readerId_textField.getText();
		String bookIdString=this.bookId_textField.getText();
		Integer readerId=null;
		Integer bookId=null;
		if(StringUtil.isEmpty(readerIdString)){
			JOptionPane.showMessageDialog(null, "学号不能为空！");
			return;
		}
		if(StringUtil.isEmpty(bookIdString)){
			JOptionPane.showMessageDialog(null, "书号不能为空！");
			return;
		}
		
		if(!IntegerUtil.isEmpty(this.readerId_textField.getText())){
			JOptionPane.showMessageDialog(null, "学号不合法！");
			return;
		}else{
			readerId=new Integer(this.readerId_textField.getText());
		}
		
		if(readerId<=0){
			JOptionPane.showMessageDialog(null, "学号不合法！");
			return;
		}
		
		if(!IntegerUtil.isEmpty(this.bookId_textField.getText())){
			JOptionPane.showMessageDialog(null, "图书编号不合法！");
			return;
		}else{
			bookId=new Integer(this.bookId_textField.getText());
		}
		
		if(bookId<=0){
			JOptionPane.showMessageDialog(null, "图书编号不合法！");
			return;
		}
		
		ReaderModel readerModel=new ReaderModel(readerId);
		BookModel bookModel=new BookModel(bookId);
		BrModel brModel=new BrModel(readerId,bookId,DateUtil.gainDate());
		Connection conn=null;
		conn=lianjieUtil.GetConnection();
		try{
			ReaderModel rm=userReader.selectReaderId(conn, readerModel);
			BookModel bm=userBook.selectBookId(conn, bookModel);
			if(rm==null){
				JOptionPane.showMessageDialog(null, "该学号不存在！");
				return;
			}
			if(bm==null){
				JOptionPane.showMessageDialog(null, "该书号不存在！");
				return;
			}
			if(rm.getBamount()<5){
				if(bm.getStock()>0){
					int addbr=userBr.add(conn, brModel);
					int addr=userReader.AddBamount(conn, readerModel);
					int addb=userBook.subStock(conn, bookModel);
					if(addbr==1 && addr==1 && addb==1){
						JOptionPane.showMessageDialog(null, "借书成功");
					}else{
						JOptionPane.showMessageDialog(null, "借书失败");
					}
				}else{
					JOptionPane.showMessageDialog(null, "该书已借完！");
				}
			}else{
				JOptionPane.showMessageDialog(null, "该学生已借5本书，不能再借阅其他图书！");
			}
			
		}catch(Exception e){
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "借书失败");
		}finally{
			lianjieUtil.Close(conn);
		}
	}

	/**
	 * 重置按钮事件处理
	 * @param evt
	 */
	private void resetValueActionPerformed(ActionEvent evt) {
		this.readerId_textField.setText(null);
		this.bookId_textField.setText(null);
	}
}
