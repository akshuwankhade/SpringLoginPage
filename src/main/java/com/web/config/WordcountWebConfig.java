package com.web.config;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.context.support.XmlWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class WordcountWebConfig { //implements WebApplicationInitializer {

	/*@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
	
		AnnotationConfigWebApplicationContext wac = new AnnotationConfigWebApplicationContext();
		wac.register(SpringApplicationConfig.class);
		
		//XmlWebApplicationContext webAC = new XmlWebApplicationContext();
		//webAC.setConfigLocation("classpath:appconfig.xml");
		
		// Create DS
		DispatcherServlet ds = new DispatcherServlet(wac);
		
		// Register DS
		ServletRegistration.Dynamic servlet = servletContext.addServlet("MyDS", ds);
		servlet.setLoadOnStartup(1);
		servlet.addMapping("/wordcount.com/*");
		
		System.out.println(servlet.getName());
		System.out.println(servlet.getMappings());
		
	}*/

}
