package 网络编程.Day03;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**UDP编程客户端。
 * 1.创建服务器端口
 * 2.准备容器，接收数据
 * 3.分析数据
 * 4.关闭资源
 * @author HILL
 *
 */
public class MyServer {

	public static void main(String[] args) throws IOException {
		 //	1.创建服务器端口,端口为9999，
		DatagramSocket server = new DatagramSocket(9999);
		//2.准备容器，接收数据  容器必须为字节数组，若为其他数据，必须转换为字节数组。
		byte[] contain = new byte[1024];
		//接受数据
		DatagramPacket packet = new DatagramPacket(contain, contain.length);
		server.receive(packet);
		//3.分析数据,以packet为对象获取数据。
		double num =  conver(packet.getData());
		
		System.out.println(num);
		
		//4.关闭资源
		server.close();
	}
	
	public static Double conver(byte[] data) throws IOException{
		DataInputStream ips = new DataInputStream(new ByteArrayInputStream(data));
		
		double num = ips.readDouble();
		return num;
		
	}

}
