package com.namuuniv.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.namuuniv.dao.StaffDAO;
import com.namuuniv.vo.StaffVO;

@WebServlet("/editStaff")
public class Staff_EditController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 교직원 정보수정
		request.getParameter("id");
		request.setAttribute("id", request.getParameter("id"));
		request.getRequestDispatcher("editStaff.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 교직원 정보 수정
		request.setCharacterEncoding("UTF-8");

		int id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");
		String birthDate = request.getParameter("birthDate");
		String address = request.getParameter("address");
		String tel = request.getParameter("tel");
		String dept = request.getParameter("dept");

		StaffVO staff = new StaffVO();
		staff.setId(id);
		staff.setName(name);
		staff.setBirthDate(birthDate);
		staff.setAddress(address);
		staff.setTel(tel);
		staff.setDept(dept);

		System.out.println(staff.toString());
		boolean editStaffSuccess = StaffDAO.updateStaff(staff);
		if (editStaffSuccess) {
			// 수정 완료 후 staff_check.jsp 로 이동
			response.sendRedirect("controller?type=staff");
		} else {

		}
	}

}
