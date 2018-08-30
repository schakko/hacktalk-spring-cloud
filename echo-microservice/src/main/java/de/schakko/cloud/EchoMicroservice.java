package de.schakko.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class EchoMicroservice {

	public static void main(String[] args) {
		SpringApplication.run(EchoMicroservice.class, args);
	}
}
