package net.codog.dao.selectsql;

import java.util.Map;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SelectSqlProvider {
	
	public String selectSql(Map<String, Object> para) {  
        String result = "select * from " + para.get("tableName") + " where 1";
        //用于分页
        if(para.get("start") != null && para.get("end") != null){
        	result += " limit " + para.get("start") + "," + para.get("end");
        }
        log.debug("sql is " + result);
		return result;
    }
	
	public String selectMessageByIsRead(Map<String, Object> para){
		String result = "select * from message where 1";
        //用于分页
		if(para.get("messageIsRead") != null){
			result += " and message_isread = " + para.get("messageIsRead");
		}
        if(para.get("start") != null && para.get("end") != null){
        	result += " limit " + para.get("start") + "," + para.get("end");
        }
        log.debug("sql is " + result);
		return result;
	}
}
