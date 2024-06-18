package com.juliomesquita.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.Connection;
import java.sql.DriverManager;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {

		String url = "jdbc:postgresql://localhost:8082/postgres";
		String username = "local";
		String password = "local";

		try (Connection conn = DriverManager.getConnection(url, username, password)) {
			if (conn != null) {
				System.out.println("Connected to the database!");
			} else {
				System.out.println("Failed to make connection!");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		SpringApplication.run(Application.class, args);
	}

}
