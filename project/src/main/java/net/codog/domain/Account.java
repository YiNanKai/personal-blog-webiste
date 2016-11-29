package net.codog.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
/**
* @author 王文涵 
* @date 2016年10月20日
* <p>Description:account表的实体类，账户表，包含用户名和密码 </p>
*/
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Account {
	//用户基本信息id
    private String user_basic_information_job_id;
    //注册用户名
    private String account_user_name;
    //注册密码
    private String account_password;
    //是否在线
    private Boolean account_isonline;
}