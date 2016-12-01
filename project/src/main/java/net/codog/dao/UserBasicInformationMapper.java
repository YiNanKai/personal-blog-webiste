package net.codog.dao;

import net.codog.domain.UserBasicInformation;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserBasicInformationMapper {
	
	@Insert("insert into user_basic_information values(#{user_basic_information_id},#{user_basic_information_birthday},#{user_basic_information_gender},#{user_basic_information_address},#{user_basic_information_register_time},1)")
    public void insertOne(UserBasicInformation userBasicInformation);
	
}