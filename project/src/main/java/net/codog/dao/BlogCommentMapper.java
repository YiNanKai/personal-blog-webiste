package net.codog.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;

import net.codog.dao.selectsql.SelectSqlProvider;
import net.codog.domain.BlogComment;

@Mapper
public interface BlogCommentMapper {
	
	@SelectProvider(type = SelectSqlProvider.class,method = "selectSql")
    public List<BlogComment> selectAll(@Param("tableName")String tableName,@Param("start")Integer start,@Param("end")Integer end);
	
	@Select("select count(*) from blog_comment")
	public int selectCount();
}