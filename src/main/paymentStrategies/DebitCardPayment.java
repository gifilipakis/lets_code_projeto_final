package main.paymentStrategies;

import main.controllers.AContrato;
import main.controllers.ACard;
import main.controllers.IPaymentStrategy;
import main.controllers.IPaymentValidator;
import main.models.DebitCard;
import main.validators.CardPaymentValidator;

public class DebitCardPayment implements IPaymentStrategy {

    private DebitCard card;

    public DebitCardPayment(DebitCard card) {
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
        System.out.println("Pagamento realizado");
    }
    
}
