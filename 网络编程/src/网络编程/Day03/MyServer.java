package ������.Day03;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**UDP��̿ͻ��ˡ�
 * 1.�����������˿�
 * 2.׼����������������
 * 3.��������
 * 4.�ر���Դ
 * @author HILL
 *
 */
public class MyServer {

	public static void main(String[] args) throws IOException {
		 //	1.�����������˿�,�˿�Ϊ9999��
		DatagramSocket server = new DatagramSocket(9999);
		//2.׼����������������  ��������Ϊ�ֽ����飬��Ϊ�������ݣ�����ת��Ϊ�ֽ����顣
		byte[] contain = new byte[1024];
		//��������
		DatagramPacket packet = new DatagramPacket(contain, contain.length);
		server.receive(packet);
		//3.��������,��packetΪ�����ȡ���ݡ�
		double num =  conver(packet.getData());
		
		System.out.println(num);
		
		//4.�ر���Դ
		server.close();
	}
	
	public static Double conver(byte[] data) throws IOException{
		DataInputStream ips = new DataInputStream(new ByteArrayInputStream(data));
		
		double num = ips.readDouble();
		return num;
		
	}

}
