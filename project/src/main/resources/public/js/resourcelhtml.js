$(document)
		.ready(
				function() {
					$(function() {

						$.post("/blog/getblogcategories", {
							isSchool : 0
						}, function(result) {
							console.log(result);
							// console.log(result.length)
							size = result.length;
							$('#ec').combobox({
								data : result,
								showItemIcon : true,
								valueField : 'blog_category_id',
								textField : 'blog_category_name',
								iconClsField : 'blog_category_iconname'
							});

						});// .post

						$.post("/gamevideo/getgamevideoscount", {
							
						}, function(result) {
							console.log(result);
							$("#ep").pagination(
									{
										total: result,
										pageSize: 3,
										showPageList: false,
					                    showRefresh: false,
										onSelectPage : function(pageNumber,
												pageSize) {
											console.log('pageNumber:'
													+ pageNumber + ',pageSize:'
													+ pageSize);
											 getgamevideos(pageNumber - 1,pageSize);
										}
									});

						});// .post
						function getgamevideos(start,end) {
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
												$("#articallist").empty();
												for (var i = 0; i < size; i++) {
													$("#articallist")
															.append(
																	);
												}

											});//.post
						}

						getblogs(0,2);
						
						$('#articallist li').click(
								function() {
									var $this = $(this), _clickTab = $this
											.find('a').attr('target');
									//console.log(_clickTab);
									$("#realcontent object").attr("data",
											_clickTab);
								});

					});
				});