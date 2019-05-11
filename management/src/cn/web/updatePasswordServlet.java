package cn.web;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.service.UpdateService;

public class updatePasswordServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//获取获取账号密码及新密码
		String sno = (String)request.getSession().getAttribute("username");
		String oldpassword = request.getParameter("old");
		String newpassword = request.getParameter("new");
		//传递到service层更新密码
		UpdateService service = new UpdateService();
        boolean isSuccess = false;
		try {
			isSuccess = service.updatePassword(sno,oldpassword,newpassword);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		 response.setContentType("text/html;charset=UTF-8");
         if(isSuccess) {
         	response.getWriter().write("修改成功");
 			response.setHeader("refresh","2;url="+request.getContextPath()+"/studentCheck");
 		}else {
 			response.getWriter().write("修改失败");
 			response.setHeader("refresh","2;url="+request.getContextPath()+"/change.jsp");
 		}
		
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}