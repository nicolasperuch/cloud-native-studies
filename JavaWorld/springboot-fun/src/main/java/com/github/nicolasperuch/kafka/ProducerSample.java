package com.github.nicolasperuch.kafka;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.util.Properties;
import java.util.concurrent.ExecutionException;

public class ProducerSample {

    private Properties props;
    private KafkaProducer<String, String> producer;

    private static Logger LOG = LogManager.getLogger(ProducerSample.class);




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
