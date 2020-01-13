$(function() {
	$("#header").on("click", function() {
		document.location.href = rootPath + "/info/list"
	})
	
	if(MODAL == "LOGIN" || MODAL == "JOIN") {
		$("#login_modal").css("display", "block")
	}
})