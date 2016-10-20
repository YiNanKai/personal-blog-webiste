package net.codog.domain;

import java.util.Date;

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
    private Integer blogId;
    //博客题目
    private String blogTitle;
    //博客url
    private String blogContent;
    //博客摘要
    private String blogSubcontent;
    //博客的阅读量
    private Integer blogReadCount;
    //博客首次上线时间
    private Date blogPublishTime;
    //博客修改时间
    private Date blogModifyTime;
    //文章差评数
    private Integer blogPoorComment;
    //文章好评
    private Integer blogGoodCpmment;
    //blog的发布者,默认是管理员
    private String blogPublisher;
    //blog类型名称
    private Integer blogTypeName;
}