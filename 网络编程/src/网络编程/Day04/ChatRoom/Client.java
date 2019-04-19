package 网络编程.Day04.ChatRoom;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

import 网络编程.Day04.ChatRoom2.Receive;
import 网络编程.Day04.ChatRoom2.Send;

public class Client {
/**
 * 1.连接服务器Socket
 * 2.接收与发送数据
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
