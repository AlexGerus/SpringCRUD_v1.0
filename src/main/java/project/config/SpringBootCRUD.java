package project.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "project")
@EntityScan(basePackages = { "project" })
public class SpringBootCRUD {
    public static void main(String[] args) {
        SpringApplication.run(SpringBootCRUD.class, args);
    }


}
