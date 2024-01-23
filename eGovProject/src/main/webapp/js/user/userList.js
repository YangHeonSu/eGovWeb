
$(document).ready(function() {
	getUserList();
})

// grid 설정
const grid = new tui.Grid({
	el: document.getElementById('grid'),
	scrollX: false,
	scrollY: false,
	pagination : true,
	pageOption: {
		userClient : true, 
		page: 1,		//페이지
		totalCount: 100	//데이터 개수
	},
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
		type: 'get',
		url: '/users.do',
		dataType: 'json'
	}).done(function(response) {
		console.log(response)
		grid.resetData(response);
	})
}


// 등록 버튼 클릭 시
$('#saveFormBtn').click(function () {
	location.href = "/userForm.do";
})