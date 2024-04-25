package com.namuuniv.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.namuuniv.dao.SearchUpdateDAO;
import com.namuuniv.vo.ProfessorVO;
import com.namuuniv.vo.StaffVO;
import com.namuuniv.vo.StudentVO;
import com.namuuniv.vo.UsersVO;

@WebServlet("/mypage")
public class MypageController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("FrontController doGet() 실행~~~");

		String type = request.getParameter("type");
		System.out.println("작업형태 type : " + type);

		HttpSession session = request.getSession();
		UsersVO loginUser = (UsersVO)session.getAttribute("loginUser");
		System.out.println(loginUser.toString());
		int id = loginUser.getId();

		// 학생정보 조회
		if ("stu".equals(type)) {
			// 1. DB연결하고 데이터 가져오기
			StudentVO student = SearchUpdateDAO.getStuInfo(id);
			// 2. 페이지 전환 - 응답할 페이지(stu_check.jsp)로 전환(포워딩)
			// student/stu_check.jsp
			response.sendRedirect("stuCheck" + "?id=" + id);
		}

		// 교수정보 조회
		if ("pro".equals(type)) {
			System.out.println(">> list 요청 처리");
			// 1. DB연결하고 데이터 가져오기
			List<ProfessorVO> proList = SearchUpdateDAO.getProInfo(id);
			System.out.println("prolist : " + proList);
			// 2. 응답페이지(pro_check.jsp)에 전달
			request.setAttribute("list", proList);

			// 응답이 커밋되지 않았는지 확인하여 forward 수행
			if (!response.isCommitted()) {
				// 3. 페이지 전환 - 응답할 페이지(pro_check.jsp)로 전환(포워딩)
				request.getRequestDispatcher("professor/pro_check.jsp").forward(request, response);
			}
		}
		// 교직원 정보 조회
		if ("staff".equals(type)) {
			System.out.println(">> list 요청 처리");
			// 1. DB연결하고 데이터 가져오기
			List<StaffVO> staffList = SearchUpdateDAO.getStaffInfo(id);
			System.out.println("staffList : " + staffList);
			// 2. 응답페이지(staff_check.jsp)에 전달
			request.setAttribute("list", staffList);

			// 3. 페이지 전환 - 응답할 페이지(staff_check.jsp)로 전환(포워딩)
			request.getRequestDispatcher("staff/staff_check.jsp").forward(request, response);

		}

	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}
}