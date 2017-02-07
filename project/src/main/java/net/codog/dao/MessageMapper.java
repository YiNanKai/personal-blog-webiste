package net.codog.dao;

import java.util.List;

import net.codog.domain.Message;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface MessageMapper {
	
	@Select("select * from message")
    public List<Message> selectAll();
	
	@Insert("insert into message values(#{messageTitie},#{messageContent},#{messageSendTime},#{messageIsRead})")
    public void insertOne(Message message);
	
	@Select("select count(*) from message where user_basic_information_id = #{userBasicInformationId}")
	public int selectCount(@Param("userBasicInformationId")Integer userBasicInformationId);
	
	@Select("select * from message where user_basic_information_id = #{userBasicInformationId} and message_isread = #{messageIsRead}")
    public List<Message> selectMessageByIsRead(@Param("messageIsRead")Integer messageIsRead,@Param("userBasicInformationId")Integer userBasicInformationId);
}