package com.example.program;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@ComponentScan("com.example")
@SpringBootApplication
public class ProjectsApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjectsApplication.class, args);
	}

}
