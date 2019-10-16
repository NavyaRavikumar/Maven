package com.slksoft.programs;

import java.util.logging.Logger;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.slksoft.cfg.AppConfig4;
import com.slksoft.dao.UserDao;

public class Main1 {
	
	static Logger log = Logger.getLogger("Main1");

	public static void main(String[] args) {

		AnnotationConfigApplicationContext ctx;
		ctx = new AnnotationConfigApplicationContext(AppConfig4.class);
		
		log.info("-------------Spring Container ready!!");
		UserDao dao= ctx.getBean("jdbcDao", UserDao.class);
		
		int c = dao.count();
		log.info(String.format("There are %d users", c));
		
		ctx.close();
	}

}
