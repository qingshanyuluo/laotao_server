package xyz.lennon.laotao_server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

@SpringBootApplication
public class LaotaoServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(LaotaoServerApplication.class, args);
    }

}
