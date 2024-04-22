<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>내정보(학생)</title>
</head>
<script>
	function stu_check(frm) {
		frm.action = "controller?type=stu";
		frm.submit();
	}
</script>
<body>
	<h1>내정보(학생)</h1>
	<form method="post">
		<input type="button" value="학생정보조회" onclick="stu_check(this.form)">
	</form>
</body>
</html>