package main.databases;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import main.controllers.AContrato;
import main.controllers.ICRUDValidators;
import main.controllers.IDataBaseManagement;
import main.validators.ContratosValidator;

public class ContratosDataBase implements IDataBaseManagement<AContrato> {

    ICRUDValidators<AContrato> validator = new ContratosValidator();
    private List<AContrato> contratos = new ArrayList<>();

    @Override
    public String insert(AContrato obj) {
        try {
            validator.validateInsert(obj, contratos);
            this.contratos.add(obj);
            return "Inserção realizada com sucesso";
        } catch (IllegalArgumentException e) {
            return e.getMessage();
        }
    }

    @Override
    public void readAll() {
        for (AContrato v : contratos) {
            System.out.println(v.toString());
        }
    }

    @Override
    public String delete(String id) {
        try {
            int i = validator.validateDelete(id, contratos);
            contratos.remove(i);
            return "Deleção realizada com sucesso";
        } catch (NoSuchElementException e) {
            return e.getMessage();
        }
    }

    @Override
    public String selectById(String id) {
        try {
            int position = validator.validateSelectById(id, contratos);
            String veiculoAsString = contratos.get(position).toString();
            return veiculoAsString;
        } catch (NoSuchElementException e) {
            return e.getMessage();
        }
    }
    
}
