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
        
        $('#registerli li').click(function() {
            var $this = $(this),
            _clickTab = $this.find('a').attr('target');
            //console.log(_clickTab);
            $("#realcontent object").attr("data",_clickTab);
        });
        
       
        $.post("/news/getnewslist",{},function(result){
        	console.log(result);
        	console.log(result.length)
        	size = result.length;
        	$("#newscount").html(size);
            //$("#newscount").html(result);
        	$("#newscountdesc").html("total " + size + " news");
        	for(var i = 0;i < size;i++){
        		$("#newscountdesc").after('<li><a target="#"><div class="task-info"><div class="desc">' + result[i].news_title + '</div></div></a></li>');    
        	}
        });
        
    });
    
});
