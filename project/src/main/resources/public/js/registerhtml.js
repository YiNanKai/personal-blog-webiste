$(document).ready(function() {
	$(function() {

		$('#submitregister').click(function() {
			console.log("register clicked");
			$.post("/user/register", {
				account_user_name : 0,
				account_password : 0
			}, function(result) {
			});// .post
		});

	});
});