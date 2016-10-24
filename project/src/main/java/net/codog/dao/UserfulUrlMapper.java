package net.codog.dao;

import java.util.List;

import net.codog.dao.selectsql.SelectSqlProvider;
import net.codog.domain.UserfulUrl;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;

@Mapper
public interface UserfulUrlMapper {
	
	//@Select("select * from userful_url")
	@SelectProvider(type = SelectSqlProvider.class,method = "selectSql")
    public List<UserfulUrl> selectAll(@Param("tableName")String tableName,@Param("start")Integer start,@Param("end")Integer end);
	
	@Insert("insert into userful_url values(#{userfulUrlLink},#{userfulUrlName},#{userfulUrlDesc})")
    public void insertOne(UserfulUrl userfulUrl);
	
	@Select("select count(*) from userful_url")
	public int selectCount();
}