<%@page import="com.namuuniv.mybatis.DBService"%>
<%@page import="org.apache.ibatis.session.SqlSession"%>
<%@page import="com.namuuniv.dao.SearchDAO"%>
<%@page import="com.namuuniv.vo.StudentVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<jsp:useBean id="dao" class="com.namuuniv.dao.SearchDAO" scope="session"/>
    <%    	
		//0.한글처리(post)
		request.setCharacterEncoding("UTF-8");
    	//전달받은 데이터 추출
    	String id = request.getParameter("id");
    	
		///1. 학생(id) 데이터 조회 후 화면 표시
		StudentVO svo = SearchDAO.studentOne(id);
		System.out.println("학생 svo : " + svo);    
		session.setAttribute("svo", svo); ///세션에 저장
		
		//2.
		//2-1.sqlSession 객체 생성
		SqlSession ss = DBService.getFactory().openSession();
		//2-2. id 값 전달해서 DB SELECT
		ss.selectOne("NAMU.studentOne", id);
		
		StudentVO vo = ss.selectOne("NAMU.studentOne", id);
		ss.close();
		
		System.out.println(":: vo: " + vo);
		//3.
		//pageContext.setAttribute("guestbookVO", vo);
		//session에 등록하여 수정, 삭제에서 사용
		session.setAttribute("StudentVO", vo);
		
		System.out.println("> student_search_profile.jsp session StudentVO: " + 
			session.getAttribute("StudentVO"));
	%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 상세 정보</title>
<link href="../css/frame.css" rel="stylesheet" type="text/css">
<link href="../css/table.css" rel="stylesheet" type="text/css">
<style>
	.profile {
		border-style: 1px solid black;
	}
</style>
<script>
	function modify_go(){
		location.href="student_profile_update.jsp"; //수정화면으로 이동
	}
</script>
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
			  <a href="staff-student_search.jsp">학생 조회</a>
			  <a href="staff-professor_search.jsp">교수 조회</a>
			  <a href="staff-staff_search.jsp">교직원 조회</a>
			</div>
			
			<div class="maintop">학생 조회</div>
			
			<!-- Page content -->
			<div class="main">
				<div class="container">
					<table class="profile">
						<tbody>
							<tr>
								<td>이름</td>
								<td>${svo.name }</td>
								<td>단과대</td>
								<td>${svo.deptId }</td>
							</tr>
							<tr>
								<td>생년월일</td>
								<td>${svo.birthDate }</td>
								<td>학과</td>
								<td>${svo.deptId  }</td>
							</tr>
							<tr>
								<td>전화번호</td>
								<td>${svo.tel }</td>
								<td>학번</td>
								<td>${svo.id }</td>
							</tr>
							<tr>
								<td>주소</td>
								<td>${svo.address } </td>
								<td>학년</td>
								<td>${svo.grade }</td>
							</tr>
						</tbody>
						<tfoot>
							<tr>
								<td><input type="button" value="수정" onclick="modify_go()"></td>
							</tr>
						</tfoot>
					</table>
				</div>
			</div>
		</div>
	</div>
</body>
</html>