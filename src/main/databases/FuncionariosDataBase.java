package main.databases;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import main.controllers.ICRUDValidators;
import main.controllers.IDataBaseManagement;
import main.models.Message;
import main.controllers.APessoa;
import main.validators.FuncionarioValidator;

public class FuncionariosDataBase implements IDataBaseManagement<APessoa> {

    Message msg = new Message();

    ICRUDValidators<APessoa> validator = new FuncionarioValidator();
    private List<APessoa> funcionarios = new ArrayList<>();

    @Override
    public String insert(APessoa obj) {
        try {
            validator.validateInsert(obj, funcionarios);
            this.funcionarios.add(obj);
            return "Inserção realizada com sucesso";
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    @Override
    public void readAll() {
        for (APessoa c : funcionarios) {
            System.out.println(c.toString());
        }
    }

    @Override
    public String delete(String id) {
        try {
            int i = validator.validateDelete(id, funcionarios);
            funcionarios.remove(i);
            return "Deleção realizada com sucesso";
        } catch (NoSuchElementException e) {
            System.out.println(e.getMessage());
            return e.getMessage();
        }
    }

    @Override
    public String selectById(String id) {
        try {
            int position = validator.validateSelectById(id, funcionarios);
            String funcionarioAsString = funcionarios.get(position).toString();
            return funcionarioAsString;
        } catch (NoSuchElementException e) {
            return e.getMessage();
        }
    }
    
}
