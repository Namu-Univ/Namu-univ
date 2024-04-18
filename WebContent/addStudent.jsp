<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
		<input type="text" id="tel" name="tel" pattern="[0~9]{3}-[0~9]{4}-[0~9]{4}" placeholder="000-0000-0000"><br>
		
		<label>입학일</label>
		<input type="date" id="entranceDate" name="entranceDate" required><br>
		
		<label for="deptId">학과</label>
		<select id="deptId" name="deptId" required>
			<option value="" selected disabled>학과를 선택하세요</option>
			<option value="" disabled>---인문대학---</option>
			<option value="0001">언어학과</option>
			<option value="0002">철학과</option>
			<option value="0003">역사학과</option>
			<option value=""  disabled>---사회과학대학---</option>
			<option value="0004">경영학과</option>
			<option value="0005">정치외교학과</option>
			<option value="0006">심리학과</option>
			<option value=""  disabled>---자연과학대학---</option>
			<option value="0007">수학과</option>
			<option value="0008">물리학과</option>
			<option value="0009">화학과</option>
			<option value=""  disabled>---공과대학---</option>
			<option value="0010">컴퓨터공학과</option>
			<option value="0011">건축학과</option>
			<option value="0012">전자공학과</option>
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
		<label>졸업예정일</label>
	</form>
	
</body>
</html>