package ������.Day03;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.SocketException;

/**
 * UDP��̣��ͻ���
 * 1.�����ͻ���
 * 2.�������
 * 3.��������
 * 4.�رտͻ���
 * @author HILL
 *
 */
public class MyClient {

	public static void main(String[] args) throws IOException {
		//1.�����ͻ��� ,��Ϊ��UDP��̣���ʱ�Ķ˿�ָ������Ӱ�����ݵķ��͡�
		DatagramSocket client = new DatagramSocket(6666);
		//2.�������
		Double num = 89.12;
		byte [] data = conver(num);
		// ����������ָ���ĵ�ַ�Ͷ˿ڲ����������͵�λ�á�
		DatagramPacket packet = new DatagramPacket(data, data.length, new InetSocketAddress("localhost",9999));
		//3.��������
		client.send(packet);
		//4.�رտͻ���
		client.close();

	}
	
	/**double ����ת��Ϊ�ֽ�����
	 * 1.�����ֽ����������
	 * 2.���ֽ�������������뵽���������
	 * 3.������������������ȡ�ֽ����顣
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
