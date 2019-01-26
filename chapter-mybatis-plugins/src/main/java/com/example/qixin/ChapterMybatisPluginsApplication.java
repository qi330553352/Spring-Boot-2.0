package com.example.qixin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.embedded.tomcat.TomcatWebServer;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cache.annotation.EnableCaching;

/** 参考资料
 * https://blog.csdn.net/qq_27384769/article/details/79020183
 */
@EnableCaching	//开启缓存
//@ServletComponentScan
@SpringBootApplication
public class ChapterMybatisPluginsApplication {

	public static void main(String[] args) {
		SpringApplication.run(ChapterMybatisPluginsApplication.class, args);
	}

}

