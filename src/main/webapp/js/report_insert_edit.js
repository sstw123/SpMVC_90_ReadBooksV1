$(function() {
	
	$("#rb_date").on("keyup", function() {
		$(this).val( $(this).val().replace(/[^0-9|-]/g, "") )
	})
	
	$("#rb_stime").on("keyup", function() {
		$(this).val( $(this).val().replace(/[^0-9|:|-|.]/g, "") )
	})
	
	$("#rb_rtime").on("keyup", function() {
		$(this).val( $(this).val().replace(/[^0-9|.]/g, "") )
	})
	
	$("#btn_submit").on("click", function() {
		
		if($("#rb_date").val() == "") {
			alert("독서일자를 입력하세요")
			$("#rb_date").focus()
			return false
		} else if($("#rb_bcode").val() != "") {
			$.ajax({
				url : rootPath + "/rest/info/isBcodeExists",
				data : {
					bookCode : $("#rb_bcode").val()
				},
				type : 'POST',
				success : function(result) {
					if (result == "NULL") {
						alert("도서코드가 존재하지 않습니다")
						return false
					} else {
						$("form").submit()
					}
				},
				error : function(error) {
					alert(error)
					return false
				}
			})
		}
		
	})
})