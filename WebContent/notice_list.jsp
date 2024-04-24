<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>공지사항</title>
</head>
<body>
	<c:if test="${isStaff }">
		<button onclick="location.href='staff_write_notice.jsp'">글작성</button>
	</c:if>
	
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
		
		</tbody>
	</table>
	
	
	
</body>
</html>