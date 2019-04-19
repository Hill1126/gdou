package ������.Day04.ChatRoom2;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;

/**
 * 1.�������� DataInputStream
 * 2.�������ݵ�Ŀ��
 * @author HILL
 *
 */
public class Receive implements Runnable {

	private DataInputStream dis;
	private boolean isRunning = true;
	public Receive(){
		
	}
	public Receive(Socket client){
		try {
			dis = new DataInputStream(client.getInputStream());
		} catch (IOException e) {
			isRunning = false;
			try {
				dis.close();
			} catch (IOException e1) {
				
			}
		}
	}
	
	private String receive(){
		String msg = "";
		try {
			 msg = dis.readUTF();
		} catch (IOException e) {
			isRunning = false;
			try {
				dis.close();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		return msg;
	}
	@Override
	public void run() {
		while(isRunning){
			System.out.println(receive());
		}
	}

}
