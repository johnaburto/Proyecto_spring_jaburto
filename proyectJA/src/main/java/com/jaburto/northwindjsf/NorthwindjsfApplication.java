package com.jaburto.northwindjsf;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;

import javax.faces.webapp.FacesServlet;

@SpringBootApplication
public class NorthwindjsfApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(NorthwindjsfApplication.class, args);
	}
	@Bean
	public ServletRegistrationBean servletRegistrationBean() {
		return new ServletRegistrationBean(new FacesServlet(), "*.jsf", "*.xhtml");
	}
}
