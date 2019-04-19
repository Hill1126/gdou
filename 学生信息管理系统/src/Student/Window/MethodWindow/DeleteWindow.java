package Student.Window.MethodWindow;

import java.awt.Event;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import Student.method.DeleteMethod.Del;


public class DeleteWindow {

	 public JFrame delframe;
	private JTextField textField;

	/**
	 * Launch the application.
	 */

		
	

	/**
	 * Create the application.
	 */
	public DeleteWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		delframe = new JFrame();
		delframe.setTitle("\u5220\u9664\u4FE1\u606F");
		delframe.setBounds(100, 100, 450, 300);
		delframe.setLocationRelativeTo(null);
		delframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		delframe.getContentPane().setLayout(null);
		
		JLabel label = new JLabel("\u8F93\u5165\u8981\u5220\u9664\u7684\u5B66\u53F7");
		label.setFont(new Font("����", Font.PLAIN, 20));
		label.setBounds(128, 35, 167, 39);
		delframe.getContentPane().add(label);
		
		textField = new JTextField();
		textField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode()==Event.ENTER){
					if(textField.getText().length()<=0){
						JOptionPane.showMessageDialog(null, "ѧ�Ų���Ϊ��");
					}
					if(textField.getText().length()>0){
						if(Del.DeleteByNum(textField.getText())){
							JOptionPane.showMessageDialog(null, "ɾ���ɹ�");
							delframe.dispose();
						}
						else JOptionPane.showMessageDialog(null, "�޴���Ϣ");	
					}
				}
			}
		});
		textField.setFont(new Font("����", Font.PLAIN, 20));
		textField.setBounds(98, 87, 220, 39);
		delframe.getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("\u5220\u9664");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(textField.getText().length()<=0){
					JOptionPane.showMessageDialog(null, "ѧ�Ų���Ϊ��");
				}
				if(textField.getText().length()>0){
					if(Del.DeleteByNum(textField.getText())){
						JOptionPane.showMessageDialog(null, "ɾ���ɹ�");	
						delframe.dispose();
					}
					else JOptionPane.showMessageDialog(null, "�޴���Ϣ");	
				}
			}
		});
		btnNewButton.setFont(new Font("����", Font.PLAIN, 20));
		btnNewButton.setBounds(153, 139, 113, 27);
		delframe.getContentPane().add(btnNewButton);
	}
}
