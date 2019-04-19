package 网络编程.Day04.ChatRoom3;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

import 网络编程.Day04.ChatRoom3.closeutil;

/**
 *  
 * @author HILL
 *
 */
public class Server {
	//储存每一个客户端，方便发送以及管理。
	private List<Mychannel> all = new ArrayList<Mychannel>();
	
	public static void main(String[] args) throws IOException {
		new Server().start();
		
	}

	/**
	 * 此方法包括封装了
	 * 1.创建与客户端连接的ServerSocket通道。
	 * 2.接受客户端的信息
	 * 
	 * @throws IOException
	 */
	@SuppressWarnings("resource")
	public void start() throws IOException{
		ServerSocket server = new ServerSocket(9999);
		while(true){
			Socket client = server.accept();
			Mychannel channel = new Mychannel(client);
			all.add(channel);
			new Thread(channel).start();
		}
			
		
	}
	
	class Mychannel implements Runnable{

		private DataInputStream dis;
		private DataOutputStream dos;
		private boolean isRunning = true;
		private String name = null;
		
		
		public Mychannel(Socket client){
		
			try {
				dis = new DataInputStream(client.getInputStream());
				dos = new DataOutputStream(client.getOutputStream());
				this.send("欢迎您进入聊天室！");
				this.name = dis.readUTF();
				this.sendorther("欢迎【"+name+"】进入聊天室！！");
				
			} catch (IOException e) {
				closeutil.closeall(dis,dos);
				isRunning = false;
			}
		}
		
		
		private String receive(){
			String msg = "";
			try {
				 msg = dis.readUTF();
			} catch (IOException e) {
				closeutil.closeall(dis,dos);
				isRunning = false;
			}
			return msg;
		}
		
		private void send(String msg){
			if(msg!=null && !"".equals(msg)){
				try {
					dos.writeUTF(msg);
					dos.flush();
				} catch (IOException e) {
					closeutil.closeall(dis,dos);
					isRunning = false;
				}
			}
		}
		
		public void sendorther(String msg){
			for(Mychannel orther: all){
				if(orther == this){
					this.send("我："+msg);
					continue;
				}
				orther.send(this.name+":"+msg);
			}
		}
		
		@Override
		public void run() {
			while(isRunning){
				sendorther(receive());
			}
		}
		
	}
}
