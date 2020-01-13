$(function() {
	$("#login_join").on("click", function() {
		//회원가입 페이지로 이동
		document.location.href = rootPath + "/member/join"
	})
	
	$("#login_login").on("click", function() {
		
		// 유효성 검사
		// id, pw가 입력되지 않았을 때 경고
		if($("#login_id").val() == "") {
			$("#login_alert").text("아이디를 입력하세요")
			$("#login_id").focus()
			return false;
		} else if($("#login_password").val() == "") {
			$("#login_alert").text("비밀번호를 입력하세요")
			$("#login_password").focus()
			return false;
		}
		
		
		$.post(
				rootPath + "/rest/member/login",
				$("form").serialize(),
				function(result) {
					if(result == 'LOGIN_SUCCESS') {
						//페이지 새로고침
						document.location.href = rootPath + "/"
					} else if (result == 'LOGIN_FAIL') {
						$("#login_alert").text("아이디 또는 비밀번호가 일치하지 않습니다")
						return false
					}
				}
		)
		
	})
	
	$("span#close").on("click", function() {
		document.location.href = rootPath + "/info/list"
	})
	
})