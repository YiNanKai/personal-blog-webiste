package net.codog.dao;

import org.apache.ibatis.annotations.Mapper;

import net.codog.domain.UserfulUrl;

@Mapper
public interface UserfulUrlMapper {
    int deleteByPrimaryKey(String userfulUrlLink);

    int insert(UserfulUrl record);

    int insertSelective(UserfulUrl record);

    UserfulUrl selectByPrimaryKey(String userfulUrlLink);

    int updateByPrimaryKeySelective(UserfulUrl record);

    int updateByPrimaryKey(UserfulUrl record);
}