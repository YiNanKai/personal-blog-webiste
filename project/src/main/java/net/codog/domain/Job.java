package net.codog.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
/**
* @author 王文涵 
* @date 2016年10月20日
* <p>Description:job表的实体类，程序员细分代码表,分为安卓工程师，ios工程师，前端工程师，数据库工程师，后端工程师，运维工程师，其他 </p>
 */
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Setter
@Getter
public class Job {
	//工作代码
    private Integer jobId;
    //对应的代码的工作名称
    private String jobName;
}