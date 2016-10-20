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
public class Guestbook {
    private Integer guestbookContent;

    private Date guestbookTime;

    private Integer userBasicInformationId;
}