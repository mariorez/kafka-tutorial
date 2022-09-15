package dev.mario.kafkatutorial.broker;

import dev.mario.kafkatutorial.model.TutorialModel;
import dev.mario.kafkatutorial.schema.StockHistory;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class Consumer {

    @KafkaListener(topics = "${topic.name}", containerFactory = "jsonListenerContainerFactory")
    public void read(TutorialModel value) {
        System.out.println("Message received: " + value);
    }

    @KafkaListener(topics = "${avro.topic.name}", containerFactory = "avroListenerContainerFactory")
    public void read(ConsumerRecord<String, StockHistory> record) {
        String key = record.key();
        StockHistory history = record.value();
        System.out.println("Avro message received for key : " + key + " / value : " + history.toString());
    }
}
