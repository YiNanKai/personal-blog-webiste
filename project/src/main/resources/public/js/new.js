// JavaScript Document
lastScrollY=0;
function heartBeat(){ 
var diffY;
if (document.documentElement && document.documentElement.scrollTop)
    diffY = document.documentElement.scrollTop;
else if (document.body)
    diffY = document.body.scrollTop
else
    {/* Netscape stuff */}
    
// alert(diffY);
percent=.1*(diffY-lastScrollY); 
if(percent>0)percent=Math.ceil(percent); 
else percent=Math.floor(percent); 
document.getElementById("lovexin12").style.top=parseInt(document.getElementById("lovexin12").style.top)+percent+"px";
document.getElementById("lovexin14").style.top=parseInt(document.getElementById("lovexin12").style.top)+percent+"px";

lastScrollY=lastScrollY+percent; 
// alert(lastScrollY);
}
$(document).ready(function() {
$(function() {
	
    $.post("/advertise/getadvertises",{},function(result){
    	//console.log(result);
    	//console.log(result.length)
    	size = result.length;
    	if(size >= 2){
    		suspendcode12="<DIV id=\"lovexin12\" style='left:22px;POSITION:absolute;TOP:69px;'><a href='" + result[0].advertise_link + "' target='_blank'><img border=0 src=" + result[0].advertise_picture + "><br><a href=JavaScript:; onclick=\"lovexin12.style.visibility='hidden'\"><img border=0 src=images/inc/close.gif></a></div>"
    	    suspendcode14="<DIV id=\"lovexin14\" style='right:22px;POSITION:absolute;TOP:69px;'><a href='" + result[1].advertise_link + "' target='_blank'><img border=0 src=" + result[1].advertise_picture + "><br><a href=JavaScript:; onclick=\"lovexin14.style.display = 'none'\"><img border=0 src=images/inc/close.gif></div>"
    	    $("#flyimage3").after(suspendcode12);
    		$("#flyimage3").after(suspendcode14);
    	}
    });
    
    $.post("/recommand/getrecommands",{},function(result){
        	//console.log(result);
        	//console.log(result.length)
        	size = result.length;
        	for(var i = 0;i < size;i++){
        		$("#recommandfirst").after('<li data-delay="5" data-src="5" data-trans3d="tr6,tr17,tr22,tr23,tr26,tr27,tr29,tr32,tr34,tr35,tr53,tr54,tr62,tr63,tr4,tr13" data-trans2d="tr3,tr8,tr12,tr19,tr22,tr25,tr27,tr29,tr31,tr34,tr35,tr38,tr39,tr41"><img  src="images/bg/blank.png" data-src="images/001/' + result[i].recommand_picture + '.jpg" data-thumb="images/001/' + result[i].recommand_picture + 'a.png"><a data-type="link" href="' + result[i].recommand_link + '" target="_blank"></a></li>');
        	}
        	var cuteslider3 = new Cute.Slider();
			cuteslider3.setup("cuteslider_3", "cuteslider_3_wrapper",
					"images/css/slider-style.css");
			cuteslider3.api.addEventListener(Cute.SliderEvent.CHANGE_START,
					function(event) {
					});
			cuteslider3.api.addEventListener(Cute.SliderEvent.CHANGE_END,
					function(event) {
					});
			cuteslider3.api.addEventListener(Cute.SliderEvent.WATING,
					function(event) {
					});
			cuteslider3.api.addEventListener(
					Cute.SliderEvent.CHANGE_NEXT_SLIDE, function(event) {
					});
			cuteslider3.api.addEventListener(
					Cute.SliderEvent.WATING_FOR_NEXT, function(event) {
					});
    	});
	});
});

