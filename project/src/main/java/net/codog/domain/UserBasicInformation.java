package net.codog.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author 王文涵
 * @date 2016年10月20日
 *       <p>
 *       Description:user_basic_information表的实体类
 *       </p>
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class UserBasicInformation {
	
	private String user_basic_information_id;

	private String user_basic_information_birthday;

	private Boolean user_basic_information_gender;

	private String user_basic_information_address;

	private String user_basic_information_register_time;

	private Integer job_id;
}