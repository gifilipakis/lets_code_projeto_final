package main.validators;

import main.controllers.AContrato;
import main.controllers.IPaymentValidator;
import main.models.Boleto;
import main.models.Message;

public class BoletoPaymentValidator implements IPaymentValidator<Boleto> {

    Message msg = new Message();

    @Override
    public void validatePaymentMethod(Boleto boleto, AContrato contrato) {
        if (boleto.getCodigoDeBarras().length() != 4) {
            throw new IllegalArgumentException("Código do boleto inválido");
        } else if(contrato.getValorTotal() != boleto.getValor()) {
            throw new IllegalArgumentException("O valor do contrato não condiz com o do boleto");
        }
    }
    
}
