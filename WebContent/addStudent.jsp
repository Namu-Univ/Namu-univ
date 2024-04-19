<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>     
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>학생 등록</title>
</head>
<body>
	<h1>학생 등록</h1>
	
	<form action="addStudent" method="post">
		<label>이름</label>
		<input type="text" id="name" name="name" required><br>
		
		<label>생년월일</label>
		<input type="date" id="birthDate" name="birthDate" required><br>
		
		<label>성별</label>
		<input type="radio" id="male" name="gender" value="M" checked>남성
		<input type="radio" id="female" name="gender" value="F">여성<br>
		
		<label>주소</label>
		<input type="text" id="address" name="address"><br>
		
		<label>전화번호</label>
		<input type="text" id="tel" name="tel" pattern="[0-9]{3}-[0-9]{4}-[0-9]{4}" placeholder="000-0000-0000"><br>
		
		<label>입학일</label>
		<input type="date" id="entranceDate" name="entranceDate" required><br>
		
		<label for="deptId">학과</label>
        <select id="deptId" name="deptId" required>
            <option value="" selected disabled>학과를 선택하세요</option>
            <c:forEach items="${departments}" var="dept">
                <option value="${dept.id}">${dept.name}</option>
            </c:forEach>
        </select><br>
		
		<label for="grade">학년</label>
		<select id="grade" name="grade" required>
			<option value="" selected disabled>학년을 선택하세요</option>
			<option value="1">1학년</option>
			<option value="2">2학년</option>
			<option value="3">3학년</option>
			<option value="4">4학년</option>
		</select><br>
		
		<label for="semester">학기</label>
		<select id="semester" name="semester" required>
			<option value="" selected disabled>학기를 선택하세요</option>
			<option value="1">1학기</option>
			<option value="2">2학기</option>
		</select><br>
		
		<label>졸업예정일</label>
		<input type="date" id="graduationDate" name="graduationDate"><br>
		
		<input type="submit" value="등록">
	</form>
	
	<c:if test="${not empty error}">
	    <script>
	        alert('${error}');
	    </script>
	</c:if>
	
</body>
</html>