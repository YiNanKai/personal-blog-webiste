package net.codog.dao;

import java.util.List;

import net.codog.dao.selectsql.SelectSqlProvider;
import net.codog.domain.Message;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;

@Mapper
public interface MessageMapper {
	
	@SelectProvider(type = SelectSqlProvider.class,method = "selectSql")
    public List<Message> selectAll(@Param("tableName")String tableName,@Param("start")Integer start,@Param("end")Integer end);
	
	@Insert("insert into message values(#{messageTitie},#{messageContent},#{messageSendTime},#{messageIsRead})")
    public void insertOne(Message message);
	
	@Select("select count(*) from message where user_basic_information_id = #{userBasicInformationId}")
	public int selectCount(@Param("userBasicInformationId")Integer userBasicInformationId);
	
	@SelectProvider(type = SelectSqlProvider.class,method = "selectMessageByIsRead")
    public List<Message> selectMessageByIsRead(@Param("start")Integer start,@Param("end")Integer end,@Param("messageIsRead")Integer messageIsRead,@Param("userBasicInformationId")Integer userBasicInformationId);
}