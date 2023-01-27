package main.validators;

import java.util.List;
import java.util.NoSuchElementException;

import main.controllers.AContrato;
import main.controllers.ICRUDValidators;
import main.models.ContratoAluguel;
import main.paymentStrategies.CreditCardPayment;

public class ContratosValidator implements ICRUDValidators<AContrato> {

    
    @Override
    public void validateInsert(AContrato contrato, List<AContrato> contratos) {
        if( contrato.getNumProtocolo().length() != 36 ) {
            throw new IllegalArgumentException("Número de protocolo inválido");
            
        }
    }
    
    @Override
    public int validateDelete(String id, List<AContrato> contratos) {
        for(int i = 0; i < contratos.size(); i++) {
            if(contratos.get(i).getNumProtocolo() == id) {
                return i;
            }
        }
        throw new NoSuchElementException("Não há um elemento com esse identificador registrado no sistema");
    }
    
    @Override
    public int validateSelectById(String id, List<AContrato> contratos) {
        for(int i = 0; i < contratos.size(); i++) {
            if(contratos.get(i).getNumProtocolo() == id) {
                return i;
            }
        }
        throw new NoSuchElementException("Não há um elemento com esse identificador registrado no sistema");
    }
    
    public void validateContract(AContrato contrato) {
        if(contrato.getTipoContrato() == "ALUGUEL") {
            if(!(contrato.getEstrategiaPagamento() instanceof CreditCardPayment) & contrato.getNumParcelas() > 1) {
                throw new IllegalArgumentException("Contratos de aluguel com mais de 1 parcela só aceitam Cartão de Crédito como forma de pagamento");
            } else if(contrato.getNumParcelas() > 12) {
                throw new IllegalArgumentException("Número de parcelas excede o máximo de 12 parcelas permitidas");
            } else if(((ContratoAluguel) contrato).getQntDias() > 90) {
                throw new IllegalArgumentException("O número de dias excede o máximo de 90 dias permitidos");
            }
        } else {
            if(contrato.getNumParcelas() > 36) {
                throw new IllegalArgumentException("Número de parcelas excede o máximo de 36 parcelas permitidas");
            }    
        }
        if(contrato.getNumParcelas() <= 0) {
            throw new IllegalArgumentException("Número de parcelas inválido");
        }
    };

}
