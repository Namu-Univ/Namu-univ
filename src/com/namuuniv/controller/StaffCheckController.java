package com.namuuniv.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.namuuniv.dao.SearchUpdateDAO;
import com.namuuniv.vo.StaffVO;
import com.namuuniv.vo.StudentVO;


@WebServlet("/staffCheck")
public class StaffCheckController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		StaffVO staff = SearchUpdateDAO.getStaffInfo(Integer.parseInt(request.getParameter("id")));
		request.setAttribute("vo", staff);
		request.getRequestDispatcher("staff/staff_check.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
