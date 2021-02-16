package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Toolkit;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JDesktopPane;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MainFrm extends JFrame {

	private JPanel contentPane;
	JDesktopPane  table =null;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrm frame = new MainFrm();
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
	public MainFrm() {
		setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 12));
		setIconImage(Toolkit.getDefaultToolkit().getImage(MainFrm.class.getResource("/images/books_32px_1169811_easyicon.net.png")));
		setTitle("\u56FE\u4E66\u7BA1\u7406\u7CFB\u7EDF");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("\u57FA\u672C\u6570\u636E\u7EF4\u62A4");
		mnNewMenu.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 15));
		mnNewMenu.setIcon(new ImageIcon(MainFrm.class.getResource("/images/wrench_16px_1235326_easyicon.net.png")));
		menuBar.add(mnNewMenu);
		
		JMenu mnNewMenu_2 = new JMenu("\u56FE\u4E66\u7C7B\u522B\u7BA1\u7406");
		mnNewMenu_2.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 15));
		mnNewMenu_2.setIcon(new ImageIcon(MainFrm.class.getResource("/images/category_18.554621848739px_1143808_easyicon.net.png")));
		mnNewMenu.add(mnNewMenu_2);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("\u56FE\u4E66\u7C7B\u522B\u6DFB\u52A0");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				BookTypeAddInterFrm bf = new BookTypeAddInterFrm();
				bf.setVisible(true);
				table.add(bf);
			}
		});
		mntmNewMenuItem_1.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 15));
		mntmNewMenuItem_1.setIcon(new ImageIcon(MainFrm.class.getResource("/images/add_article_14.501872659176px_1138580_easyicon.net.png")));
		mnNewMenu_2.add(mntmNewMenuItem_1);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("\u56FE\u4E66\u7C7B\u522B\u7EF4\u62A4");
		mntmNewMenuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				BookTypeMangerInterFrm btm = new BookTypeMangerInterFrm();
				btm.setVisible(true);
				table.add(btm);
				
			}
		});
		mntmNewMenuItem_2.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 15));
		mntmNewMenuItem_2.setIcon(new ImageIcon(MainFrm.class.getResource("/images/pen_16px_1137927_easyicon.net.png")));
		mnNewMenu_2.add(mntmNewMenuItem_2);
		
		JMenu mnNewMenu_3 = new JMenu("\u56FE\u4E66\u7BA1\u7406");
		mnNewMenu_3.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 15));
		mnNewMenu_3.setIcon(new ImageIcon(MainFrm.class.getResource("/images/book_16px_1169810_easyicon.net.png")));
		mnNewMenu.add(mnNewMenu_3);
		
		JMenuItem mntmNewMenuItem_3 = new JMenuItem("\u56FE\u4E66\u6DFB\u52A0");
		mntmNewMenuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				BookAddInterFrm ba=new BookAddInterFrm();
				ba.setVisible(true);
				table.add(ba);
				
			}
		});
		mntmNewMenuItem_3.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 15));
		mntmNewMenuItem_3.setIcon(new ImageIcon(MainFrm.class.getResource("/images/add_article_14.501872659176px_1138580_easyicon.net.png")));
		mnNewMenu_3.add(mntmNewMenuItem_3);
		
		JMenuItem mntmNewMenuItem_4 = new JMenuItem("\u56FE\u4E66\u7EF4\u62A4");
		mntmNewMenuItem_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BookManagerInterFrm bmif=new BookManagerInterFrm();
				bmif.setVisible(true);
				table.add(bmif);
			}
		});
		mntmNewMenuItem_4.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 15));
		mntmNewMenuItem_4.setIcon(new ImageIcon(MainFrm.class.getResource("/images/pen_16px_1137927_easyicon.net.png")));
		mnNewMenu_3.add(mntmNewMenuItem_4);
		
		JMenuItem menuItem = new JMenuItem("\u5B89\u5168\u9000\u51FA");
		menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int r=JOptionPane.showConfirmDialog(null, "ÊÇ·ñÍË³öÏµÍ³£¿");
				if(r==0) {
					dispose();
				}
				
			}
		});
		menuItem.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 15));
		menuItem.setIcon(new ImageIcon(MainFrm.class.getResource("/images/access_close_exit_logout_sign_out_16px_1225473_easyicon.net.png")));
		mnNewMenu.add(menuItem);
		
		JMenu mnNewMenu_1 = new JMenu("\u5173\u4E8E\u6211\u4EEC");
		mnNewMenu_1.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 15));
		mnNewMenu_1.setIcon(new ImageIcon(MainFrm.class.getResource("/images/about_16px_1143785_easyicon.net.png")));
		menuBar.add(mnNewMenu_1);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("\u4F5C\u8005\uFF1A\u674E\u5FB7\u7428");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				InterFrm inf=new InterFrm();
				inf.setVisible(true);
				table.add(inf);
				
			}
		});
		mntmNewMenuItem.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 15));
		mntmNewMenuItem.setIcon(new ImageIcon(MainFrm.class.getResource("/images/about_16px_1143785_easyicon.net.png")));
		mnNewMenu_1.add(mntmNewMenuItem);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		table = new JDesktopPane();
		table.setBackground(Color.WHITE);
		contentPane.add(table, BorderLayout.CENTER);
		
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
	}

}
