<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>학생 내정보</title>
</head>
<body>
	<h1>학생 내정보 페이지</h1>
	<p><%=session.getAttribute("id") %></p>
</body>
</html>