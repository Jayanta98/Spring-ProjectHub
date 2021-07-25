package com.lti.config;


import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;



public class WebConfig  extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class<?>[] getRootConfigClasses() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
	
		return new Class[] {
				MyDispatcherAndDataSourceConfig.class
		};
	}

	@Override
	protected String[] getServletMappings() {
		return new String[] {
			"/myrest/*"
		};
	}

}
