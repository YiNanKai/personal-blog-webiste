package net.codog.dao;

import java.util.List;

import net.codog.domain.Blog;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface BlogMapper {
	
	@Select("select * from blog where blog_id = #{blogId}")
	public Blog selectBlogByBlogId(@Param("blogId")Integer blogId);
	
	@Select("select count(*) from blog")
	public int selectCount();
	
	@Select("select count(*) from blog where blog_category_id = #{blogCategoryId}")
	public int selectCountByCategory(@Param("blogCategoryId") Integer blogCategoryId);

	@Select("select blog.*,blog_type.blog_type_name from blog left join blog_type on blog.blog_type_id = blog_type.blog_type_id left join blog_category on blog.blog_category_id = blog_category.blog_category_id where blog_category.blog_category_isSchool=#{isSchool}")
    public List<Blog> selectAll(@Param("isSchool") Integer isSchool);
	
	@Select("select blog.*,blog_type.blog_type_name from blog left join blog_type on blog.blog_type_id = blog_type.blog_type_id left join blog_category on blog.blog_category_id = blog_category.blog_category_id where blog_category.blog_category_isSchool=#{isSchool} and blog_category.blog_category_id = #{blogCategoryId}")
    public List<Blog> selectAllByCategory(@Param("isSchool") Integer isSchool,@Param("blogCategoryId")Integer blogCategoryId);
}