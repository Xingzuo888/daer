package UI;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;

import Book.book;
import Userdao.userdao;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JFormattedTextField;
import javax.swing.JList;
import javax.swing.JTable;
import javax.swing.JComboBox;
import java.awt.Scrollbar;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Vector;

import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class yyyy extends JFrame {

	private JPanel contentPane;
	private JScrollPane scrollPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					yyyy frame = new yyyy();
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
	public yyyy() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 670, 445);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(79, 68, 509, 274);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"bno", "name", "publish", "author", "price", "borrow","chioce"
			}
		));
		scrollPane.setViewportView(table);
		
		
		
		table.getColumnModel().getColumn(table.getColumnCount()-1).setCellRenderer(new TableCellRenderer() {
			
			@Override
			public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
					int row, int column) {
				JCheckBox jc=new JCheckBox();
				jc.setSelected(isSelected);
				jc.setHorizontalAlignment((int) 0.5f);
				return jc;
			}
		});  //Ìí¼Ó¸´Ñ¡¿ò
		
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
		
		JButton button = new JButton("\u786E\u5B9A");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int index = table.getSelectedRow();
				int num=(int) table.getValueAt(index, 0);
				iiiiiii i=new iiiiiii(num);
				i.setVisible(true);
			}
		});
		button.setBounds(459, 24, 93, 23);
		contentPane.add(button);
		
	}
}
