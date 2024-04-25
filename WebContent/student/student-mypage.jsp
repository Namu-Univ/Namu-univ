<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>내정보(학생)</title>
<link href="css/frame.css" rel="stylesheet" type="text/css">

<script>
	function stu_check(frm) {
		//frm.action = "student/stu_check.jsp";
		frm.action = "mypage?type=stu";
		frm.submit();
	}
</script>
</head>
<body>
	<div>
		<div>
			<div class="top">
				<a href="#">로그인</a>
			</div>
			<div class="nav">
				<div class="logo">
					<img src="img/tree.png">나무대학교
				</div>
				<div class="topnav">
					<a href="mypage?type=stu">내정보</a>
		            <a href="#">휴학신청</a>
		            <a href="#">등록/관리</a>
		            <a href="#">공지사항</a>
				</div>
			</div>
			<div class="mid">
				<!-- Side navigation -->
				<div class="sidenav">
					<a href="mypage?type=stu">내정보</a>
					<a href="editStudent">정보수정</a>
				</div>

				<div class="maintop">내정보 조회</div>
				</div>
			</div>
		</div>
</body>
</html>
