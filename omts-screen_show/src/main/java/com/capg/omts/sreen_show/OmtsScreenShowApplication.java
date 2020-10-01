package com.capg.omts.sreen_show;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.capg.omts.sreen_show.service.ScreenServiceImpl;

@SpringBootApplication
public class OmtsScreenShowApplication {

	public static void main(String[] args) {
		SpringApplication.run(OmtsScreenShowApplication.class, args);
		Logger logger = LoggerFactory.getLogger(OmtsScreenShowApplication.class);
		logger.info("Hello Info");
		logger.debug("Hello debug");
		logger.trace("hello trace");
		logger.warn("Hello warn");
	}

}
