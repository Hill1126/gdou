package 聊天室.Server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import 聊天室.Client.closeutil;

/**
 *  
 * @author HILL
 *
 */
public class Myserver {
	//储存每一个客户端，方便发送以及管理。
	private static List<Mychannel> all = new ArrayList<Mychannel>();
	public static final String LRCF = "\r\n";
	
	public static void main(String[] args) throws IOException {
		new Myserver().start();		
	}

	/**
	 * 此方法封装了
	 * 1.创建与客户端连接的ServerSocket通道。
	 * 2.接受客户端的信息
	 * 
	 * @throws IOException
	 */
	@SuppressWarnings("resource")
	public void start() throws IOException{
		ServerSocket server = new ServerSocket(9999);
		while(true){
			Socket Client = server.accept();
			Mychannel channel = new Mychannel(Client);
			all.add(channel);
			new Thread(channel).start();
		}		
	}
	
	class Mychannel implements Runnable{

		private DataInputStream dis;
		private DataOutputStream dos;
		private Socket client;
		private boolean isRunning = true;
		private String name = null;		
		
		private Date date;
		private DateFormat dateformat;
		
		public Mychannel(Socket client){
		
			try {
				date = new Date();
				dateformat = DateFormat.getDateInstance();
				dateformat = new SimpleDateFormat("yyyy年MM月dd天--yyyy年第DD天");
				
				this.client = client;
				dis = new DataInputStream(client.getInputStream());
				dos = new DataOutputStream(client.getOutputStream());
				this.name = dis.readUTF();
				this.ServerSend(dateformat.format(date)+LRCF+"系统消息：欢迎【"+name+"】进入聊天室！！"+LRCF);
				
			} catch (IOException e) {
				closeutil.closeIO(dis,dos);
				isRunning = false;
			}
		}
		
		
		private String receive(){
			String msg = "";
			try {
				 msg = dis.readUTF();
			} catch (IOException e) {
				closeutil.closeIO(dis,dos);
				isRunning = false;
			}
			return msg;
		}
		
		private void send(String msg){
			if(msg!=null && !"".equals(msg) &&!client.isClosed()){
				try {
					dos.writeUTF(msg);
					dos.flush();
				} catch (IOException e) {
					closeutil.closeIO(dis);
					closeutil.closeIO(dos);
					isRunning = false;
				}
			}
		}
		
		public void SendOrther(String msg){
			/*for(Mychannel orther: all){
				orther.send(msg);
				
			}
			*/
			for(Mychannel orther: all){
				if(orther == this && !client.isClosed()){
					this.send( dateformat.format(date)+LRCF+"我："+msg+LRCF+LRCF);
					continue;
				}
				if(!client.isClosed()){
					orther.send(dateformat.format(date)+LRCF+this.name+":"+msg+LRCF+LRCF);					
				}
			}
		}
		
		public void ServerSend(String msg){
			for(Mychannel orther: all){
				orther.send(msg);
			}
		}
		@Override
		public void run() {
			while(isRunning){
				SendOrther(receive());
			}
		}
		
	}
}
