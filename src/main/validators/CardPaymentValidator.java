package main.validators;

import main.controllers.AContrato;
import main.controllers.ACard;
import main.controllers.IPaymentValidator;


public class CardPaymentValidator implements IPaymentValidator<ACard> {
    
    @Override
    public void validatePaymentMethod(ACard card, AContrato contrato) {
        if (card.getNumber().length() != 4) {
            throw new IllegalArgumentException("Número do cartão inválido");
        } else if(card.getCvv().length() != 3){
            throw new IllegalArgumentException("CVV do cartão inválido");
        } else if(contrato.getValorTotal() > card.getLimit()) {
            throw new IllegalArgumentException("O valor total excede o limite do cartão");
        }
    }
    
}
