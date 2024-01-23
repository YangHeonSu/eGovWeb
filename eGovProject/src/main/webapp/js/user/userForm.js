// 등록 버튼 클릭 시
$('#saveBtn').click(function() {
	if (confirm("계정을 등록하시겠습니까?")) {
		let data = getData();
		saveUser(data);
	}
});

// 취소 버튼 클릭 시
$('#moveListBtn').click(function() {
	if (confirm("계정 목록 페이지로 이동하시겠습니까?\n이동 시 입력 내용이 저장되지 않습니다.")) {
		location.href = "/userList.do";
	}
})

// 계정 등록 데이터 가져오기
function getData() {
	return {
		"userId": $('#userId').val(),
		"password": $('#password').val(),
		"name": $('#name').val(),
		"auth": $('#auth').val(),
		"dept": $('#dept').val()
	}
}

// 계정 등록
function saveUser(data) {
	$.ajax({
		method: 'POST',
		url: 'userSave.do',
		data: JSON.stringify(data),
		contentType: 'application/json',
	}).done(function(response) {
		if (response['result'] === 200) {
			location.href = "/";
		}
	}).fail(function(jqXHR, textStatus, errorThrown) {
		console.log(jqXHR);
		console.log(textStatus);
		console.log(errorThrown)
	});
}