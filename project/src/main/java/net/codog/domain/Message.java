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
* <p>Description: message的实体类，通知用户的消息表,个性化的通知用户的时候用到</p>
 */
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Setter
@Getter
public class Message {
	//自增id
    private Integer message_id;
    //消息题目
    private String messageTitie;
    //消息内容
    private String messageContent;
    //发布时间
    private Date messageSendTime;
}