<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>내정보 조회(학생)</title>
<!-- <link href="../css/frame.css" rel="stylesheet" type="text/css"> -->
<jsp:include page="../css/frameCss.jsp"/>
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
<jsp:include page="../partials/navTop.jsp"></jsp:include>
    <div class="mid">
    <jsp:include page="../partials/sideNav.jsp"></jsp:include>
        <!-- Page content -->
        <div class="main">
            <div class="rectangle">
                <div>
                    <div>ID</div>
                    <div>학과 ID</div>
                    <div>이름</div>
                    <div>생년월일</div>
                    <div>성별</div>
                    <div>주소</div>
                    <div>전화번호</div>
                    <div>학년</div>
                    <div>학기</div>
                    <div>입학일</div>
                    <div>졸업일</div>
                </div>
                
                 <div>
                     <div>${vo.id}</div>
                     <div>${vo.deptId}</div>
                     <div>${vo.name}</div>
                     <div>${vo.birthDate}</div>
                     <div>${vo.gender}</div>
                     <div>${vo.address}</div>
                     <div>${vo.tel}</div>
                     <div>${vo.grade}</div>
                     <div>${vo.semester}</div>
                     <div>${vo.entranceDate}</div>
                     <div>${vo.graduationDate}</div>
                     <!-- 수정 버튼 -->
                     <div>
                         <a href="editStudent?id=${vo.id}">수정</a>
                     </div>
                 </div>

            </div>
        </div>
    </div>
</body>
</html>
