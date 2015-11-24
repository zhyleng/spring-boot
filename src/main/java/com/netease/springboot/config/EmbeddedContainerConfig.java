package com.netease.springboot.config;

import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.stereotype.Component;

/**
 * 嵌入的Servlet容器定制
 * 	配置Tomcat
 * @author hzlengzhaoyang
 *
 */
@Component
public class EmbeddedContainerConfig implements EmbeddedServletContainerCustomizer{

	@Override
	public void customize(ConfigurableEmbeddedServletContainer container) {
		// TODO Auto-generated method stub
		container.setContextPath("");
		container.setPort(80);
		container.setSessionTimeout(30*60);
	}

}
