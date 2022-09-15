package dev.mario.kafkatutorial.model;

public class StockHistoryModel {

    private String id;
    private int tradeQuantity;
    private String tradeMarket;
    private String stockName;
    private String tradeType;
    private float price;
    private float amount;

    public String getId() {
        return id;
    }

    public StockHistoryModel setId(String id) {
        this.id = id;
        return this;
    }

    public int getTradeQuantity() {
        return tradeQuantity;
    }

    public StockHistoryModel setTradeQuantity(int tradeQuantity) {
        this.tradeQuantity = tradeQuantity;
        return this;
    }

    public String getTradeMarket() {
        return tradeMarket;
    }

    public StockHistoryModel setTradeMarket(String tradeMarket) {
        this.tradeMarket = tradeMarket;
        return this;
    }

    public String getStockName() {
        return stockName;
    }

    public StockHistoryModel setStockName(String stockName) {
        this.stockName = stockName;
        return this;
    }

    public String getTradeType() {
        return tradeType;
    }

    public StockHistoryModel setTradeType(String tradeType) {
        this.tradeType = tradeType;
        return this;
    }

    public float getPrice() {
        return price;
    }

    public StockHistoryModel setPrice(float price) {
        this.price = price;
        return this;
    }

    public float getAmount() {
        return amount;
    }

    public StockHistoryModel setAmount(float amount) {
        this.amount = amount;
        return this;
    }
}
