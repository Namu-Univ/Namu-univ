<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>교직원 등록</title>
</head>
<body>
	<h1>교직원 등록</h1>
	
	<form action="addStaff" method="post">
		<label for="name">이름</label>
		<input type="text" id="name" name="name" required><br>
		
		<label for="birthDate">생년월일</label>
		<input type="date" id="birthDate" name="birthDate" required><br>
		
		<label>성별</label>
		<input type="radio" id="male" name="gender" value="M" checked>남성
		<input type="radio" id="female" name="gender" value="F">여성<br>
		
		<label for="address">주소</label>
		<input type="text" id="address" name="address"><br>
		
		<label for="tel">전화번호</label>
		<input type="text" id="tel" name="tel" pattern="[0-9]{3}-[0-9]{4}-[0-9]{4}" placeholder="000-0000-0000"><br>
		
		<label for="hireDate">고용일</label>
		<input type="date" id="hireDate" name="hireDate"><br>
		
		<label for="dept">부서</label>
		<select id="dept" name="dept">
			<option value="" selected disabled>부서를 선택하세요</option>
			<option value="교무처">교무처</option>
			<option value="학생처">학생처</option>
			<option value="사무국">사무국</option>
		</select><br>
		
		<input type="submit" value="등록">
	</form>
		
	<%-- 오류 메시지 --%>
	<c:if test="${not empty error}">
	    <script>
	        alert('${error}');
	    </script>
	</c:if>
	
</body>
</html>