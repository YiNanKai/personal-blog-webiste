package net.codog.dao;

import java.util.List;

import net.codog.domain.Account;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface AccountMapper {
	
	@Select("select * from account where account_user_name = #{userName} and password = #{password}")
    public List<Account> selectByUserNameAndPassword(@Param("userName")String userName,@Param("password")String passport);

	@Select("insert into account values(#{account_user_name},#{account_password},#{account_isonline},#{user_basic_information_job_id})")
    public void insertOne(Account account);

}