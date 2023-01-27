package main.databases;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import main.controllers.ICRUDValidators;
import main.controllers.IDataBaseManagement;
import main.controllers.APessoa;
import main.validators.ClienteValidator;

public class ClientesDataBase implements IDataBaseManagement<APessoa>{

    ICRUDValidators<APessoa> validator = new ClienteValidator();
    private List<APessoa> clientes = new ArrayList<>();

    @Override
    public String insert(APessoa obj) {
        try {
            validator.validateInsert(obj, clientes);
            this.clientes.add(obj);
            return "Inserção realizada com sucesso";
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    @Override
    public void readAll() {
        for (APessoa c : clientes) {
            System.out.println(c.toString());
        }
    }

    @Override
    public String delete(String id) {
        try {
            int i = validator.validateDelete(id, clientes);
            clientes.remove(i);
            return "Deleção realizada com sucesso";
        } catch (NoSuchElementException e) {
           return e.getMessage();
        }
    }

    @Override
    public String selectById(String id) {
        try {
            int position = validator.validateSelectById(id, clientes);
            String clienteAsString = clientes.get(position).toString();
            return clienteAsString;
        } catch (NoSuchElementException e) {
            return e.getMessage();
        }
    }
    
}
