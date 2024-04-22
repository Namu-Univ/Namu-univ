<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>학생 정보 수정</title>
</head>
<body>
<h1>학생 정보 수정</h1>
<form action="editStudent" method="post">
    <input type="hidden" name="id" value="${student.id}">
    <!-- ID는 readonly로 보이도록 숨겨둠 -->

    <label for="name">이름:</label>
    <input type="text" id="name" name="name" value="${student.name}"><br>

    <label for="birthDate">생년월일:</label>
    <input type="text" id="birthDate" name="birthDate" value="${student.birthDate}"><br>

    <label for="gender">성별:</label>
    <input type="text" id="gender" name="gender" value="${student.gender}"><br>

    <label for="address">주소:</label>
    <input type="text" id="address" name="address" value="${student.address}"><br>

    <label for="tel">전화번호:</label>
    <input type="text" id="tel" name="tel" value="${student.tel}"><br>

    <label for="grade">학년:</label>
    <input type="text" id="grade" name="grade" value="${student.grade}"><br>

    <label for="semester">학기:</label>
    <input type="text" id="semester" name="semester" value="${student.semester}"><br>

    <label for="entranceDate">입학일:</label>
    <input type="text" id="entranceDate" name="entranceDate" value="${student.entranceDate}"><br>

    <label for="graduationDate">졸업일:</label>
    <input type="text" id="graduationDate" name="graduationDate" value="${student.graduationDate}"><br>

    <input type="submit" value="수정">
</form>
</body>
</html>
