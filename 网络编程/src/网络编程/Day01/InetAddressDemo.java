package ������.Day01;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class InetAddressDemo {

	public static void main(String[] args) throws UnknownHostException {
		//ʹ�ñ��ػ����õ�����
		InetAddress addres = InetAddress.getLocalHost();
		
		System.out.println(addres.getHostAddress());
		
		//ʹ�������õ�����
		addres = InetAddress.getByName("www.baidu.com");
		System.out.println(addres.getHostName());		//����������
		System.out.println(addres.getHostAddress());   //���ص�ַ��
		
		//ʹ��IP��ַ�õ�����
		addres = InetAddress.getByName("14.215.177.38");
		System.out.println(addres.getHostName());
		System.out.println(addres.getHostAddress());    //
	}

}
