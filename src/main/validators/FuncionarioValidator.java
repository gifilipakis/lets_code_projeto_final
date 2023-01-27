package main.validators;

import java.util.List;
import java.util.NoSuchElementException;

import main.controllers.ICRUDValidators;
import main.controllers.APessoa;

public class FuncionarioValidator implements ICRUDValidators<APessoa> {

    @Override
    public void validateInsert(APessoa funcionario, List<APessoa> funcionarios) {
        if( funcionario.getIdentificador().length() != 6) {
            throw new IllegalArgumentException("Chave de funcionário inválida");
        } else {
            for (APessoa f : funcionarios) {
                if(f.getIdentificador() == funcionario.getIdentificador()) {
                    throw new IllegalArgumentException("Esse elemento já está cadastrado no sistema");
                }
            }
        }
    }

    @Override
    public int validateDelete(String id, List<APessoa> funcionarios) {
        for(int i = 0; i < funcionarios.size(); i++) {
            if(funcionarios.get(i).getIdentificador() == id) {
                return i;
            }
        }
        throw new NoSuchElementException("Não há um elemento com esse identificador registrado no sistema");
    }

    @Override
    public int validateSelectById(String id, List<APessoa> funcionarios) {
        for(int i = 0; i < funcionarios.size(); i++) {
            if(funcionarios.get(i).getIdentificador() == id) {
                return i;
            }
        }
        throw new NoSuchElementException("Não há um elemento com esse identificador registrado no sistema");
    }
    
}
