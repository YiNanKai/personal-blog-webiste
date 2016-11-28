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
}
