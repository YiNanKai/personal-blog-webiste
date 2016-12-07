package net.codog.service;

import java.util.List;

import net.codog.dao.GameVideoMapper;
import net.codog.domain.GameVideo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GameVideoService {
	@Autowired
	private GameVideoMapper gameVideoMapper;
	
	public List<GameVideo> getAllGameVideos(Integer start,Integer end){
		return gameVideoMapper.selectAll(start, end);
	}
	
	public Integer getGameVideosCount(){
		return gameVideoMapper.selectCount();
	}
	
	public List<GameVideo> getAllGameVideosByType(Integer start,Integer end,Integer gameVideoTypeId){
		return gameVideoMapper.selectAllByType(start, end, gameVideoTypeId);
	}
	
	public Integer getGameVideosCountByType(Integer gameVideoTypeId){
		return gameVideoMapper.selectCountByType(gameVideoTypeId);
	}
}
