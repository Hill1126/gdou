package cn.utils;

import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import cn.domain.Student;

//封装用于赋值的代码
public class MyBeanUtils {

	
	public static void populate(Student stu,String key,String value) {
		if(key.equals("Sname")) {
			stu.setSname(value);
			return;
		}
		if(key.equals("Ssno")) {
			stu.setSsno(value);
			return;
		}
		if(key.equals("Ssex")) {
			stu.setSsex(value);
			return;
		}
		if(key.equals("Sdept")) {
			stu.setSdept(value);
			return;
		}
		if(key.equals("Simg")) {
			stu.setSimg(value);
			return;
		}
		if(key.equals("Stel")) {
			stu.setStel(value);
			return;
		}
		if(key.equals("Smail")) {
			stu.setSmali(value);
			return;
		}
		if(key.equals("Saddress")) {
			stu.setSaddress(value);
			return;
		}
		if(key.equals("Sbirthday")) {
			stu.setSbirthday(value);
			return;
		}
		if(key.equals("Sdescribe")) {
			stu.setSdescribe(value);
			return;
		}
		if(key.equals("Sentrance")) {
			stu.setSentrance(value);
			return;
		}
		if(key.equals("Sgraduate")) {
			stu.setSgraduate(value);
			return;
		}
	}
	
	public static void populate(Student stu,Map<String,String[]> map) {
		
		Iterator<Entry<String, String[]>> it = map.entrySet().iterator(); 
			while(it.hasNext()) {
				Entry<String, String[]> entry = it.next();  
				if(entry.getKey().equals("Sname")) {
					stu.setSname(entry.getValue()[0]);
					continue;
				}
				if(entry.getKey().equals("Ssno")) {
					stu.setSsno(entry.getValue()[0]);
					continue;
				}if(entry.getKey().equals("Ssex")) {
					stu.setSsex(entry.getValue()[0]);
					continue;
				}if(entry.getKey().equals("Sdept")) {
					stu.setSdept(entry.getValue()[0]);
					continue;
				}if(entry.getKey().equals("Stel")) {
					stu.setStel(entry.getValue()[0]);
					continue;
				}if(entry.getKey().equals("Smali")) {
					stu.setSmali(entry.getValue()[0]);
					continue;
				}if(entry.getKey().equals("Saddress")) {
					stu.setSaddress(entry.getValue()[0]);
					continue;
				}if(entry.getKey().equals("Sbirthday")) {
					stu.setSbirthday(entry.getValue()[0]);
					continue;
				}if(entry.getKey().equals("Sdescribe")) {
					stu.setSdescribe(entry.getValue()[0]);
					continue;
				}if(entry.getKey().equals("Sentrance")) {
					stu.setSentrance(entry.getValue()[0]);
					continue;
				}if(entry.getKey().equals("Sgraduate")) {
					stu.setSgraduate(entry.getValue()[0]);
					continue;
				}
			}
			
		
		
		
	}
}
