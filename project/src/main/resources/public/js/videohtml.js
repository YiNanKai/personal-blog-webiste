$(document)
		.ready(
				function() {
					$(function() {
						$.post("/gamevideo/getgamevideoscount", {

						}, function(result) {
							console.log(result);
							$("#ep")
									.pagination(
											{
												total : result,
												pageSize : 2,
												showPageList : false,
												showRefresh : false,
												onSelectPage : function(
														pageNumber, pageSize) {
													console.log("pageNumber: "
															+ pageNumber
															+ ",pageSize: "
															+ pageSize);
													getgamevideos(
															pageNumber - 1,
															pageSize);
												}
											});

						});// .post

						function getgamevideos(start, end) {
							console.log("getgamevideos");
							$
									.post(
											"/gamevideo/getgamevideos",
											{
												start : start,
												end : end
											},
											function(result) {
												console.log(result);
												size = result.length;
												//$("#content").empty();
												for (var i = 0; i < size; i++) {
													$("#content")
															.append(
																	'<div class="item"> '
																			+ '<div class="thumb_wrapper"> '
																			+ '<div class="thumb"> '
																			+ '<ul> '
																			+ '<li><a rev="group1" rel="zoomHeight:200, zoomWidth:400, adjustX: 10, adjustY:-4, position:body" class="cloud-zoom" href="images/formstack1.jpg"><img src="images/thumbs/formstack1.jpg" alt="Formstack 1" /></a></li> '
																			+ '<li><a rev="group1" rel="zoomHeight:200, zoomWidth:400, adjustX: 10, adjustY:-4, position:body" class="cloud-zoom" href="images/formstack2.jpg"><img src="images/thumbs/formstack2.jpg" alt="Formstack 2" /></a></li> '
																			+ '<li><a rev="group1" rel="zoomHeight:200, zoomWidth:400, adjustX: 10, adjustY:-4, position:body" class="cloud-zoom" href="images/formstack3.jpg"><img src="images/thumbs/formstack3.jpg" alt="Formstack 3" /></a></li> '
																			+ '</ul> '
																			+ '</div> '
																			+ '<a class="prev" href="#"></a> '
																			+ '<a class="next" href="#"></a> '
																			+ '<span>Hover to zoom, click to view</span> '
																			+ '</div> '
																			+ '<div class="description"> '
																			+ '<h2>Formstack</h2> '
																			+ '<p>Quickly create any type of web form with our easy to use drag and drop form builder. Seamlessly create HTML forms and embed them on your website or use style templates to match your color, logo and overall look and feel.</p>'
																			+ '<a href="http://www.formstack.com">http://www.formstack.com</a> '
																			+ '</div> '
																			+ '</div> '
																			+ '<div class="clear"></div> '
																			+ '<div class="line"></div> ');
												}

											});// .post
						}

						getgamevideos(0, 1);
					});
				});