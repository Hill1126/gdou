package cn.web;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.service.SearchService;

public class getPhoServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String sno = (String)request.getSession().getAttribute("username");
		SearchService service = new SearchService();
		String path = "";
		try {
			path = service.getPho(sno);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if(path!=null&&!"".equals(path)) {
			request.setAttribute("path", path);
			request.getRequestDispatcher("/addPho.jsp").forward(request, response);
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}