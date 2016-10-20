package net.codog.dao;

import org.apache.ibatis.annotations.Mapper;

import net.codog.domain.Job;

@Mapper
public interface JobMapper {
    int deleteByPrimaryKey(Integer jobId);

    int insert(Job record);

    int insertSelective(Job record);

    Job selectByPrimaryKey(Integer jobId);

    int updateByPrimaryKeySelective(Job record);

    int updateByPrimaryKey(Job record);
}