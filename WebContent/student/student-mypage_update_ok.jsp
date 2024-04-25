<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>학생 정보 수정 결과</title>
</head>
<body>
    <h1>학생 정보 수정 결과</h1>
    <% if ((boolean) request.getAttribute("success")) { %>
        <p>학생 정보가 성공적으로 수정되었습니다.</p>
    <% } else { %>
        <p>학생 정보 수정에 실패했습니다.</p>
        <!-- 실패 시 사용자에게 알리고 다시 수정 페이지로 이동하도록 설정할 수 있음 -->
    <% } %>
    <a href="stu_check.jsp">돌아가기</a>
</body>
</html>
