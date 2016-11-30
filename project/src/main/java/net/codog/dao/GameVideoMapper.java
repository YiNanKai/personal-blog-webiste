package net.codog.dao;

import java.util.List;

import net.codog.dao.selectsql.SelectSqlProvider;
import net.codog.domain.GameVideo;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;

@Mapper
public interface GameVideoMapper {

	@SelectProvider(type = SelectSqlProvider.class,method = "selectGameVideos")
    public List<GameVideo> selectAll(@Param("start")Integer start,@Param("end")Integer end);
	
	@Select("Select count(*) from game_video")
    public Integer selectCount();
}
