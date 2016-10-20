package net.codog.dao;

import org.apache.ibatis.annotations.Mapper;

import net.codog.domain.UserBasicInformation;

@Mapper
public interface UserBasicInformationMapper {
    int deleteByPrimaryKey(Integer userBasicInformationId);

    int insert(UserBasicInformation record);

    int insertSelective(UserBasicInformation record);

    UserBasicInformation selectByPrimaryKey(Integer userBasicInformationId);

    int updateByPrimaryKeySelective(UserBasicInformation record);

    int updateByPrimaryKey(UserBasicInformation record);
}