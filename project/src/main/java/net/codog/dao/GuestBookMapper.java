package net.codog.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;

import net.codog.dao.selectsql.SelectSqlProvider;
import net.codog.domain.Guestbook;

@Mapper
public interface GuestBookMapper {
	@SelectProvider(type = SelectSqlProvider.class,method = "selectSql")
    List<Guestbook> selectAll(@Param("tableName")String tableName,@Param("start")Integer start,@Param("end")Integer end);
	
	@Select("select count(*) from guestbook")
	int selectCount();
}