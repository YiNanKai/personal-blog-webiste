package net.codog.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
/**
* @author 王文涵 
* @date 2016年10月20日
* <p>Description:userful_link实体类 ，有用的网址,友情链接,实现SEO等等</p>
 */
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Setter
@Getter
public class UserfulUrl {
	//网址链接
    private String userfulUrlLink;
    //网址的名称
    private String userfulUrlName;
    //网址的作用描述
    private String userfulUrlDesc;
}