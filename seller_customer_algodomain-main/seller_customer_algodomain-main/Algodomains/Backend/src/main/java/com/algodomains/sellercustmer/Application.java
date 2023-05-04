package com.algodomains.sellercustmer;

import org.hibernate.SessionFactory;
import org.hibernate.jpa.HibernateEntityManagerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication(scanBasePackages = "com.algodomains.sellercustmer")
@EnableScheduling
@EnableAutoConfiguration
@Configuration
public class Application {
    public static void main(String [] args){
        SpringApplication.run(Application.class,args);
    }
    @Bean
    public SessionFactory sessionFactory (HibernateEntityManagerFactory hibernateEntityManagerFactory){
        return hibernateEntityManagerFactory.getSessionFactory();
    }
}
