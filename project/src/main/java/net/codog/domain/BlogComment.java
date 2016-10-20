package net.codog.domain;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Setter
@Getter
public class BlogComment {
	//博客评论的id
    private Integer blogCommentId;
    //为空时候是回复文章，代表回复的评论的id
    private Integer blogCommentResponseId;
    //评论的内容
    private Integer blogCommentContent;
    //评论的时间
    private Date blogCommentSendTime;
    //注册用户名
    private String accountUserName;
    //博客id
    private Integer blogId;
}