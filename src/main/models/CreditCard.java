package main.models;

import main.controllers.ACard;

public class CreditCard extends ACard {

    private double futureDebits;

    public CreditCard(String number, String expirationDate, String cvv, double limit) {
        super(number, expirationDate, cvv, limit);
        setType("CREDITO");
    }

    public double getFutureDebits() {
        return futureDebits;
    }

    public void setFutureDebits(double futureDebits) {
        this.futureDebits = futureDebits;
    }
    
}
