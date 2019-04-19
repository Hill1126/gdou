package 网络编程.Day03;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.SocketException;

/**
 * UDP编程，客户端
 * 1.创建客户端
 * 2.打包数据
 * 3.发送数据
 * 4.关闭客户端
 * @author HILL
 *
 */
public class MyClient {

	public static void main(String[] args) throws IOException {
		//1.创建客户端 ,因为是UDP编程，此时的端口指定并不影响数据的发送。
		DatagramSocket client = new DatagramSocket(6666);
		//2.打包数据
		Double num = 89.12;
		byte [] data = conver(num);
		// 在数据这里指定的地址和端口才是真正发送的位置。
		DatagramPacket packet = new DatagramPacket(data, data.length, new InetSocketAddress("localhost",9999));
		//3.发送数据
		client.send(packet);
		//4.关闭客户端
		client.close();

	}
	
	/**double 类型转换为字节数组
	 * 1.创建字节数组输出流
	 * 2.将字节数组输出流传入到数据输出流
	 * 3.利用数据输出流对象获取字节数组。
	 * @throws IOException 
	 * 
	 */
	public static byte[] conver(double num) throws IOException{
		ByteArrayOutputStream bops = new ByteArrayOutputStream();
		DataOutputStream ops = new DataOutputStream(bops);
	
		ops.writeDouble(num);
		ops.flush();
		
		byte [] data = bops.toByteArray();
	
		return data;
	}
}
