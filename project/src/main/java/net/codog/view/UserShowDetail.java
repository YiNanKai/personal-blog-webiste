package net.codog.view;

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
public class UserShowDetail {
    private Integer userBasicInformationId;

    private Date userBasicInformationBirthday;

    private Boolean userBasicInformationGender;

    private String userBasicInformationAddress;

    private Date userBasicInformationRegisterTime;

    private String jobName;

    private String userContactInformationQq;

    private String userContactInformationWeixin;

    private String userContactInformationWeibo;

    private String userContactInformationEmail;

    private String userContactInformationPhone;

    private String userContactInformationGithub;

    private String userContactInformationBlog;

    private String userContactInformationOther;
}
