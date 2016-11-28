package net.codog.service;

import java.util.List;

import lombok.extern.slf4j.Slf4j;
import net.codog.dao.BlogCategoryMapper;
import net.codog.domain.BlogCategory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class BlogCategoryService {

	@Autowired
	private BlogCategoryMapper blogCategoryMapper;
	
	public List<BlogCategory> getAllBlogCategories(Integer isSchool){
		log.info("isSchool:" + isSchool);
		return blogCategoryMapper.selectAll(isSchool);
	}
}
