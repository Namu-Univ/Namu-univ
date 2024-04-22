<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>교직원 등록</title>
<link href="css/registration.css" rel="stylesheet">
</head>
<body>
	<h1>교직원 등록</h1>
	
	<div class="main">
	<form action="addStaff" method="post">
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
					<input type="radio" id="female" name="gender" value="F">여성<br>
				</div>
				</td>
			</tr>
			<tr>
				<td><label for="address">주소</label></td>
				<td><input type="text" id="address" name="address"></td>
			</tr>
			<tr>
				<td><label for="tel">전화번호</label></td>
				<td><input type="text" id="tel" name="tel" pattern="[0-9]{3}-[0-9]{4}-[0-9]{4}" placeholder="000-0000-0000"></td>
			</tr>
			<tr>
				<td><label for="hireDate">고용일</label></td>
				<td><input type="date" id="hireDate" name="hireDate"></td>
			</tr>
			<tr>
				<td><label for="dept">부서</label></td>
				<td><select id="dept" name="dept">
					<option value="" selected disabled>부서를 선택하세요</option>
					<option value="교무처">교무처</option>
					<option value="학생처">학생처</option>
					<option value="사무국">사무국</option>
				</select></td>		
			</tr>
		</table>
		<div class="button">
			<input type="submit" value="등록">
		</div>
	</form>
	</div>
	
	<script>
		//페이지 전환처리
		window.onload = function() {
		    var result = "<c:out value='${result}'/>";
		    if (result == "success") {
		        if (confirm('등록이 완료되었습니다. 계속 등록하시겠습니까?')) {
		            window.location.reload(); // 페이지 새로고침
		        } else {
		            window.location.href = 'viewStaffs.jsp'; //조회페이지 이동
		        }
		    } else if (result == "fail") {
		        alert('등록에 실패했습니다.');
		    }
		}
	</script>
   
</body>
</html>