package net.codog.dao;

import java.util.List;

import net.codog.domain.BlogCategory;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface BlogCategoryMapper {

	@Select("select * from blog_category where blog_category_isSchool = #{isSchool}")
	public List<BlogCategory> selectAll(@Param("isSchool")Integer isSchool);
}
