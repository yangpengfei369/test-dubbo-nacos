package com.pengfei.bootstrap;

import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import com.alibaba.nacos.api.annotation.NacosProperties;
import com.alibaba.nacos.spring.context.annotation.config.EnableNacosConfig;
import com.alibaba.nacos.spring.context.annotation.config.NacosPropertySource;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.PropertySource;

import java.io.IOException;

// Dubbo 配置
@EnableDubbo(scanBasePackages = "com.pengfei.app")
@PropertySource(value = "classpath:/provider-config.propertis")

// 配置中心
@EnableNacosConfig(globalProperties = @NacosProperties(serverAddr = "127.0.0.1:8848"))
//@NacosConfigurationProperties(dataId = "provider-config.propertis")
@NacosPropertySource(dataId = "provider-config.propertis", autoRefreshed = true)
public class ProviderBootstrap {

    public static void main(String[] args) throws IOException {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(ProviderBootstrap.class);
        context.refresh();
        System.out.println("服务提供商启动。。。。");
        System.in.read();
    }

//    public static void main(String[] args) throws IOException {
//        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext();
//        context.setConfigLocation("/dubbo-provider-context.xml");
//        context.refresh();
//        System.out.println("DemoService provider (XML) is starting...");
//        System.in.read();
//    }
}
