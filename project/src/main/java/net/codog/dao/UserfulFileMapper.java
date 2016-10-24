package net.codog.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;

import net.codog.dao.selectsql.SelectSqlProvider;
import net.codog.domain.UserfulFile;

@Mapper
public interface UserfulFileMapper {
	
	//@Select("select * from userful_file")
	@SelectProvider(type = SelectSqlProvider.class,method = "selectSql")
    public List<UserfulFile> selectAll(@Param("tableName")String tableName,@Param("start")Integer start,@Param("end")Integer end);
	
	@Insert("insert into userful_file values(#{userfulUrlLink},#{userfulUrlName},#{userfulUrlDesc})")
    public void insertOne(UserfulFile userfulfile);
	
	@Select("select count(*) from userful_file")
	public int selectCount();
}