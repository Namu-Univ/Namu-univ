<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="com.namuuniv.vo.UsersVO"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>내정보 수정(학생)</title>
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
	UsersVO user = (UsersVO)session.getAttribute("loginUser");
	int id = user.getId();
%>
<body>
    <div>
    <jsp:include page="../partials/navTop.jsp"></jsp:include>
        <div class="mid">
            <jsp:include page="../partials/sideNav.jsp"></jsp:include>
            <div class="maintop">학생 정보 수정</div>
            
            <!-- Page content -->
            <div class="main">
                <form action="editStudent" method="post">
                    <input type="hidden" name="id" value="<%=id%>">
                    <!-- ID는 readonly로 보이도록 숨겨둠 -->

                    <label for="name">이름:</label>
                    <input type="text" id="name" name="name" value="${student.name}" class="input-field"><br>

                    <label for="address">주소:</label>
                    <input type="text" id="address" name="address" value="${student.address}" class="input-field"><br>

                    <label for="tel">전화번호:</label>
                    <input type="text" id="tel" name="tel" value="${student.tel}" class="input-field"><br>

                    <input type="submit" value="수정">
                </form>
            </div>
        </div>
    </div>
</body>
</html>
