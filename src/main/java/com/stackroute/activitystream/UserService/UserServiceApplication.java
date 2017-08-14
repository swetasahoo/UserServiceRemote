package com.stackroute.activitystream.UserService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.orm.jpa.vendor.HibernateJpaSessionFactoryBean;
import org.springframework.web.client.RestTemplate;

import com.stackroute.activitystream.model.User;


@SpringBootApplication(scanBasePackages={"com.stackroute.activitystream"})
@EntityScan(basePackages={"com.stackroute.activitystream.model"})
public class UserServiceApplication {

	
	@Bean
	public HibernateJpaSessionFactoryBean sessionFactory() {
	    return new HibernateJpaSessionFactoryBean();
	}
	
	

	
	public static void main(String[] args) {
		SpringApplication.run(UserServiceApplication.class, args);
	}
}
