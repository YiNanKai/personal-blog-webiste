package net.codog.dao;

import java.util.List;

import net.codog.domain.BlogComment;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface BlogCommentMapper {
	
	@Select("select * from blog_comment")
    public List<BlogComment> selectAll();
	
	@Select("select count(*) from blog_comment")
	public int selectCount();
}