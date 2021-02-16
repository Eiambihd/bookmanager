package View;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;

import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;

import Dao.BookDao;
import Dao.BookTypeDao;
import Model.Book;
import Model.BookType;
import Tools.DB;
import Tools.String_Tool;

public class BookAddInterFrm extends JInternalFrame {
	private JTextField BookNameTxt;
	private JTextField BookAuthorTxt;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JTextField priceTxt;
	private DB db=new DB();
	private BookDao bd=new BookDao();
	private BookTypeDao btd=new BookTypeDao();
	private JComboBox BookTypeJcb;
	private JTextArea BookDescTxt;
	private JRadioButton manJrb;
	private JRadioButton femaleJrb;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BookAddInterFrm frame = new BookAddInterFrm();
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
	public BookAddInterFrm() {
		getContentPane().setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 15));
		setIconifiable(true);
		setClosable(true);
		setTitle("\u56FE\u4E66\u6DFB\u52A0");
		setBounds(100, 100, 478, 527);
		
		JLabel lblNewLabel = new JLabel("\u56FE\u4E66\u540D\u79F0\uFF1A");
		lblNewLabel.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 15));
		
		BookNameTxt = new JTextField();
		BookNameTxt.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("\u56FE\u4E66\u4F5C\u8005\uFF1A");
		lblNewLabel_1.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 15));
		
		BookAuthorTxt = new JTextField();
		BookAuthorTxt.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("\u4F5C\u8005\u6027\u522B\uFF1A");
		lblNewLabel_2.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 15));
		
		manJrb = new JRadioButton("\u7537");
		buttonGroup.add(manJrb);
		manJrb.setSelected(true);
		manJrb.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 15));
		
		femaleJrb = new JRadioButton("\u5973");
		femaleJrb.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 15));
		buttonGroup.add(femaleJrb);
		
		JLabel label = new JLabel("\u56FE\u4E66\u4EF7\u683C\uFF1A");
		label.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 15));
		
		priceTxt = new JTextField();
		priceTxt.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("\u56FE\u4E66\u7C7B\u522B\uFF1A");
		lblNewLabel_3.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 15));
		
		BookTypeJcb = new JComboBox();
		BookTypeJcb.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 15));
		
		JLabel lblNewLabel_4 = new JLabel("\u56FE\u4E66\u63CF\u8FF0\uFF1A");
		lblNewLabel_4.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 15));
		
		BookDescTxt = new JTextArea();
		
		JButton btnNewButton = new JButton("\u6DFB\u52A0");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				BookAddActionPerformed(e);
				
			}
		});
		btnNewButton.setIcon(new ImageIcon(BookAddInterFrm.class.getResource("/images/add_article_14.501872659176px_1138580_easyicon.net.png")));
		btnNewButton.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 15));
		
		JButton btnNewButton_1 = new JButton("\u91CD\u7F6E");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				ResetValueActionPerformed(e);
			
			}
		});
		btnNewButton_1.setIcon(new ImageIcon(BookAddInterFrm.class.getResource("/images/refresh_16px_1187720_easyicon.net.png")));
		btnNewButton_1.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 15));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(59)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lblNewLabel_4)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(BookDescTxt))
								.addGroup(groupLayout.createSequentialGroup()
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
										.addGroup(groupLayout.createSequentialGroup()
											.addComponent(lblNewLabel)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(BookNameTxt, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)
											.addGap(34)
											.addComponent(lblNewLabel_1))
										.addGroup(groupLayout.createSequentialGroup()
											.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
												.addGroup(groupLayout.createSequentialGroup()
													.addComponent(lblNewLabel_3)
													.addPreferredGap(ComponentPlacement.RELATED)
													.addComponent(BookTypeJcb, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
												.addGroup(groupLayout.createSequentialGroup()
													.addComponent(lblNewLabel_2)
													.addPreferredGap(ComponentPlacement.RELATED)
													.addComponent(manJrb)
													.addPreferredGap(ComponentPlacement.RELATED)
													.addComponent(femaleJrb)))
											.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
											.addComponent(label)))
									.addPreferredGap(ComponentPlacement.RELATED)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
										.addComponent(priceTxt, 0, 0, Short.MAX_VALUE)
										.addComponent(BookAuthorTxt, GroupLayout.DEFAULT_SIZE, 67, Short.MAX_VALUE))))
							.addGap(19))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(125)
							.addComponent(btnNewButton)
							.addGap(59)
							.addComponent(btnNewButton_1)))
					.addContainerGap(51, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(37)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(BookNameTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_1)
						.addComponent(BookAuthorTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(29)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_2)
						.addComponent(manJrb)
						.addComponent(femaleJrb)
						.addComponent(label)
						.addComponent(priceTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_3)
						.addComponent(BookTypeJcb, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(38)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_4)
						.addComponent(BookDescTxt, GroupLayout.PREFERRED_SIZE, 208, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton)
						.addComponent(btnNewButton_1))
					.addGap(28))
		);
		getContentPane().setLayout(groupLayout);
		FillBookType();
	}
	
	private void ResetValueActionPerformed(ActionEvent e) {
		this.ResetValue();
		
	}

	private void BookAddActionPerformed(ActionEvent e) {
		
		String bookname=this.BookNameTxt.getText();
		String author=this.BookAuthorTxt.getText();
		String price=this.priceTxt.getText();
		String bookdesc=this.BookDescTxt.getText();
		
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

		String sex ="";
		if(manJrb.isSelected()) {
			sex="ÄÐ";
		}else if(femaleJrb.isSelected()) {
			sex="Å®";
		}
		
		BookType bt=(BookType) BookTypeJcb.getSelectedItem();
		int btid=bt.getId();
		
		Book b=new Book(bookname, author, sex, bookdesc,Float.parseFloat(price),btid);
		Connection conn = null;
		
		try {
			conn=db.getCon();
			
			int r=bd.add(conn, b);
			if(r==1) {
				JOptionPane.showMessageDialog(null, "Í¼ÊéÌí¼Ó³É¹¦£¡");
				ResetValue();
			}else {
				JOptionPane.showMessageDialog(null, "Í¼ÊéÌí¼ÓÊ§°Ü£¡");
			}
			
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			JOptionPane.showMessageDialog(null, "Í¼ÊéÌí¼ÓÊ§°Ü£¡");
		}finally {
			try {
				db.close(conn);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
	}

	private void ResetValue() {
		this.BookNameTxt.setText("");
		this.BookAuthorTxt.setText("");
		this.priceTxt.setText("");
		this.manJrb.setSelected(true);
		this.BookDescTxt.setText("");
		if(this.BookTypeJcb.getItemCount()>0) {
			this.BookTypeJcb.setSelectedIndex(0);
		}
	}

	private void FillBookType() {
		Connection conn =null;
		BookType bt=new BookType();
		try {
			conn=db.getCon();
			ResultSet rs=btd.list(conn, new BookType());
			while(rs.next()) {
				bt=new BookType();
				bt.setId(rs.getInt("id"));
				bt.setBookTypeName(rs.getString("BookTypeName"));
				this.BookTypeJcb.addItem(bt);
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
