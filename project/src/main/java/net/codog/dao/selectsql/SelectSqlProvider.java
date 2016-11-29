package net.codog.dao.selectsql;

import java.util.Map;

import lombok.extern.slf4j.Slf4j;

/***
* @author 王文涵 
* @date 2016年10月24日
* <p>Description: 提供复杂sql的类</p>
 */

@Slf4j
public class SelectSqlProvider {
	
	/**
	 * @param para 根据表名分页查询
	 * @return 查询的sql
	 */
	public String selectSql(Map<String, Object> para) {  
        String result = "select * from " + para.get("tableName") + " where 1";
        //用于分页
        if(para.get("start") != null && para.get("end") != null){
        	result += " limit " + para.get("start") + "," + para.get("end");
        }
        log.info("sql is " + result);
		return result;
    }
	
	/**
	 * @param para 获取用户的未读，已读，或者全部消息
	 * @return 查询的sql
	 */
	public String selectMessageByIsRead(Map<String, Object> para){
		String result = "select * from message where user_basic_information_id = " + para.get("userBasicInformationId");
        //用于分页
		if(para.get("messageIsRead") != null){
			result += " and message_isread = " + para.get("messageIsRead");
		}
        if(para.get("start") != null && para.get("end") != null){
        	result += " limit " + para.get("start") + "," + para.get("end");
        }
        log.info("sql is " + result);
		return result;
	}
	
	public String selectBlogs(Map<String, Object> para){
		String result = "select blog.*,blog_type.blog_type_name from blog left join blog_type on blog.blog_type_id = blog_type.blog_type_id left join blog_category on blog.blog_category_id = blog_category.blog_category_id where blog_category.blog_category_isSchool=" + para.get("isSchool");
        if(para.get("start") != null && para.get("end") != null){
        	result += " limit " + para.get("start") + "," + para.get("end");
        }
        log.info("sql is " + result);
		return result;
	}
	
	public String selectGameVideos(Map<String, Object> para){
		String result = "select game_video.*,game_video_type.game_video_type_name from game_video left join game_video_type on game_video.game_video_type_id = game_video_type.game_video_type_id";
        if(para.get("start") != null && para.get("end") != null){
        	result += " limit " + para.get("start") + "," + para.get("end");
        }
        log.info("sql is " + result);
		return result;
	}
}
