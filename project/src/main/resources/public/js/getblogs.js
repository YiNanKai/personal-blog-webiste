function getblogs(isSchool,blogCategoryId,start, end) {
	$
			.post(
					"/blog/getblogs",
					{
						isSchool : isSchool,
						start : start,
						end : end,
						blogCategoryId : blogCategoryId
					},
					function(result) {
						console.log(result);
						size = result.length;
						$("#articallist").empty();
						var bigPicture = "";
						var contentHref = "";
						for (var i = 0; i < size; i++) {
							if(blogCategoryId == 0){
								bigPicture = '<img src="images/blogpicture/giveupjava.png" class="img-responsive">';
								contentHref = '<h3 class="article-header"><a href="blog/';
							}else if(blogCategoryId == 10){
								bigPicture = '<img src="images/blogpicture/paobu.jpg">';
							    contentHref = '<h3 class="article-header"><a href="health/';
							}
							
							$("#articallist")
									.append(
											'<li class="article-container row">'
													+ '<div class="col-md-3">'
													+ bigPicture
													+ '</div>'
													+ '<div class="article-content col-md-9">'
													+ contentHref
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
function getBlogPager(isSchool,blogCategoryId){
	$.post("/blog/getblogcount", {
		blogCategoryId:blogCategoryId
	}, function(result) {
		$("#ep").pagination(
				{
					total: result,
					pageSize: 2,
					showPageList: false,
                    showRefresh: false,
					onSelectPage : function(pageNumber,
							pageSize) {
						console.log('pageNumber:'
								+ pageNumber + ',pageSize:'
								+ pageSize);
						 getblogs(isSchool,blogCategoryId,(pageNumber - 1)*pageSize,pageSize);
					}
				});

	});// .post
}