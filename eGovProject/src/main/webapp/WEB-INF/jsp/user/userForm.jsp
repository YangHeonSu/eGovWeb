<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>

<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<link href="css/sb-admin-2.min.css" rel="stylesheet">
<title>계정 등록</title>
</head>
<body>
	<form action="/userSave.do" method="POST">
	    <div class="container w-50">
            <div>
                <label for="userId" class="dt">아이디</label>
                <input type="text" id="userId" name="userId" class="form-control" maxlength="20">
                <label class="text-danger" id="userIdValidMessage" name="validMessage"></label>
            </div>
            <div>
                <label for="password">비밀번호</label>
                <input type="password" id="password" name="password" class="form-control" maxlength="12">
                <label class="text-danger" id="passwordValidMessage" name="validMessage" ></label>
            </div>
            <div>
                <label for="name">이름</label>
                <input type="text" id="name" name="name" class="form-control" maxlength="5">
                <label class="text-danger" id="nameValidMessage" name="validMessage" ></label>
            </div>
            <div>
                <label for="companyName">회사명</label>
                <input type="text" id="companyName" name="companyName" class="form-control"  maxlength="20">
                <label class="text-danger" id="companyNameValidMessage" name="validMessage" ></label>
            </div>
            <div>
                <label for="dept">부서</label>
			<select id="dept" name="dept" class="form-control">
				<c:forEach var="dept" items="${dept}">
					<option value="${dept.id}">${dept.name}</option>
				</c:forEach>
			</select>
                <label class="text-danger" id="authValidMessage" name="validMessage" ></label>
            </div>

        <div class="float-right mt-2">
            <button type="button" class="btn btn-primary" id="saveBtn">등록</button>
            <button type="button" class="btn btn-dark" id="moveListBtn">취소</button>
        </div>
    </div>
	</form>

</body>

<script src="js/bootstrap/sb-admin-2.min.js"></script>
<script src="js/jquery/jquery-3.6.0.js" /></script>
<script src="js/jquery/jquery-3.6.0.min.js"></script>
<script src="js/user/userForm.js"></script>

</html>