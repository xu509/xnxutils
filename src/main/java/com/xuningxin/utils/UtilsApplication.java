package com.xuningxin.utils;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication
public class UtilsApplication {

	private static void showMenu(){
		System.out.println("show menu");
	}

	public static void main(String[] args) {
		SpringApplication.run(UtilsApplication.class, args);


		showMenu();
	}
}
