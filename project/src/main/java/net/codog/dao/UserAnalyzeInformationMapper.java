package net.codog.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

import net.codog.domain.UserAnalyzeInformation;

@Mapper
public interface UserAnalyzeInformationMapper {

	@Insert("insert into user_analyze_information values(#{userBasicInformationId},#{userExtraInformationIp},#{userExtraInformationAgent},#{userExtraInformationRefer},#{userAnalyzeInformationLoginTime},#{userAnalyzeInformationLogoutTime})")
    public void insertOne(UserAnalyzeInformation userAnalyzeInformation);
}