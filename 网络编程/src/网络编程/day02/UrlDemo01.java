package ������.day02;

import java.net.MalformedURLException;
import java.net.URL;
/**
 * URL:��Դ��λ����
 * http����ʾЭ��
 * ��80 ��ʾ80�˿�
 *
 *�󲿷���ҳ����ҳ�������˲��ָ�ʽ��������Ϊ��Ĭ����Դ
 * @author HILL
 *
 */
public class UrlDemo01 {

	public static void main(String[] args) throws MalformedURLException {
		URL url = new URL("http://www.baidu.com:80/a.html#aaaa?username=hill");
		
		System.out.println("Э��"+url.getProtocol());
		System.out.println("��Դ"+url.getFile());
		System.out.println("�˿�"+url.getPort());
		System.out.println("?�������"+url.getQuery());  //��ê����ڣ��򷵻ؿա�
		System.out.println("����"+url.getHost());
		System.out.println("ê�㣨#���棩"+url.getRef());
		System.out.println("���·��"+url.getPath());
		
		

	}

}
