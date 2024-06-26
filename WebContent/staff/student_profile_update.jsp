<%@page import="com.namuuniv.dao.SearchDAO"%>
<%@page import="com.namuuniv.vo.StaffVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>학생 정보 수정</title>
<script>
	function save_go(frm){
		frm.action = "student_update_ok.jsp"; //db수정처리
		frm.submit();
	}
</script>
</head>
<body>

	<form method="get">
		<table class="profile">
			<tbody>
				<tr>
					<td>이름</td>
					<td><input type="text" name="name" value="${StudentVO.name }"></td>
					<td>학과</td>
					<td>${StudentVO.deptId }</td>
				</tr>
				<tr>
					<td>생년월일</td>
					<td><input type="text" name="birthDate" value="${StudentVO.birthDate }"></td>
					<td>학번</td>
					<td>${svo.id }</td>
				</tr>
				<tr>
					<td>전화번호</td>
					<td><input type="text" name="tel" value="${StudentVO.tel}"></td>
					<td>주소</td>
					<td><input type="text" name="address" value="${StudentVO.address }"></td>
				</tr>
			</tbody>
			<tfoot>
				<tr>
					<td>
						<input type="button" value="수정" onclick="save_go(this.form)">
						<input type="reset" value="취소">
						<input type="hidden" name="id" value="${StudentVO.id }">
					</td>
				</tr>
			</tfoot>
		</table>
	</form>
</body>
</html>