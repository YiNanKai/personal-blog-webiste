package net.codog.view.dao;

import net.codog.view.UserPermission;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserPermissionMapper {
	
	@Select("select ubi.user_basic_information_id,permission_url from user_basic_information ubi join user_role ur on ubi.user_basic_information_id = ur.user_basic_information_id join role r on ur.role_id = r.role_id join role_permission rp on r.role_id = rp.role_id join permission p on rp.permission_id = p.permission_id and ubi.user_basic_information_id = #{userBasicInformationId}")
	UserPermission selectByUserBasicInformationId(@Param("userBasicInformationId")Integer userBasicInformationId);
}
