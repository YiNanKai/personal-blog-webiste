package net.codog.dao;

import java.util.List;

import net.codog.domain.Guestbook;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface GuestBookMapper {
	@Select("select * from guestbook")
    public List<Guestbook> selectAll();
	
	@Select("select count(*) from guestbook")
	public int selectCount();
}