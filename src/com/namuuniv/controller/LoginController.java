package com.namuuniv.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.namuuniv.dao.LoginDAO;
import com.namuuniv.vo.UsersVO;

@WebServlet("/login")
public class LoginController extends HttpServlet  {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.getRequestDispatcher("login.jsp").forward(request, response);
//		try {
//			
//			if (!loginChk.isEmpty()) {
//				user = role.get(0);
//				userRole = user.getRole();
//				session.setAttribute("id", id);
//				session.setAttribute("role", userRole);
//				//System.out.println("저장된 id : " + id);
//				
//				 else {
//					errorMsg = "로그인 오류 : 관리자에게 문의바랍니다.";
//					request.setAttribute("errorMsg", errorMsg);
//					request.getRequestDispatcher("login.jsp").forward(request, response);
//				}
//			}
//			else {
//				errorMsg = "아이디 또는 비밀번호를 다시 입력바랍니다.";
//				request.setAttribute("errorMsg", errorMsg);
//				System.out.println("로그인 실패");
//				
//				request.getRequestDispatcher("login.jsp").forward(request, response);
//			}
//		} catch (IndexOutOfBoundsException i) {
//			errorMsg = "아이디 또는 비밀번호를 입력하세요.";
//			request.setAttribute("errorMsg", errorMsg);
//
//			request.getRequestDispatcher("login.jsp").forward(request, response);
//		}
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UsersVO reqUser = new UsersVO();
		reqUser.setId(request.getParameter("id"));
		reqUser.setPassword(request.getParameter("password"));
		
		HttpSession session = request.getSession();
		
		UsersVO loginChk = LoginDAO.getLogin(reqUser);
		System.out.println(loginChk.toString());
		
		// 학생 내정보로 이동
		if (loginChk == null) {
			String errorMsg = "로그인 오류 : 관리자에게 문의바랍니다.";
			request.setAttribute("errorMsg", errorMsg);
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
		
		String userRole = loginChk.getRole();
		session.setAttribute("loginUser", loginChk);

		if(userRole.equals("student")) {				
			//request.getRequestDispatcher("mypage?type=stu").forward(request, response);
			response.sendRedirect("mypage?type=stu");
		} else if(userRole.equals("professor")) {
			//request.getRequestDispatcher("mypage?type=pro").forward(request, response);
			response.sendRedirect("mypage?type=pro");
		} else if(userRole.equals("staff")) {
			//request.getRequestDispatcher("mypage?type=staff").forward(request, response);
			response.sendRedirect("mypage?type=staff");
		}
	}
}
