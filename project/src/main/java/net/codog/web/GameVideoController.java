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

@RestController
@RequestMapping("/gamevideo")
@Slf4j
public class GameVideoController {

	@Autowired
	private GameVideoService gameVideoService;
	
	@RequestMapping(value="/getgamevideos",method=RequestMethod.POST)
	public List<GameVideo> getGameVideos(@RequestParam("start")Integer start,@RequestParam("end")Integer end){
		log.info("getgamevideos");
		return gameVideoService.getAllGameVideos(start, end);
	}
	
	@RequestMapping(value="/getgamevideoscount",method=RequestMethod.POST)
	public Integer getGameVideosCount(){
		log.info("getgamevideoscount");
		return gameVideoService.getGameVideosCount();
	}
}
