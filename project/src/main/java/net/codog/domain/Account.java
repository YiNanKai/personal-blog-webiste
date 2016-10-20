package net.codog.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
/**
* @author 王文涵 
* @date 2016年10月20日
* <p>Description:account表的实体类，账户表，包含用户名和密码 </p>
*/
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Setter
@Getter
public class Account {
	//用户基本信息id
    private Integer userBasicInformationJobId;
    //注册用户名
    private String accountUserName;
    //注册密码
    private String accountPassword;
    //是否在线
    private Boolean accountIsonline;
}