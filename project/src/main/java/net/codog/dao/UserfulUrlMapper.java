package net.codog.dao;

import java.util.List;

import net.codog.domain.UserfulUrl;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserfulUrlMapper {
	
	@Select("select * from userful_url uu inner join url_type  ut on uu.url_type_id = ut.url_type_id and ut.url_type_id=#{type}")
	public List<UserfulUrl> selectAll(int type);
	
	@Select("select count(*) from userful_url uu inner join url_type  ut on uu.url_type_id = ut.url_type_id and ut.url_type_id=#{type}")
	public int selectCount(int type);
}