package View;

import java.awt.EventQueue;
import java.awt.Frame;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.BorderLayout;
import javax.swing.JDesktopPane;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MainFrame extends JFrame {

	private JPanel contentPane;
	private JDesktopPane table;

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
		setTitle("\u56FE\u4E66\u7BA1\u7406\u7CFB\u7EDF\u4E3B\u754C\u9762");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 808, 532);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("\u57FA\u672C\u6570\u636E\u7EF4\u62A4");
		mnNewMenu.setIcon(new ImageIcon("D:\\eclipse\u6587\u4EF6\\Jiemian\\src\\images\\base.png"));
		menuBar.add(mnNewMenu);
		
		JMenu menu_2 = new JMenu("\u7CFB\u522B\u7BA1\u7406");
		menu_2.setIcon(new ImageIcon("D:\\eclipse\u6587\u4EF6\\Jiemian\\src\\images\\bookTypeManager.png"));
		mnNewMenu.add(menu_2);
		
		JMenuItem menuItem = new JMenuItem("\u7CFB\u522B\u6DFB\u52A0");
		menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SdeptTypeClassAdd sdeptTypeClassAdd=new SdeptTypeClassAdd();
				sdeptTypeClassAdd.setVisible(true);
				table.add(sdeptTypeClassAdd);
			}
		});
		menuItem.setIcon(new ImageIcon("D:\\eclipse\u6587\u4EF6\\Jiemian\\src\\images\\add.png"));
		menu_2.add(menuItem);
		
		JMenuItem menuItem_1 = new JMenuItem("\u7CFB\u522B\u7EF4\u62A4");
		menuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SdeptTypeClassWeihu sdeptTypeClassWeihu=new SdeptTypeClassWeihu();
				sdeptTypeClassWeihu.setVisible(true);
				table.add(sdeptTypeClassWeihu);
			}
		});
		menuItem_1.setIcon(new ImageIcon("D:\\eclipse\u6587\u4EF6\\Jiemian\\src\\images\\edit.png"));
		menu_2.add(menuItem_1);
		
		JMenu menu_1 = new JMenu("\u56FE\u4E66\u7BA1\u7406");
		menu_1.setIcon(new ImageIcon("D:\\eclipse\u6587\u4EF6\\Jiemian\\src\\images\\bookManager.png"));
		mnNewMenu.add(menu_1);
		
		JMenuItem menuItem_2 = new JMenuItem("\u56FE\u4E66\u6DFB\u52A0");
		menuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BookClassAdd bookClassAdd=new BookClassAdd();
				bookClassAdd.setVisible(true);
				table.add(bookClassAdd);
			}
		});
		menuItem_2.setIcon(new ImageIcon("D:\\eclipse\u6587\u4EF6\\Jiemian\\src\\images\\add.png"));
		menu_1.add(menuItem_2);
		
		JMenuItem menuItem_3 = new JMenuItem("\u56FE\u4E66\u7EF4\u62A4");
		menuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BookClassWeihu bookClassWeihu=new BookClassWeihu();
				bookClassWeihu.setVisible(true);
				table.add(bookClassWeihu);
			}
		});
		menuItem_3.setIcon(new ImageIcon("D:\\eclipse\u6587\u4EF6\\Jiemian\\src\\images\\edit.png"));
		menu_1.add(menuItem_3);
		
		JMenu menu_3 = new JMenu("\u8BFB\u8005\u7BA1\u7406");
		menu_3.setIcon(new ImageIcon("D:\\eclipse\u6587\u4EF6\\Jiemian\\src\\images\\me.png"));
		mnNewMenu.add(menu_3);
		
		JMenuItem menuItem_5 = new JMenuItem("\u8BFB\u8005\u6DFB\u52A0");
		menuItem_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ReaderClassAdd readerClassAdd=new ReaderClassAdd();
				readerClassAdd.setVisible(true);
				table.add(readerClassAdd);
			}
		});
		menuItem_5.setIcon(new ImageIcon("D:\\eclipse\u6587\u4EF6\\Jiemian\\src\\images\\add.png"));
		menu_3.add(menuItem_5);
		
		JMenuItem menuItem_6 = new JMenuItem("\u8BFB\u8005\u7EF4\u62A4");
		menuItem_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ReaderClassWeihu readerClassWeihu=new ReaderClassWeihu();
				readerClassWeihu.setVisible(true);
				table.add(readerClassWeihu);
			}
		});
		menuItem_6.setIcon(new ImageIcon("D:\\eclipse\u6587\u4EF6\\Jiemian\\src\\images\\edit.png"));
		menu_3.add(menuItem_6);
		
		JMenu menu_4 = new JMenu("\u501F\u9605\u7BA1\u7406");
		menu_4.setIcon(new ImageIcon(MainFrame.class.getResource("/images/search.png")));
		mnNewMenu.add(menu_4);
		
		JMenuItem menuItem_7 = new JMenuItem("\u501F\u9605\u6DFB\u52A0");
		menuItem_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BrClassAdd brClassAdd=new BrClassAdd();
				brClassAdd.setVisible(true);
				table.add(brClassAdd);
			}
		});
		menuItem_7.setIcon(new ImageIcon(MainFrame.class.getResource("/images/add.png")));
		menu_4.add(menuItem_7);
		
		JMenuItem menuItem_8 = new JMenuItem("\u501F\u9605\u7EF4\u62A4");
		menuItem_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BrClassWeihu brClassWeihu=new BrClassWeihu();
				brClassWeihu.setVisible(true);
				table.add(brClassWeihu);
			}
		});
		menuItem_8.setIcon(new ImageIcon(MainFrame.class.getResource("/images/edit.png")));
		menu_4.add(menuItem_8);
		
		JMenu menu_5 = new JMenu("\u9000\u51FA");
		menu_5.setIcon(new ImageIcon(MainFrame.class.getResource("/images/exit.png")));
		mnNewMenu.add(menu_5);
		
		JMenuItem menuItem_9 = new JMenuItem("\u6CE8\u9500\u7528\u6237");
		menuItem_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int n=JOptionPane.showConfirmDialog(null, "是否注销该用户？");
				if(n==0){
					JOptionPane.showMessageDialog(null, "注销成功");
					LogOnFrame logOnFrame=new LogOnFrame();
					logOnFrame.setVisible(true);
					dispose();
				}
			}
		});
		menuItem_9.setIcon(new ImageIcon(MainFrame.class.getResource("/images/userName.png")));
		menu_5.add(menuItem_9);
		
		JMenuItem menuItem_10 = new JMenuItem("\u5B89\u5168\u9000\u51FA");
		menuItem_10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int n=JOptionPane.showConfirmDialog(null, "确定退出？");
				if(n==0){
					System.exit(0);
				}
			}
		});
		menuItem_10.setIcon(new ImageIcon(MainFrame.class.getResource("/images/exit.png")));
		menu_5.add(menuItem_10);
		
		JMenu menu = new JMenu("\u5173\u4E8E\u6211\u4EEC");
		menu.setIcon(new ImageIcon("D:\\eclipse\u6587\u4EF6\\Jiemian\\src\\images\\about.png"));
		menuBar.add(menu);
		
		JMenuItem menuItem_4 = new JMenuItem("\u5236\u4F5C\u56E2\u961F");
		menuItem_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AboutOur g=new AboutOur();
				g.setVisible(true);
				table.add(g);
			}
		}); 
		menuItem_4.setIcon(new ImageIcon("D:\\eclipse\u6587\u4EF6\\Jiemian\\src\\images\\about.png"));
		menu.add(menuItem_4);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		table = new JDesktopPane();
		table.setBackground(SystemColor.textHighlight);
		contentPane.add(table, BorderLayout.CENTER);
		
		//设置frame最大化
		this.setExtendedState(Frame.MAXIMIZED_BOTH);
	}
}
