package com.hcl.launcher;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * This Class is used to Launch the Application.
 *
 */
@SpringBootApplication
public class ApplicationLauncher {
	public static void main(String[] args) {
		SpringApplication.run(ApplicationLauncher.class, args);
	}
}
