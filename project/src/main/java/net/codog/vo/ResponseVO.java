package net.codog.vo;

import lombok.AllArgsConstructor;
//import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
* @author 王文涵 
* @date 2016年10月24日
* <p>Description: 返回给前端的类</p>
 */
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Setter
@Getter
//@Builder(builderMethodName="buildResponseVO")
public class ResponseVO<T> {

	//是否成功
	private boolean isSuccess;
	//错误信息
	private String errorMessage;
	//真正的返回信息
	private T object; 
}
