package net.codog.web;

import java.util.List;

import lombok.extern.slf4j.Slf4j;
import net.codog.domain.Message;
import net.codog.service.MessageService;
import net.codog.vo.ResponseVO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/message")
@Slf4j
public class MessageController {

	@Autowired
	MessageService messageService;
	
	@RequestMapping(value="/test",method=RequestMethod.GET)
	public ResponseVO<List<Message>> test(){
		ResponseVO<List<Message>> result = new ResponseVO<List<Message>>(true,"",messageService.getAllMessages());
		messageService.getMessageByIsRead(0, 0);
		messageService.getMessageCount(0);
		log.info("message测试通过");
		return result;
	}
}
