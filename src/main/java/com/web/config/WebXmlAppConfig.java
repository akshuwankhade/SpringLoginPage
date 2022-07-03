package com.web.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class WebXmlAppConfig extends 
AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class<?>[] getRootConfigClasses() {
		
		return null;
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class[] {SpringApplicationConfig.class};
		//Class classArr[] = {SpringApplicationConfig.class};
		//return classArr ;
	}

	@Override
	protected String[] getServletMappings() {
		return new String[] {"/"};
		//String arrMapping[] = {"/"};
		//return arrMapping;
	}
	

}
