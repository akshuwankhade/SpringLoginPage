package com.web.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.web")
public class SpringApplicationConfig implements WebMvcConfigurer {

/*			@Bean
			public InternalResourceViewResolver viewResolver() {
			InternalResourceViewResolver vm = new InternalResourceViewResolver();
			vm.setPrefix("/WEB-INF/");;
			vm.setSuffix(".jsp");;
			return vm;
		}*/
	
		@Override
		public void configureViewResolvers(ViewResolverRegistry registry) {
			registry.jsp("/WEB-INF/", ".jsp");
		
		}
		@Override
		public void addResourceHandlers(ResourceHandlerRegistry registry) {
			registry.addResourceHandler("/resources/**").addResourceLocations("classpath:/statics/");
		}
		
		@Bean
		DriverManagerDataSource getDataSource() {
		DriverManagerDataSource dataSource  = new DriverManagerDataSource();
		
		//Set the DB info to the Datasource object
		
		dataSource.setUsername("root");
		dataSource.setPassword("root");
		dataSource.setUrl("jdbc:mysql://localhost:3306/wordcount");
		dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
		
		//(spring?allowPublicKeyRetrieval=true&useSSL=false");
		
		return dataSource;
		}
		
		@Bean
		public JdbcTemplate jdbcTemplate() {
			return new JdbcTemplate((javax.sql.DataSource) getDataSource());
		}
}
