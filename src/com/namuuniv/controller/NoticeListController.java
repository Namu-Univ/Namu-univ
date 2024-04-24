package com.namuuniv.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.namuuniv.dao.NoticeDAO;
import com.namuuniv.vo.NoticeVO;
import com.namuuniv.vo.PagingVO;

@WebServlet("/noticeList")
public class NoticeListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Integer userId = (Integer) request.getSession().getAttribute("id");
		
		// 교직원 여부 확인
		boolean isStaff = false;
		if (userId != null) {
			isStaff = NoticeDAO.checkStaff(userId);
		}
		
		// 현재 페이지 번호
		String cPage = request.getParameter("cPage");
		if (cPage == null || cPage.trim().isEmpty()) {
			cPage = "1";
		}
		int currentPage = Integer.parseInt(cPage);
		
		// 페이징 처리
		PagingVO pvo = new PagingVO();
		pvo.setNowPage(currentPage);
		pvo.setTotalRecord(NoticeDAO.totalNoticeCount());
		pvo.calculatePaging();
		
		// 현재 페이지에 해당하는 공지 목록
		List<NoticeVO> list = NoticeDAO.noticeList(pvo.getBegin(), pvo.getEnd());
		
		request.setAttribute("pvo", pvo);
		request.setAttribute("list", list);
		request.setAttribute("isStaff", isStaff);
		
		request.getRequestDispatcher("notice_list").forward(request, response);
		
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
}
