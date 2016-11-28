package net.codog.web;

import java.util.List;

import lombok.extern.slf4j.Slf4j;
import net.codog.domain.SearchCategory;
import net.codog.service.SearchCategoryService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/searchcategory")
@Slf4j
public class SearchCategoryController {
	
	@Autowired
	private SearchCategoryService searchCategoryService;
	
	@RequestMapping(value="/getsearchcategories",method=RequestMethod.POST)
	public List<SearchCategory> getSearchCategories(){
		List<SearchCategory> allSearchCategories = searchCategoryService.getAllSearchCategories();
		log.info("获取的全部搜索类型是" + allSearchCategories.toString());
		return allSearchCategories;
	}
}
