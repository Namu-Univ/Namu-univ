<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
<link rel="stylesheet" type="text/css" href="css/login.css">

<script>
	function login_btn(frm) {
		frm.action = "login";
		frm.submit();
	}
</script>

</head>
<body>
	<h3>로그인 페이지</h3>
	<div id="loginForm">
		<form action="login" method="post">
		<div class="txt">
	    	<input type="text" id="id" placeholder="아이디" name="id">
		</div>
		<div class="txt">
		    <input type="password" id="password" placeholder="비밀번호" name="password">
		</div>
		  
		  <!-- 로그인 실패 시 처리 -->
		  <% 
		  String errorMsg = (String)request.getAttribute("errorMsg");
		  if(errorMsg != null) { 
		  %>
		  <div style="color:red;"><%=errorMsg %></div>
		 <% } %>
		
		  <button type="submit" onclick="login_btn(this.form)">로그인</button>
		</form>
	</div>
</body>
</html>