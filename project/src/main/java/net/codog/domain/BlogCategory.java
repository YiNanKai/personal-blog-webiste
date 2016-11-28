package net.codog.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BlogCategory {

	private Integer blog_category_id;
	private String blog_category_name;
	private Integer blog_category_isSchool;
	private String blog_category_iconname;
}
