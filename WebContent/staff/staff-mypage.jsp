<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>내정보(교직원)</title>
<link href="css/frame.css" rel="stylesheet" type="text/css">
</head>
	<script>
		function staff_check(frm) {
			frm.action = "mypage?type=staff";
			frm.submit();
		}
	</script>
<body>
	<div>
		<div>
			<div class="top">
				<a href="#">로그인</a>
			</div>
			<div class="nav">
				<div class="logo">
					<img src="img/tree.png" alt="나무대학교 로고">나무대학교
				</div>
				<div class="topnav">
					<a href="staff-mypage.jsp">내정보</a>
					<a href="staff-student_search.jsp">조회</a>
					<a href="staff-add_student.jsp">등록/관리</a>
					<a href="#">공지사항</a> 
				</div>
			</div>
			<div class="mid">
				<!-- Side navigation -->
				<div class="sidenav">
					<a href="mypage?type=staff">내정보</a>
					<a href="editStaff.jsp">정보수정</a>
				</div>

				<div class="maintop">내정보 조회</div>
				<!-- Page content -->
			</div>
		</div>
	</div>
	
</body>
</html>
