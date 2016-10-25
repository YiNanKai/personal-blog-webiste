package net.codog.web;

import java.util.List;

import lombok.extern.slf4j.Slf4j;
import net.codog.domain.Guestbook;
import net.codog.service.GuestbookService;
import net.codog.vo.ResponseVO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/guestbook")
@Slf4j
public class GuestbookController {
	
	@Autowired
	GuestbookService guestbookService;
	
	@RequestMapping(value="/test",method=RequestMethod.GET)
	public ResponseVO<List<Guestbook>> test(){
		int start = 0;
		int end = 4;
		ResponseVO<List<Guestbook>> guestbookList = new ResponseVO<List<Guestbook>>(true,"",guestbookService.getAllGuestbook(start, end));
		guestbookService.getGuestbookCount();
		log.info("guestbook测试通过");
		return guestbookList;
	}
}
