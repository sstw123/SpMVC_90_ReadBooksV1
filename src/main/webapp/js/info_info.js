$(function() {
	$("#info_edit").on("click", function(event) {
		if(MEMBER == "") {
			$("#login_modal").css("display", "block")
			return false
		} else {
			document.location.href = rootPath + "/info/edit?bookCode=" + $(this).attr("data-bcode")
		}
	})
	
	$("#info_delete").on("click", function(event) {
		if(MEMBER == "") {
			$("#login_modal").css("display", "block")
			return false
		} else {
			if(confirm("정말 삭제하시겠습니까?")) {
				$.ajax({
					url : rootPath + "/rest/info/delete",
					data : {
						bookCode : $(this).attr("data-bcode")
					},// 앞은 controller에서 받은 변수명, 뒤는 JS에서 보낼 값
					type : 'POST',
					success : function(result) {
						if (result < 1) {
							alert("삭제 도중 문제 발생")
							return false
						} else {
							//삭제 성공시 새로고침
							document.location.href = rootPath + "/info/list"
						}
					},
					error : function(error) {
						if(error.status == 403) {
							alert("삭제 권한이 없습니다")
							return false
						}
					}
				})
				return false
			}
		}
	})
	
	$("#report_write").on("click", function() {
		if(MEMBER == "") {
			$("#login_modal").css("display", "block")
			return false
		} else {
			document.location.href = rootPath + "/report/insert?bookCode=" + $(this).data("bcode")
		}
	})
	
	$("#report_edit").on("click", function() {
		if(MEMBER == "") {
			$("#login_modal").css("display", "block")
			return false
		} else {
			document.location.href = rootPath + "/report/update?rb_seq=" + $(this).data("seq")
		}
	})
	
	$("#report_delete").on("click", function() {
		if(MEMBER == "") {
			$("#login_modal").css("display", "block")
			return false
		} else {
			if(confirm("정말 삭제하시겠습니까?")) {
				let bookCode = $(this).data("bcode")
				
				$.ajax({
					url : rootPath + "/rest/report/delete",
					data : {
						rb_seq : $(this).data("seq"),
						bookCode : $(this).data("bcode")
					},// 앞은 controller에서 받은 변수명, 뒤는 JS에서 보낼 값
					type : 'POST',
					success : function(result) {
						if (result < 1) {
							alert("삭제 도중 문제 발생")
							return false
						} else {
							//삭제 성공시 새로고침
							document.location.replace(rootPath + "/info/info?bookCode=" +  bookCode)
						}
					},
					error : function(error) {
						if(error.status == 403) {
							alert("삭제 권한이 없습니다")
							return false
						}
					}
					
				})
			}
		}
	})
	
})