package net.codog.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
/**
* @author 王文涵 
* @date 2016年10月20日
* <p>Description: user_contact_information表的实体类</p>
 */
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