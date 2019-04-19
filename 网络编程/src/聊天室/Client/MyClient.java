package ÁÄÌìÊÒ.Client;

import java.io.IOException;
import java.net.Socket;;

public class MyClient {

	private Send out;
	private Receive in;
	private Socket client ;
	public Socket getClient() {
		return client;
	}

	public MyClient(){
	}
	
	public boolean StartClient(String name){
			try {
				client = new Socket("localhost",9999);
				out = new Send(client,name);
				in = new Receive(client);	
				return true;
			} catch (IOException e) {
				return false;
			}
		}

	public Send getOut() {
		return out;
	}

	public Receive getIn() {
		return in;
	}
	}

