package dev.mario.kafkatutorial.broker;

import dev.mario.kafkatutorial.model.TutorialModel;
import dev.mario.kafkatutorial.schema.StockHistory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFutureCallback;

@Service
public class Producer {

    @Autowired
    private KafkaTemplate<String, TutorialModel> jsonKafkaTemplate;
    @Autowired
    private KafkaTemplate<String, StockHistory> avroKafkaTemplate;
    @Value("${topic.name}")
    private String topicName;
    @Value("${avro.topic.name}")
    String avroTopicName;

    public void send(TutorialModel model) {
        var future = jsonKafkaTemplate.send(topicName, model.getId(), model);
        future.addCallback(new ListenableFutureCallback<>() {
            @Override
            public void onFailure(Throwable ex) {
                System.out.println("Failed to send message to: " + topicName);
            }

            @Override
            public void onSuccess(SendResult<String, TutorialModel> result) {
                System.out.println("Successfully sent message to topic: " + topicName + ", with ID: " + result.getProducerRecord().key());
            }
        });
    }

    public void send(StockHistory stockHistory) {
        var future = avroKafkaTemplate.send(avroTopicName, String.valueOf(stockHistory.getTradeId()), stockHistory);
        future.addCallback(new ListenableFutureCallback<>() {
            @Override
            public void onFailure(Throwable ex) {
                System.out.println("Failed to send message to: " + avroTopicName);
            }

            @Override
            public void onSuccess(SendResult<String, StockHistory> result) {
                System.out.println("Successfully sent message to topic: " + avroTopicName + ", with ID: " + result.getProducerRecord().key());
            }
        });
    }
}
