<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>교수 등록</title>
<link href="../css/registration.css" rel="stylesheet">
<link href="../css/frame.css" rel="stylesheet" type="text/css">
</head>
<body>
	<div>
		<div>
		<div class="top">
			<a href="#">로그인</a>
		</div>
		<div class="nav">
			<div class="logo"><img src="../img/tree.png">나무대학교</div>
			  <div class="topnav">
				  <a href="#">내정보</a>
				  <a href="staff-student_search.jsp">조회</a>
				  <a href="#">등록/관리</a>
				  <a href="#">공지사항</a> 
			 </div>
		</div>
		<div class="mid">
			<!-- Side navigation -->
			<div class="sidenav">
			  <a href="addStudent.jsp">학생 등록</a>
			  <a href="addProfessor.jsp">교수 등록</a>
			  <a href="addStaff.jsp">교직원 등록</a>
			  <a href="#">학적 관리</a>
			</div>
			
			<div class="maintop">교수 등록</div>
			
			<!-- Page content -->
			<div class="main">
				<div class="container">
				<form action="addProfessor">
					<table>
						<tr>
							<td><label for="name">이름</label></td>
							<td><input type="text" id="name" name="name" required></td>
						</tr>
						<tr>
							<td><label for="birthDate">생년월일</label></td>
							<td><input type="date" id="birthDate" name="birthDate" required></td>
						</tr>
						<tr>
							<td><label>성별</label></td>
							<td>
							<div class="radio">
								<input type="radio" id="male" name="gender" value="M" checked>남성
							</div>
							<div class="radio">
								<input type="radio" id="female" name="gender" value="F">여성
							</div>
							</td>
						</tr>
						<tr>
							<td><label for="address">주소</label></td>
							<td><input type="text" id="address" name="address"></td>
						</tr>
						<tr>
							<td><label for="tel">전화번호</label></td>
							<td><input type="text" id="tel" name="tel" pattern="[0-9]{3}[0-9]{4}[0-9]{4}" placeholder="000-0000-0000"></td>
						</tr>
						<tr>
							<td><label for="hireDate">고용일</label></td>
							<td><input type="date" id="hireDate" name="hireDate"></td>
						</tr>
						<tr>
							<td><label for="deptId">학과</label></td>
							<td><select id="deptId" name="deptId" required>
								<option value="" selected disabled>학과를 선택하세요</option>
								<c:forEach items="${departments}" var="dept">
									<option value="${dept.id}">${dept.name}</option>
								</c:forEach>
							</select></td>
						</tr>
					</table>
					<div class="button">
						<input type="submit" value="등록">
					</div>
				</form>
				</div>
			</div>
		</div>
	   </div>
    </div>
	<script>
		window.onload = function() {
			var result = "<c:out value='${rewult}'/>";
			if (result == "success") {
				if (confirm('등록이 완료되었습니다. 계속 등록하시겠습니까?')) {
					window.location.reload();
				} else {
					window.location.href = 'staff-professor_search.jsp';
				}
			} else if (result == "fail") {
				alert('등록에 실패했습니다.');
			}
		}
	</script>
</body>
</html>
