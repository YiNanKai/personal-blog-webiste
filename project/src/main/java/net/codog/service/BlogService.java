package net.codog.service;

import java.util.List;

import net.codog.dao.BlogCommentMapper;
import net.codog.dao.BlogMapper;
import net.codog.domain.Blog;
import net.codog.domain.BlogComment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
* @author 王文涵 
* @date 2016年10月24日
* <p>Description: blog的service层，包括博客和博客评论的信息</p>
 */
@Service
public class BlogService {
	
	@Autowired
	private BlogMapper blogMapper;
	
	@Autowired
	private BlogCommentMapper blogCommentMapper;
	
    public List<Blog> getAllBlogs(Integer start,Integer end){
    	return blogMapper.selectAll("blog", start, end);
    }
	
	public Blog getBlogByBlogId(Integer blogId){
		return blogMapper.selectBlogByBlogId(blogId);
	}
	
	public int getBlogCount(){
		return blogMapper.selectCount();
	}
	
    public List<BlogComment> getAllBlogComments(Integer start,Integer end){
    	return blogCommentMapper.selectAll("blog_comment", start, end);
    }
    
    public int getBlogCommentCount(){
    	return blogCommentMapper.selectCount();
    }
}
