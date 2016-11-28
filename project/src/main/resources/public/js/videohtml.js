$(document).ready(function() {
$(function() {
	
    $.post("/gamevideo/getgamevideotypes",{},function(result){
    	console.log(result);
    	//console.log(result.length)
    	size = result.length;
    	$('#ec').combobox({
    	    data:result,
    	    showItemIcon: true,
    	    valueField: 'game_video_type_id',
            textField: 'game_vido_type_name',
    	});
    	
    	});//.post
    
    $.post("/gamevideo/getgamevideos",{},function(result){
    	console.log(result);
    	//console.log(result.length)
    	size = result.length;
    	for(var i = 0;i < size;i++){
    		$("#content").append('<div class="item">'+
			'<div class="thumb_wrapper">'+
			'<div class="thumb">'+
				'<ul>'+
					'<li><a rev="group1" rel="zoomHeight:200, zoomWidth:400, adjustX: 10, adjustY:-4, position:\'body\'" class=\'cloud-zoom\' href="images/formstack1.jpg">'+
    		'<img src="images/thumbs/formstack1.jpg" alt="Formstack 1" /></a></li>'+
					'<li><a rev="group1" rel="zoomHeight:200, zoomWidth:400, adjustX: 10, adjustY:-4, position:\'body\'"'+
						'class=\'cloud-zoom\' href="images/formstack2.jpg"><img'+
							'src="images/thumbs/formstack2.jpg" alt="Formstack 2" /></a></li>'+
					'<li><a rev="group1"'+
						'rel="zoomHeight:200, zoomWidth:400, adjustX: 10, adjustY:-4, position:\'body\'"'+
						'class=\'cloud-zoom\' href="images/formstack3.jpg"><img'+
							'src="images/thumbs/formstack3.jpg" alt="Formstack 3" /></a></li>'+
				'</ul>'+
			'</div>'+
			'<a class="prev" href="#"></a> <a class="next" href="#"></a> <span>Hover to zoom, click to view</span>'+
		'</div>'+
		'<div class="description">'+
			'<h2>Formstack</h2>'+
			'<p>Quickly create any type of web form with our easy to use</p>'+
			'<a href="http://www.formstack.com">http://www.formstack.com</a>'+
		'</div>'+
	'</div>'+
	'<div class="clear"></div>'+
	'<div class="line"></div>);'
    	}
    	
    	});//.post
    
    
	});
});