<%@page import="com.namuuniv.vo.UsersVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>내정보 변경(교직원)</title>
    <link href="css/frame.css" rel="stylesheet" type="text/css">
    <style>
        .input-field {
            width: 100%;
            padding: 10px;
            margin-bottom: 20px;
            border: 1px solid #ccc;
            border-radius: 5px;
            box-sizing: border-box;
        }
    </style>
</head>
<%
	UsersVO user = (UsersVO) session.getAttribute("loginUser");
	int id = user.getId();
%>
<body>
    <div>
        <div class="top">
            <a href="#">로그인</a>
        </div>
        <div class="nav">
            <div class="logo"><img src="img/tree.png">나무대학교</div>
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
              <a href="#">내정보</a>
              <a href="#">정보수정</a>
            </div>
            
            <div class="maintop">교직원 정보 수정</div>
            
            <!-- Page content -->
            <div class="main">
                <form action="editStaff" method="post">
                    <input type="hidden" name="id" value="<%=id%>">
                    <!-- ID는 readonly로 보이도록 숨겨둠 -->

                    <label for="name">이름:</label>
                    <input type="text" id="name" name="name" value="${staff.name}" class="input-field"><br>

                    <label for="address">주소:</label>
                    <input type="text" id="address" name="address" value="${staff.address}" class="input-field"><br>

                    <label for="tel">전화번호:</label>
                    <input type="text" id="tel" name="tel" value="${staff.tel}" class="input-field"><br>

                    <label for="dept">부서:</label>
                    <input type="text" id="dept" name="dept" value="${staff.dept}" class="input-field"><br>

                    <input type="submit" value="수정">
                </form>
            </div>
        </div>
    </div>
</body>
</html>
