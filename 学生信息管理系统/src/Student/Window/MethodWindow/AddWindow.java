package Student.Window.MethodWindow;

import java.awt.Font;
import java.awt.Window.Type;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import Student.method.AddMethod.Add;



public class AddWindow {

	public JFrame addframe;
	private JTextField txtXjf;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	/**
	 * Launch the application.
	 */

	

	/**
	 * Create the application.
	 */
	public AddWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		addframe = new JFrame();
		addframe.setType(Type.POPUP);
		addframe.setTitle("\u6DFB\u52A0");
		addframe.setBounds(100, 100, 520, 352);
		addframe.setLocationRelativeTo(null);
		addframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		addframe.getContentPane().setLayout(null);
		
		JLabel label = new JLabel("\u5B66\u53F7");
		label.setFont(new Font("����", Font.PLAIN, 22));
		label.setBounds(37, 39, 81, 27);
		addframe.getContentPane().add(label);
		
		JLabel label_1 = new JLabel("\u59D3\u540D");
		label_1.setFont(new Font("����", Font.PLAIN, 22));
		label_1.setBounds(37, 93, 81, 27);
		addframe.getContentPane().add(label_1);
		
		JLabel label_2 = new JLabel("\u6027\u522B");
		label_2.setFont(new Font("����", Font.PLAIN, 22));
		label_2.setBounds(37, 145, 81, 27);
		addframe.getContentPane().add(label_2);
		
		JLabel label_3 = new JLabel("\u73ED\u7EA7");
		label_3.setFont(new Font("����", Font.PLAIN, 22));
		label_3.setBounds(37, 199, 81, 27);
		addframe.getContentPane().add(label_3);
		
		JLabel label_4 = new JLabel("\u7535\u8BDD");
		label_4.setFont(new Font("����", Font.PLAIN, 22));
		label_4.setBounds(37, 250, 81, 27);
		addframe.getContentPane().add(label_4);
		
		txtXjf = new JTextField();
		txtXjf.setFont(new Font("����", Font.PLAIN, 20));
		txtXjf.setBounds(95, 35, 238, 37);
		addframe.getContentPane().add(txtXjf);
		txtXjf.setColumns(10);
		
		textField = new JTextField();
		textField.setFont(new Font("����", Font.PLAIN, 20));
		textField.setColumns(10);
		textField.setBounds(95, 89, 238, 37);
		addframe.getContentPane().add(textField);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("����", Font.PLAIN, 20));
		textField_1.setColumns(10);
		textField_1.setBounds(95, 141, 238, 37);
		addframe.getContentPane().add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("����", Font.PLAIN, 20));
		textField_2.setColumns(10);
		textField_2.setBounds(95, 195, 238, 37);
		addframe.getContentPane().add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setFont(new Font("����", Font.PLAIN, 20));
		textField_3.setColumns(10);
		textField_3.setBounds(95, 246, 238, 37);
		addframe.getContentPane().add(textField_3);
		
		JButton button = new JButton("\u5B8C\u6210");
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String A_Num = txtXjf.getText();
				String A_Name = textField.getText();
				String A_Sex = textField_1.getText();
				String A_banji = textField_2.getText();
				String A_Tel = textField_3.getText();
			
				
				if(A_Num.length()<=0|A_Name.length()<=0|A_Sex.length()<=0|A_banji.length()<=0|A_Tel.length()<=0){
					JOptionPane.showMessageDialog(null, "���������룡");
				}
				
					if(A_Num.length()>0&&A_Name.length()>0&&A_Sex.length()>0&&A_banji.length()>0&&A_Tel.length()>0){
						//���ʧ�ܣ�������棬�ع����ݿ⡣
						if(Add.AddAll(A_Num,A_Name,A_Sex,A_banji,A_Tel)){
							JOptionPane.showMessageDialog(null, "������");	
						}
						else JOptionPane.showMessageDialog(null, "ѧ���ظ������ʧ��");	
						addframe.dispose();	
					}
					
				}					
		});
		button.setBounds(364, 231, 110, 49);
		addframe.getContentPane().add(button);
	}
}
