package net.codog.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

import net.codog.domain.UserContactInformation;

@Mapper
public interface UserContactInformationMapper {
    
	@Insert("insert into user_contact_information values(#{userContactInformationQq},#{userContactInformationWeixin},#{userContactInformationWeibo},#{userContactInformationEmail},#{userContactInformationPhone},#{userContactInformationGithub},#{userContactInformationBlog},#{userContactInformationOther})")
    void insertOne(UserContactInformation userContactInformation);
}