
$(document).ready(function () {
	getUserList();
})

// grid 설정
const grid = new tui.Grid({
	el: document.getElementById('grid'),
	scrollX: false,
	scrollY: false,
	columns: [
		{
			header: '아이디',
			name: 'userId'
		},
		{
			header: '이름',
			name: 'name'
		},
		{
			header: '권한',
			name: 'auth'
		}
	]
});

// 계정 목록 조회
function getUserList() {
	$.ajax({
		type : 'get',
		url : '/users.do',
		dataType : 'json'
	}).done(function(response) {
		console.log(response)
		grid.resetData(response);
	})
}