package com.example.demo3;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.SpringVersion;

@MapperScan("com.example.demo3.dao.mapper")
@SpringBootApplication
public class Demo3Application {

    public static void main(String[] args) {
//        SpringApplication.run(Demo3Application.class, args);
//        app.run(args);
        //System.out.println(SpringVersion.getVersion());
          SpringApplication.run(Demo3Application.class, args);
//        SpringApplication app = new SpringApplication(Demo3Application.class);
//        app.setWebApplicationType(WebApplicationType.NONE);
//        app.setBannerMode(Banner.Mode.OFF);
//        app.run(args);
    }

}
