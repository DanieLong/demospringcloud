package com.lk.consumer.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.net.URI;

@RestController
public class HelloController {
    protected Logger logger = LoggerFactory.getLogger(HelloController.class);

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private LoadBalancerClient loadBalancerClient;

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String hello() {
        return restTemplate.getForEntity("http://SERVICE-HELLO/hello", String.class).getBody();
    }

    @RequestMapping(value = "/helloEx", method = RequestMethod.GET)
    public String helloEx() {
        ServiceInstance instance = this.loadBalancerClient.choose("SERVICE-HELLO");
        URI helloUri = URI.create(String.format("http://%s:%s/hello", instance.getHost(), instance.getPort()));
        logger.info("Target service uri = {}. ", helloUri.toString());
        return new RestTemplate().getForEntity(helloUri, String.class).getBody();
    }


}
