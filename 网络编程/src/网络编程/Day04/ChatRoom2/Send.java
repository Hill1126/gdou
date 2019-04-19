package ������.Day04.ChatRoom2;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class Send implements Runnable{

	//����̨������
	private BufferedReader console;
	//�ܵ������
	private DataOutputStream dos;
	//���м��
	private boolean isRunning = true;
	//�û��ǳ�
	private String name = null;
	
	public Send(){
		console = new BufferedReader(new InputStreamReader(System.in));
	}
	public Send(Socket client,String name){
		this();
		try {
			dos = new DataOutputStream(client.getOutputStream());
			this.name = name;
			send(this.name);
		} catch (IOException e) {
			isRunning = false;
			try {
				console.close();
				dos.close();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}
	
	//�ӿ���̨��ȡ��Ϣ
	private String getString(){
		try {
			return console.readLine();
		} catch (IOException e) {

			e.printStackTrace();
		}
		return "";
	}
	
	//������Ϣ
	private void send(String msg){
		if(msg!=null && !"".equals(msg)){
			try {
				dos.writeUTF(msg);
				dos.flush();
			} catch (IOException e) {
				isRunning = false;
				try {
					dos.close();
					console.close();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		}
	}
	@Override
	public void run() {
		while(isRunning){
			send(getString());
		}
	}

}
