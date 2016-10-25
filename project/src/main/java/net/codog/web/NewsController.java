package net.codog.web;

import java.util.List;

import lombok.extern.slf4j.Slf4j;
import net.codog.domain.News;
import net.codog.service.NewsService;
import net.codog.vo.ResponseVO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/news")
@Slf4j
public class NewsController {

	@Autowired
	NewsService newsService;
	
	@RequestMapping(value="/test",method=RequestMethod.GET)
	public ResponseVO<List<News>> test(){
		int start = 0;
		int end = 2;
		ResponseVO<List<News>> newsList = new ResponseVO<List<News>>(true, "", newsService.getAllNews(start, end));
		newsService.getNewsCount();
		log.info("news测试通过");
		return newsList;
	}
}
