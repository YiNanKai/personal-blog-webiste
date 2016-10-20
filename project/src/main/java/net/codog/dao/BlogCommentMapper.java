package net.codog.dao;

import org.apache.ibatis.annotations.Mapper;

import net.codog.domain.BlogComment;

@Mapper
public interface BlogCommentMapper {
    int deleteByPrimaryKey(Integer blogCommentId);

    int insert(BlogComment record);

    int insertSelective(BlogComment record);

    BlogComment selectByPrimaryKey(Integer blogCommentId);

    int updateByPrimaryKeySelective(BlogComment record);

    int updateByPrimaryKey(BlogComment record);
}