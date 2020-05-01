$(document).ready(function() {
	$(".categoryform").submit(function() {
		action = $(".categoryselect").val();
		$(this).attr("action", "/categories/" + action);

	})
	$(".productform").submit(function() {
		action = $(".productselect").val();
		$(this).attr("action", "/products/" + action);

	})
});