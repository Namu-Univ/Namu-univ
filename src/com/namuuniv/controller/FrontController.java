package com.namuuniv.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.sql.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.namuuniv.dao.ProfessorDAO;
import com.namuuniv.dao.StaffDAO;
import com.namuuniv.dao.StudentDAO;
import com.namuuniv.vo.ProfessorVO;
import com.namuuniv.vo.StaffVO;
import com.namuuniv.vo.StudentVO;

@WebServlet("/controller")
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("FrontController doGet() 실행~~~");

		String type = request.getParameter("type");
		System.out.println("작업형태 type : " + type);

		// 학생정보 조회
		if ("stu".equals(type)) {
			System.out.println(">> list 요청 처리");
			// 1. DB연결하고 데이터 가져오기
			List<StudentVO> stuList = StudentDAO.getStuInfo();
			System.out.println("stuList : " + stuList);
			// 2. 응답페이지(stu_check.jsp)에 전달
			request.setAttribute("list", stuList);

			// 3. 페이지 전환 - 응답할 페이지(stu_check.jsp)로 전환(포워딩)
			request.getRequestDispatcher("stu_check.jsp").forward(request, response);
		}

		// 교수정보 조회
		if ("pro".equals(type)) {
			System.out.println(">> list 요청 처리");
			// 1. DB연결하고 데이터 가져오기
			List<ProfessorVO> proList = ProfessorDAO.getProInfo();
			System.out.println("prolist : " + proList);
			// 2. 응답페이지(pro_check.jsp)에 전달
			request.setAttribute("list", proList);

			// 응답이 커밋되지 않았는지 확인하여 forward 수행
			if (!response.isCommitted()) {
				// 3. 페이지 전환 - 응답할 페이지(pro_check.jsp)로 전환(포워딩)
				request.getRequestDispatcher("pro_check.jsp").forward(request, response);
			}
		}
		// 교직원 정보 조회
		if ("staff".equals(type)) {
			System.out.println(">> list 요청 처리");
			// 1. DB연결하고 데이터 가져오기
			List<StaffVO> staffList = StaffDAO.getStaffInfo();
			System.out.println("staffList : " + staffList);
			// 2. 응답페이지(staff_check.jsp)에 전달
			request.setAttribute("list", staffList);

			// 응답이 커밋되지 않았는지 확인하여 forward 수행

			// 3. 페이지 전환 - 응답할 페이지(staff_check.jsp)로 전환(포워딩)
			request.getRequestDispatcher("staff_check.jsp").forward(request, response);

		}
		// 학생 정보 수정 폼으로 이동
		if ("editStudentForm".equals(type)) {
		    // editStudent.jsp로 포워딩
		    request.getRequestDispatcher("/editStudent.jsp").forward(request, response);
		}

	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String type = request.getParameter("type");
		// 학생 정보 수정 처리
		if ("editStudent".equals(type)) {
			int id = Integer.parseInt(request.getParameter("id"));
		    String name = request.getParameter("name");
		    String birthDate = request.getParameter("birthDate");
		    String gender = request.getParameter("gender");
		    String address = request.getParameter("address");
		    String tel = request.getParameter("tel");
		    int grade = Integer.parseInt(request.getParameter("grade"));
		    int semester = Integer.parseInt(request.getParameter("semester"));
		    String entranceDateStr = request.getParameter("entranceDate");
		    String graduationDateStr = request.getParameter("graduationDate");

		    // Date 형식으로 변환
		    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		    Date entranceDate = null;
		    Date graduationDate = null;
		    try {
		        entranceDate = new Date(dateFormat.parse(entranceDateStr).getTime());
		        graduationDate = new Date(dateFormat.parse(graduationDateStr).getTime());
		    } catch (ParseException e) {
		        e.printStackTrace();
		        // 날짜 형식이 잘못되었을 경우 처리
		    }

		    // 수정할 학생 정보 생성
		    StudentVO updatedStudent = new StudentVO();
		    updatedStudent.setId(id);
		    updatedStudent.setName(name);
		    updatedStudent.setBirthDate(birthDate);
		    updatedStudent.setGender(gender);
		    updatedStudent.setAddress(address);
		    updatedStudent.setTel(tel);
		    updatedStudent.setGrade(grade);
		    updatedStudent.setSemester(semester);
		    updatedStudent.setEntranceDate(entranceDate);
		    updatedStudent.setGraduationDate(graduationDate);

		    // 학생 정보 업데이트
		    boolean success = StudentDAO.updateStudent(updatedStudent);

		    if (success) {
		        List<StudentVO> stuList = StudentDAO.getStuInfo();
		        request.setAttribute("list", stuList);
		        request.getRequestDispatcher("stu_check.jsp").forward(request, response);
		    } else {
		    }
		}
	}
}