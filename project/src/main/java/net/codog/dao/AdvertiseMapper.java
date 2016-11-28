package net.codog.dao;

import java.util.List;

import net.codog.domain.Advertise;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface AdvertiseMapper {
	
	@Select("select * from advertise")
    public List<Advertise> selectAll();

}