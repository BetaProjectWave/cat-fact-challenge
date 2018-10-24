package uk.co.asto.interview.cats;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * Core spring boot application for running the Cat Fact Service
 */
@ComponentScan({"uk.co.asto"})
@SpringBootApplication
public class CatFactApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(CatFactApiApplication.class, args);
    }
}
