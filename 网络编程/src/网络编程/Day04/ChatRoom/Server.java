package ������.Day04.ChatRoom;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

import ������.Day04.ChatRoom2.closeutil;

/**
 *  1.����
 * @author HILL
 *
 */
public class Server {
	//����ÿһ���ͻ��ˣ����㷢���Լ�����
	private List<Mychannel> all = new ArrayList<Mychannel>();
	
	public static void main(String[] args) throws IOException {
		new Server().start();
		
	}

	/**
	 * �˷���������װ��
	 * 1.������ͻ������ӵ�ServerSocketͨ����
	 * 2.�ӿͻ��˵���Ϣ
	 * 3.�����ڲ���Mychannel�Ķ��̵߳ķ�����
	 * @throws IOException
	 */
	@SuppressWarnings("resource")
	public void start() throws IOException{
		ServerSocket server = new ServerSocket(9999);
		//����ʼ������׼�����ܿͻ�����Ϣ��
		while(true){
			//ÿ����һ���ͻ�������һ���̡߳�
			Socket client = server.accept();
			Mychannel channel = new Mychannel(client);
			all.add(channel); //��ӵ������й���
			new Thread(channel).start();//����һ��ͨ����
		}
			
		
	}
	
	/**
	 * �ڲ���
	 * 1.��װ��������յķ�����
	 * 2.���һ����ȥ�Լ��ķ��ͷ���
	 * 3.��run()���з��ͷ�����
	 * @author HILL
	 *
	 */
	class Mychannel implements Runnable{

		private DataInputStream dis;
		private DataOutputStream dos;
		private boolean isRunning = true;
		
		/**
		 * ���캯��
		 * ��ʼ���������Լ��������
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
