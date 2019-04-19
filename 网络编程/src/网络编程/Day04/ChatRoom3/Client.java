package ������.Day04.ChatRoom3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;

import ������.Day04.ChatRoom3.Receive;
import ������.Day04.ChatRoom3.Send;

public class Client {
/**
 * 1.���ӷ�����Socket
 * 2.�����뷢������
 * @param args
 * @throws IOException 
 * @throws UnknownHostException 
 */
	public static void main(String[] args) throws UnknownHostException, IOException {
		
		System.out.println("������һ���ǳƣ�");
		BufferedReader fr = new BufferedReader(new InputStreamReader(System.in));
		String name = fr.readLine();
		if(name.length()>10 || "".equals(name)){
			return ;
		}
		Socket client = new Socket("localhost", 9999);
		new Thread(new Send(client,name)).start(); 
		new Thread(new Receive(client)).start();
	}

}
