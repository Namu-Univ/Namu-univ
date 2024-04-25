package com.namuuniv.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.namuuniv.dao.SearchUpdateDAO;
import com.namuuniv.vo.StudentVO;


@WebServlet("/stuCheck")
public class StuCheckController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println(request.getParameter("id"));
		
		StudentVO student = SearchUpdateDAO.getStuInfo(Integer.parseInt(request.getParameter("id")));
		request.setAttribute("vo", student);
		request.getRequestDispatcher("student/stu_check.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
