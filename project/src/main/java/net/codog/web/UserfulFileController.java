package net.codog.web;

import java.util.List;

import lombok.extern.slf4j.Slf4j;
import net.codog.domain.UserfulFile;
import net.codog.service.UserfulFileService;
import net.codog.vo.ResponseVO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/userfile")
@Slf4j
public class UserfulFileController {
	
	@Autowired
	UserfulFileService userfulFileService;
	
	@RequestMapping(value="/test",method=RequestMethod.GET)
	public ResponseVO<List<UserfulFile>> test(){
		int start = 0;
		int end = 2;
		ResponseVO<List<UserfulFile>> userfulFileList = new ResponseVO<List<UserfulFile>>(true, "", userfulFileService.getAllUserfulFile(start, end));
		userfulFileService.getUserfulFileCount();
		log.info("userfulFile测试通过");
		return userfulFileList;
	}
}
