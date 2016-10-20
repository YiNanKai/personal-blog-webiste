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
public class Account {
    private Integer userBasicInformationJobId;

    private String accountUserName;

    private String accountPassword;

    private Boolean accountIsonline;
}