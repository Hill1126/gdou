package 网络编程.day02;

import java.net.MalformedURLException;
import java.net.URL;
/**
 * URL:资源定位器。
 * http：表示协议
 * ：80 表示80端口
 *
 *大部分网页的主页都隐藏了部分格式，那是因为有默认资源
 * @author HILL
 *
 */
public class UrlDemo01 {

	public static void main(String[] args) throws MalformedURLException {
		URL url = new URL("http://www.baidu.com:80/a.html#aaaa?username=hill");
		
		System.out.println("协议"+url.getProtocol());
		System.out.println("资源"+url.getFile());
		System.out.println("端口"+url.getPort());
		System.out.println("?后参数："+url.getQuery());  //若锚点存在，则返回空。
		System.out.println("域名"+url.getHost());
		System.out.println("锚点（#后面）"+url.getRef());
		System.out.println("相对路径"+url.getPath());
		
		

	}

}
