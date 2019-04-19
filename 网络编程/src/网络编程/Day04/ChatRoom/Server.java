package 网络编程.Day04.ChatRoom;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

import 网络编程.Day04.ChatRoom2.closeutil;

/**
 *  1.满足
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
	 * 2.接客户端的信息
	 * 3.启动内部类Mychannel的多线程的方法。
	 * @throws IOException
	 */
	@SuppressWarnings("resource")
	public void start() throws IOException{
		ServerSocket server = new ServerSocket(9999);
		//保持始终运行准备接受客户端信息。
		while(true){
			//每接收一个客户端则创造一个线程。
			Socket client = server.accept();
			Mychannel channel = new Mychannel(client);
			all.add(channel); //添加到集合中管理
			new Thread(channel).start();//启动一条通道。
		}
			
		
	}
	
	/**
	 * 内部类
	 * 1.封装发送与接收的方法。
	 * 2.添加一个除去自己的发送方法
	 * 3.在run()运行发送方法。
	 * @author HILL
	 *
	 */
	class Mychannel implements Runnable{

		private DataInputStream dis;
		private DataOutputStream dos;
		private boolean isRunning = true;
		
		/**
		 * 构造函数
		 * 初始化输入流以及输出流。
		 * @param client
		 */
		public Mychannel(Socket client){
			try {
				dis = new DataInputStream(client.getInputStream());
				dos = new DataOutputStream(client.getOutputStream());
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
		
		public void sendorther(){
			String msg = "";
			msg = receive();
			for(Mychannel orther: all){
				if(orther == this){
					continue;
				}
				orther.send(msg);
			}
		}
		
		@Override
		public void run() {
			while(isRunning){
				sendorther();
			}
		}
		
	}
}
