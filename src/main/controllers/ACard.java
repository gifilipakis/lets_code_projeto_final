package main.controllers;

public abstract class ACard {
    
    private String number;
    private String expirationDate;
    private String cvv;
    private double limit;
    private double amount;
    private String type;

    public ACard(String number, String expirationDate, String cvv, double limit) {
        this.number = number;
        this.expirationDate = expirationDate;
        this.cvv = cvv;
        this.limit = limit;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(String expirationDate) {
        this.expirationDate = expirationDate;
    }

    public String getCvv() {
        return cvv;
    }

    public void setCvv(String cvv) {
        this.cvv = cvv;
    }

    public double getLimit() {
        return limit;
    }

    public void setLimit(double limit) {
        this.limit = limit;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        String card = this.number+" | "+this.expirationDate;
        return card;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

}
