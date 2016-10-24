package net.codog.service;

import java.util.List;

import net.codog.dao.NewsMapper;
import net.codog.domain.News;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
/**
* @author 王文涵 
* @date 2016年10月24日
* <p>Description:news的service层，负责新闻功能 </p>
 */
@Service
public class NewsService {
    
	@Autowired
	private NewsMapper newsMapper;
	
	public List<News> getAllNews(Integer start,Integer end){
		return newsMapper.selectAll("news", start, end);
	}

    public void addANews(News news){
    	newsMapper.insertOne(news);
    }
	
	public int getNewsCount(){
		return newsMapper.selectCount();
	}
}
