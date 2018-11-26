package UI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JMenuBar;
import java.awt.CardLayout;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.ActionEvent;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.Toolkit;

public class Dl extends JFrame {

	private JPanel contentPane;
	private final JInternalFrame internalFrame = new JInternalFrame("New JInternalFrame");
	private final JInternalFrame internalFrame_1 = new JInternalFrame("New JInternalFrame");
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Dl frame = new Dl();
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
	public Dl() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 472, 376);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu menu = new JMenu("\u56FE\u4E66\u7EF4\u62A4");
		menu.setHorizontalAlignment(SwingConstants.CENTER);
		menuBar.add(menu);
		
		JMenuItem menuItem_2 = new JMenuItem("\u6DFB\u52A0\u56FE\u4E66");
		menu.add(menuItem_2);
		
		JMenuItem menuItem_3 = new JMenuItem("\u4FEE\u6539\u56FE\u4E66");
		menu.add(menuItem_3);
		
		JMenuItem menuItem_4 = new JMenuItem("\u5220\u9664\u56FE\u4E66");
		menu.add(menuItem_4);
		
		JMenu menu_1 = new JMenu("\u8BFB\u8005\u7EF4\u62A4");
		menu_1.setHorizontalAlignment(SwingConstants.CENTER);
		menuBar.add(menu_1);
		
		JMenuItem menuItem_5 = new JMenuItem("\u6DFB\u52A0\u8BFB\u8005");
		menu_1.add(menuItem_5);
		
		JMenuItem menuItem_6 = new JMenuItem("\u4FEE\u6539\u4FE1\u606F");
		menu_1.add(menuItem_6);
		
		JMenuItem menuItem_7 = new JMenuItem("\u5220\u9664\u8BFB\u8005");
		menu_1.add(menuItem_7);
		
		JMenu menu_4 = new JMenu("\u4FE1\u606F\u67E5\u8BE2");
		menu_4.setHorizontalAlignment(SwingConstants.CENTER);
		/*menu_4.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub
				JInternalFrame internalFrame_1 = new JInternalFrame("New JInternalFrame");
				internalFrame_1.setBounds(-13, -27, 487, 376);
				getContentPane().add(internalFrame_1);
				internalFrame_1.getContentPane().setLayout(null);
				
				JButton btnNewButton_6 = new JButton("New button");
				btnNewButton_6.setBounds(178, 273, 93, 23);
				internalFrame_1.getContentPane().add(btnNewButton_6);
				
				JButton btnNewButton_7 = new JButton("New button");
				btnNewButton_7.setBounds(178, 220, 93, 23);
				internalFrame_1.getContentPane().add(btnNewButton_7);
				internalFrame_1.setVisible(true);
				dispose();
			}
		});*/
		menu_4.addMenuListener(new MenuListener() {
			
			@Override
			public void menuSelected(MenuEvent e) {
				// TODO Auto-generated method stub
				
				internalFrame_1.setBounds(-11, -52, 477, 376);
				getContentPane().add(internalFrame_1);
				internalFrame_1.getContentPane().setLayout(null);
				
				JButton btnNewButton_6 = new JButton("New button");
				btnNewButton_6.setBounds(178, 273, 93, 23);
				internalFrame_1.getContentPane().add(btnNewButton_6);
				
				JButton btnNewButton_7 = new JButton("New button");
				btnNewButton_7.setBounds(178, 220, 93, 23);
				internalFrame_1.getContentPane().add(btnNewButton_7);
				internalFrame_1.setVisible(true);
				internalFrame.setVisible(false);
			}
			
			@Override
			public void menuDeselected(MenuEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void menuCanceled(MenuEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
		JMenu menu_2 = new JMenu("\u501F\u4E66");
		menuBar.add(menu_2);
		
		JMenu menu_5 = new JMenu("\u8FD8\u4E66");
		menuBar.add(menu_5);
		menuBar.add(menu_4);
		
		JMenuItem menuItem_10 = new JMenuItem("\u67E5\u8BE2\u8D85\u671F\u501F\u4E66\u8BB0\u5F55");
		menu_4.add(menuItem_10);
		
		JMenuItem menuItem_11 = new JMenuItem("\u67E5\u8BE2\u5DF2\u88AB\u501F\u51FA\u7684\u4E66\u672C");
		menu_4.add(menuItem_11);
		
		JMenuItem menuItem_12 = new JMenuItem("\u67E5\u8BE2\u67D0\u51FA\u7248\u793E\u7684\u4E66");
		menu_4.add(menuItem_12);
		
		JMenuItem menuItem_13 = new JMenuItem("\u67E5\u8BE2\u67D0\u8BFB\u8005\u501F\u7684\u4E66");
		menu_4.add(menuItem_13);
		
		JMenuItem menuItem_14 = new JMenuItem("\u67E5\u8BE2\u67D0\u8BFB\u8005\u5F52\u8FD8\u67D0\u4E66\u7684\u65E5\u671F");
		menu_4.add(menuItem_14);
		
		JMenu menu_3 = new JMenu("\u5E2E\u52A9");
		menuBar.add(menu_3);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("\u5173\u4E8E\u6211\u4EEC");
		menu_3.add(mntmNewMenuItem);
		
		JMenuItem menuItem_8 = new JMenuItem("\u9000\u51FA");
		menu_3.add(menuItem_8);
		
		getContentPane().setLayout(null);
		
		
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new CardLayout(0, 0));
		
	}
}
