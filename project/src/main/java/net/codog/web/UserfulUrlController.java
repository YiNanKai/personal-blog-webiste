package net.codog.web;

import java.util.List;

import lombok.extern.slf4j.Slf4j;
import net.codog.domain.UserfulUrl;
import net.codog.service.UserfulUrlService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageHelper;

@RestController
@RequestMapping("/userurl")
@Slf4j
public class UserfulUrlController {

	@Autowired
	UserfulUrlService userfulUrlService;
	
	@RequestMapping(value="/getuserfulurlbytype",method=RequestMethod.POST)
	public List<UserfulUrl> getUserfulUrlByType(@RequestParam("type")int type,Integer start,Integer end){
		if(start != null || end != null){
			PageHelper.startPage(start,end);
		}
		log.info("getUserfulUrlByType");
		return userfulUrlService.getAllUserfulUrl(type);
	}
}
