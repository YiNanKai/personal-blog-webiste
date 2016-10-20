package net.codog.service;

import java.util.List;

import net.codog.domain.UserfulUrl;

import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Service;

@Service
public interface UserfulUrlService {

	@Select("select * from userful_url")
	List<UserfulUrl> selectUserfulUrlList(); 
}
