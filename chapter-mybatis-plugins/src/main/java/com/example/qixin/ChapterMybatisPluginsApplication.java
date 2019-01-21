package com.example.qixin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@ServletComponentScan
@SpringBootApplication
public class ChapterMybatisPluginsApplication {

	public static void main(String[] args) {
		SpringApplication.run(ChapterMybatisPluginsApplication.class, args);
	}

}

