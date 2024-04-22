package com.namuuniv.controller;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.namuuniv.dao.StaffDAO;
import com.namuuniv.vo.StaffVO;

@WebServlet("/addStaff")
public class AddStaffController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//System.out.println("addStaff doGet()");
		doPost(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//System.out.println("addStaff doPost()");
		request.setCharacterEncoding("UTF-8");
		
		StaffVO staff = new StaffVO();
		
		// 파라미터 값을 문자열로 받아와서 sql.Date 객체로 변환
		String hireDateStr = request.getParameter("hireDate");
		Date hireDateSql = null;
		if (hireDateStr != null && !hireDateStr.isEmpty()) {
			hireDateSql = Date.valueOf(hireDateStr);
		}
		
		staff.setName(request.getParameter("name"));
		staff.setBirthDate(request.getParameter("birthDate"));
		staff.setGender(request.getParameter("gender"));
		staff.setAddress(request.getParameter("address"));
		staff.setTel(request.getParameter("tel"));
		staff.setHireDate(hireDateSql);
		staff.setDept(request.getParameter("dept"));
		
		int result = StaffDAO.insertStaff(staff);
		if (result > 0) {
			request.setAttribute("result", "success");
		} else {
			request.setAttribute("result", "fail");
		}
		request.getRequestDispatcher("addStaff.jsp").forward(request, response);
	}

}
