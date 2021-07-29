package com.mafei.producer.controller;

import com.mafei.bean.CustomMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

import static com.mafei.properties.Topics.TOPIC1;

@RestController
public class IndexController {

    private Integer offset = 0;
    @Autowired
    private KafkaTemplate kafkaTemplate;

    @GetMapping
    public Object index(@RequestParam("msg") String msg) {

        kafkaTemplate.send(TOPIC1, "test",
                CustomMessage.builder()
                        .offset(offset)
                        .startTime(new Date().toString())
                        .msg(msg)
                        .build()
        );
        offset++;
        return "done " + offset;
    }

}
