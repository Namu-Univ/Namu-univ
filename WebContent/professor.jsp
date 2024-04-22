<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>내정보(교수)</title>
</head>
<script>
	function pro_check(frm) {
		frm.action = "controller?type=pro";
		frm.submit();
	}
</script>
<body>
	<h1>내정보(교수)</h1>
	<form method="post">
		<input type="button" value="교수정보조회" onclick="pro_check(this.form)">
	</form>
</body>
</html>