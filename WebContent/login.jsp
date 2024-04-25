<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
<jsp:include page="css/loginCss.jsp"></jsp:include>
<script>
	function login_btn(frm) {
		frm.action = "login";
		frm.submit();
	}
</script>

</head>
<body>
	<div id="loginForm">
		<div id="logo">
			<img src="css/img/namu_logo.png" alt="namuLogo"/>
			<p>나무대학교</p>
		</div>
		<form action="login" method="post">
	    	<input type="text" id="id" placeholder="아이디" name="id">
		    <input type="password" id="password" placeholder="비밀번호" name="password">

			  <button type="submit" onclick="login_btn(this.form)">로그인</button>
			  <!-- 로그인 실패 시 처리 -->
			  <% 
			  String errorMsg = (String)request.getAttribute("errorMsg");
			  if(errorMsg != null) { 
			  %>
			  <div id="errorMsg" style="color:red;"><%=errorMsg %></div>
			 <% } %>
		</form>
	</div>
</body>
</html>