package com.slksoft.cfg;

import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.PropertySource;

import com.slksoft.dao.DummyUserDao;
import com.slksoft.dao.JdbcUserDao;

@Configuration
@PropertySource("classpath:jdbc-info.properties")
public class AppConfig1 {

	Logger log = Logger.getLogger("com.slksoft.cfg.AppConfig1");
	@Value("${jdbc.url}")
	String url;
	@Value("${jdbc.username}")
	String username;
	@Value("${jdbc.password}")
	String password;
	@Value("${jdbc.driver}")
	String driver;

	public AppConfig1() {
		log.info("AppConfig instantiated!!");
	}

	@Bean
	@Lazy
	public JdbcUserDao jdbcDao() {
		log.info("AppConfig1.jdbcDao() called!");
		JdbcUserDao dao = new JdbcUserDao();
		// setter injection
		dao.setDriver(driver);
		dao.setUrl(url);
		dao.setUsername(username);
		dao.setPassword(password);
		return dao;
	}

	@Bean
	// @Lazy
	public DummyUserDao dummyDao() {
		log.info("AppConfig1.dummyDao() called!");
		return new DummyUserDao();
	}

}
