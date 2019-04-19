package ������.Window;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import ������.Client.MyClient;

public class EnterWindow {

	private JFrame frame;
	private JTextField textField;
	private MyClient client;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EnterWindow window = new EnterWindow();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public EnterWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("\u804A\u5929\u5BA4");
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(94, 80, 239, 40);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("\u8FDB\u5165");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String name = "";
				name = textField.getText();       
				if(null!=name&name.length()<10&!"".equals(name)){
					client = new MyClient();
					if(client.StartClient(name)){
						frame.dispose();
						ChatWindow window = new ChatWindow(client);
						window.Chatframe.setVisible(true);
						new Thread(client.getIn()).start();
					
					}else{
						JOptionPane.showMessageDialog(null, "����������Ӧ��");
					}
					
				}else{
					JOptionPane.showMessageDialog(null, "����������������룡");
				}
				
			}
		});
		btnNewButton.setFont(new Font("����", Font.PLAIN, 20));
		btnNewButton.setBounds(150, 133, 119, 33);
		frame.getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("\u8BF7\u8F93\u5165\u4F60\u7684\u6635\u79F0");
		lblNewLabel.setFont(new Font("����", Font.PLAIN, 18));
		lblNewLabel.setBounds(139, 45, 239, 33);
		frame.getContentPane().add(lblNewLabel);
	}
}
