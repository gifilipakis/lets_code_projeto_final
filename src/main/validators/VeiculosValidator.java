package main.validators;

import java.util.List;
import java.util.NoSuchElementException;

import main.controllers.ICRUDValidators;
import main.models.Veiculos;

public class VeiculosValidator implements ICRUDValidators<Veiculos> {

    @Override
    public void validateInsert(Veiculos veiculo, List<Veiculos> veiculos) {
        if( veiculo.getIdentificador().length() != 4 ) {
            throw new IllegalArgumentException("Placa inválida");

        }

        for (Veiculos v : veiculos) {
            if(v.getIdentificador() == veiculo.getIdentificador()) {
                throw new IllegalArgumentException("Esse elemento já está cadastrado no sistema");
            }
        }
    }

    @Override
    public int validateDelete(String id, List<Veiculos> veiculos) {
        for(int i = 0; i < veiculos.size(); i++) {
            if(veiculos.get(i).getIdentificador() == id) {
                return i;
            }
        }
        throw new NoSuchElementException("Não há um elemento com esse identificador registrado no sistema");
    }

    @Override
    public int validateSelectById(String id, List<Veiculos> veiculos) {
        for(int i = 0; i < veiculos.size(); i++) {
            if(veiculos.get(i).getIdentificador() == id) {
                return i;
            }
        }
        throw new NoSuchElementException("Não há um elemento com esse identificador registrado no sistema");
    }

}
