package com.example.brtapp;

public class Ticket {
    private int id;
    private String origin;
    private String destiny;
    private float price;
    private int userId;
    private int lineId;

    public Ticket(){}

    public Ticket(int newId, String newOrigin, String newDestiny, float newPrice, int newUserId, int newLineId){
        setId(newId);
        setOrigin(newOrigin);
        setDestiny(newDestiny);
        setDestiny(newDestiny);
        setPrice(newPrice);
        setUserId(newUserId);
        setLineId(newLineId);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getDestiny() {
        return destiny;
    }

    public void setDestiny(String destiny) {
        this.destiny = destiny;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getLineId() {
        return lineId;
    }

    public void setLineId(int lineID) {
        this.lineId = lineID;
    }
}

