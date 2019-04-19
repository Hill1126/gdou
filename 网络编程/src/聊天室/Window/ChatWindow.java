package 聊天室.Window;

import java.awt.Button;
import java.awt.Event;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTextArea;

import 聊天室.Client.MyClient;
import 聊天室.Client.closeutil;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class ChatWindow  {

	JFrame Chatframe;
	private MyClient client;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the application.
	 */
	public ChatWindow(MyClient client) {
		this.client = client;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		Chatframe = new JFrame();
		Chatframe.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				client.getOut().send("已退出聊天室");
				closeutil.closeSocket(client.getClient());
			}
		});
		Chatframe.setFont(new Font("Dialog", Font.PLAIN, 23));
		Chatframe.setTitle("\u804A\u5929\u5BA4");
		Chatframe.setBounds(100, 100, 593, 728);
		Chatframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Chatframe.getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 575, 456);
		Chatframe.getContentPane().add(scrollPane);
		Chatframe.setTitle("聊天室"+"                         "+"昵称："+client.getOut().getName());
		
		JTextArea textArea = new JTextArea();
		textArea.setFont(new Font("Monospaced", Font.PLAIN, 20));
		scrollPane.setViewportView(textArea);
		textArea.setEditable(false);               //设置为不可编辑的状态
		
		//自动滚动到最新界面
		scrollPane.getVerticalScrollBar().setValue(scrollPane.getVerticalScrollBar().getMaximum());
		client.getIn().setTextArea(textArea);
		

		JEditorPane editorPane = new JEditorPane();
		editorPane.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode()==Event.ENTER){
					String text = editorPane.getText();
					editorPane.setText(null);	
					if(null!=text && !"".equals(text)){
						client.getOut().send(text);	
					}
				}	
			}
		});

		editorPane.setBounds(0, 517, 575, 151);
		Chatframe.getContentPane().add(editorPane);
		
		JButton btnNewButton = new JButton("\u53D1\u9001");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				client.getOut().send(editorPane.getText());
				editorPane.setText("");
			}
		});
		btnNewButton.setFont(new Font("宋体", Font.PLAIN, 20));
		btnNewButton.setBounds(471, 478, 104, 33);
		Chatframe.getContentPane().add(btnNewButton);
		
		
		Button button = new Button("\u53D1\u9001\u56FE\u7247");
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JFileChooser jc = new JFileChooser();
				jc.setFileSelectionMode(JFileChooser.FILES_ONLY);
				jc.showOpenDialog(null);
				
				
			}
		});
		button.setBounds(0, 478, 87, 33);
		Chatframe.getContentPane().add(button);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(0, 513, 575, 33);
		Chatframe.getContentPane().add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(0, 469, 575, 2);
		Chatframe.getContentPane().add(separator_1);
		
			
	}


}
