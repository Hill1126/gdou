package 网络编程.Day01;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class InetAddressDemo {

	public static void main(String[] args) throws UnknownHostException {
		//使用本地机器得到对象
		InetAddress addres = InetAddress.getLocalHost();
		
		System.out.println(addres.getHostAddress());
		
		//使用域名得到对象
		addres = InetAddress.getByName("www.baidu.com");
		System.out.println(addres.getHostName());		//返回域名。
		System.out.println(addres.getHostAddress());   //返回地址。
		
		//使用IP地址得到对象
		addres = InetAddress.getByName("14.215.177.38");
		System.out.println(addres.getHostName());
		System.out.println(addres.getHostAddress());    //
	}

}
