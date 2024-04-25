<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>학생 휴학신청서 상세보기</title>
    <link href="css/frame.css" rel="stylesheet" type="text/css">
    <style>
        /* Table style */
        table {
            width: 100%;
            border-collapse: collapse;
            margin-top: 20px;
        }
        th, td {
            border: 1px solid #dddddd;
            text-align: left;
            padding: 8px;
        }
        th {
            background-color: #f2f2f2;
        }
    </style>
</head>
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
            
            <div class="maintop">학생 휴학신청서 상세보기</div>
            
            <!-- Page content -->
            <div class="main">
                <table>
                    <thead>
                        <tr>
                            <th>신청일</th>
                            <th>학번</th>
                            <th>시작학기</th>
                            <th>종료학기</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="vo" items="${List}">
                            <tr>
                                <td>${vo.reporingDate}</td>
                                <td>${vo.id}</td>
                                <td>${vo.startSemester}</td>
                                <td>${vo.finishSemester}</td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</body>
</html>
