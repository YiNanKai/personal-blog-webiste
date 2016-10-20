package net.codog.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
/**
* @author 王文涵 
* @date 2016年10月20日
* <p>Description:uerful_file的实体类， 有用的文件链接,文件存在百度云上</p>
 */
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Setter
@Getter
public class UserfulFile {
	//文件的官方链接
    private String userfulFileSourceLink;
    //文件的本地链接
    private String userfulFileLocalLink;
    //文件名称
    private String userfulFileName;
    //文件作用描述
    private String userfulFileDesc;
}