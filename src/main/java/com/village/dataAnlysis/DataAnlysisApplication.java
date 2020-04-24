package com.village.dataAnlysis;

import com.alibaba.druid.pool.DruidDataSource;
import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import javax.sql.DataSource;

@SpringBootApplication
@MapperScan("com.village.dataAnlysis.domain.mapper")//com.village.dataAnlysis.domain.mapper
public class DataAnlysisApplication {

	@Autowired
	private Environment env;

	public static void main(String[] args) {
		SpringApplication.run(DataAnlysisApplication.class, args);
	}

	@Bean
	public DataSource dataSource() {
		DruidDataSource dataSource = new DruidDataSource();
		dataSource.setUrl(env.getProperty("spring.datasource.url"));
		dataSource.setUsername(env.getProperty("spring.datasource.username"));//用户名
		dataSource.setPassword(env.getProperty("spring.datasource.password"));//密码
		dataSource.setDriverClassName(env.getProperty("spring.datasource.driver-class-name"));
		dataSource.setInitialSize(2);
		dataSource.setMaxActive(20);
		dataSource.setMinIdle(0);
		dataSource.setMaxWait(60000);
		dataSource.setValidationQuery("SELECT 1");
		dataSource.setTestOnBorrow(false);
		dataSource.setTestWhileIdle(true);
		dataSource.setPoolPreparedStatements(false);
		return dataSource;
	}

	@Bean
	public FilterRegistrationBean corsFilter() {
		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		CorsConfiguration config = new CorsConfiguration();
		config.setAllowCredentials(true);
		// 设置你要允许的网站域名，如果全允许则设为 *
//		config.addAllowedOrigin("http://127.0.0.1:8088");
		config.addAllowedOrigin("*");
		// 如果要限制 HEADER 或 METHOD 请自行更改
		config.addAllowedHeader("*");
		config.addAllowedMethod("*");
		source.registerCorsConfiguration("/**", config);
		FilterRegistrationBean bean = new FilterRegistrationBean(new CorsFilter(source));
		// 这个顺序很重要哦，为避免麻烦请设置在最前
		bean.setOrder(0);
		return bean;
	}

	/**
	 * mybatis-plus分页需要使用该插件
	 * @return
	 */
	@Bean
	public PaginationInterceptor paginationInterceptor() {
		return new PaginationInterceptor();
	}


	/*@Bean
	PageHelper pageHelper(){
		//分页插件
		PageHelper pageHelper = new PageHelper();
		Properties properties = new Properties();
		properties.setProperty("reasonable", "true");
		properties.setProperty("supportMethodsArguments", "true");
		properties.setProperty("returnPageInfo", "check");
		properties.setProperty("params", "count=countSql");
		pageHelper.setProperties(properties);

		//添加插件
		new SqlSessionFactoryBean().setPlugins( new Interceptor[]{ pageHelper});
		return pageHelper;
	}*/

}

