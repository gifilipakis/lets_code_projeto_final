package main.validators;

import main.controllers.AContrato;
import main.controllers.IPaymentValidator;
import main.models.Pix;

public class PixValidator implements IPaymentValidator<Pix> {

    @Override
    public void validatePaymentMethod(Pix pix, AContrato contrato) {
        if(pix.getKey().equals("")) {
            throw new IllegalArgumentException("Chave pix inválida");
        }
    }
    
}
