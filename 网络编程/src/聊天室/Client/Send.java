package 聊天室.Client;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

import javax.swing.JEditorPane;


public class Send implements Runnable{

	//编辑区文本框
	JEditorPane editorPane;
	
	//管道输出流
	private DataOutputStream dos;
	//运行监控
	private boolean isRunning = true;
	//用户昵称
	private String name = null;
	
	public Send(){
	}
	
	public Send(Socket client,String name){
		this();
		try {
			dos = new DataOutputStream(client.getOutputStream());
			this.name = name;
			send(this.name);
		} catch (IOException e) {
			isRunning = false;
			try {
				dos.close();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}
	
	public void seteditorPane(JEditorPane editorPane){
		this.editorPane = editorPane;
		
	}
	
	//从文本框获取信息


/*
	private void sendpicture(File picture){
		try {
			BufferedInputStream bfis = new BufferedInputStream(new FileInputStream(picture)) ;
			
			byte buf[] = new byte[1024];
			int len = 0;	
			while((len=bfis.read(buf))!=-1){
					dos.write(buf,0,len);
				}
				dos.flush();
			} catch (IOException e) {
				e.printStackTrace();
			}
	
	}
*/		
	
	//发送信息
	public void send(String msg){
		if(msg!=null && !"".equals(msg)){
			try {
				dos.writeUTF(msg);
				dos.flush();
			} catch (IOException e) {
				isRunning = false;
				closeutil.closeIO(dos);
			}
		}
	}
	public String getName() {
		return name;
	}

	@Override
	public void run() {
		while(isRunning){
			
		}
	}

}
