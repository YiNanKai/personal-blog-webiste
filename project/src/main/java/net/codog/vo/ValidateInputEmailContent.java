package net.codog.vo;

import org.hibernate.validator.constraints.Length;
import lombok.Data;

@Data
public class ValidateInputEmailContent {

	@Length(min=1,max=10,message="标题过长")
	private String title;
	
	@Length(min=1,max=100,message="内容过长")
	private String content;
}
