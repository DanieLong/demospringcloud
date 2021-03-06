package com.lk.server;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class DemoServer {

    public static void main(String[] args) {
        new SpringApplicationBuilder(DemoServer.class).web(true).run(args);
    }
}
