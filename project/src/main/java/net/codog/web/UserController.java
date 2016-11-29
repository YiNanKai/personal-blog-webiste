package net.codog.web;

import javax.servlet.http.HttpServletRequest;

import lombok.extern.slf4j.Slf4j;
import net.codog.domain.Account;
import net.codog.domain.UserBasicInformation;
import net.codog.service.UserService;
import net.codog.view.UserShowDetail;
import net.codog.vo.ResponseVO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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
	
	@RequestMapping(value="/register",method=RequestMethod.POST)
	public ResponseVO<String> register(HttpServletRequest request,@RequestParam("account_user_name")String account_user_name,@RequestParam("account_password")String account_password ){
		ResponseVO<String> result = new ResponseVO<String>();
	    
		String id = request.getLocalAddr();
		log.info("ip is " + id);
		UserBasicInformation userBasicInformation = UserBasicInformation.builder()
				.job_id(1)
				.user_basic_information_register_time("2016-11-18 00:00:00")
				.user_basic_information_id("" + id)
				.build();
		Account account = new Account(id, account_user_name, account_password, true);
		//userService.addUser(userBasicInformation);
		//userService.addAccount(account);
		return result;
	}

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
