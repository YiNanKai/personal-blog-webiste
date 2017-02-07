package net.codog.dao;

import java.util.List;

import net.codog.domain.News;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface NewsMapper {
	
	@Select("select * from news")
    public List<News> selectAll();

	@Insert("insert into news values(#{newsTitle},#{newsContent},#{newsPublishTime},#{newsModifyTime},#{newsUrl},#{newsTypeName})")
    public void insertOne(News news);
	
	@Select("select count(*) from news")
	public int selectCount();

}