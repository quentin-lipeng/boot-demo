package com.quentin.bootdemo.config;

import com.quentin.bootdemo.converter.MyDefaultHttpMessageConverter;
import com.quentin.bootdemo.pojo.RetMessage;
import org.springframework.boot.ExitCodeGenerator;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author:quentin
 * @create: 2022-10-18 11:45
 * @Description:
 */
// 如果proxyBeanMethods=false为lite mode
// =true也就是默认的配置 为full mode
@Configuration(proxyBeanMethods = false)
public class BeansComponent {

    @Bean("msg1")
    public RetMessage<String> retMsg1() {
        return new RetMessage<>();
    }

    /**
     * when SpringApplication.exit() is called.
     * @return exit code
     * @author quentin
     * @date 2022/10/23
     */
    @Bean
    public ExitCodeGenerator exitCodeGenerator(){
        return () -> 42;
    }
    // 注册自己定义的转换器
//    @Bean
//    public HttpMessageConverters customConverters() {
//        return new HttpMessageConverters(new MyDefaultHttpMessageConverter());
//    }

}
