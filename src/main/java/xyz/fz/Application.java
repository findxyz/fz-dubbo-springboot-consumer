package xyz.fz;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import xyz.fz.dubbo.service.AbcService;

@SpringBootApplication
public class Application {
    public static void main(String[] args) throws InterruptedException {
        ConfigurableApplicationContext context = SpringApplication.run(Application.class, args);
        AbcService abcService = (AbcService) context.getBean("abcService");
        for (int i = 0; i < 9999999; i++) {
            abcService.demoService.record("no" + i);
            Thread.sleep(10L);
        }
    }
}
