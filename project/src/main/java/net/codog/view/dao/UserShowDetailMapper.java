package net.codog.view.dao;

import net.codog.view.UserShowDetail;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserShowDetailMapper {
	
	@Select("select user_basic_information_birthday,user_basic_information_gender,user_basic_information_address,user_basic_information_register_time,job_name,uci.* from user_basic_information ubi join job on job.job_id = ubi.job_id join user_contact_information uci on uci.user_basic_information_id = ubi.user_basic_information_id")
	UserShowDetail selectUserShowDetailByUserBasicInformationId(@Param("userBasicInformationId")Integer userBasicInformationId);

}
