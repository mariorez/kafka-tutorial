package dev.mario.kafkatutorial.controller;

import dev.mario.kafkatutorial.broker.Producer;
import dev.mario.kafkatutorial.model.StockHistoryModel;
import dev.mario.kafkatutorial.model.TutorialModel;
import dev.mario.kafkatutorial.schema.StockHistory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TutorialController {

    @Autowired
    private Producer producer;

    @PostMapping(path = "/send")
    public void send(@RequestBody TutorialModel model) {
        producer.send(model);
    }

    @PostMapping("/send/stock-history")
    public void sendStockHistory(@RequestBody StockHistoryModel model) {
        var stockHistory = StockHistory.newBuilder().build();
        stockHistory.setStockName(model.getStockName());
        stockHistory.setTradeType(model.getTradeType());
        stockHistory.setPrice(model.getPrice());
        stockHistory.setAmount(model.getAmount());
        stockHistory.setTradeId(model.getId());
        stockHistory.setTradeMarket(model.getTradeMarket());
        stockHistory.setTradeQuantity(model.getTradeQuantity());
        producer.send(stockHistory);
    }
}
