package net.codog.dao;

import org.apache.ibatis.annotations.Mapper;

import net.codog.domain.News;

@Mapper
public interface NewsMapper {
    int deleteByPrimaryKey(Integer newsId);

    int insert(News record);

    int insertSelective(News record);

    News selectByPrimaryKey(Integer newsId);

    int updateByPrimaryKeySelective(News record);

    int updateByPrimaryKey(News record);
}