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
public class UserBasicInformation {
    private Integer userBasicInformationId;

    private Date userBasicInformationBirthday;

    private Boolean userBasicInformationGender;

    private String userBasicInformationAddress;

    private Date userBasicInformationRegisterTime;

    private Integer jobId;
}