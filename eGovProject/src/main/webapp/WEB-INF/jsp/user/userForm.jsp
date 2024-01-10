<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>

<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>계정 등록</title>
</head>
<body>
<form action="/userSave.do", method="POST">
	<div>
		<label>아이디 : </label> <input type="text" id="userId" name="userId">
	</div>

	<div>
		<label>비밀번호 : </label> <input type="password" id="password" name="password">
	</div>

	<div>
		<label>이름 : </label> <input type="text" id="name" name="name">
	</div>

	<div>
		<label>권한 : </label> 
		<select id="auth" name="auth">
			<option value="ROLE_ADMIN">관리자</option>
			<option value="ROLE_USER">사용자</option>
		</select>
	</div>

	<div>
		<label>부서 : </label>
		 <select id="dept" name="dept">
			<c:forEach var="dept" items="${dept}">
				<option value="${dept.id}">${dept.name}</option>
			</c:forEach>
		</select>
	</div>

	<div>
		<button type="submit" id="2saveBtn">등록</button>
	</div>
</form>

</body>
<script src="./js/jquery-3.6.0.js" /></script>
<script src="./js/jquery-3.6.0.min.js"></script>

<script>
	function getData() {
		return {
			"userId" : $('#userId').val(),
			"password" : $('#password').val(),
			"name" : $('#name').val(),
			"auth" : $('#auth').val(),
			"dept" : $('#dept').val()
		}
	}

	function saveUser(data) {
		$.ajax({
			method : 'POST',
			url : '/userSave.do',
			data : JSON.stringify(data),
			contentType : 'application/json; charset-utf-8',
		}).done(function(response) {
			console.log(response);
			alert('등록sa');
		}).fail(function(jqXHR, textStatus, errorThrown) {
			console.log(jqXHR);
			console.log(textStatus);
			console.log(errorThrown)
		});
	}

	$('#saveBtn').click(function() {
		if (confirm("계정을 등록하시겠습니까?")) {
			let data = getData();
			saveUser(data);
		}
	});
</script>
</html>