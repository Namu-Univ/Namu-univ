<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>교직원 내 정보</title>
</head>
<body>
	<p>교직원 내 정보</p>
	<p><%=session.getAttribute("id") %></p>
</body>
</html>