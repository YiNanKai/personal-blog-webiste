package net.codog.dao;

import org.apache.ibatis.annotations.Mapper;

import net.codog.domain.Blog;

@Mapper
public interface BlogMapper {
    int deleteByPrimaryKey(Integer blogId);

    int insert(Blog record);

    int insertSelective(Blog record);

    Blog selectByPrimaryKey(Integer blogId);

    int updateByPrimaryKeySelective(Blog record);

    int updateByPrimaryKey(Blog record);
}