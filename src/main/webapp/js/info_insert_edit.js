$(function() {
	$("#b_code").on("keyup", function() {
		$(this).val( $(this).val().replace(/[^0-9|-]/g, "") )
	})
	
	$("#b_iprice").on("keyup", function() {
		$(this).val( $(this).val().replace(/[^0-9]/g, "") )
	})
	
	$("#b_year").on("keyup", function() {
		$(this).val( $(this).val().replace(/[^0-9|-|/|.]/g, "") )
	})
	
	$("#btn_insert_submit").on("click", function() {
		
		if($("#b_code").val() == "") {
			alert("도서코드를 입력하세요")
			$("#b_code").focus()
			return false
		} else if($("#b_name").val() == "") {
			alert("도서명을 입력하세요")
			$("#b_name").focus()
			return false
		} else if($("#b_auther").val() == "") {
			alert("저자를 입력하세요")
			$("#b_auther").focus()
			return false
		}
		
		
		$.ajax({
			url : rootPath + "/rest/info/isBcodeExists",
			data : {
				bookCode : $("#b_code").val()
			},
			type : 'POST',
			success : function(result) {
				if (result == "EXISTS") {
					alert("도서코드가 이미 존재합니다")
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
		
	})
	
	$("#btn_edit_submit").on("click", function() {
		
		if($("#b_code").val() == "") {
			alert("도서코드를 입력하세요")
			$("#b_code").focus()
			return false
		} else if($("#b_name").val() == "") {
			alert("도서명을 입력하세요")
			$("#b_name").focus()
			return false
		} else if($("#b_auther").val() == "") {
			alert("저자를 입력하세요")
			$("#b_auther").focus()
			return false
		}
		
		$("form").submit()
		
	})
})