package com.namuuniv.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.namuuniv.dao.SearchUpdateDAO;
import com.namuuniv.vo.StaffVO;

@WebServlet("/editStaff")
public class Staff_EditController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 교직원 정보수정
		request.getRequestDispatcher("staff/staff-mypage_update.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 교직원 정보 수정
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String address = request.getParameter("address");
		String tel = request.getParameter("tel");
		String dept = request.getParameter("dept");

		StaffVO staff = new StaffVO();
		staff.setId(id);
		staff.setName(name);
		staff.setAddress(address);
		staff.setTel(tel);
		staff.setDept(dept);

		System.out.println(staff.toString());
		boolean editStaffSuccess = SearchUpdateDAO.updateStaff(staff);
		if (editStaffSuccess) {
			// 수정 완료 후 staff_check.jsp 로 이동
			response.sendRedirect("controller?type=staff");
		} else {

		}
	}

}
