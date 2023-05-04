package com.library.store;


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

@SpringBootApplication(scanBasePackages = "com.library.store")
@EnableScheduling
@Transactional
public class Application {

    public static void main(String args[]) {


        SpringApplication.run(Application.class, args);

    }
    @Bean
    public SessionFactory sessionFactory(HibernateEntityManagerFactory hemf  )
    {

        return hemf .getSessionFactory();
    }

}
