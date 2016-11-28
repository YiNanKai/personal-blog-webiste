package net.codog.web;

import java.util.List;

import lombok.extern.slf4j.Slf4j;
import net.codog.domain.Recommand;
import net.codog.service.RecommandService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/recommand")
@Slf4j
public class RecommandController {
	
	@Autowired
	private RecommandService recommandService;
	
	@RequestMapping(value="/getrecommands",method=RequestMethod.POST)
	public List<Recommand> getRecommands(){
		List<Recommand> recommands = recommandService.getAllRecommand();
		log.info("全部数据是" + recommands.toString());
		return recommands;
	}
}
