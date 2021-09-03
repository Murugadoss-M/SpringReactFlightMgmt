package com.mmdoss;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class FlightMgmtConfigServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(FlightMgmtConfigServerApplication.class, args);
	}

}
