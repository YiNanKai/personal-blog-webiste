package net.codog.service;

import java.util.List;

import lombok.extern.slf4j.Slf4j;
import net.codog.dao.AdvertiseMapper;
import net.codog.domain.Advertise;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class AdvertiseService {

	@Autowired
	private AdvertiseMapper advertiseMapper;
	
	public List<Advertise> getAllAdvertise(){
		log.info("AdvertiseService");
		return advertiseMapper.selectAll();
	}
}
