package net.codog.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;

import net.codog.dao.selectsql.SelectSqlProvider;
import net.codog.domain.News;

@Mapper
public interface NewsMapper {
	@SelectProvider(type = SelectSqlProvider.class,method = "selectSql")
    List<News> selectAll(@Param("tableName")String tableName,@Param("start")Integer start,@Param("end")Integer end);

	@Insert("insert into news values(#{newsTitle},#{newsContent},#{newsPublishTime},#{newsModifyTime},#{newsUrl},#{newsTypeName})")
    void insertOne(News news);
	
	@Select("select count(*) from news")
	int selectCount();
}