package net.codog.service;

import java.util.List;

import net.codog.dao.UserfulUrlMapper;
import net.codog.domain.UserfulUrl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
* @author 王文涵 
* @date 2016年10月24日
* <p>Description:userfulurl的service层，负责有用连接功能 </p>
 */
@Service
public class UserfulUrlService {

	@Autowired
	private UserfulUrlMapper userfulUrlMapper;
	
	public List<UserfulUrl> getAllUserfulUrl(int type){
		return userfulUrlMapper.selectAll(type);
	}
	
	public int getUserfulUrlCount(int type){
		return userfulUrlMapper.selectCount(type);
	}
	
}
