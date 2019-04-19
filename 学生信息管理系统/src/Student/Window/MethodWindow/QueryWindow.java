package Student.Window.MethodWindow;

import java.awt.Event;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;

import Student.method.ShowMethod.Show;
import Student.method.ShowMethod.ShowToTable;

import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class QueryWindow {

	public JFrame queryframe;
	private JTextField textField;
	private JTable table;

	/**
	 * Launch the application.
	 */
	
	

	/**
	 * Create the application.
	 */
	public QueryWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		queryframe = new JFrame();
		queryframe.setTitle("\u67E5\u627E");
		queryframe.setBounds(100, 100, 786, 463);
		queryframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		queryframe.getContentPane().setLayout(null);
		queryframe.setLocationRelativeTo(null);
		
		textField = new JTextField();
		textField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode()==Event.ENTER){
					ResultSet rs = null;	
					rs = Show.showQuery(textField.getText());
					
					ShowToTable.showMsg(table, rs);
				}
			}
		});
		textField.setFont(new Font("����", Font.PLAIN, 20));
		textField.setBounds(60, 48, 453, 34);
		queryframe.getContentPane().add(textField);
		textField.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(60, 95, 657, 308);
		queryframe.getContentPane().add(scrollPane);
		
		table = new JTable();
		table.setFont(new Font("����", Font.PLAIN, 20));
		table.setRowHeight(30);
		scrollPane.setViewportView(table);
		
		JButton btnNewButton = new JButton("\u67E5\u8BE2");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ResultSet rs =null;
				String text = textField.getText();
				try{
					rs = Show.showQuery(text);
					if(text.length()>0){
						ShowToTable.showMsg(table, rs);
					}
				}catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		});
		btnNewButton.setFont(new Font("����", Font.PLAIN, 20));
		btnNewButton.setBounds(540, 48, 119, 34);
		queryframe.getContentPane().add(btnNewButton);
	}
}
