$(function() {
	$("button#info_insert").on("click", function() {
		if(MEMBER == "") {
			$("#login_modal").css("display", "block")
			return false
		} else {
			document.location.href = rootPath + "/info/insert"
		}
	})
	
	$("tr.record").on("click", function() {
		document.location.href = rootPath + "/info/info?bookCode=" + $(this).attr("data-b_code")
	})
})