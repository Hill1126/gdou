package Student.Window.MethodWindow.UpdateWindow;

import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import Student.method.UpdateMethod.Update;


public class InputUpdateMsg {

	public JFrame Inputframe;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	
	private int flag = -1 ;

	/**
	 * Launch the application.
	 */
	


	/**
	 * Create the application.
	 */
	public InputUpdateMsg() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		Inputframe = new JFrame();
		Inputframe.setFont(new Font("Dialog", Font.PLAIN, 20));
		Inputframe.setTitle("\u8F93\u5165\u4FE1\u606F");
		Inputframe.setBounds(100, 100, 735, 457);
		Inputframe.setLocationRelativeTo(null);
		Inputframe.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		Inputframe.getContentPane().setLayout(null);
		
		textField = new JTextField();
		textField.setFont(new Font("����", Font.PLAIN, 20));
		textField.setBounds(179, 50, 389, 39);
		Inputframe.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel label = new JLabel("\u5B66\u53F7");
		label.setFont(new Font("����", Font.PLAIN, 22));
		label.setBounds(123, 59, 72, 18);
		Inputframe.getContentPane().add(label);
		
		JLabel label_1 = new JLabel("\u59D3\u540D");
		label_1.setFont(new Font("����", Font.PLAIN, 22));
		label_1.setBounds(123, 111, 72, 18);
		Inputframe.getContentPane().add(label_1);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("����", Font.PLAIN, 20));
		textField_1.setColumns(10);
		textField_1.setBounds(179, 102, 389, 39);
		Inputframe.getContentPane().add(textField_1);
		
		JLabel label_2 = new JLabel("\u6027\u522B");
		label_2.setFont(new Font("����", Font.PLAIN, 22));
		label_2.setBounds(123, 163, 72, 18);
		Inputframe.getContentPane().add(label_2);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("����", Font.PLAIN, 20));
		textField_2.setColumns(10);
		textField_2.setBounds(179, 154, 389, 39);
		Inputframe.getContentPane().add(textField_2);
		
		JLabel label_3 = new JLabel("\u73ED\u7EA7");
		label_3.setFont(new Font("����", Font.PLAIN, 22));
		label_3.setBounds(123, 215, 72, 18);
		Inputframe.getContentPane().add(label_3);
		
		textField_3 = new JTextField();
		textField_3.setFont(new Font("����", Font.PLAIN, 20));
		textField_3.setColumns(10);
		textField_3.setBounds(179, 206, 389, 39);
		Inputframe.getContentPane().add(textField_3);
		
		JLabel label_4 = new JLabel("\u7535\u8BDD");
		label_4.setFont(new Font("����", Font.PLAIN, 22));
		label_4.setBounds(123, 267, 72, 18);
		Inputframe.getContentPane().add(label_4);
		
		textField_4 = new JTextField();
		textField_4.setFont(new Font("����", Font.PLAIN, 20));
		textField_4.setColumns(10);
		textField_4.setBounds(179, 258, 389, 39);
		Inputframe.getContentPane().add(textField_4);
		
		JButton btnNewButton = new JButton("\u786E\u5B9A");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				if(textField.getText().length()<=0|textField_1.getText().length()<=0|textField_2.getText().length()<=0|
						textField_3.getText().length()<=0|textField_4.getText().length()<=0){
					JOptionPane.showMessageDialog(null, "��Ϣ����Ϊ��");
				}
				if(textField.getText().length()>0&textField_1.getText().length()>0&textField_2.getText().length()<=0|
						textField_3.getText().length()>0&textField_4.getText().length()>0){
					flag = Update.UpdateAll(textField.getText(), textField_1.getText(), textField_2.getText(),
							textField_3.getText(), textField_4.getText(), ToUpdateWindow.Ex_Num);
					
				}
				if(flag==0){
					JOptionPane.showMessageDialog(null, "�޸�ʧ�ܣ����������Ѵ���");
				}
				if(flag==1){
					JOptionPane.showMessageDialog(null, "�޸ĳɹ���");
					Inputframe.dispose();
				}
			}
		});
		btnNewButton.setBounds(298, 310, 122, 45);
		Inputframe.getContentPane().add(btnNewButton);
	}

}
