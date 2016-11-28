package net.codog.dao;

import java.util.List;

import net.codog.domain.SearchCategory;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface SearchCategoryMapper {
	
	@Select("select * from search_category")
	public List<SearchCategory> selectAll();
}
