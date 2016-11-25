$(document).ready(function() {
	
    $(function() {
        $('#nav-accordion li').click(function() {
            var $this = $(this),
            _clickTab = $this.find('a').attr('target');
            //console.log(_clickTab);
            if(_clickTab === "javascript:;"){
            	return;
            }
            $("#realcontent object").attr("data",_clickTab);
        });
    });
    
});
