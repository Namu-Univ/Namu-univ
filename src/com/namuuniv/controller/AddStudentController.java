package com.namuuniv.controller;

import java.io.IOException;
import java.sql.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.namuuniv.dao.StaffDAO;
import com.namuuniv.vo.DepartmentVO;
import com.namuuniv.vo.StudentVO;

@WebServlet("/addStudent")
public class AddStudentController extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<DepartmentVO> departments = StaffDAO.getAllDepts();
		request.setAttribute("departments", departments);
		request.getRequestDispatcher("addStudent.jsp").forward(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		StudentVO student = new StudentVO();
		
		String entranceDateStr = request.getParameter("entranceDate");
		Date entranceDateSql = Date.valueOf(entranceDateStr);
		String graduationDateStr = request.getParameter("graduationDate");
		Date graduationDateSql = null;
		if (graduationDateStr != null && !graduationDateStr.isEmpty()) {
			graduationDateSql = Date.valueOf(graduationDateStr);
		}

		student.setName(request.getParameter("name"));
		student.setBirthDate(request.getParameter("birthDate"));
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
			request.setAttribute("result", "success");
		} else {
			request.setAttribute("result", "fail");
		}
		request.getRequestDispatcher("addStaff.jsp").forward(request, response);
		
	}
}
