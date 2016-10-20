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
public class UserfulFile {
    private String userfulFileSourceLink;

    private String userfulFileLocalLink;

    private String userfulFileName;

    private String userfulFileDesc;
}