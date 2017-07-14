package com.github.nicolasperuch.producer;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.ExecutionException;

public class ProducerSample {

    private static Logger LOG = LogManager.getLogger(ProducerSample.class);

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Properties props = new Properties();
        props.put("bootstrap.servers", "localhost:9092");
        props.put("acks", "1");
        props.put("retries", 0);
        props.put("batch.size", 2);
        props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");

        KafkaProducer<String, String> producer = new KafkaProducer<String, String>(props);

        List<String> messages = new ArrayList<String>();

        messages.add("It's a test");

        messages.stream()
                .forEach(m -> {
                    try {
                        LOG.info("Preparing to send message:" + m);
                        producer.send(new ProducerRecord<>("new_topic", m)).get();
                        LOG.info("Sent message:" + m);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } catch (ExecutionException e) {
                        e.printStackTrace();
                    }
                });

        producer.flush();
    }


}
