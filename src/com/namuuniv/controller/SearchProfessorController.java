package com.namuuniv.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.namuuniv.dao.ProfileSearchDAO;
import com.namuuniv.vo.ProfessorVO;

@WebServlet("/SearchProfessor")
public class SearchProfessorController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println(":: SearchController doGet()실행");
		
		String idx = req.getParameter("idx");
		String keyword = req.getParameter("keyword");
		System.out.println("idx" + idx + "keyword" + keyword);
		
		//단순 페이지 전환인지 DB데이터 조회(검색)처리를 해야 하는지 결정해서 처리
		if(keyword == null || keyword.trim().length() == 0) {
			//검색을 위한 검색어 입력 (화면)페이지로 이동
			req.getRequestDispatcher("staff-professor_search.jsp").forward(req, resp);
			return;
		}
		//동적검색 처리 작업 진행
		System.out.println(">>>동적검색 처리 작업 진행");
		List<ProfessorVO> list = ProfileSearchDAO.getProfessorSearch(idx, keyword);
		System.out.println("list: " + list);
		
		//동적검색 작업 형태 확인
		String title ="";
		switch (idx) {
		case "0" : title = "이름"; break;
		case "1" : title = "교번"; break;
		case "2" : title = "전공"; break;
		default:
				title = "선택안함";
		}
		
		//동적검색 결과 데이터 응답페이지로 전달
		req.setAttribute("list", list);
		req.setAttribute("title", title);
		
		//페이지 전환(searchList.jsp 페이지에 위임)
		req.getRequestDispatcher("staff-professor_search.jsp").forward(req, resp);
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println(":: SearchController doPost()실행");
		req.setCharacterEncoding("UTF-8");
		doGet(req, resp);
	}
}
