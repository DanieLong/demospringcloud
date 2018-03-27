package com.lk.mq;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by daniel on 18/3/16.
 */
@RestController
@RequestMapping("/rabbit")
public class RabbitTest {

    @Autowired
    private HelloSender1 helloSender1;
//    @Autowired
//    private HelloSender1 helloSender2;

    @GetMapping("/hello")
    public void hello() {
        helloSender1.send();
    }

    /**
     * 单生产者-多消费者
     */
    @GetMapping("/oneToMany")
    public void oneToMany() {
        for (int i = 1; i < 11; i++) {
            helloSender1.send("hellomsg:" + i);
        }

    }
}
