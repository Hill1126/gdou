package ÍøÂç±à³Ì.day02;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.URL;

public class UrlDemo02 {

	public static void main(String[] args) throws IOException {
		URL url = new URL("http://www.baidu.com");
		
		BufferedReader bufr = new BufferedReader(new InputStreamReader(url.openStream(),"utf-8"));
		BufferedWriter buwr = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("baidu.html"),"utf-8"));
		byte[] line = new byte[1024];
		String len = null;
		while((len=bufr.readLine())!=null){
			buwr.append(len);
			buwr.newLine();
		}
		buwr.flush();
		buwr.close();
		bufr.close();
	}

}
