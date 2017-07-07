package com.github.nicolasperuch;

import com.github.nicolasperuch.kafka.ProducerSample;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@RequestMapping("/produce")
@SpringBootApplication
public class Central {

    ProducerSample producer = new ProducerSample();

    @RequestMapping("/topic/{topic}/message/{message}")
    @ResponseBody
    public boolean produceLog(@PathVariable (value = "topic") String topic,
                              @PathVariable (value = "message") String message){
        return producer.produceMessage(topic, message);
    }

}
