package net.codog.service;

import java.util.List;

import net.codog.dao.MessageMapper;
import net.codog.domain.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
* @author 王文涵 
* @date 2016年10月24日
* <p>Description:message的service层，负责消息功能 </p>
 */
@Service
public class MessageService {
	
	@Autowired
	private MessageMapper messageMapper;
	
    public List<Message> getAllMessages(Integer start,Integer end){
    	return messageMapper.selectAll("message", start, end);
    }
	
    public void addAMessage(Message message){
    	messageMapper.insertOne(message);
    }
	
	public int getMessageCount(Integer userBasicInformationId){
		return messageMapper.selectCount(userBasicInformationId);
	}
	
    public List<Message> getMessageByIsRead(Integer start,Integer end,Integer messageIsRead,Integer userBasicInformationId){
    	return messageMapper.selectMessageByIsRead(start, end, messageIsRead,userBasicInformationId);
    }
}
