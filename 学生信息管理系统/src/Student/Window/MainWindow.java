package Student.Window;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.WindowConstants;

import Student.Window.MethodWindow.AddWindow;
import Student.Window.MethodWindow.DeleteWindow;
import Student.Window.MethodWindow.QueryWindow;
import Student.Window.MethodWindow.UpdateWindow.ToUpdateWindow;
import Student.method.DeleteMethod.Del;
import Student.method.ShowMethod.Show;
import Student.method.ShowMethod.ShowToTable;


public class MainWindow {

	JFrame frame;
	private JButton btnNewButton_1;
	private JTable table;
	private JScrollPane scrollPane_1;
	private JButton button;

	/**
	 * Launch the application.
	 */

	

	/**
	 * Create the application.
	 */
	public MainWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setFont(new Font("����", Font.PLAIN, 18));
		frame.setTitle("\u5B66\u751F\u4FE1\u606F\u7BA1\u7406\u7CFB\u7EDF");
		frame.setBounds(300, 300, 905, 612);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JButton btnNewButton = new JButton("\u5237\u65B0");
		btnNewButton.setBounds(39, 77, 118, 33);
		
		scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(49, 136, 800, 398);
		frame.getContentPane().add(scrollPane_1);
		
		table = new JTable();
		table.setFont(new Font("����", Font.PLAIN, 20));
		table.setRowHeight(30);
		scrollPane_1.setViewportView(table);
		
		ShowToTable.showMsg(table,Show.showAll());	
		
		
		
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {	
				ShowToTable.showMsg(table,Show.showAll());			
			
			}
		});
		frame.getContentPane().setLayout(null);
		btnNewButton.setFont(new Font("����", Font.PLAIN, 20));
		frame.getContentPane().add(btnNewButton);
		
		btnNewButton_1 = new JButton("\u6DFB\u52A0\u4FE1\u606F");
		btnNewButton_1.setBounds(303, 77, 118, 33);
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							AddWindow window = new AddWindow();
							window.addframe.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
							window.addframe.setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});
		btnNewButton_1.setFont(new Font("����", Font.PLAIN, 20));
		frame.getContentPane().add(btnNewButton_1);
		
		button = new JButton("\u4FEE\u6539\u4FE1\u606F");
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							ToUpdateWindow window = new ToUpdateWindow();
							window.ToUpdateframe.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
							window.ToUpdateframe.setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});
		button.setFont(new Font("����", Font.PLAIN, 20));
		button.setBounds(435, 77, 125, 33);
		frame.getContentPane().add(button);
		
		JButton button_1 = new JButton("\u5220\u9664\u4FE1\u606F");
		button_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							DeleteWindow window = new DeleteWindow();
							window.delframe.setVisible(true);
							window.delframe.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});
		button_1.setFont(new Font("����", Font.PLAIN, 20));
		button_1.setBounds(574, 77, 133, 33);
		frame.getContentPane().add(button_1);	
		
		JButton button_2 = new JButton("\u67E5\u8BE2\u4FE1\u606F");
		button_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							QueryWindow window = new QueryWindow();
							window.queryframe.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
							window.queryframe.setVisible(true);
							
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});
		button_2.setFont(new Font("����", Font.PLAIN, 20));
		button_2.setBounds(171, 77, 118, 33);
		frame.getContentPane().add(button_2);
		
		JButton button_3 = new JButton("\u6E05\u7A7A\u4FE1\u606F");
		button_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int flag = JOptionPane.showConfirmDialog(null, "ȷ��ɾ����?", "ȷ��ɾ����", JOptionPane.YES_NO_OPTION);
				if(flag==JOptionPane.YES_OPTION){
					Del.DeleteAll();
				}
				
			}
		});
		button_3.setFont(new Font("����", Font.PLAIN, 20));
		button_3.setBounds(721, 77, 133, 33);
		frame.getContentPane().add(button_3);
		
	}
}
