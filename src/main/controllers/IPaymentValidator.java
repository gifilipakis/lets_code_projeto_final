package main.controllers;

public interface IPaymentValidator<T> {
    
    void validatePaymentMethod(T obj, AContrato contrato);
    
}
