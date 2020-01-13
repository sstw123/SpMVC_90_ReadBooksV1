$(function() {
	$("button#info_insert").on("click", function() {
		document.location.href = rootPath + "/info/insert"
	})
	
	$("tr.record").on("click", function() {
		document.location.href = rootPath + "/info/info?bookCode=" + $(this).attr("data-b_code")
	})
})