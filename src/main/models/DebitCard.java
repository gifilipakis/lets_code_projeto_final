package main.models;

import main.controllers.ACard;

public class DebitCard extends ACard {

    public DebitCard(String number, String expirationDate, String cvv, double limit) {
        super(number, expirationDate, cvv, limit);
        setType("DEBITO");
    }
    
}
