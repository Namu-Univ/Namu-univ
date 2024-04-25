<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>내정보 조회(교직원)</title>
    <link href="css/frame.css" rel="stylesheet" type="text/css">
    <style>
        .rectangle {
            display: flex;
            flex-wrap: wrap;
        }

        .rectangle > div {
            width: 50%; /* 각 항목이 2개씩 나오도록 설정 */
            box-sizing: border-box;
            border: 1px solid transparent; /* 테두리 설정 변경 */
            padding: 10px;
        }

        .rectangle > div > div {
            margin-bottom: 5px; /* 각 항목 사이 간격 설정 */
        }

        .rectangle > div > div:last-child {
            margin-bottom: 0; /* 마지막 항목의 하단 간격 제거 */
        }

        .rectangle > div > div:last-child > a {
            display: inline-block; /* 수정 버튼을 인라인 블록 요소로 만들어 줄을 차지하도록 설정 */
            margin-top: 10px; /* 수정 버튼과 다음 박스칸 사이 간격 설정 */
            float: right; /* 우측으로 이동시킴 */
            background-color: #007bff; /* 배경색 */
            color: #fff; /* 글자색 */
            padding: 5px 10px; /* 안쪽 여백 */
            border: none; /* 테두리 제거 */
            border-radius: 3px; /* 둥근 테두리 */
            text-decoration: none; /* 밑줄 제거 */
        }

        .rectangle > div > div:last-child > a:hover {
            background-color: #0056b3; /* 호버 시 배경색 변경 */
        }
    </style>
</head>
<body>
    <div>
        <div>
            <div class="top">
                <a href="#">로그인</a>
            </div>
            <div class="nav">
                <div class="logo">
                    <img src="img/tree.png" alt="나무대학교 로고">나무대학교
                </div>
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
                <div class="maintop">내정보 조회(교직원)</div>
                <!-- Page content -->
                <div class="main">
                    <div class="rectangle">
                        <div>
                            <div>ID</div>
                            <div>이름</div>
                            <div>생년월일</div>
                            <div>성별</div>
                            <div>주소</div>
                            <div>전화번호</div>
                            <div>입사일</div>
                            <div>부서</div>
                        </div>
                        <div>
                            <div>${vo.id}</div>
                            <div>${vo.name}</div>
                            <div>${vo.birthDate}</div>
                            <div>${vo.gender}</div>
                            <div>${vo.address}</div>
                            <div>${vo.tel}</div>
                            <div>${vo.hireDate}</div>
                            <div>${vo.dept}</div>
                            <!-- 수정 버튼 -->
                            <div>
                                <a href="editStaff?id=${vo.id}">수정</a>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</body>
</html>
