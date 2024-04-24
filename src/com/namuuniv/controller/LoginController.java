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
		
		String id = (String)request.getParameter("id");
		String pw = (String)request.getParameter("password");
		
		//System.out.println("id : " + id);
		//System.out.println("pw : " + pw);
		
		HttpSession session = request.getSession();
		
		List<UsersVO> loginChk = LoginDAO.getLogin(id, pw);
		List<UsersVO> role = LoginDAO.getRole(id);
		//System.out.println(" loginChk : " + loginChk);
		
		String errorMsg = "";
		String userRole = "";
		UsersVO user;
		try {
			//System.out.println("role: " + userRole);
			
			if (!loginChk.isEmpty()) {
				user = role.get(0);
				userRole = user.getRole();
				session.setAttribute("id", id);
				session.setAttribute("role", userRole);
				//System.out.println("저장된 id : " + id);
				
				// 학생 내정보로 이동
				if(userRole.equals("student")) {				
					request.getRequestDispatcher("studentMypage.jsp").forward(request, response);
				} else if(userRole.equals("professor")) {
					request.getRequestDispatcher("professorMypage.jsp").forward(request, response);
				} else if(userRole.equals("staff")) {
					request.getRequestDispatcher("staffMypage.jsp").forward(request, response);
				} else {
					errorMsg = "로그인 오류 : 관리자에게 문의바랍니다.";
					request.setAttribute("errorMsg", errorMsg);
					request.getRequestDispatcher("login.jsp").forward(request, response);
				}
			}
			else {
				errorMsg = "아이디 또는 비밀번호를 다시 입력바랍니다.";
				request.setAttribute("errorMsg", errorMsg);
				System.out.println("로그인 실패");
				
				request.getRequestDispatcher("login.jsp").forward(request, response);
			}
		} catch (IndexOutOfBoundsException i) {
			errorMsg = "아이디 또는 비밀번호를 입력하세요.";
			request.setAttribute("errorMsg", errorMsg);

			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
