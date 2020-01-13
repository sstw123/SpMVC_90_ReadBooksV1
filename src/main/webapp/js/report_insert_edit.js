$(function() {
	$("#btn_submit").on("click", function() {
		
		if($("#rb_date").val() == "") {
			alert("독서일자를 입력하세요")
			$("#rb_date").focus()
			return false
		}
		
		$("form").submit()
		
	})
})