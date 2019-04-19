package ������.Day04.ChatRoom;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

import ������.Day04.ChatRoom2.Receive;
import ������.Day04.ChatRoom2.Send;

public class Client {
/**
 * 1.���ӷ�����Socket
 * 2.�����뷢������
 * @param args
 * @throws IOException 
 * @throws UnknownHostException 
 */
	public static void main(String[] args) throws UnknownHostException, IOException {
		Socket client = new Socket("localhost", 9999);
		
		new Thread(new Send(client, null)).start(); 
		new Thread(new Receive(client)).start();
	}

}
