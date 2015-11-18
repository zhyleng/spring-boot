package com.netease.springboot.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.boot.context.embedded.FilterRegistrationBean;
import org.springframework.boot.context.embedded.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;

import com.netease.springboot.controller.TestServlet;
import com.netease.springboot.filter.TestFilter;
import com.netease.springboot.model.User;

@PropertySource("classpath:application-dev.properties")
@ImportResource({"spring-mvc.xml"})
@Configuration
public class ApplicationConfig {
	@Value("${id}")
	private int id;
	@Value("${name}")
	private String name;
	
	
	@Scope(value=ConfigurableBeanFactory.SCOPE_PROTOTYPE)
	@Bean(name="user", autowire=Autowire.BY_TYPE)
	public User user() {
		return new User(id, name);
	}
	
	@Bean(name="testServletRegistrationBean")
	public ServletRegistrationBean servletRegistrationBean() {
		ServletRegistrationBean srb = new ServletRegistrationBean();
		srb.setServlet(new TestServlet());
		srb.setUrlMappings(Arrays.asList("/one"));
		srb.setLoadOnStartup(1);
		srb.setEnabled(true);
		srb.setOrder(1);
		return srb;
	}
	
	@Bean
	public FilterRegistrationBean filterRegistrationBean() {
		FilterRegistrationBean frb = new FilterRegistrationBean();
		frb.setFilter(new TestFilter());
		frb.setEnabled(true);
		frb.setUrlPatterns(Arrays.asList("/ts", "/test"));
		frb.setOrder(1);
		return frb;
	}
}