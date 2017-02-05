				function getUserfulURLByType(urlType) {
					$
					.ajax({
						type : "post",
						url : "/userurl/getuserfulurlbytype",
						async : false,
						data : {
							type: urlType
						},
						success : function(result) {
							for (var i = 0; i < result.length; i++){
								str = '<li>'+
						            '<div class="boxgrid captionfull"> <a href="' + result[i].userful_url_link + '" target="_blank">'+
									'<img src="images/resourcepicture/' + result[i].userful_url_picture + '" alt="' + result[i].userful_url_name + '" height="140" width="120"></a>'+
						              '<div class="cover boxcaption">'+
						                '<p>' + result[i].userful_url_desc + '</p>'+
						              '</div>'+
						            '</div>'+
						            '<h3><a href="#" target="_blank" title="' + result[i].userful_url_name + '">' + result[i].userful_url_name + '</a></h3>'+
						          '</li>'
								$("#userfulurllist").append(str);
							}
						}
					});
				}