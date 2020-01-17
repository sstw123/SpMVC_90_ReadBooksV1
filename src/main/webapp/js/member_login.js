$(function() {
	$("#login_join").on("click", function() {
		//회원가입 창 열기
		$("#login_modal").css("display", "none")
		$("#join_modal").css("display", "block")
		
	})
	
	$("#login_login").on("click", function() {
		
		// 유효성 검사
		// id, pw가 입력되지 않았을 때 경고
		if($("#login_id").val() == "") {
			$("#login_alert").text("아이디를 입력하세요")
			$("#login_id").focus()
			return false
		} else if($("#login_password").val() == "") {
			$("#login_alert").text("비밀번호를 입력하세요")
			$("#login_password").focus()
			return false
		}
		
		
		$.post(
				rootPath + "/rest/member/login",
				$("#login_form").serialize(),
				function(result) {
					if(result == 'LOGIN_SUCCESS') {
						//이전 페이지로
						document.location.replace(document.location.href)
					} else if (result == 'LOGIN_FAIL') {
						$("#login_alert").text("아이디 또는 비밀번호가 일치하지 않습니다")
						return false
					}
				}
		)
		
	})
	
	$("span#close").on("click", function() {
		$("#login_modal").css("display", "none")
	})
	
	$(document).on("keydown", function(e) {
		if(e.keyCode == 27) {
			$("#login_modal").css("display", "none")
		}
	})
	
})