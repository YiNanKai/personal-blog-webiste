$(document)
		.ready(
				function() {
					$(function() {

						$.post("/blog/getblogcategories", {
							isSchool : 2
						}, function(result) {
							size = result.length;
							$('#ec').combobox({
								data : result,
								showItemIcon : true,
								valueField : 'blog_category_id',
								textField : 'blog_category_name',
								iconClsField : 'blog_category_iconname'
							});

						});// .post

						$.post("/blog/getblogcount", {
							blogCategoryId:10
						}, function(result) {
							$("#ep").pagination(
									{
										total: result,
										pageSize: 2,
										showPageList: false,
					                    showRefresh: false,
										onSelectPage : function(pageNumber,
												pageSize) {
											 getblogs((pageNumber - 1)*pageSize,pageSize);
										}
									});

						});// .post
						function getblogs(start,end) {
							$
									.post(
											"/blog/getblogs",
											{
												isSchool : 2,
												start : start,
												end : end,
												blogCategoryId:10
											},
											function(result) {
												size = result.length;
												$("#articallist").empty();
												for (var i = 0; i < size; i++) {
													$("#articallist")
															.append(
																	'<li class="article-container">'
																			+ '<div class="article-img">'
																			+ '<img src="images/blogpicture/paobu.jpg">'
																			+ '</div>'
																			+ '<div class="article-content">'
																			+ '<h3 class="article-header"><a href="health/'
																			+ result[i].blog_content
																			+ '" target="_blank">'
																			+ result[i].blog_title
																			+ '</a></h3>'
																			+ '<div class="article-info">'
																			+ '<span class="article-author"> <a href="profile.html" target="_blank">'
																			+ '<img class="article-author-avatar" src="images/cologo.png">'
																			+ '<span class="article-author-name">'
																			+ result[i].blog_publisher
																			+ '</span>'
																			+ '</a>'
																			+ '</span> <span class="article-publish-time">发布时间 '
																			+ result[i].blog_publish_time
																			+ ' </span>'
																			+ '<span class="article-classify"> 分类：'
																			+ result[i].blog_type_name
																			+ '</span>'
																			+ '</div>'
																			+ '<div class="article-abstract">'
																			+ result[i].blog_subcontent
																			+ '</div>'
																			+ '</div>'
																			+ '</li>');
												}

											});//.post
						}

						getblogs(0,2);
						
						$('#articallist li').click(
								function() {
									var $this = $(this), _clickTab = $this
											.find('a').attr('target');
									$("#realcontent object").attr("data",
											_clickTab);
								});

					});
				});