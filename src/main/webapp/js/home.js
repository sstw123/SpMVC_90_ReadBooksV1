$(function() {
	$("#header").on("click", function() {
		document.location.href = rootPath + "/"
	})
	
	if(MODAL == "LOGIN") {
		$("#login_modal").css("display", "block")
	}
	
	if(MODAL == "JOIN") {
		$("#join_modal").css("display", "block")
	}
})