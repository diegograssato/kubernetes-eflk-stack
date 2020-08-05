package org.dtux.demo;


import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@Slf4j
public class Application {

    @RequestMapping("/")
    public String home() {

        log.info("Logging at INFO level");

        return "Hello Docker World";
    }

    public static void main(String[] args) {
        System.out.println("Current Directory = " + System.getProperty("user.dir"));
        SpringApplication.run(Application.class, args);
         
    }

}