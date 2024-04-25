package com.namuuniv.controller;

import java.io.IOException;
import java.util.List;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.namuuniv.dao.CheckLeaveAbDAO;
import com.namuuniv.vo.StudentStatusVO;

@WebServlet("/checkLeave")
public class CheckLeaveAbController extends HttpServlet {

	@Override	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("FrontController doGet() 실행~~~");
		String studentId = req.getParameter("id");
		System.out.println("studentId : " + studentId);
		List<StudentStatusVO> leaveList = CheckLeaveAbDAO.getCheckLeave(studentId); // DAO로부터 휴학신청서 목록을 가져옴
		System.out.println("leaveList : " + leaveList);
		req.setAttribute("List", leaveList); // 가져온 목록을 request 속성에 설정

		// JSP로 포워드
		req.getRequestDispatcher("view_leaveAbsence.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
