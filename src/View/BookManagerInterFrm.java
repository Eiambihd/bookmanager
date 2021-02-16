package View;

import java.awt.EventQueue;
import java.awt.Font;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Vector;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import Dao.BookDao;
import Dao.BookTypeDao;
import Model.Book;
import Model.BookType;
import Tools.DB;
import Tools.String_Tool;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JTextArea;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class BookManagerInterFrm extends JInternalFrame {
	private JTable BookTable;
	private JTextField S_BookNameTxt;
	private JTextField S_Author;
	private DB db=new DB();
	private BookDao bd=new BookDao();
	private BookTypeDao btd=new BookTypeDao();
	private JComboBox S_BookTypeJcb;
	private JTextField bookidtxt;
	private JTextField booknametxt;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JTextField pricetxt;
	private JTextField authortxt;
	private JRadioButton femalejrb;
	private JRadioButton manjrb;
	private JTextArea bookdesctxt;
	private JComboBox booktypejcb;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BookManagerInterFrm frame = new BookManagerInterFrm();
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
	public BookManagerInterFrm() {
		setClosable(true);
		setIconifiable(true);
		setTitle("\u56FE\u4E66\u7BA1\u7406");
		setBounds(100, 100, 704, 657);
		
		JScrollPane scrollPane = new JScrollPane();
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "\u641C\u7D22\u6761\u4EF6", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "\u8868\u5355\u64CD\u4F5C", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(panel_1, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 660, Short.MAX_VALUE)
						.addComponent(panel, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 660, Short.MAX_VALUE))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(22)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 160, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 294, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(22, Short.MAX_VALUE))
		);
		
		JLabel lblNewLabel_3 = new JLabel("\u7F16\u53F7\uFF1A");
		lblNewLabel_3.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 15));
		
		bookidtxt = new JTextField();
		bookidtxt.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 15));
		bookidtxt.setEditable(false);
		bookidtxt.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("\u56FE\u4E66\u540D\u79F0\uFF1A");
		lblNewLabel_4.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 15));
		
		booknametxt = new JTextField();
		booknametxt.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 15));
		booknametxt.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("\u4F5C\u8005\u6027\u522B\uFF1A");
		lblNewLabel_5.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 15));
		
		manjrb = new JRadioButton("\u7537");
		buttonGroup.add(manjrb);
		manjrb.setSelected(true);
		manjrb.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 15));
		
		femalejrb = new JRadioButton("\u5973");
		buttonGroup.add(femalejrb);
		femalejrb.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 15));
		
		JLabel lblNewLabel_6 = new JLabel("\u4EF7\u683C\uFF1A");
		lblNewLabel_6.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 15));
		
		pricetxt = new JTextField();
		pricetxt.setColumns(10);
		
		JLabel lblNewLabel_7 = new JLabel("\u56FE\u4E66\u4F5C\u8005\uFF1A");
		lblNewLabel_7.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 15));
		
		authortxt = new JTextField();
		authortxt.setText("");
		authortxt.setColumns(10);
		
		JLabel lblNewLabel_8 = new JLabel("\u56FE\u4E66\u7C7B\u522B");
		lblNewLabel_8.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 15));
		
		booktypejcb = new JComboBox();
		
		JLabel lblNewLabel_9 = new JLabel("\u56FE\u4E66\u63CF\u8FF0\uFF1A");
		lblNewLabel_9.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 15));
		
		bookdesctxt = new JTextArea();
		
		JButton btnNewButton_1 = new JButton("\u4FEE\u6539");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BookUpdateActionPerformed(e);
			}
		});
		btnNewButton_1.setIcon(new ImageIcon(BookManagerInterFrm.class.getResource("/images/pen_16px_1137927_easyicon.net.png")));
		btnNewButton_1.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 15));
		
		JButton btnNewButton_2 = new JButton("\u5220\u9664");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				BookDeleteActionPerformed(e);
				
			}
		});
		btnNewButton_2.setIcon(new ImageIcon(BookManagerInterFrm.class.getResource("/images/delete_15.275362318841px_1143794_easyicon.net.png")));
		btnNewButton_2.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 15));
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(42)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING, false)
								.addGroup(gl_panel_1.createSequentialGroup()
									.addComponent(lblNewLabel_6)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(pricetxt, 0, 0, Short.MAX_VALUE))
								.addGroup(gl_panel_1.createSequentialGroup()
									.addComponent(lblNewLabel_3)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(bookidtxt, GroupLayout.PREFERRED_SIZE, 73, GroupLayout.PREFERRED_SIZE)))
							.addGap(18)
							.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING, false)
								.addGroup(gl_panel_1.createSequentialGroup()
									.addComponent(lblNewLabel_4)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(booknametxt, GroupLayout.PREFERRED_SIZE, 111, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_panel_1.createSequentialGroup()
									.addComponent(lblNewLabel_7)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(authortxt)))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING, false)
								.addGroup(gl_panel_1.createSequentialGroup()
									.addComponent(lblNewLabel_5)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(manjrb)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(femalejrb))
								.addGroup(gl_panel_1.createSequentialGroup()
									.addComponent(lblNewLabel_8)
									.addGap(18)
									.addComponent(booktypejcb, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addComponent(lblNewLabel_9)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(bookdesctxt, GroupLayout.DEFAULT_SIZE, 441, Short.MAX_VALUE)))
					.addContainerGap(84, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(221)
					.addComponent(btnNewButton_1)
					.addGap(47)
					.addComponent(btnNewButton_2)
					.addContainerGap(216, Short.MAX_VALUE))
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_3)
						.addComponent(bookidtxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_4)
						.addComponent(booknametxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_5)
						.addComponent(manjrb)
						.addComponent(femalejrb))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_6)
						.addComponent(pricetxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_7)
						.addComponent(authortxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_8)
						.addComponent(booktypejcb, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_9)
						.addComponent(bookdesctxt, GroupLayout.PREFERRED_SIZE, 103, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton_1)
						.addComponent(btnNewButton_2))
					.addContainerGap(30, Short.MAX_VALUE))
		);
		panel_1.setLayout(gl_panel_1);
		
		JLabel lblNewLabel = new JLabel("\u56FE\u4E66\u540D\u79F0\uFF1A");
		lblNewLabel.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 15));
		
		S_BookNameTxt = new JTextField();
		S_BookNameTxt.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("\u56FE\u4E66\u4F5C\u8005\uFF1A");
		lblNewLabel_1.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 15));
		
		S_Author = new JTextField();
		S_Author.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("\u56FE\u4E66\u7C7B\u522B\uFF1A");
		lblNewLabel_2.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 15));
		
		S_BookTypeJcb = new JComboBox();
		
		JButton btnNewButton = new JButton("\u641C\u7D22");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				BookSearchActionPerformed(e);
				
			}
		});
		btnNewButton.setIcon(new ImageIcon(BookManagerInterFrm.class.getResource("/images/Search_16px_1191708_easyicon.net.png")));
		btnNewButton.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 15));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(S_BookNameTxt, GroupLayout.PREFERRED_SIZE, 82, GroupLayout.PREFERRED_SIZE)
					.addGap(10)
					.addComponent(lblNewLabel_1)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(S_Author, GroupLayout.PREFERRED_SIZE, 82, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(lblNewLabel_2)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(S_BookTypeJcb, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnNewButton)
					.addContainerGap(23, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(S_BookNameTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_1)
						.addComponent(S_Author, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_2)
						.addComponent(S_BookTypeJcb, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnNewButton))
					.addContainerGap(18, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		
		BookTable = new JTable();
		BookTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent me) {
				
				BookTableMouserPressed(me);
				
			}
		});
		BookTable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u7F16\u53F7", "\u56FE\u4E66\u540D\u79F0", "\u56FE\u4E66\u4F5C\u8005", "\u4F5C\u8005\u6027\u522B", "\u56FE\u4E66\u4EF7\u683C", "\u56FE\u4E66\u7C7B\u522B", "\u56FE\u4E66\u63CF\u8FF0"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		BookTable.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 15));
		scrollPane.setViewportView(BookTable);
		getContentPane().setLayout(groupLayout);
		this.FillBookType("search");
		this.FillBookType("modify");
		this.FillTable(new Book());
	}
	
	protected void BookDeleteActionPerformed(ActionEvent e) {
		
		String id=bookidtxt.getText();
		if(String_Tool.isEmpty(id)) {
			JOptionPane.showMessageDialog(null, "ÇëÑ¡ÔñÒªÉ¾³ýµÄ¼ÇÂ¼£¡");
			return;
		}
		int n=JOptionPane.showConfirmDialog(null, "È·¶¨ÒªÉ¾³ý¸Ã¼ÇÂ¼Âð£¿");
		if(n==0) {
			Connection conn=null;
			try {
				conn=db.getCon();
				int r=bd.DeleteBook(conn, id);
				if(r==1) {
					JOptionPane.showMessageDialog(null, "É¾³ý³É¹¦£¡");
					this.resetvalue();
					this.FillTable(new Book());
				}else {
					JOptionPane.showMessageDialog(null, "É¾³ýÊ§°Ü£¡");
				}
			} catch (Exception e1) {
				JOptionPane.showMessageDialog(null, "É¾³ýÊ§°Ü£¡");
				e1.printStackTrace();
			}finally {
				try {
					db.close(conn);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		}
	}

	private void BookUpdateActionPerformed(ActionEvent evt) {
		Connection conn=null;
		Book b=new Book();
		String id=bookidtxt.getText();
		if(String_Tool.isEmpty(id)) {
			JOptionPane.showMessageDialog(null, "ÇëÑ¡ÔñÒªÐÞ¸ÄµÄ¼ÇÂ¼£¡");
			return;
		}
		
		String bookname=this.booknametxt.getText();
		String author=this.authortxt.getText();
		String price=this.pricetxt.getText();
		
		if(String_Tool.isEmpty(bookname)) {
			JOptionPane.showMessageDialog(null, "Í¼ÊéÃû³Æ²»ÄÜÎª¿Õ£¡");
			return;
		}
		if(String_Tool.isEmpty(author)) {
			JOptionPane.showMessageDialog(null, "Í¼Êé×÷Õß²»ÄÜÎª¿Õ£¡");
			return;
		}
		if(String_Tool.isEmpty(price)) {
			JOptionPane.showMessageDialog(null, "Í¼Êé¼Û¸ñ²»ÄÜÎª¿Õ£¡");
			return;
		}
		
		try {
			conn=db.getCon();
			b.setId(Integer.parseInt(bookidtxt.getText()));
			b.setAuthor(authortxt.getText());
			b.setBookDesc(bookdesctxt.getText());
			b.setBookName(booknametxt.getText());
			b.setPrice(Float.parseFloat(pricetxt.getText()));
			String sex="ÄÐ";
			if(manjrb.isSelected()) {
				sex="ÄÐ";
			}else if(femalejrb.isSelected()) {
				sex="Å®";
			}
			b.setSex(sex);
			BookType bt=(BookType) booktypejcb.getSelectedItem();
			b.setBookTypeId(bt.getId());
			int r=bd.UpdateBook(conn, b);
			if(r==1) {
				JOptionPane.showMessageDialog(null, "Í¼ÊéÐÞ¸Ä³É¹¦£¡");
				resetvalue();
				this.FillTable(new Book());
			}else {
				JOptionPane.showMessageDialog(null, "Í¼ÊéÐÞ¸Ä³É¹¦£¡");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Í¼ÊéÐÞ¸ÄÊ§°Ü£¡");
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
		this.bookidtxt.setText("");
		this.authortxt.setText("");
		this.bookdesctxt.setText("");
		this.bookidtxt.setText("");
		this.booknametxt.setText("");
		this.pricetxt.setText("");
		this.manjrb.setSelected(true);
		if(this.booktypejcb.getItemCount()>0) {
			this.booktypejcb.setSelectedIndex(0);
		}
	}

	private void BookTableMouserPressed(MouseEvent me) {
		
		int r=this.BookTable.getSelectedRow();
		this.bookidtxt.setText((String) BookTable.getValueAt(r, 0));
		this.booknametxt.setText((String) BookTable.getValueAt(r, 1));
		this.authortxt.setText((String) BookTable.getValueAt(r, 2));
		String sex=(String) BookTable.getValueAt(r, 3);
		if("ÄÐ".equals(sex)) {
			this.manjrb.setSelected(true);
		}else if("Å®".equals(sex)) {
			this.femalejrb.setSelected(true);
		}
		this.pricetxt.setText((String)BookTable.getValueAt(r, 4));
		this.bookdesctxt.setText((String) BookTable.getValueAt(r, 5));
		String btn = (String) this.BookTable.getValueAt(r, 6);
		int n=this.booktypejcb.getItemCount();

		for(int i=0;i<n;i++) {
			BookType item = (BookType) this.booktypejcb.getItemAt(i);
			if(item.getBookTypeName().equals(btn)) {

				this.booktypejcb.setSelectedIndex(i);

			}
		}
	}

	private void BookSearchActionPerformed(ActionEvent evt) {
		
		String bookname=this.S_BookNameTxt.getText();
		String author=this.S_Author.getText();
		
		BookType bt=(BookType) this.S_BookTypeJcb.getSelectedItem();
		int booktypeid=bt.getId();
		Book b=new Book();
		b.setAuthor(author);
		b.setBookName(bookname);
		b.setBookTypeId(booktypeid);
		this.FillTable(b);
	}

	private void FillBookType(String type) {
		Connection conn=null;
		BookType bt =null;
		try {
			conn=db.getCon();
			ResultSet rs = btd.list(conn, new BookType());
			if("search".equals(type)) {
				bt=new BookType();
				bt.setBookTypeName("ÇëÑ¡Ôñ...");
				bt.setId(-1);
				this.S_BookTypeJcb.addItem(bt);
			}
			while(rs.next()) {
				
				bt=new BookType();
				bt.setBookTypeName(rs.getString("BookTypeName"));
				bt.setId(rs.getInt("id"));
				if("search".equals(type)) {
					this.S_BookTypeJcb.addItem(bt);
				}else if("modify".equals(type)) {
					this.booktypejcb.addItem(bt);
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
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
	
	private void FillTable(Book b) {
		Connection conn=null;
		DefaultTableModel dtm=(DefaultTableModel) BookTable.getModel();
		dtm.setRowCount(0);
		try {
			conn=db.getCon();
			ResultSet rs=bd.list(conn, b);
			while(rs.next()) {
				Vector v=new Vector();
				v.add(rs.getString("Id"));
				v.add(rs.getString("BookName"));
				v.add(rs.getString("Author"));
				v.add(rs.getString("Sex"));
				v.add(rs.getString("price"));
				v.add(rs.getString("BookDesc"));
				v.add(rs.getString("BookTypeName"));
				dtm.addRow(v);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
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
