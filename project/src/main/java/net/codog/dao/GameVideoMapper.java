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

	@SelectProvider(type = SelectSqlProvider.class, method = "selectGameVideos")
	public List<GameVideo> selectAll(@Param("start") Integer start,
			@Param("end") Integer end);

	@Select("Select count(*) from game_video")
	public Integer selectCount();

	@SelectProvider(type = SelectSqlProvider.class, method = "selectGameVideosByType")
	public List<GameVideo> selectAllByType(@Param("start") Integer start,
			@Param("end") Integer end,
			@Param("gameVideoTypeId") Integer gameVideoTypeId);

	@Select("Select count(*) from game_video where game_video_type_id=#{gameVideoTypeId}")
	public Integer selectCountByType(
			@Param("gameVideoTypeId") Integer gameVideoTypeId);
}
