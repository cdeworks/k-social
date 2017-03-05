package com.cdeworks.ksocial.conf;

import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.boot.web.servlet.ErrorPage;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class WebConfig extends WebMvcConfigurerAdapter{
	
	@Bean
	public EmbeddedServletContainerCustomizer containerCustomizer() {
	
		return (container -> 
			container.addErrorPages(new ErrorPage(HttpStatus.NOT_FOUND, "/errors/404"),
					new ErrorPage(HttpStatus.FORBIDDEN, "/errors/403"))
		);
		
	}
	
	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addRedirectViewController("/", "/home");
	}
	

}
