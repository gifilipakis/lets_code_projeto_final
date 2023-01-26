package main.models;

import main.controllers.AContrato;
import main.controllers.IPaymentStrategy;

public class ServicePayment {
    
    public static void processOrder(AContrato contrato) {
        IPaymentStrategy strategy = contrato.getEstrategiaPagamento();
        try {
            contrato.validateContrato(contrato);
            strategy.collectPaymentDetails();
            strategy.validatePaymentStrategy(contrato);
            strategy.pay(contrato);
        } catch (Exception e) {
            System.out.println("---Contrato inválido.");
            System.out.println(e.getMessage());
        }
    }

}
