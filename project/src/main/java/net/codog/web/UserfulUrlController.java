package net.codog.web;

import java.util.List;

import lombok.extern.slf4j.Slf4j;
import net.codog.domain.UserfulUrl;
import net.codog.service.UserfulUrlService;
import net.codog.vo.ResponseVO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/userurl")
@Slf4j
public class UserfulUrlController {

	@Autowired
	UserfulUrlService userfulUrlService;
	
	@RequestMapping(value="/test",method=RequestMethod.GET)
	public ResponseVO<List<UserfulUrl>> test(){
		int start = 0;
		int end = 2;
		ResponseVO<List<UserfulUrl>> userfulUrlList = new ResponseVO<List<UserfulUrl>>(true, "", userfulUrlService.getAllUserfulUrl(start, end));
		userfulUrlService.getUserfulUrlCount();
		log.info("userfulUrl测试通过");
		return userfulUrlList;
	}
}
