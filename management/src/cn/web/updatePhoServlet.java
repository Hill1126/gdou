package cn.web;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import cn.service.AddService;

public class updatePhoServlet extends HttpServlet {

	final String path = "D:\\User\\img";
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		String sno = (String)request.getSession().getAttribute("username");
		// 创建上传所需要的两个对象
	    DiskFileItemFactory factory = new DiskFileItemFactory();  // 磁盘文件对象
	    ServletFileUpload sfu = new ServletFileUpload(factory);   // 文件上传对象

	    // 设置解析文件上传中的文件名的编码格式
	    sfu.setHeaderEncoding("utf-8");

	    // 创建 list容器用来保存 
	    List<FileItem> items = new ArrayList<FileItem>();

	    // 将表单中的所有数据信息放入 list容器中
	    try {
	        items = sfu.parseRequest(request);
	    } catch (FileUploadException e) {
	        e.printStackTrace();
	    }
	    
	    for (FileItem item : items) {
	            // 处理 文件数据项 信息
	        	  // 获取 文件数据项中的 文件名
	            String fileName = item.getName();

	            // 判断 此文件的文件名是否合法
	            if (fileName==null || "".equals(fileName)) {
	                return;
	            }

	            // 控制只能上传图片
	            if (!item.getContentType().startsWith("image")) {
	                return;
	            }

	            File file = new File(path);   // 创建 file对象

	            // 创建 /files 目录
	            if (!file.exists()) {
	                file.mkdir();
	            }

	            // 将文件保存到服务器上（UUID是通用唯一标识码，不用担心会有重复的名字出现）
	            String photoname =  UUID.randomUUID().toString().substring(0, 7)+"_"+fileName;
	            try {
	                item.write(new File(file.toString(),photoname));
	                
	            } catch (Exception e) {
	                e.printStackTrace();
	            }
	            AddService service = new AddService();
	            boolean isSuccess = false;
	            try {
	            	isSuccess = service.addPhoto(photoname,sno);
				} catch (SQLException e) {
					e.printStackTrace();
				}
	            response.setContentType("text/html;charset=UTF-8");
	            if(isSuccess) {
	            	response.getWriter().write("添加成功");
	    			response.setHeader("refresh","2;url="+request.getContextPath()+"/studentCheck");
	    		}else {
	    			response.getWriter().write("添加失败");
	    			response.setHeader("refresh","2;url="+request.getContextPath()+"/addPho.jsp");
	    		}
	            
	            
	        }
	     }
	    
		
	

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}