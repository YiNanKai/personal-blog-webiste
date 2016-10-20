package net.codog.dao;

import org.apache.ibatis.annotations.Mapper;

import net.codog.domain.Account;

@Mapper
public interface AccountMapper {
    int deleteByPrimaryKey(Integer userBasicInformationJobId);

    int insert(Account record);

    int insertSelective(Account record);

    Account selectByPrimaryKey(Integer userBasicInformationJobId);

    int updateByPrimaryKeySelective(Account record);

    int updateByPrimaryKey(Account record);
}