package net.codog.dao;

import org.apache.ibatis.annotations.Mapper;

import net.codog.domain.Message;

@Mapper
public interface MessageMapper {
    int deleteByPrimaryKey(Integer message);

    int insert(Message record);

    int insertSelective(Message record);

    Message selectByPrimaryKey(Integer message);

    int updateByPrimaryKeySelective(Message record);

    int updateByPrimaryKey(Message record);
}