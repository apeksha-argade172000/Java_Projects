package com.college.project;


import org.hibernate.SessionFactory;
import org.hibernate.jpa.HibernateEntityManagerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;
import java.util.Date;
import java.util.TimeZone;

@SpringBootApplication(scanBasePackages = "com.college.project")
@EnableAutoConfiguration
@EnableScheduling
@Configuration
@Transactional
public class Application {
    @PostConstruct
    void started(){
        TimeZone.setDefault(TimeZone.getTimeZone("Asia/Kolkata"));
        System.out.println(new Date());
    }
    public static void main(String args[]) {


        SpringApplication.run(Application.class, args);

    }
    @Bean
    public SessionFactory sessionFactory(HibernateEntityManagerFactory hemf  )
    {

        return hemf .getSessionFactory();
    }

}
