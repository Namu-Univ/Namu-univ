<%@page import="com.namuuniv.mybatis.DBService"%>
<%@page import="org.apache.ibatis.session.SqlSession"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    
	<jsp:useBean id="vo" class="com.namuuniv.vo.StaffVO" scope="session"/>
	<jsp:setProperty property="*" name="vo"/>
	<%-- 세션에 있는 StaffVO의 id값 사용 --%>
	<jsp:setProperty property="id" name="vo" value="${StaffVO.id }"/>
<%
		//0.한글처리(post)
		request.setCharacterEncoding("UTF-8");

		SqlSession ss = DBService.getFactory().openSession(true);
	
	try {
		int result = ss.update("namu.updateStaff", vo);
		System.out.println(">> 수정 성공 ");

		response.sendRedirect("staff_search_profile.jsp?id=" + vo.getId());

	} catch(Exception e){
		//3. 페이지 전환(입력 실패시 이동)
		System.out.println(">>[예외발생] 수정 실패");
		//ss.rollback(); //명시적 롤백 처리 - DB 작업 취소 처리
		e.printStackTrace();
%>
	<script>
		alert("[수정 실패] 오류 전산팀 문의 바랍니다");
		//history.back();
		history.go(-2); //2페이지 이전인 상세페이지로 이동
	</script>
<%		
	} finally {
		ss.close();
	}
	
%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>교직원 수정 제출</title>
</head>
<body>
 <h2> update ok</h2>

</body>
</html>