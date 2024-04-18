package com.namuuniv.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.namuuniv.model.dao.LoginDAO;
import com.namuuniv.vo.UsersVO;

@WebServlet("/LoginController")
public class LoginController extends HttpServlet  {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println(">> login 요청 처리");
		
		int id = Integer.parseInt(request.getParameter("id"));
		String pw = (String)request.getParameter("password");
		
		System.out.println("id : " + id);
		System.out.println("pw : " + pw);
		
		HttpSession session = request.getSession();
		
		List<UsersVO> login = LoginDAO.getLogin(id, pw);
		
		// 세션 생성
		if (!login.equals(null)) {
			session.setAttribute("id", id);
			System.out.println("저장된 id : " + id);
			request.getRequestDispatcher("mypage.jsp").forward(request, response);
		}
		else {
			System.out.println("로그인 실패");
			response.sendRedirect("login.jsp");
		}

		request.setAttribute("id", id);

		
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		super.doPost(request, response);
	}
}
