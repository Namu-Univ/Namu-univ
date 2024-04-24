package com.namuuniv.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.namuuniv.dao.ProfessorDAO;
import com.namuuniv.dao.StudentDAO;
import com.namuuniv.vo.ProfessorVO;

@WebServlet("/editProfessor")
public class professor_EditController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 교수 정보수정
		request.getParameter("id");
		request.setAttribute("id", request.getParameter("id"));
		request.getRequestDispatcher("editProfessor.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 교수 정보수정
		request.setCharacterEncoding("UTF-8");

		int id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");
		String birthDate = request.getParameter("birthDate");
		String address = request.getParameter("address");
		String tel = request.getParameter("tel");

		ProfessorVO professor = new ProfessorVO();
		professor.setId(id);
	    professor.setName(name);
	    professor.setBirthDate(birthDate);
	    professor.setAddress(address);
	    professor.setTel(tel);
	    
		System.out.println(professor.toString());
		boolean editProSuccess = ProfessorDAO.updateProfessor(professor);
		System.out.println();

		if (editProSuccess) {
			// 수정 완료 후 pro_check.jsp로 리다이렉트
			response.sendRedirect("controller?type=pro");
		} else {

		}
	}
}
