package org.dtux.demo;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class Application {
    final Logger log = LoggerFactory.getLogger(Application.class);

    @RequestMapping("/")
    public String home() {

        log.trace("Logging at TRACE level");
        log.debug("Logging at DEBUG level");
        log.info("Logging at INFO level");
        log.warn("Logging at WARN level");
        log.error("Logging at ERROR level");

        return "Hello Docker World";
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}