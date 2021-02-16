package View;

import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Vector;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JInternalFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Dao.BookDao;
import Dao.BookTypeDao;
import Model.BookType;
import Tools.DB;
import Tools.String_Tool;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.JTextArea;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class BookTypeMangerInterFrm extends JInternalFrame {
	private JTable BookTypeTable;
	private BookTypeDao btd = new BookTypeDao();
	private DB db=new DB();
	private JTextField S_BookTypeNameTxt;
	private JTextField idtxt;
	private JTextField booktypenametxt;
	private JTextArea booktypedesctxt;
	private BookDao bd=new BookDao();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BookTypeMangerInterFrm frame = new BookTypeMangerInterFrm();
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
	public BookTypeMangerInterFrm() {
		setIconifiable(true);
		setClosable(true);
		setTitle("\u56FE\u4E66\u7C7B\u522B\u7BA1\u7406");
		setBounds(100, 100, 518, 611);
		
		JScrollPane scrollPane = new JScrollPane();
		
		JLabel lblNewLabel = new JLabel("\u56FE\u4E66\u7C7B\u522B\u540D\u79F0\uFF1A");
		lblNewLabel.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 15));
		
		S_BookTypeNameTxt = new JTextField();
		S_BookTypeNameTxt.setColumns(10);
		
		JButton btnNewButton = new JButton("\u67E5\u8BE2");
		btnNewButton.setIcon(new ImageIcon(BookTypeMangerInterFrm.class.getResource("/images/Search_16px_1191708_easyicon.net.png")));
		btnNewButton.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 15));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				BookTypeSearchActionPerformed(e);
				
			}
		});
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "\u8868\u5355\u64CD\u4F5C", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addGap(40)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(panel, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
							.addComponent(lblNewLabel)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(S_BookTypeNameTxt, GroupLayout.DEFAULT_SIZE, 202, Short.MAX_VALUE)
							.addGap(18)
							.addComponent(btnNewButton))
						.addComponent(scrollPane, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 422, Short.MAX_VALUE))
					.addGap(40))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(32)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(S_BookTypeNameTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnNewButton))
					.addGap(34)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 168, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 264, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(30, Short.MAX_VALUE))
		);
		
		JLabel lblNewLabel_1 = new JLabel("\u7F16\u53F7\uFF1A");
		lblNewLabel_1.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 15));
		
		idtxt = new JTextField();
		idtxt.setEnabled(false);
		idtxt.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 15));
		idtxt.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("\u56FE\u4E66\u7C7B\u522B\u540D\u79F0\uFF1A");
		lblNewLabel_2.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 15));
		
		booktypenametxt = new JTextField();
		booktypenametxt.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("\u63CF\u8FF0\uFF1A");
		lblNewLabel_3.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 15));
		
		booktypedesctxt = new JTextArea();
		
		JButton btnNewButton_1 = new JButton("\u4FEE\u6539");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				BookTypeUpdateActionEvent(e);
				
			}
		});
		btnNewButton_1.setIcon(new ImageIcon(BookTypeMangerInterFrm.class.getResource("/images/pen_16px_1137927_easyicon.net.png")));
		btnNewButton_1.setFont(new Font("Ó×Ô²", Font.PLAIN, 15));
		
		JButton btnNewButton_2 = new JButton("\u5220\u9664");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BookTypeDeleteActionEvent(e);
			}
		});
		btnNewButton_2.setIcon(new ImageIcon(BookTypeMangerInterFrm.class.getResource("/images/delete_15.275362318841px_1143794_easyicon.net.png")));
		btnNewButton_2.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 15));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addContainerGap()
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING, false)
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(lblNewLabel_1)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(idtxt, GroupLayout.PREFERRED_SIZE, 69, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(lblNewLabel_2)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(booktypenametxt, GroupLayout.PREFERRED_SIZE, 125, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(lblNewLabel_3)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(booktypedesctxt))))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(95)
							.addComponent(btnNewButton_1)
							.addGap(49)
							.addComponent(btnNewButton_2)))
					.addContainerGap(22, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1)
						.addComponent(idtxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_2)
						.addComponent(booktypenametxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel_3)
						.addComponent(booktypedesctxt, GroupLayout.PREFERRED_SIZE, 113, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(18)
							.addComponent(btnNewButton_1))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(18)
							.addComponent(btnNewButton_2)))
					.addContainerGap(20, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		
		BookTypeTable = new JTable();
		BookTypeTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				
				BookTypeMouserPressed(e);
				
			}
		});
		BookTypeTable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u7F16\u53F7", "\u56FE\u4E66\u7C7B\u522B\u540D\u79F0", "\u56FE\u4E66\u7C7B\u522B\u4ECB\u7ECD"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		BookTypeTable.getColumnModel().getColumn(1).setPreferredWidth(194);
		BookTypeTable.getColumnModel().getColumn(2).setPreferredWidth(127);
		scrollPane.setViewportView(BookTypeTable);
		getContentPane().setLayout(groupLayout);
		
		this.FillTable(new BookType());

	}
	
	protected void BookTypeDeleteActionEvent(ActionEvent evt) {
		// TODO Auto-generated method stub
		String id=idtxt.getText();
		if(String_Tool.isEmpty(id)) {
			JOptionPane.showMessageDialog(null, "ÇëÑ¡ÔñÒªÉ¾³ýµÄ¼ÇÂ¼£¡");
			return;
		}
		int jr=JOptionPane.showConfirmDialog(null, "È·ÈÏÒªÉ¾³ý¸Ã¼ÇÂ¼Âð£¿");
		if(jr==0) {
			Connection conn=null;
			try {
				conn=db.getCon();
				boolean f=bd.ExistBookByBookTypeId(conn, id);
				if(f) {
					JOptionPane.showMessageDialog(null, "µ±Ç°Í¼ÊéÀà±ðÏÂÓÐÍ¼Êé£¬ÎÞ·¨É¾³ý£¡");
					return;
				}
				int r=btd.delete(conn, id);
				
				if(r==1) {
					JOptionPane.showMessageDialog(null, "É¾³ý³É¹¦£¡");
					this.resetvalue();
					this.FillTable(new BookType());
				}else {
					JOptionPane.showMessageDialog(null, "É¾³ýÊ§°Ü£¡");
				}
			} catch (Exception e) {
				e.printStackTrace();
				JOptionPane.showMessageDialog(null, "É¾³ýÊ§°Ü£¡");
			}finally {
				try {
					db.close(conn);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

	protected void BookTypeUpdateActionEvent(ActionEvent evt) {
		
		String id=idtxt.getText();
		String booktypename=booktypenametxt.getText();
		String booktypedesc=booktypedesctxt.getText();
		
		if(String_Tool.isEmpty(id)) {
			JOptionPane.showMessageDialog(null, "ÇëÑ¡ÔñÒªÐÞ¸ÄµÄ¼ÇÂ¼£¡");
			return;
		}
		
		if(String_Tool.isEmpty(booktypename)) {
			JOptionPane.showMessageDialog(null, "ÇëÊäÈëÍ¼ÊéÀà±ðÃû³Æ£¡");
			return;
		}
		
		BookType bt=new BookType();
		bt.setId(Integer.parseInt(id));
		bt.setBookTypeName(booktypename);
		bt.setBookTypeDesc(booktypedesc);
		Connection conn=null;
		try {
			conn=db.getCon();
			int r=btd.update(conn, bt);
			if(r==1) {
				JOptionPane.showMessageDialog(null, "ÐÞ¸Ä³É¹¦£¡");
				this.resetvalue();
				this.FillTable(new BookType());
			}else {
				JOptionPane.showMessageDialog(null, "ÐÞ¸ÄÊ§°Ü£¡");
			}
		} catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "ÐÞ¸ÄÊ§°Ü£¡");
		}finally {
			try {
				db.close(conn);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}
	
	private void resetvalue() {
		this.idtxt.setText("");
		this.booktypenametxt.setText("");
		this.booktypedesctxt.setText("");
	}
	
	private void BookTypeMouserPressed(MouseEvent evt) {
		int row = BookTypeTable.getSelectedRow();
		
		idtxt.setText((String) BookTypeTable.getValueAt(row, 0));
		booktypenametxt.setText((String) BookTypeTable.getValueAt(row, 1));
		booktypedesctxt.setText((String) BookTypeTable.getValueAt(row, 2));
	}

	private void BookTypeSearchActionPerformed(ActionEvent evt) {

		String s_booktypename=S_BookTypeNameTxt.getText();
		BookType bt =new BookType();
		bt.setBookTypeName(s_booktypename);
		FillTable(bt);
		
	}

	private void FillTable(BookType bt) {
		DefaultTableModel dtm = (DefaultTableModel) BookTypeTable.getModel();
		dtm.setRowCount(0);
		Connection conn = null;
		try {
			
			conn=db.getCon();			
			ResultSet rs=btd.list(conn, bt);
			while(rs.next()) {
				
				Vector v=new Vector();
				v.add(rs.getString("id"));
				v.add(rs.getString("BookTypeName"));
				v.add(rs.getString("BookTypeDesc"));
				dtm.addRow(v);
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				db.close(conn);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
