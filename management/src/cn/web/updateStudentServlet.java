package cn.web;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.domain.Student;
import cn.service.UpdateService;

public class updateStudentServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	
		//获取到需要修改的学号
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		String Ssno = request.getParameter("Ssno");
		Student stu = new Student();
		stu.setSsno(Ssno);
		stu.setSname(request.getParameter("Sname"));
		stu.setSsex(request.getParameter("Ssex"));
		stu.setSdept(request.getParameter("Sdept"));
		stu.setStel(request.getParameter("Stel"));
		stu.setSmali(request.getParameter("Smali"));
		stu.setSaddress(request.getParameter("Saddress"));
		stu.setSbirthday(request.getParameter("Sbirthday"));
		stu.setSdescribe(request.getParameter("Sdescribe"));
		stu.setSentrance(request.getParameter("Sentrance"));
		stu.setSgraduate(request.getParameter("Sgraduate"));
		
		UpdateService service = new UpdateService();
		boolean isSuccess = false;
		try {
			isSuccess =	service.updateBySno(Ssno,stu);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if(true==isSuccess) {
			
			response.getWriter().write("修改成功");
			response.setHeader("refresh","2;url="+request.getContextPath()+"/studentCheck");
		}else {
			response.getWriter().write("修改失败，请重新填写");
			response.setHeader("refresh","2;url="+request.getContextPath()+"/domain.jsp");
		}
		
		
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}