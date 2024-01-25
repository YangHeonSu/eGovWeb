<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>계정 상세</title>
</head>
<body>
	<form action="/" id="frm" name="frm">
	    <div class="container w-50">
            <div>
                <label class="dt">아이디</label>
                <label>${user.userId}</label>
            </div>
            <div>
                <label>비밀번호</label>
                <button type="button" id="passwordChangeBtn" class="btn btn-primary">비밀번호 변경</button>
            </div>
            <div>
                <label for="name">이름</label>
                <input type="text" id="name" name="name" class="form-control" maxlength="5" value="${user.name}">
            </div>
            <div>
                <label for="companyName">회사명</label>
                <input type="text" id="companyName" name="companyName" class="form-control"  maxlength="20" value="${user.companyName}">
            </div>
            <div>
                <label for="dept">부서</label>
			<select id="dept" name="dept" class="form-control" >
				<c:forEach var="dept" items="${dept}">
					<option value="${dept.id}" <c:if test="${user.dept == dept.id}">selected</c:if>>${dept.name}</option>
				</c:forEach>
			</select>
            </div>

        <div class="float-right mt-2">
            <button type="button" class="btn btn-primary" id="updateBtn">등록</button>
            <button type="button" class="btn btn-dark" id="moveListBtn">취소</button>
        </div>
    </div>
	</form>
</body>
</html>