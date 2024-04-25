package com.namuuniv.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.namuuniv.dao.SearchUpdateDAO;
import com.namuuniv.vo.StudentVO;
import com.namuuniv.vo.UsersVO;

@WebServlet("/editStudent")
public class Student_EditController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 학생 정보수정
		request.getRequestDispatcher("student/staff-mypage_update.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 학생 정보 수정 처리
		HttpSession session = request.getSession();
		UsersVO user = (UsersVO)session.getAttribute("loginUser");
		String name = request.getParameter("name");
		String birthDate = request.getParameter("birthDate");
		String gender = request.getParameter("gender");
		String address = request.getParameter("address");
		String tel = request.getParameter("tel");

		// 학생 정보 업데이트
		StudentVO student = new StudentVO();
		student.setId(user.getId());
		student.setName(name);
		student.setBirthDate(birthDate);
		student.setGender(gender);
		student.setAddress(address);
		student.setTel(tel);

		System.out.println(student.toString());
		boolean editStuSuccess = SearchUpdateDAO.updateStudent(student); // StudentDAO에서 updateStudent 메서드를 정의해야 함
		System.out.println();

		if (editStuSuccess) {
			session.setAttribute("loginUser", student);
			// 수정 완료 후 stu_check.jsp로 리다이렉트
			response.sendRedirect("mypage?type=stu");
		} else {

		}
	}

}
