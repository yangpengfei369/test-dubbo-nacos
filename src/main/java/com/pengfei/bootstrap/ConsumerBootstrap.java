package com.pengfei.bootstrap;

import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import com.pengfei.app.api.DemoService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.PropertySource;

import javax.annotation.PostConstruct;
import java.io.IOException;

@EnableDubbo
@PropertySource(value = "classpath:/consumer-config.propertis")
public class ConsumerBootstrap {

    @Reference(version = "${demo.service.version}")
    private DemoService demoService;

    @PostConstruct
    public void init() {
        while (true) {
            System.out.println(demoService.sayHi("Mercy"));
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws IOException {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(ConsumerBootstrap.class);
        context.refresh();
        context.close();
    }
}
