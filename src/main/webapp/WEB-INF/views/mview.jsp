<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>내용 수정</title>
</head>
<body>
	<h2>내용 수정</h2>
	<hr>
	<table border="1" cellpadding="0" cellspacing="0" width="1000">
	
	<form action="modify">
	<c:forEach items="${list }" var="dto">
			<tr>
				<th bgcolor="skyblue">글번호</th>
				<td><input type="text" name="mid" readonly="readonly" value="${dto.mid}"></td>
			</tr>
			<tr height="40" bgcolor="">
				<th bgcolor="skyblue">글쓴이</th>
				<td><input type="text" name="mwriter" size="60" value="${dto.mwriter}"></td>
			</tr>
			<tr height="50">
				<th bgcolor="skyblue">한줄쓰기</th>
				<td><input type="text" name="mcontent" size="150" value="${dto.mcontent}"></td>
			</tr>
			</c:forEach>
			<tr>
				<td colspan="2" align="right">
					<input type="submit" value="수정완료">
					<input type="button" value="목록보기" onclick="javascript:window.location='list'">
				</td>
			</tr>
	</form>
	</table>
</body>
</html>