package net.codog.web;

import lombok.extern.slf4j.Slf4j;
import net.codog.service.UserService;
import net.codog.view.UserShowDetail;
import net.codog.vo.ResponseVO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
/**
* @author 王文涵 
* @date 2016年10月25日
* <p>Description: 用户的controller层，用来处理用户信息</p>
 */
@RestController
@RequestMapping("/user")
@Slf4j
public class UserController {
	
	@Autowired
	UserService userService;
	

	@RequestMapping(value="/test",method=RequestMethod.GET)
	public ResponseVO<UserShowDetail> test(){
		int userBasicInformationId = 0;
		//String url = "123";
		ResponseVO<UserShowDetail> user = new ResponseVO<UserShowDetail>(true, "", userService.getUserShowDetailByUserBasicInformationId(userBasicInformationId));
		//userService.isHasPermission(userBasicInformationId, url);
		log.info("user测试通过");
		return user;
	}
}
