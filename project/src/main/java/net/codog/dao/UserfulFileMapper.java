package net.codog.dao;

import java.util.List;

import net.codog.domain.UserfulFile;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserfulFileMapper {
	
	@Select("select * from userful_file")
    public List<UserfulFile> selectAll();
	
	@Insert("insert into userful_file values(#{userfulUrlLink},#{userfulUrlName},#{userfulUrlDesc})")
    public void insertOne(UserfulFile userfulfile);
	
	@Select("select count(*) from userful_file")
	public int selectCount();
}