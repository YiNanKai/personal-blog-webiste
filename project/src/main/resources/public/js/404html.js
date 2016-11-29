$(document).ready(function() {
	$(function() {

		$('#wrapper div').click(function() {
			var $this = $(this), _clickTab = $this.find('a').attr('target');
			console.log(_clickTab);
			$("#realcontent object").attr("data", _clickTab);
		});

	});
});