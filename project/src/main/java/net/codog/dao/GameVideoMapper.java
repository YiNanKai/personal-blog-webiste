package net.codog.dao;

import java.util.List;

import net.codog.domain.GameVideo;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface GameVideoMapper {

	@Select("select * from game_video")
	public List<GameVideo> selectAll();

	@Select("Select count(*) from game_video")
	public Integer selectCount();

	@Select("select game_video.*,game_video_type.game_video_type_name from game_video left join game_video_type on game_video.game_video_type_id = game_video_type.game_video_type_id where game_video.game_video_type_id = #{gameVideoTypeId}")
	public List<GameVideo> selectAllByType(@Param("gameVideoTypeId") Integer gameVideoTypeId);

	@Select("Select count(*) from game_video where game_video_type_id=#{gameVideoTypeId}")
	public Integer selectCountByType(
			@Param("gameVideoTypeId") Integer gameVideoTypeId);
}
