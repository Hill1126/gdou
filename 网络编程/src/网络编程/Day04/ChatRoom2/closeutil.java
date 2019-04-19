package ÍøÂç±à³Ì.Day04.ChatRoom2;

import java.io.Closeable;
import java.io.IOException;

public class closeutil {

	public static void closeall(Closeable ...io){
		for(Closeable temp:io){
			if(null!=temp){
				try {
					temp.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
	}

}
