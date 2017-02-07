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
	
	public List<GameVideo> getAllGameVideos(){
		return gameVideoMapper.selectAll();
	}
	
	public Integer getGameVideosCount(){
		return gameVideoMapper.selectCount();
	}
	
	public List<GameVideo> getAllGameVideosByType(Integer gameVideoTypeId){
		return gameVideoMapper.selectAllByType(gameVideoTypeId);
	}
	
	public Integer getGameVideosCountByType(Integer gameVideoTypeId){
		return gameVideoMapper.selectCountByType(gameVideoTypeId);
	}
}
