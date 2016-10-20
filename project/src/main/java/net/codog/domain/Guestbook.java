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
* <p>Description: guestbook的实体类，留言板</p>
 */
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Setter
@Getter
public class Guestbook {
	//留言内容
    private Integer guestbookContent;
    //留言时间
    private Date guestbookTime;
    //用户基本信息id
    private Integer userBasicInformationId;
}