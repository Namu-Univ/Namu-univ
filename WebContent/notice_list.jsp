<%@page import="com.namuuniv.vo.UsersVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>공지사항</title>
</head>
<body>
	
	<table border="1">
		<thead>
			<tr class="title">
				<th>번호</th>
				<th>제목</th>
				<th>작성자</th>
				<th>날짜</th>
				<th>조회수</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${list}" var="notice">
				<tr>
					<td>${notice.id }</td>
					<td>${notice.title}</td>
					<td>${notice.staffName}</td>
					<td>
						<c:if test="${not empty notice.created}">
							<fmt:formatDate value="${notice.created}" pattern="yyyy.MM.dd"/>
						</c:if>
					</td>
					<td>${notice.views }</td>
				</tr>
			</c:forEach>
		</tbody>
		<tfoot>
			<tr>
				<td colspan = "4">
					<div class="paging">
					<c:if test="{pvo.beginPage == 1}">
						<span class="disable">&laquo;</span>
					</c:if>
					<c:if test="{pvo.beginPage != 1}">
						<a href="notice_list.jsp?cPage=${pvo.beginPage - 1}">&laquo;</a>
					</c:if>
						<c:if test="${pvo.nowBlock == 1}">
							<span class="disabled">&laquo;</span>
						</c:if>
						
						<c:forEach var="page" begin="${pvo.beginPage}" end="${pvo.endPage}">
							<c:choose>
								<c:when test="${page == pvo.nowPage}">
									<span>${page}</span>
								</c:when>
								<c:otherwise>
									<a href="notice_list.jsp?cPage=${page}">${page}</a>
								</c:otherwise>
							</c:choose>
						</c:forEach>
						
						<c:if test="${pvo.endPage < pvo.totalPage}">
							<a href="notice_list.jsp?cPage=${pvo.endPage + 1}">&raquo;</a>
						</c:if>
						<c:if test="${pvo.endPage >= pvo.totalPage}">
							<span class="disable">&raquo;</span>
						</c:if>
					</div>
				</td>
				<td>
					<c:if test="${isStaff }">
						<button onclick="location.href='staff_write_notice.jsp'">글작성</button>
					</c:if>
				</td>
			</tr>
		</tfoot>
		
	</table>
	
</body>
</html>