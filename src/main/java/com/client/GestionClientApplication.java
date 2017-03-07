package com.client;

import org.glassfish.jersey.servlet.ServletContainer;
import org.glassfish.jersey.servlet.ServletProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.client.controller.JerseyConfig;

@SpringBootApplication
@Controller
@EnableAutoConfiguration
@ComponentScan({"com.client"})
public class GestionClientApplication {

	
	@RequestMapping("/")
    @ResponseBody
    String home() {
        return "Hello World!";
    }
	public static void main(String[] args) {
		SpringApplication.run(GestionClientApplication.class, args);
	}
	@Bean
	public ServletRegistrationBean jerseyServlet() {
	    ServletRegistrationBean registration = new ServletRegistrationBean(new ServletContainer(), "/rest/*");
	    // our rest resources will be available in the path /rest/*
	    registration.addInitParameter(ServletProperties.JAXRS_APPLICATION_CLASS, JerseyConfig.class.getName());
	    return registration;
	}
}
