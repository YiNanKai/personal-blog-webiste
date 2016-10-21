package net.codog.dao;

import java.util.List;

import net.codog.dao.selectsql.SelectSqlProvider;
import net.codog.domain.Blog;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;

@Mapper
public interface BlogMapper {
	
	@SelectProvider(type = SelectSqlProvider.class,method = "selectSql")
    List<Blog> selectAll(@Param("tableName")String tableName,@Param("start")Integer start,@Param("end")Integer end);
	
	@Select("select * from blog where blog_id = #{blogId}")
	Blog selectBlogByBlogId(@Param("blogId")Integer blogId);
	
	@Select("select count(*) from blog")
	int selectCount();
}