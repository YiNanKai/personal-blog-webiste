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
public class Blog {
    private Integer blogId;

    private String blogTitle;

    private String blogContent;

    private String blogSubcontent;

    private Integer blogReadCount;

    private Date blogPublishTime;

    private Date blogModifyTime;

    private Integer blogPoorComment;

    private Integer blogGoodCpmment;

    private String blogPublisher;

    private Integer blogTypeId;
}