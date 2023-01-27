package main.validators;

import java.util.List;
import java.util.NoSuchElementException;

import main.controllers.ICRUDValidators;
import main.controllers.APessoa;

public class ClienteValidator implements ICRUDValidators<APessoa> {

    @Override
    public void validateInsert(APessoa cliente, List<APessoa> clientes) {
        if( cliente.getIdentificador().length() != 11) {
            throw new IllegalArgumentException("CPF inválido");
        } else {
            for (APessoa c : clientes) {
                if(c.getIdentificador() == cliente.getIdentificador()) {
                    throw new IllegalArgumentException("Esse elemento já está cadastrado no sistema");
                }
            }
        }
    }

    @Override
    public int validateDelete(String id, List<APessoa> clientes) {
        for(int i = 0; i < clientes.size(); i++) {
            if(clientes.get(i).getIdentificador() == id) {
                return i;
            }
        }
        throw new NoSuchElementException("Não há um elemento com esse identificador registrado no sistema");
    }

    @Override
    public int validateSelectById(String id, List<APessoa> clientes) {
        for(int i = 0; i < clientes.size(); i++) {
            if(clientes.get(i).getIdentificador() == id) {
                return i;
            }
        }
        throw new NoSuchElementException("Não há um elemento com esse identificador registrado no sistema");
    }
    
}
