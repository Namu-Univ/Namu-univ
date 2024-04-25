<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>교수 검색</title>
<link href="../css/frame.css" rel="stylesheet" type="text/css">
<link href="../css/table.css" rel="stylesheet" type="text/css">
</head>
<body>
	<div>
		<div>
		<div class="top">
			<a href="#">로그인</a>
		</div>
		<div class="nav">
			<div class="logo"><img src="../img/tree.png">나무대학교</div>
			  	<a href="staff-mypage.jsp">내정보</a>
				<a href="staff-student_search.jsp">조회</a>
				<a href="staff-add_student.jsp">등록/관리</a>
				<a href="#">공지사항</a>
			</div>
		</div>
		<div class="mid">
			<!-- Side navigation -->
			<div class="sidenav">
			  <a href="staff-student_search.jsp">학생 조회</a>
			  <a href="staff-professor_search.jsp">교수 조회</a>
			  <a href="staff-staff_search.jsp">교직원 조회</a>
			</div>
			
			<div class="maintop">교수 조회</div>
			
			<!-- Page content -->
			<div class="main">
				<form action="SearchProfessor" method="get">
					<select name="idx">
						<option value="0">이름</option>
						<option value="1">교번</option>
						<option value="2">전공</option>
					</select>
					<input type="text" name="keyword">
					<input type="submit" value="검색">
				</form>
			
				<table border="1">
					<thead>
						<th>교번</th>
						<th>이름</th>
						<th>학과</th>
						<th>연락처</th>
					</thead>
					<c:forEach var="vo" items="${list }">
						
						<tbody>
							<td>${vo.id }</td>
							<td><a href="professor_search_profile.jsp?id=${vo.id}">${vo.name }</td>
							<td>${vo.deptName }</td>
							<td>${vo.tel }</td>
						</tbody>
					</c:forEach>
					<c:if test="${empty list }">
						<tr>
							<td colspan="5">조회된 사람이 없습니다.</td>
						</tr>
					</c:if>
				</table>
			</div>
		</div>
	</div>

	
</body>
</html>