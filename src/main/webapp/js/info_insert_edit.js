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
	
	$("#btn_submit").on("click", function() {
		
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
		
	})
})