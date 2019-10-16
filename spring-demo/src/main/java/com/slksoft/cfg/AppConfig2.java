package com.slksoft.cfg;

import java.sql.Connection;
import java.sql.DriverManager;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import com.slksoft.dao.JdbcUserDao;
import com.slksoft.dao.UserDao;

@Configuration
@PropertySource("classpath:jdbc-info.properties")
public class AppConfig2 {

	@Value("${jdbc.url}")
	String url;
	@Value("${jdbc.username}")
	String username;
	@Value("${jdbc.password}")
	String password;
	@Value("${jdbc.driver}")
	String driver;

	@Bean
	public Connection connection() throws Exception {
		Class.forName(driver);
		return DriverManager.getConnection(url, username, password);
	}

	@Bean
	public UserDao jdbcDao(Connection conn) {
		JdbcUserDao dao =  new JdbcUserDao();
		dao.setConnection(conn);
		return dao;
	}
}
