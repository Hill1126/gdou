package Student.Window.MethodWindow.UpdateWindow;

import java.awt.Event;
import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Font;
import javax.swing.JTextField;

import Student.method.UpdateMethod.IsNum;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ToUpdateWindow {

	 public JFrame ToUpdateframe;
	private JTextField textField_2;
	public static String Ex_Num;

	/**
	 * Launch the application.
	 */


	/**
	 * Create the application.
	 */
	public ToUpdateWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		ToUpdateframe = new JFrame();
		ToUpdateframe.setFont(new Font("Dialog", Font.PLAIN, 36));
		ToUpdateframe.setTitle("\u67E5\u627E");
		ToUpdateframe.setBounds(100, 100, 370, 283);
		ToUpdateframe.setLocationRelativeTo(null);
		ToUpdateframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ToUpdateframe.getContentPane().setLayout(null);
		
		textField_2 = new JTextField();
		textField_2.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {	/*
				 * 1.��ȡ�����ѧ����Ϣ��
				 * 2.�ж�ѧ�ţ������ڸ���������ø��º���
				 * 3.���³ɹ��رմ��ڡ�
				 */
				if(e.getKeyCode()==Event.ENTER){
					 Ex_Num = textField_2.getText();
					
					if(IsNum.IsNumMethod(Ex_Num)){
						ToUpdateframe.dispose();
						InputUpdateMsg window = new InputUpdateMsg();
						window.Inputframe.setDefaultCloseOperation(window.Inputframe.DISPOSE_ON_CLOSE);
						window.Inputframe.setVisible(true);
					
					}
					if(Ex_Num.length()<=0){
						JOptionPane.showMessageDialog(null, "ѧ�Ų���Ϊ��");
					}
					else  if(!IsNum.IsNumMethod(Ex_Num))
						JOptionPane.showMessageDialog(null, "û�д�ѧ��");	
				}
			}
		});
	
		textField_2.setFont(new Font("����", Font.PLAIN, 20));
		textField_2.setColumns(10);
		textField_2.setBounds(67, 85, 201, 40);
		ToUpdateframe.getContentPane().add(textField_2);
		
		JLabel lblNewLabel = new JLabel("\u8BF7\u8F93\u5165\u5B66\u53F7");
		lblNewLabel.setFont(new Font("����", Font.PLAIN, 20));
		lblNewLabel.setBounds(107, 39, 137, 33);
		ToUpdateframe.getContentPane().add(lblNewLabel);
		
		JButton button = new JButton("\u641C\u7D22");
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
			}
		});
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 Ex_Num = textField_2.getText();
									
				if(IsNum.IsNumMethod(Ex_Num)){
					ToUpdateframe.dispose();
					InputUpdateMsg window = new InputUpdateMsg();
					window.Inputframe.setVisible(true);
				}
				if(Ex_Num.length()<=0){
					JOptionPane.showMessageDialog(null, "ѧ�Ų���Ϊ��");
				}
				else  if(!IsNum.IsNumMethod(Ex_Num))
					JOptionPane.showMessageDialog(null, "û�д�ѧ��");	
			}
		});
		button.setFont(new Font("����", Font.PLAIN, 20));
		button.setBounds(107, 138, 113, 27);
		ToUpdateframe.getContentPane().add(button);
	}
}
