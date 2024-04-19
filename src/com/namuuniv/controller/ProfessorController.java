package com.namuuniv.controller;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.namuuniv.dao.StaffDAO;
import com.namuuniv.vo.ProfessorVO;

@WebServlet("/addProfessor")
public class ProfessorController extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ProfessorVO professor = new ProfessorVO();
		
		String hireDateStr = request.getParameter("hireDate");
		Date hireDateSql = null;
		if (hireDateStr != null && hireDateStr.isEmpty()) {
			hireDateSql = Date.valueOf(hireDateStr);
		}
		
		professor.setName(request.getParameter("name"));
		professor.setBirthDate(request.getParameter("birthDate"));
		professor.setGender(request.getParameter("gender"));
		professor.setAddress(request.getParameter("address"));
		professor.setTel(request.getParameter("tel"));
		professor.setHireDate(hireDateSql);
		professor.setDeptId(Integer.parseInt(request.getParameter("deptId")));
		
		int result = StaffDAO.insertProfessor(professor);
		if (result > 0) {
			response.sendRedirect("addProfessor.jsp");
		} else {
			request.setAttribute("error", "등록에 실패했습니다.");
			request.getRequestDispatcher("addProfessor.jsp").forward(request, response);
		}
		
	}
}
