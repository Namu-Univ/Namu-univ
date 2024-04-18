<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
<script>
	function login_btn(frm) {
		frm.action = "LoginController?type=login";
		frm.submit();
	}
</script>
</head>
<body>
	<h3>로그인 페이지</h3>
	<form action="LoginController?type=mypage" method="get">
	  <div id="id">
	    <label for="id" class="id">아이디 :</label>
	    <input type="text" class="id" id="id" placeholder="아이디" name="id">
	  </div>
	  <div id="password">
	    <label for="password" class="pw">비밀번호 :</label>
	    <input type="password" class="password" id="password" placeholder="비밀번호" name="password">
	  </div>
	  <div class="rememberId">
	    <label>
	      <input type="checkbox" name="rememberId"> 아이디 저장
	    </label>
	  </div>
	  <button type="submit" onclick="login_btn(this.form)">로그인</button>
	</form>
</body>
</html>