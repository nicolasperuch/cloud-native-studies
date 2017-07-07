package com.github.nicolasperuch.kafka;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.util.Properties;
import java.util.concurrent.ExecutionException;

public class Producer {

    private Properties props;
    private KafkaProducer<String, String> producer;

    private static Logger LOG = LogManager.getLogger(Producer.class);


    public Producer() {
        props = new Properties();
        props.put("bootstrap.servers", "localhost:9092");
        props.put("acks", "1");
        props.put("retries", 0);
        props.put("batch.size", 2);
        props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");

        producer = new KafkaProducer<String, String>(props);
    }

    public boolean produceMessage(String topic, String message){
        try {
            producer.send(new ProducerRecord<>(topic, message)).get();
            producer.flush();
            return true;
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        producer.flush();

        return false;
    }

}
