$(document).ready(function() {
	
    $(function() {
        $('#nav-accordion li').click(function() {
            var $this = $(this),
            _clickTab = $this.find('a').attr('target');
            $("#realcontent object").attr("data",_clickTab);
            /*$.get(_clickTab,
            function(data) {
				console.log(data);
                //$("#iframe").html(data);
				$("#iframe").load(data);
            });*/
        });
    });
    
});
