$(function() {
	$("li#home").on("click", function() {
		document.location.href = rootPath + "/info/list"
	})
	
	$("li#booklist").on("click", function() {
		document.location.href = rootPath + "/info/booklist"
	})
	
	$("li#login").on("click", function() {
		$("#login_modal").css("display", "block")
	})
	
	$("li#join").on("click", function() {
		$("#join_modal").css("display", "block")
	})
	
	$("li#logout").on("click", function() {
		document.location.href = rootPath + "/member/logout"
	})
	
})
