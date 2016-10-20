package net.codog.domain;

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
public class UserContactInformation {
    private Integer userBasicInformationId;

    private String userContactInformationQq;

    private String userContactInformationWeixin;

    private String userContactInformationWeibo;

    private String userContactInformationEmail;

    private String userContactInformationPhone;

    private String userContactInformationGithub;

    private String userContactInformationBlog;

    private String userContactInformationOther;
}