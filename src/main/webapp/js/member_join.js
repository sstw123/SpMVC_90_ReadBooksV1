$(function() {
	$("#pwCheckFail").hide()
	
	// 비밀번호 일치 확인
	$(".join_pw").keyup(function() {
		var pw1 = $("#join_pw1").val()
		var pw2 = $("#join_pw2").val()
		
		if(pw1 != "" && pw2 != "") {
			if(pw1 == pw2) {
				$("#pwCheckFail").hide()
				
				// 첫번째 클릭(summit) 이후 여러번 클릭시 DB 중복첨가 오류가 발생하므로 클릭 막기 구현
			} else {
				$("#pwCheckFail").show()
			}
		}
	})
	
	// 회원가입 유효성 검사
	$("#join_join").on("click", function() {
		
		var id = $("#join_id").val()
		var pw1 = $("#join_pw1").val()
		var pw2 = $("#join_pw2").val()
		
		if(id == "") {
			$("#join_alert").text("ID를 입력하세요")
			return false
		} else if (pw1 == "") {
			$("#join_alert").text("비밀번호를 입력하세요")
			return false
		} else if (pw2 == "") {
			$("#join_alert").text("비밀번호 확인을 입력하세요")
			return false
		} else if (pw1 != pw2) {
			return false
		}
		
		$("form").submit()
	})
	
	$("span#close").on("click", function() {
		document.location.href = rootPath + "/info/list"
	})
})