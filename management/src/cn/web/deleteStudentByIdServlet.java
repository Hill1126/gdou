package cn.web;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.service.UpdateService;

public class deleteStudentByIdServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//解决乱码问题
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		
		//获取需要删除信息的学生学号
		String sno = request.getParameter("manage_Sno");
		UpdateService service = new UpdateService();
		boolean isSucced = false;
		try {
			isSucced = service.deleteStudentById(sno);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if(isSucced) {
			response.getWriter().write("删除成功");
			response.setHeader("refresh","1;url="+request.getContextPath()+"/showAllStudent");
		}else {
			response.getWriter().write("删除失败 ");
			response.setHeader("refresh","1;url="+request.getContextPath()+"/showAllStudent");
		}
	
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}