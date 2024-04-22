<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>내정보 조회(학생)</title>
</head>
<body>
	<h1>내정보 조회(학생)</h1>
	<table border="1">
		<tr>
			<th>ID</th>
			<th>학과 ID</th>
			<th>이름</th>
			<th>생년월일</th>
			<th>성별</th>
			<th>주소</th>
			<th>전화번호</th>
			<th>학년</th>
			<th>학기</th>
			<th>입학일</th>
			<th>졸업일</th>
			<th>수정</th>
		</tr>
		<c:forEach var="vo" items="${list}">
			<tr>
				<td>${vo.id}</td>
				<td>${vo.deptId}</td>
				<td>${vo.name}</td>
				<td>${vo.birthDate}</td>
				<td>${vo.gender}</td>
				<td>${vo.address}</td>
				<td>${vo.tel}</td>
				<td>${vo.grade}</td>
				<td>${vo.semester}</td>
				<td>${vo.entranceDate}</td>
				<td>${vo.graduationDate}</td>
				<!-- 수정 버튼 -->
				<td><a href="editStudent.jsp?id=${vo.id}">수정</a></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>
</body>
</html>
