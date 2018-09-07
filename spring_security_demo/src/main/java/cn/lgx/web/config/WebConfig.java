/**
 * 
 */
package cn.lgx.web.config;

import java.util.ArrayList;
import java.util.List;

import cn.lgx.interceptor.TimeInterceptor;
import cn.lgx.web.filter.TimeFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.AsyncSupportConfigurer;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;



@Configuration
public class WebConfig extends WebMvcConfigurerAdapter {
//
//	@SuppressWarnings("unused")
//	@Autowired
//	private TimeInterceptor timeInterceptor;

//	同步处理拦截器
//	@Override
//	public void addInterceptors(InterceptorRegistry registry) {
//		registry.addInterceptor(timeInterceptor);
//	}

	//异步处理拦截器
	@Override
	public void configureAsyncSupport(AsyncSupportConfigurer configurer) {
//		configurer.registerCallableInterceptors(); 所填写的interceptor需要继承CallableProcessingInterceptor
//		configurer.registerDeferredResultInterceptors();
		super.configureAsyncSupport(configurer);
	}

	//
//	@Bean
	public FilterRegistrationBean timeFilter() {
		
		FilterRegistrationBean registrationBean = new FilterRegistrationBean();
		
		TimeFilter timeFilter = new TimeFilter();
		registrationBean.setFilter(timeFilter);
		
		List<String> urls = new ArrayList<>();
		urls.add("/*");   //过滤（拦截）
		registrationBean.setUrlPatterns(urls);
		
		return registrationBean;
		
	}

}
