package net.codog.dao;

import java.util.List;

import net.codog.domain.Recommand;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface RecommandMapper {
	
	@Select("select * from recommand")
    public List<Recommand> selectAll();

}