package net.codog.service;

import net.codog.dao.AccountMapper;
import net.codog.dao.UserBasicInformationMapper;
import net.codog.domain.Account;
import net.codog.domain.UserBasicInformation;
import net.codog.view.UserShowDetail;
import net.codog.view.dao.UserPermissionMapper;
import net.codog.view.dao.UserShowDetailMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
* @author 王文涵 
* @date 2016年10月24日
* <p>Description:user的service层，负责用户信息展示和用户权限验证功能 </p>
 */
@Service
public class UserService {
	
	@Autowired
	private UserShowDetailMapper userShowDetailMapper;
	
	@Autowired
	private UserPermissionMapper userPermissionMapper;
	
	@Autowired
	private UserBasicInformationMapper userBasicInformationMapper;
	
	@Autowired
	private AccountMapper accountMapper;
	
	public UserShowDetail getUserShowDetailByUserBasicInformationId(Integer userBasicInformationId){
		return userShowDetailMapper.selectUserShowDetailByUserBasicInformationId(userBasicInformationId);
	}
	
	//判断用户请求的url是否符合正则表达式
	public boolean isHasPermission(Integer userBasicInformationId,String url){	
		return (url.matches(userPermissionMapper.selectByUserBasicInformationId(userBasicInformationId).getPermissionUrl()));
	}
	
	public void addUser(UserBasicInformation userBasicInformation){
		userBasicInformationMapper.insertOne(userBasicInformation);
	}
	public void addAccount(Account account){
		accountMapper.insertOne(account);
	}
}
