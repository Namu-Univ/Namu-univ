package com.namuuniv.command;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.namuuniv.dao.StaffDAO;
import com.namuuniv.dao.StudentDAO;
import com.namuuniv.vo.StaffVO;
import com.namuuniv.vo.StudentVO;

public class Staff_CheckCommand {

	public String exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println(">> list 요청 처리");
		// 1. DB연결하고 데이터 가져오기
		List<StaffVO> stafflist = StaffDAO.getStaffInfo();

		// 2. 응답페이지(staff_check.jsp)에 전달
		request.setAttribute("list", stafflist);

		// 3. 페이지 전환 - 응답할 페이지(staff_check.jsp)로 전환(포워딩)

		return "staff_check.jsp";
	}
}
