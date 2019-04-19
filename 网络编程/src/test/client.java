package test;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class client {

	public static void main(String[] args) {

		try {
			Socket client = new Socket("localhost", 9999);
			byte [] arr = new byte[1024];
			client.getOutputStream().write(arr);
			client.close();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
