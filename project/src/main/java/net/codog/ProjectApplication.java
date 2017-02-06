package net.codog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.boot.web.servlet.ErrorPage;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;

@SpringBootApplication
@EnableCaching
public class ProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjectApplication.class, args);
	}
	
	@Bean
	public EmbeddedServletContainerCustomizer containerCustomizer() {

		return (container -> {
			ErrorPage error401Page = new ErrorPage(HttpStatus.UNAUTHORIZED,
					"/404.html");
			ErrorPage error404Page = new ErrorPage(HttpStatus.NOT_FOUND,
					"/404.html");
			ErrorPage error500Page = new ErrorPage(
					HttpStatus.INTERNAL_SERVER_ERROR, "/404.html");

			container.addErrorPages(error401Page, error404Page, error500Page);
		});
	}
}
