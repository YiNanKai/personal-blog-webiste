package net.codog.dao;

import org.apache.ibatis.annotations.Mapper;

import net.codog.domain.UserfulFile;

@Mapper
public interface UserfulFileMapper {
    int deleteByPrimaryKey(String userfulFileSourceLink);

    int insert(UserfulFile record);

    int insertSelective(UserfulFile record);

    UserfulFile selectByPrimaryKey(String userfulFileSourceLink);

    int updateByPrimaryKeySelective(UserfulFile record);

    int updateByPrimaryKey(UserfulFile record);
}