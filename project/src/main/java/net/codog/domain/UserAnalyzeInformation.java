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
public class UserAnalyzeInformation {
    private String userExtraInformationIp;

    private String userExtraInformationAgent;

    private String userExtraInformationRefer;

    private Date userAnalyzeInformationLoginTime;

    private Date userAnalyzeInformationLogoutTime;

    private Integer userBasicInformationId;
}