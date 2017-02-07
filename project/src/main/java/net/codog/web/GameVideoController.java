package net.codog.web;

import java.util.List;

import lombok.extern.slf4j.Slf4j;
import net.codog.domain.GameVideo;
import net.codog.service.GameVideoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageHelper;

@RestController
@RequestMapping("/gamevideo")
@Slf4j
public class GameVideoController {

	@Autowired
	private GameVideoService gameVideoService;
	
	@RequestMapping(value="/getgamevideos",method=RequestMethod.POST)
	public List<GameVideo> getGameVideos(Integer start,Integer end,@RequestParam("gameVideoTypeId") Integer gameVideoTypeId){
		log.info("getgamevideos");
		if(start != null || end != null){
			PageHelper.startPage(start,end);
		}
		return gameVideoService.getAllGameVideosByType(gameVideoTypeId);
	}
	
	@RequestMapping(value="/getgamevideoscount",method=RequestMethod.POST)
	public Integer getGameVideosCount(@RequestParam("gameVideoTypeId") Integer gameVideoTypeId){
		log.info("getgamevideoscount");
		return gameVideoService.getGameVideosCountByType(gameVideoTypeId);
	}
}
