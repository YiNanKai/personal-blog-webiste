package net.codog.web;

import java.util.List;

import lombok.extern.slf4j.Slf4j;
import net.codog.domain.Advertise;
import net.codog.service.AdvertiseService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/advertise")
@Slf4j
public class AdvertiseController {
	
	@Autowired
	private AdvertiseService advertiseService;
	
	@RequestMapping(value="/getadvertises",method=RequestMethod.POST)
	public List<Advertise> getAdvertise(){
		List<Advertise> advertises = advertiseService.getAllAdvertise();
		log.info("全部数据是" + advertises.toString());
		return advertises;
	}
}
