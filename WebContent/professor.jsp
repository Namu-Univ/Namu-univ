<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>내정보(교수)</title>
<link href="css/frame.css" rel="stylesheet" type="text/css">
</head>
<script>
	function pro_check(frm) {
		frm.action = "controller?type=pro";
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
			<div class="logo"><img src="img/tree.png">나무대학교</div>
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
			  <a href="controller?type=pro">내정보</a>
			  <a href="editProfessor.jsp">정보수정</a>
			</div>
			
			<div class="maintop">내정보 조회</div>
		</div>
	</div>	
</body>
</html>