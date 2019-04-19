package Student.Window;

import java.awt.Event;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import Student.LoginBySql.Login;


@SuppressWarnings("serial")
public class LoginWindow extends JFrame {

	private JPanel contentPane;
	private  JTextField textField;
	private  JPasswordField passwordField;
	private static LoginWindow frame;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		frame = new LoginWindow();
		frame.setVisible(true);
	
	}	

	/**
	 * Create the frame.
	 */
	public LoginWindow() {
		inti();
}

	public void inti() {
		setTitle("\u4FE1\u606F\u7BA1\u7406\u7CFB\u7EDF");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setLocationRelativeTo(null);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\u7528\u6237\uFF1A");
		lblNewLabel.setFont(new Font("����", Font.PLAIN, 22));
		lblNewLabel.setBounds(47, 60, 81, 38);
		contentPane.add(lblNewLabel);
		
		JLabel label = new JLabel("\u5BC6\u7801\uFF1A");
		label.setFont(new Font("����", Font.PLAIN, 22));
		label.setBounds(47, 111, 81, 38);
		contentPane.add(label);
		
		textField = new JTextField();
		textField.setFont(new Font("����", Font.PLAIN, 18));
		textField.setBounds(108, 63, 202, 38);
		contentPane.add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode()==Event.ENTER){
					if(Login.IsUser(textField.getText(),new String(passwordField.getPassword(),0,passwordField.getPassword().length))){								
						frame.dispose();

						EventQueue.invokeLater(new Runnable() {
							public void run() {
								try {
									MainWindow window = new MainWindow();
									window.frame.setVisible(true);
								} catch (Exception e) {
									e.printStackTrace();
								}
							}
						});
						
					}
					
					else {
						JOptionPane.showMessageDialog(null, "������󣡣�");
					}
				}
			}
		});
		passwordField.setFont(new Font("����", Font.PLAIN, 18));
		passwordField.setBounds(108, 114, 202, 38);
		contentPane.add(passwordField);
		
		JButton button = new JButton("\u767B\u5F55");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(Login.IsUser(textField.getText(),new String(passwordField.getPassword(),0,passwordField.getPassword().length))){								
						frame.dispose();
						EventQueue.invokeLater(new Runnable() {
							public void run() {
								try {
									MainWindow window = new MainWindow();
									window.frame.setVisible(true);
								} catch (Exception e) {
									e.printStackTrace();
								}
							}
						});
						
				}
				else JOptionPane.showMessageDialog(null, "������󣡣�");
			}
		});
		button.setBounds(145, 165, 129, 27);
		contentPane.add(button);
		
		JLabel lblNewLabel_1 = new JLabel("\u8BF7\u767B\u5F55");
		lblNewLabel_1.setFont(new Font("����", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(165, 16, 176, 34);
		contentPane.add(lblNewLabel_1);
	}
	}
	
