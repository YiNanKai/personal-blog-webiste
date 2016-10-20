package net.codog.dao;

import org.apache.ibatis.annotations.Mapper;

import net.codog.domain.GuestBook;

@Mapper
public interface GuestBookMapper {
    int insert(GuestBook record);

    int insertSelective(GuestBook record);
}