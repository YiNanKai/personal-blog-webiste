package net.codog.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;

import net.codog.dao.selectsql.SelectSqlProvider;
import net.codog.domain.Message;
import net.codog.domain.News;

@Mapper
public interface MessageMapper {
	@SelectProvider(type = SelectSqlProvider.class,method = "selectSql")
    List<Message> selectAll(@Param("tableName")String tableName,@Param("start")Integer start,@Param("end")Integer end);
	
	@Insert("insert into message values(#{messageTitie},#{messageContent},#{messageSendTime},#{messageIsRead})")
    void insertOne(News news);
	
	@Select("select count(*) from message")
	int selectCount();
	
	@SelectProvider(type = SelectSqlProvider.class,method = "selectMessageByIsRead")
    List<Message> selectMessageByIsRead(@Param("tableName")String tableName,@Param("start")Integer start,@Param("end")Integer end,@Param("messageIsRead")Integer messageIsRead);
}