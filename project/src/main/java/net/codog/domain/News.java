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
public class News {
    private Integer newsId;

    private String newsTitle;

    private String newsContent;

    private Date newsPublishTime;

    private Date newsModifyTime;

    private String newsUrl;

    private Integer newsTypeId;
}