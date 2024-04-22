<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>내정보(교직원)</title>
</head>
<script>
	function staff_check(frm) {
		frm.action = "controller?type=staff";
		frm.submit();
	}
</script>
<body>
	<h1>내정보(교직원)</h1>
	<form method="post">
		<input type="button" value="교직원정보조회" onclick="staff_check(this.form)">
	</form>
</body>
</html>