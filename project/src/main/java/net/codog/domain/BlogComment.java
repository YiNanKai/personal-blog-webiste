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
    private Integer blogCommentId;

    private Integer blogCommentResponseId;

    private Integer blogCommentContent;

    private Date blogCommentSendTime;

    private Integer userBasicInformationId;

    private Integer blogId;
}