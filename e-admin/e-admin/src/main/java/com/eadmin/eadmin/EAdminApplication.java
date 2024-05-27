package com.eadmin.eadmin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.eadmin.eadmin", "service"})
public class EAdminApplication {
 
	public static void main(String[] args) {
		SpringApplication.run(EAdminApplication.class, args);
		System.out.print("project is run brooooooooooooooooooo");
	}

}
