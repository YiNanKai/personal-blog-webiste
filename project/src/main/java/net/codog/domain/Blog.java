package net.codog.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
/**
* @author 王文涵 
* @date 2016年10月20日
* <p>Description:blog表的实体类，博客 </p>
 */
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Setter
@Getter
public class Blog {
	//自增id
    private Integer blog_id;
    //博客题目
    private String blog_title;
    //博客url
    private String blog_content;
    //博客摘要
    private String blog_subcontent;
    //博客的阅读量
    private Integer blog_read_count;
    //博客首次上线时间
    private String blog_publish_time;
    //博客修改时间
    private String blog_modify_time;
    //文章差评数
    private Integer blog_poor_comment;
    //文章好评
    private Integer blog_good_comment;
    //blog的发布者,默认是管理员
    private String blog_publisher;
    //blog类型名称
    private String blog_type_name;
   
}