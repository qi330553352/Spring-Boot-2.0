package com.example.qixin;

import com.example.qixin.filter.CustomFilter;
import com.example.qixin.listener.CustomListener;
import com.example.qixin.servlet.CustomServlet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.*;
import javax.servlet.DispatcherType;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;

import javax.servlet.*;
import java.util.EnumSet;

/** 参考资料
 * https://blog.csdn.net/qq_27384769/article/details/79020183
 */
@EnableCaching	//开启缓存
//@ServletComponentScan 在 SpringBootApplication 上使用@ServletComponentScan 注解后，直接通过@WebServlet、@WebFilter、@WebListener 注解自动注册 方法三
@SpringBootApplication
public class ChapterMybatisPluginsApplication { //implements ServletContextInitializer  //使用 servlet、filter、listener 方法二

	public static void main(String[] args) {
		SpringApplication.run(ChapterMybatisPluginsApplication.class, args);
	}

//  使用 servlet、filter、listener 方法一
//	@Bean
//	public ServletRegistrationBean servletRegistrationBean() {
//
//		return new ServletRegistrationBean(new CustomServlet(), "/api/blog");
//	}
//
//	@Bean
//	public FilterRegistrationBean filterRegistrationBean() {
//
//		return new FilterRegistrationBean(new CustomFilter(), servletRegistrationBean());
//	}
//
//	@Bean
//	public ServletListenerRegistrationBean<CustomListener> servletListenerRegistrationBean() {
//		return new ServletListenerRegistrationBean<CustomListener>(new CustomListener());
//	}

//  使用 servlet、filter、listener 方法二
//	@Override
//	public void onStartup(ServletContext servletContext) throws ServletException {
//		servletContext.addServlet("customServlet", new CustomServlet()).addMapping("/api/blog");
//		servletContext.addFilter("customFilter", new CustomFilter()).addMappingForServletNames(EnumSet.of(DispatcherType.REQUEST), true, "customServlet");
//		servletContext.addListener(new CustomListener());
//	}
}

