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
	
	//@SelectProvider(type = SelectSqlProvider.class,method = "selectSql")
    //public List<Blog> selectAll(@Param("tableName")String tableName,@Param("start")Integer start,@Param("end")Integer end);
	
	@Select("select * from blog where blog_id = #{blogId}")
	public Blog selectBlogByBlogId(@Param("blogId")Integer blogId);
	
	@Select("select count(*) from blog")
	public int selectCount();
	
	@SelectProvider(type = SelectSqlProvider.class,method = "selectBlogs")
    public List<Blog> selectAll(@Param("start")Integer start,@Param("end")Integer end);
	
}