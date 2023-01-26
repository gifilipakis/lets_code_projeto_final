package main.controllers;


public interface IPaymentStrategy {
    
    void validatePaymentStrategy(AContrato contrato);
    void collectPaymentDetails();
    void pay(AContrato contrato);
    
}
