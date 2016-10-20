package net.codog.dao;

import org.apache.ibatis.annotations.Mapper;

import net.codog.domain.UserAnalyzeInformation;

@Mapper
public interface UserAnalyzeInformationMapper {
    int insert(UserAnalyzeInformation record);

    int insertSelective(UserAnalyzeInformation record);
}