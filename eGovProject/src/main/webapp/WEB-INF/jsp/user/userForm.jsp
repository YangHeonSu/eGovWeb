<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>계정 등록</title>
</head>
<body>
	<div>
		<label>아이디 : </label> <input type="text" id="userId">
	</div>

	<div>
		<label>비밀번호 : </label> <input type="password" id="password">
	</div>

	<div>
		<label>이름 : </label> <input type="text" id="name">
	</div>

	<div>
		<label>권한 : </label> <select id="auth">
			<option value="ROLE_ADMIN">관리자</option>
			<option value="ROLE_USER">사용자</option>
		</select>
	</div>

	<div>
		<label>부서 : </label> <select id="auth">
			<c:forEach var="dept" items="${dept}">
				<option value="${dept.id}">${dept.name}</option>
			</c:forEach>
		</select>
	</div>
	
	<div>
		<button type="button" id="saveBtn">등록</button>
	</div>
</body>
</html>