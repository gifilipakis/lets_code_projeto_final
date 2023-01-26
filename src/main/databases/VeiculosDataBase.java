package main.databases;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import main.controllers.ICRUDValidators;
import main.controllers.IDataBaseManagement;
import main.models.Veiculos;
import main.validators.VeiculosValidator;

public class VeiculosDataBase implements IDataBaseManagement<Veiculos> {

    ICRUDValidators<Veiculos> validator = new VeiculosValidator();
    private List<Veiculos> veiculos = new ArrayList<>();

    @Override
    public String insert(Veiculos obj) {
        try {
            validator.validateInsert(obj, veiculos);
            this.veiculos.add(obj);
            return "Inserção realizada com sucesso";
        } catch (IllegalArgumentException e) {
            return e.getMessage();
        }
    }

    @Override
    public void readAll() {
        for (Veiculos v : veiculos) {
            System.out.println(v.toString());
        }
    }

    @Override
    public String delete(String id) {
        try {
            int i = validator.validateDelete(id, veiculos);
            veiculos.remove(i);
            return "Deleção realizada com sucesso";
        } catch (NoSuchElementException e) {
            return e.getMessage();
        }
    }

    @Override
    public String selectById(String id) {
        try {
            int position = validator.validateSelectById(id, veiculos);
            String veiculoAsString = veiculos.get(position).toString();
            return veiculoAsString;
        } catch (NoSuchElementException e) {
            return e.getMessage();
        }
    }
    
}
