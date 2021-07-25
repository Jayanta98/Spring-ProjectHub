package com.lti.config;

import java.util.HashMap;

import javax.persistence.EntityManagerFactory;
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
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@Configuration
@ComponentScan(basePackages = "com.lti")
@PropertySources({
		@PropertySource("classpath:application.properties"),
		@PropertySource("classpath:jdbc.properties")
})
@EnableWebMvc  //this is very very important for MVC+ REST
public class MyDispatcherAndDataSourceConfig {
	
	
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
	
	  @Bean("entityMangerFactoryFormyDB")
	    public LocalContainerEntityManagerFactoryBean primeEntityManager(@Autowired @Qualifier("ds1") DataSource datasource1) {
	        LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
	        em.setDataSource(datasource1);
	        em.setPackagesToScan("com.lti.model");///////Package for @Entity
	        
	        
	        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
	        em.setJpaVendorAdapter(vendorAdapter);
	        HashMap<String, Object> properties = new HashMap<String, Object>();
	       // properties.put("hibernate.hbm2ddl.auto", env.getProperty("hibernate.hbm2ddl.auto"));
	       //properties.put("hibernate.dialect", env.getProperty("hibernate.dialect"));
	        properties.put("hibernate.show_sql", true);
	        
	        em.setJpaPropertyMap(properties);
	        return em;
	    }
	/*<property name="jpaProperties">
				<props>
				<!-- <prop key="hibernate.hbm2ddl.auto">validate</prop> -->
					<prop key="hibernate.show_sql">true</prop>
				</props>
			</property>*/
	
	
	
	  @Bean("myDBTXm")
	   public PlatformTransactionManager primeTransactionManager(@Autowired @Qualifier("entityMangerFactoryFormyDB") EntityManagerFactory entityMangerFactoryFormyDB) {
	        JpaTransactionManager transactionManager = new JpaTransactionManager();
	        transactionManager.setEntityManagerFactory(entityMangerFactoryFormyDB);
	        return transactionManager;
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
	
	
	 @Bean("entityMangerFactoryForSecondDB")
	    public LocalContainerEntityManagerFactoryBean getEntityManagerForSecondDB(@Autowired @Qualifier("ds2") DataSource datasource2) {
	        LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
	        em.setDataSource(datasource2);
	        em.setPackagesToScan("com.lti.model");///////Package for @Entity
	        
	        
	        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
	        em.setJpaVendorAdapter(vendorAdapter);
	        HashMap<String, Object> properties = new HashMap<String, Object>();
	       // properties.put("hibernate.hbm2ddl.auto", env.getProperty("hibernate.hbm2ddl.auto"));
	       //properties.put("hibernate.dialect", env.getProperty("hibernate.dialect"));
	        properties.put("hibernate.show_sql", true);
	        
	        em.setJpaPropertyMap(properties);
	        return em;
	    }
	/*<property name="jpaProperties">
				<props>
				<!-- <prop key="hibernate.hbm2ddl.auto">validate</prop> -->
					<prop key="hibernate.show_sql">true</prop>
				</props>
			</property>*/
	
	
	
	  @Bean("myDBTXmForSecondDB")
	   public PlatformTransactionManager getTransactionManagerForSecondDB(@Autowired @Qualifier("entityMangerFactoryForSecondDB") EntityManagerFactory entityMangerFactoryForSecondDB) {
	        JpaTransactionManager transactionManager = new JpaTransactionManager();
	        transactionManager.setEntityManagerFactory(entityMangerFactoryForSecondDB);
	        return transactionManager;
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
