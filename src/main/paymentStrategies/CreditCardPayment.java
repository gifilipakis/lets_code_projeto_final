package main.paymentStrategies;

import main.controllers.AContrato;
import main.controllers.ACard;
import main.controllers.IPaymentStrategy;
import main.controllers.IPaymentValidator;
import main.models.CreditCard;
import main.validators.CardPaymentValidator;

public class CreditCardPayment implements IPaymentStrategy {

    private CreditCard card;

    public CreditCardPayment(CreditCard card) {
        this.card = card;
    }
    
    @Override
    public void validatePaymentStrategy(AContrato contrato) {
        IPaymentValidator<ACard> cardValidator = new CardPaymentValidator();
        cardValidator.validatePaymentMethod(card, contrato);
    }
    
    @Override
    public void collectPaymentDetails() {
        System.out.println("Coletando os dados do usuário.");
        System.out.println("---> "+card.toString());    
    }
    
    @Override
    public void pay(AContrato contrato) {
        card.setFutureDebits(contrato.getValorTotal());
        System.out.println("Pagamento realizado");
    }
    
}
