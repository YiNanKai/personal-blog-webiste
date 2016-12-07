package net.codog.web;

import java.util.List;

import lombok.extern.slf4j.Slf4j;
import net.codog.domain.Blog;
import net.codog.domain.BlogCategory;
import net.codog.service.BlogCategoryService;
import net.codog.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 王文涵
 * @date 2016年10月24日
 *       <p>
 *       Description: 博客的controller层，用来处理博客界面
 *       </p>
 */
@RestController
@RequestMapping("/blog")
@Slf4j
public class BlogController {

	@Autowired
	BlogService blogService;

	@Autowired
	BlogCategoryService blogCategoryService;

	@RequestMapping(value = "/getblogcategories", method = RequestMethod.POST)
	public List<BlogCategory> getBlogCategories(
			@RequestParam("isSchool") Integer isSchool) {
		return blogCategoryService.getAllBlogCategories(isSchool);
	}

	@RequestMapping(value = "/getblogs", method = RequestMethod.POST)
	public List<Blog> getBlogs(@RequestParam("start") Integer start,
			@RequestParam("end") Integer end,
			@RequestParam("isSchool") Integer isSchool,@RequestParam("blogCategoryId") Integer blogCategoryId) {
		log.info("start:" + start + ",end:" + end + ",isSchool:" + isSchool + ",blogCategoryId:" + blogCategoryId);
		return blogService.getAllBlogsByCategory(start, end, isSchool, blogCategoryId);
	}

	@RequestMapping(value = "/getblogcount", method = RequestMethod.POST)
	public Integer getBlogCount(@RequestParam("blogCategoryId") Integer blogCategoryId) {
		return blogService.getBlogCountByCategory(blogCategoryId);
	}
}
