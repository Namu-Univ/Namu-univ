<%@page import="com.namuuniv.vo.StudentStatusVO"%>
<%@page import="java.util.List"%>
<%@page import="com.namuuniv.dao.CheckLeaveAbDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="css/frame.css" rel="stylesheet" type="text/css">
<script>
	function check_leave(frm) {
		frm.action = "controller?Type=checkLeave";
		frm.submit();
	}
</script>
<style>
/* 테이블 스타일 */
.student-status {
	border-collapse: collapse;
	width: 100%;
}

.student-status th, .student-status td {
	border: 1px solid #ddd;
	padding: 8px;
	text-align: center;
}

.student-status th {
	background-color: #f2f2f2;
}
</style>
</head>
<body>
	<div>
		<div class="top">
			<a href="#">로그인</a>
		</div>
		<div class="nav">
			<div class="logo">
				<img src="img/tree.png">나무대학교
			</div>
			<div class="topnav">
				<a href="#">내정보</a>
				<a href="staff-student_search.jsp">조회</a>
				<a href="#">등록/관리</a>
				<a href="#">공지사항</a>
			</div>
		</div>
		<div class="mid">
			<!-- Side navigation -->
			<div class="sidenav">
				<a href="#">학생/교수 등록</a>
				 <a href="#">교직원 등록</a>
				  <a href="#">학생휴학</a>
			</div>

			<div class="maintop">학생 학적 관리</div>

			<!-- Page content -->
			<div class="main">
				<table class="student-status" border="1">
					<thead>
						<tr>
							<th>신청일</th>
							<th>학번</th>
							<th>시작학기</th>
							<th>종료학기</th>
							<th>신청서 확인</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="vo" items="${list}">
							<tr>
								<td>${vo.reporingDate}</td>
								<td>${vo.id}</td>
								<td>${vo.startSemester}</td>
								<td>${vo.finishSemester}</td>
								<td><a href="checkLeave?id=${vo.id}">확인하기</a></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</div>
</body>
</html>
