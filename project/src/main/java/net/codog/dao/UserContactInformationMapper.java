package net.codog.dao;

import org.apache.ibatis.annotations.Mapper;

import net.codog.domain.UserContactInformation;

@Mapper
public interface UserContactInformationMapper {
    int deleteByPrimaryKey(Integer userBasicInformationId);

    int insert(UserContactInformation record);

    int insertSelective(UserContactInformation record);

    UserContactInformation selectByPrimaryKey(Integer userBasicInformationId);

    int updateByPrimaryKeySelective(UserContactInformation record);

    int updateByPrimaryKey(UserContactInformation record);
}