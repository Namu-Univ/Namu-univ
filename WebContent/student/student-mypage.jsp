<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>내정보(학생)</title>
<!-- <link href="css/frame.css" rel="stylesheet" type="text/css"> -->
<jsp:include page="../css/frameCss.jsp"/>
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
			<jsp:include page="../partials/navTop.jsp"/>
			<div class="mid">
				<jsp:include page="../partials/sideNav.jsp"/>
				<div class="maintop">내정보 조회</div>
				</div>
			</div>
		</div>
</body>
</html>
