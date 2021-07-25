package com.lti.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;


@Configuration
@ComponentScan(basePackages = "com.lti")
@PropertySources({
    @PropertySource("classpath:application.properties"),
    @PropertySource("classpath:jdbc.properties")
})
@EnableWebMvc
public class MyDispatcherConfig   {
	
	
	//you can configure dataSource and all other here also
	//either udse Environment or use @Value()
	
	
	@Value("${datasource1.driver-class-name}")
	private String myDBdriverclass;
	@Value("${datasource1.url}")
	private String mydbURL;
	@Value("${datasource1.username}")
	private String mydbUsername;
	@Value("${datasource1.password}")
	private String mydbPassword;
	

	
	@Bean("ds1")
    public DataSource dataSourceforMydb() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(myDBdriverclass);
        dataSource.setUrl(mydbURL);
        dataSource.setUsername(mydbUsername);
        dataSource.setPassword(mydbPassword);
        return dataSource;
	}
    
	
	@Bean("jdbcTemp1")
	public NamedParameterJdbcTemplate createNamredParameterJdbcTemplate1(@Autowired @Qualifier("ds1") DataSource dataSource1){
	    return new NamedParameterJdbcTemplate(dataSource1);
	}
	
	
	@Bean("transactionManger1")
	public DataSourceTransactionManager getTransactionmangerFormydb(@Autowired @Qualifier("ds1") DataSource datasource1) {
		return new DataSourceTransactionManager(datasource1);
	}
	
	
	
	
	
	
	
	
	
	
	@Value("${datasource2.driver-class-name}")
	private String myDBdriverclass2;
	@Value("${datasource2.url}")
	private String mydbURL2;
	@Value("${datasource2.username}")
	private String mydbUsername2;
	@Value("${datasource2.password}")
	private String mydbPassword2;
	
	
	
	
	@Bean("ds2")
    public DataSource dataSourceformyseconddb() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/myseconddb");
        dataSource.setUsername("root");
        dataSource.setPassword("root");
        return dataSource;
	}
    
	
	@Bean("jdbcTemp2")
	public NamedParameterJdbcTemplate createNamredParameterJdbcTemplate2(@Autowired @Qualifier("ds2") DataSource dataSource2){
	    return new NamedParameterJdbcTemplate(dataSource2);
	}
	
	
	@Bean("transactionManger2")
	public DataSourceTransactionManager getTransactionmangerForseconddb(@Autowired @Qualifier("ds2") DataSource datasource2) {
		return new DataSourceTransactionManager(datasource2);
	}
	
	
	
	
	@Autowired
	private Environment env;
	
	@Bean
	public InternalResourceViewResolver getViewResolver() {
		 InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		    resolver.setViewClass(JstlView.class);
	        resolver.setPrefix(env.getProperty("prefix"));
	        resolver.setSuffix(env.getProperty("suffix"));
	        return resolver;
	}
}


