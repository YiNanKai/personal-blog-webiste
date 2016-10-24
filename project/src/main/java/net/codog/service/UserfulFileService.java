package net.codog.service;

import java.util.List;

import net.codog.dao.UserfulFileMapper;
import net.codog.domain.UserfulFile;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
* @author 王文涵 
* @date 2016年10月24日
* <p>Description:userfulfile的service层，负责文件功能 </p>
 */
@Service
public class UserfulFileService {

	@Autowired
	UserfulFileMapper userfulFileMapper;
    List<UserfulFile> getAllUserfulFile(Integer start,Integer end){
    	return userfulFileMapper.selectAll("userful_file", start, end);
    }
	
    void addAUserfulFile(UserfulFile userfulfile){
    	userfulFileMapper.insertOne(userfulfile);
    }
	
	int getUserfulFileCount(){
		return userfulFileMapper.selectCount();
	}
}
