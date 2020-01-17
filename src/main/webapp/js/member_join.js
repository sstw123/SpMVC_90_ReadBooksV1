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
		
		
		$.ajax({
			url : rootPath + "/rest/member/isMemberExists",
			data : {m_id : id},
			type : "POST",
			success : function(result) {
				if(result == "EXISTS") {
					alert("이미 존재하는 아이디입니다")
					return false
				} else {
					// result가 NULL, 즉 중복된 아이디가 없으면 form submit
					$.post(
							rootPath + "/rest/member/join",
							$("#join_form").serialize(),
							function(result) {
								if(result == 'JOIN_SUCCESS') {
									//페이지 새로고침
									document.location.href = rootPath + "/"
								} else if (result == 'JOIN_FAIL') {
									alert("회원가입에 실패했습니다")
									document.location.href = rootPath + "/"
								}
							}
					)
				}
			},
			error : function(error) {
				alert("서버 통신 오류")
				return false
			}
		})
		
	})
	
	$("span#close").on("click", function() {
		$("#join_modal").css("display", "none")
	})
	
	$(document).on("keydown", function(e) {
		if(e.keyCode == 27) {
			$("#join_modal").css("display", "none")
		}
	})
})