// 로그인 버튼 클릭 시
$('#loginBtn').on("click", function() {
	if(loginValid()) {
		let form = document.getElementById('frm');
		form.action = "/loginProc.do";
		form.method = "post";
		form.submit();
	}
}) 


function loginValid() {
	let userId = $('#userId').val();
	let password = $('#password').val();
	
	if (userId == "") {
		alert("아이디를 입력해주세요.");
		return false;
	}
	
	if(password == "") {
		alert("비밀번호를 입력해주세요.");
		return false;		
	}
	
	return true;
}