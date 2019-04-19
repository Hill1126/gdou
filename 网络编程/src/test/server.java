package test;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.ServerSocket;
import java.net.Socket;

public class server {
	static Socket client;
	static DataOutputStream out;
	static DataInputStream in;
	public static void main(String[] args) {	
		try {
		ServerSocket server = new ServerSocket(9999);
		client = server.accept();	
		System.out.println(client.toString());
		out = new DataOutputStream(client.getOutputStream());
		in = new DataInputStream(client.getInputStream());
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void send(String msg) throws IOException {
		out.write(msg.getBytes());
		out.flush();
		out.close();
		
	}

	public static void read() throws IOException {
		byte [] arr = new byte[1024];
		int len;
		if((len=in.read(arr))!=-1) {
			System.out.println(new String(arr,0,len));
		}
			
	}

}
