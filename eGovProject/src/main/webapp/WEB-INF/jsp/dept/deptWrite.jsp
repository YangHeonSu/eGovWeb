<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>부서 등록</title>
</head>

<style>
table {
	width:400px;
	border-collapse:collapse; /* cell 간격 제거 */
}

th, td {
	border:1px soild #cccccc;
	padding:5px;
}
</style>

<body>
	<form name="frm" method="post" action="deptSave.do">
		<table>
			<tr>
				<th>부서 번호</th>
				<td><input type="text" name="deptNo"></td>
			</tr>
			<tr>
				<th>부서 이름</th>
				<td><input type="text" name="deptName"></td>
			</tr>
			<tr>
				<th>부서 위치</th>
				<td><input type="text" name="deptLocation"></td>
			</tr>
			<tr>
				<th colspan="2">
					<button type="submit">등록</button>
				</th>
			</tr>
		</table>

	</form>
</body>
</html>