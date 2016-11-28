package net.codog.service;

import java.util.List;

import lombok.extern.slf4j.Slf4j;
import net.codog.dao.SearchCategoryMapper;
import net.codog.domain.SearchCategory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class SearchCategoryService {

	@Autowired
	private SearchCategoryMapper searchCategoryMapper;
	
	public List<SearchCategory> getAllSearchCategories(){
		log.info("SearchCategoryService");
		return searchCategoryMapper.selectAll();
	}
}
