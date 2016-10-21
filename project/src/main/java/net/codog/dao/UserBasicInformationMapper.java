package net.codog.dao;

import net.codog.domain.UserBasicInformation;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserBasicInformationMapper {
	
	@Insert("insert into user_basic_information values(#{userBasicInformationId},#{userBasicInformationBirthday},#{userBasicInformationGender},#{userBasicInformationAddress},#{userBasicInformationRegisterTime})")
    void insertOne(UserBasicInformation userBasicInformation);
	
	
}