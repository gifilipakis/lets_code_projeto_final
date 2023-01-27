package main.paymentStrategies;

import main.controllers.AContrato;
import main.controllers.IPaymentStrategy;
import main.controllers.IPaymentValidator;
import main.models.Boleto;
import main.validators.BoletoPaymentValidator;

public class BoletoPayment implements IPaymentStrategy {

    private Boleto boleto;

    public BoletoPayment(Boleto boleto) {
        this.boleto = boleto;
    }

    @Override
    public void validatePaymentStrategy(AContrato contrato) {
        IPaymentValidator<Boleto> boletoValidator = new BoletoPaymentValidator();
        boletoValidator.validatePaymentMethod(boleto, contrato);
    }

    @Override
    public void collectPaymentDetails() {
        System.out.println("Coletando os dados do usuário.");
        System.out.println(boleto.toString()); 
    }

    @Override
    public void pay(AContrato contrato) {
        System.out.println("Pagamento realizado");
    }
    
}
