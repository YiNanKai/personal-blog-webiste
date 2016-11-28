package net.codog.service;

import java.util.List;

import lombok.extern.slf4j.Slf4j;
import net.codog.dao.RecommandMapper;
import net.codog.domain.Recommand;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class RecommandService {

	@Autowired
	private RecommandMapper recommandMapper;
	
	public List<Recommand> getAllRecommand(){
		log.info("recommandService");
		return recommandMapper.selectAll();
	}
}
