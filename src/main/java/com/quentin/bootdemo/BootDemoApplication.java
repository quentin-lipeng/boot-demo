package com.quentin.bootdemo;

import com.quentin.bootdemo.vo.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

// 此注解包含了@EnableAutoConfiguration
@SpringBootApplication
@EnableConfigurationProperties({Info.class})
// 使用了@EnableAutoConfiguration or @SpringBootApplication 会自动扫描注解就不需要下面的注解
//@EnableJpaRepositories
//@EntityScan(basePackages = "com.quentin.bootdemo.pojo")
public class BootDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(BootDemoApplication.class, args);
	}

}
