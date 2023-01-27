package main.paymentStrategies;

import main.controllers.AContrato;
import main.controllers.IPaymentStrategy;
import main.controllers.IPaymentValidator;
import main.models.Pix;
import main.validators.PixValidator;

public class PixPayment implements IPaymentStrategy {

    private Pix pix;

    public PixPayment(Pix pix) {
        this.pix = pix;
    }

    @Override
    public void validatePaymentStrategy(AContrato contrato) {
        IPaymentValidator<Pix> pixValidator = new PixValidator();
        pixValidator.validatePaymentMethod(pix, contrato);
    }

    @Override
    public void collectPaymentDetails() {
        System.out.println("Coletando os dados do usuário.");
        System.out.println("---> "+pix.toString()); 
    }

    @Override
    public void pay(AContrato contrato) {
        System.out.println("Pagamento realizado");
    }
    
}
