package View;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.Connection;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import Model.DengLuModel;
import UserDao.UserDenglu;
import Util.LianjieUtil;
import Util.StringUtil;
import javax.swing.UIManager;

public class LogOnFrame extends JFrame {

	private JPanel contentPane;
	private JTextField zhanghuText;
	private JPasswordField mimaText;
	
	private LianjieUtil lianjieutil=new LianjieUtil();
	private UserDenglu userdenglu=new UserDenglu();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LogOnFrame frame = new LogOnFrame();
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
	public LogOnFrame() {
		setTitle("\u7BA1\u7406\u5458\u767B\u5F55");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 486, 369);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		this.setLocationRelativeTo(null);
		
		JLabel lblNewLabel = new JLabel("\u56FE\u4E66\u7BA1\u7406\u7CFB\u7EDF");
		lblNewLabel.setFont(new Font("宋体", Font.BOLD, 20));
		lblNewLabel.setIcon(new ImageIcon("D:\\eclipse\u6587\u4EF6\\Jiemian\\src\\images\\logo.png"));
		lblNewLabel.setBounds(116, 58, 256, 56);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("\u7528\u6237\u540D\uFF1A");
		lblNewLabel_1.setIcon(new ImageIcon("D:\\eclipse\u6587\u4EF6\\Jiemian\\src\\images\\userName.png"));
		lblNewLabel_1.setFont(new Font("宋体", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(94, 127, 93, 35);
		contentPane.add(lblNewLabel_1);
		
		zhanghuText = new JTextField();
		zhanghuText.setBounds(214, 131, 147, 28);
		contentPane.add(zhanghuText);
		zhanghuText.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("\u5BC6\u7801\uFF1A");
		lblNewLabel_2.setIcon(new ImageIcon("D:\\eclipse\u6587\u4EF6\\Jiemian\\src\\images\\password.png"));
		lblNewLabel_2.setFont(new Font("宋体", Font.PLAIN, 15));
		lblNewLabel_2.setBounds(94, 186, 93, 35);
		contentPane.add(lblNewLabel_2);
		
		mimaText = new JPasswordField();
		mimaText.addKeyListener(new KeyListener() {
			public void keyTyped(KeyEvent e) {
			}
			public void keyReleased(KeyEvent e) {
			}
			public void keyPressed(KeyEvent e) {
				if(e.getKeyChar()==KeyEvent.VK_ENTER)
				loginActionPerformed(e);
			}
		});
		mimaText.setBounds(214, 190, 147, 28);
		contentPane.add(mimaText);
		
		JButton btnNewButton = new JButton("\u767B\u5F55");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				loginActionPerformed(e);
			}
		});
		
		btnNewButton.setBackground(UIManager.getColor("CheckBox.shadow"));
		btnNewButton.setIcon(new ImageIcon("D:\\eclipse\u6587\u4EF6\\Jiemian\\src\\images\\login.png"));
		btnNewButton.setBounds(116, 258, 84, 35);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("\u91CD\u7F6E");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				resetValueActionPerformed(e);
			}
		});
		btnNewButton_1.setBackground(UIManager.getColor("CheckBox.shadow"));
		btnNewButton_1.setIcon(new ImageIcon("D:\\eclipse\u6587\u4EF6\\Jiemian\\src\\images\\reset.png"));
		btnNewButton_1.setBounds(246, 258, 84, 35);
		contentPane.add(btnNewButton_1);
	}

	/**
	 * 鼠标点击登录事件处理
	 * @param e
	 */
	private void loginActionPerformed(ActionEvent evt) {
		String zhanghu=this.zhanghuText.getText();
		String mima=new String(this.mimaText.getPassword());
		if(StringUtil.isEmpty(zhanghu)){
			JOptionPane.showMessageDialog(null, "用户名不能为空！");
			return;
		}
		if(StringUtil.isEmpty(mima)){
			JOptionPane.showMessageDialog(null, "密码不能为空！");
			return;
		}
		
		DengLuModel denglu= new DengLuModel(zhanghu,mima);
		Connection conn=null;
		conn=lianjieutil.GetConnection();
		try {
			DengLuModel currenDnglu=userdenglu.login(conn, denglu);
			if(currenDnglu!=null){
				JOptionPane.showMessageDialog(null, "登录成功！");
				MainFrame mainFrame=new MainFrame();
				mainFrame.setVisible(true);
				dispose();
			}else{
				JOptionPane.showMessageDialog(null, "用户名或密码错误！");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			lianjieutil.Close(conn);
		}
	}
	
	/**
	 * enter键登录事件处理
	 * @param evt
	 */
	private void loginActionPerformed(KeyEvent evt) {
		String zhanghu=this.zhanghuText.getText();
		String mima=new String(this.mimaText.getPassword());
		if(StringUtil.isEmpty(zhanghu)){
			JOptionPane.showMessageDialog(null, "用户名不能为空！");
			return;
		}
		if(StringUtil.isEmpty(mima)){
			JOptionPane.showMessageDialog(null, "密码不能为空！");
			return;
		}
		
		DengLuModel denglu= new DengLuModel(zhanghu,mima);
		Connection conn=null;
		conn=lianjieutil.GetConnection();
		try {
			DengLuModel currenDnglu=userdenglu.login(conn, denglu);
			if(currenDnglu!=null){
				JOptionPane.showMessageDialog(null, "登录成功！");
				MainFrame mainFrame=new MainFrame();
				mainFrame.setVisible(true);
				dispose();
			}else{
				JOptionPane.showMessageDialog(null, "用户名或密码错误！");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			lianjieutil.Close(conn);
		}
	}

	/**
	 * 重置事件处理
	 * @param evt
	 */
	private void resetValueActionPerformed(ActionEvent evt) {
		this.zhanghuText.setText(null);
		this.mimaText.setText(null);
	}
}
