package com.namuuniv.controller;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.namuuniv.dao.StaffDAO;
import com.namuuniv.vo.StudentVO;

@WebServlet("/addStudent")
public class AddStudentController extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		StudentVO student = new StudentVO();
		
		String birthDateStr = request.getParameter("birthDate");
		Date birthDateSql = Date.valueOf(birthDateStr);
		String entranceDateStr = request.getParameter("entranceDate");
		Date entranceDateSql = Date.valueOf(entranceDateStr);
		String graduationDateStr = request.getParameter("graduationDate");
		Date graduationDateSql = Date.valueOf(graduationDateStr);

		student.setName(request.getParameter("name"));
		student.setBirthDate(birthDateSql);
		student.setGender(request.getParameter("gender"));
		student.setAddress(request.getParameter("address"));
		student.setTel(request.getParameter("tel"));
		student.setEntranceDate(entranceDateSql);
		student.setDeptId(Integer.parseInt(request.getParameter("deptId")));
		student.setGrade(Integer.parseInt(request.getParameter("grade")));
		student.setSemester(Integer.parseInt(request.getParameter("semester")));
		student.setGraduationDate(graduationDateSql);
		
		int result = StaffDAO.insertStudent(student);
		if (result > 0) {
			response.sendRedirect("addStudent.jsp");
		} else {
			request.setAttribute("error", "등록에 실패했습니다.");
			request.getRequestDispatcher("addStudent.jsp").forward(request, response);
		}
		
	}
	
}
