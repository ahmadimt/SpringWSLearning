/**
 * 
 */
package com.imt.test.persistence.config;

import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author imteyaza
 *
 */
@Configuration
@ComponentScan(basePackages = { "com.imt.test" })
@EnableTransactionManagement
@EnableJpaRepositories("com.imt.test.persistence.repo")
public class PersistenceContextConfig {

	@Autowired
	private Environment environment;

	@Value("${db.url}")
	private String dbUrl;

	@Value("${db.driver}")
	private String driverClass;

	@Value("${db.username}")
	private String dbUserName;

	@Value("${db.password}")
	private String password;

	@Value("${hibernate.dialect}")
	private String hibernateDialect;

	@Value("${hibernate.ejb.naming_strategy}")
	private String hibernateEjbNamingStrategy;

	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
		LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
		em.setDataSource(dataSource());
		em.setPackagesToScan(new String[] { "com.imt.test" });
		JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
		em.setJpaVendorAdapter(vendorAdapter);
		em.setJpaProperties(jpaProperties());
		return em;
	}

	@Bean
	public PlatformTransactionManager transactionManager(
			EntityManagerFactory emf) {
		JpaTransactionManager transactionManager = new JpaTransactionManager();
		transactionManager.setEntityManagerFactory(emf);

		return transactionManager;
	}

	@Bean
	public PersistenceExceptionTranslationPostProcessor exceptionTranslation() {
		return new PersistenceExceptionTranslationPostProcessor();
	}

	Properties jpaProperties() {
		Properties prop = new Properties();
		prop.setProperty("hibernate.dialect", hibernateDialect);
		prop.setProperty("hibernate.ejb.naming_strategy",
				hibernateEjbNamingStrategy);
		return prop;

	}

	@Bean
	public DataSource dataSource() {
		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setDriverClassName(driverClass);
		dataSource.setUrl(dbUrl);
		dataSource.setUsername(dbUserName);
		dataSource.setPassword(password);
		return dataSource;
	}
}
