package net.codog.web;

import java.util.List;

import lombok.extern.slf4j.Slf4j;
import net.codog.domain.Blog;
import net.codog.service.BlogService;
import net.codog.vo.ResponseVO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
/**
* @author 王文涵 
* @date 2016年10月24日
* <p>Description: 博客的controller层，用来处理博客界面</p>
 */
/**
* @author 王文涵 
* @date 2016年10月24日
* <p>Description: 博客的controller层，用来处理博客界面</p>
 */
@RestController
@RequestMapping("/blog")
@Slf4j
public class BlogController {
	
	@Autowired
	BlogService blogService; 
	
	@RequestMapping(value="/test",method=RequestMethod.GET)
	public ResponseVO<List<Blog>> test(){
		int start = 0;
		int end = 2;
		//build方法测试 
		/*ResponseVO<Object> res = ResponseVO.buildResponseVO().
		isSuccess(true).
		errorMessage("hahaha").
		object(blogService.getAllBlogs(start, end)).
		build();*/
		
		ResponseVO<List<Blog>> blogList = new ResponseVO<>(true,"",blogService.getAllBlogs(start, end));
		blogService.getAllBlogComments(start, end);
		blogService.getBlogByBlogId(1);
		blogService.getBlogCommentCount();
		blogService.getBlogCount();
		log.info("blog测试通过");
		return blogList;
	}
}
