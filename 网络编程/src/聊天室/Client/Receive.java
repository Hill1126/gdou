package ¡ƒÃÏ “.Client;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;

import javax.swing.JTextArea;

public class Receive implements Runnable {

	private DataInputStream dis;
	private boolean isRunning = true;
	private JTextArea textArea;
	
	public void setTextArea(JTextArea textArea) {
		if(null==this.textArea){
			this.textArea = textArea;
		}
	}
	public Receive(){
		
	}
	public Receive(Socket client){
		try {
			dis = new DataInputStream(client.getInputStream());
		} catch (IOException e) {
			closeutil.closeIO(dis);
			isRunning = false;
		}
	}
	
	public void receive(){
		String msg = "";
		try {
			msg = dis.readUTF();
			textArea.append(msg);
		} catch (IOException e) {
			closeutil.closeIO(dis);
			isRunning = false;
		}
	}

	@Override
	public void run() {
		while(isRunning){
			receive();
		}
	}
	

}
