package 网络编程.Day04.ChatRoom3;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class Send implements Runnable{

	//控制台输入流
	private BufferedReader console;
	//管道输出流
	private DataOutputStream dos;
	//运行监控
	private boolean isRunning = true;
	//用户昵称
	private String name = null;
	
	public Send(){
		console = new BufferedReader(new InputStreamReader(System.in));
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
				console.close();
				dos.close();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}
	
	//从控制台获取信息
	private String getString(){
		try {
			return console.readLine();
		} catch (IOException e) {

			e.printStackTrace();
		}
		return "";
	}
	
/*	private void sendpicture(File picture){
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
	private void send(String msg){
		if(msg!=null && !"".equals(msg)){
			try {
				dos.writeUTF(msg);
				dos.flush();
			} catch (IOException e) {
				isRunning = false;
				closeutil.closeall(dos,console);
			}
		}
	}
	@Override
	public void run() {
		while(isRunning){
			send(getString());
		}
	}

}
