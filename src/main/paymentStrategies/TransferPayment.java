package main.paymentStrategies;

import main.controllers.AContrato;
import main.controllers.IPaymentStrategy;

public class TransferPayment implements IPaymentStrategy {

    @Override
    public void validatePaymentStrategy(AContrato contrato) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void collectPaymentDetails() {
        System.out.println("Coletando os dados do usuário.");
    }

    @Override
    public void pay(AContrato contrato) {
        System.out.println("Pagamento realizado");
    }
    
}
