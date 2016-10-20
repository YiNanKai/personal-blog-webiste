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
* <p>Description: news的实体类，新闻，用爬虫去爬取，或者自己写</p>
 */
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Setter
@Getter
public class News {
	//自增id
    private Integer newsId;
    //新闻题目
    private String newsTitle;
    //新闻url
    private String newsContent;
    //新闻发布时间
    private Date newsPublishTime;
    //新闻修改时间
    private Date newsModifyTime;
    //爬取的新闻的地址
    private String newsUrl;
    //新闻类型的名称
    private Integer newsTypeName;
}