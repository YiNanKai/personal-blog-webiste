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
* <p>Description:user_analyze_information实体类 </p>
 */
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Setter
@Getter
public class UserAnalyzeInformation {
    private String userExtraInformationIp;

    private String userExtraInformationAgent;

    private String userExtraInformationRefer;

    private Date userAnalyzeInformationLoginTime;

    private Date userAnalyzeInformationLogoutTime;

    private Integer userBasicInformationId;
}