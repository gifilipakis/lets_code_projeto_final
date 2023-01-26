package main.models;

import main.controllers.APessoa;
import main.enums.FuncaoFuncionariosENUM;

public class Funcionario extends APessoa {

    private FuncaoFuncionariosENUM funcao;

    public Funcionario(String id, String nome, String telefone, String dataNascimento, FuncaoFuncionariosENUM funcao) {
        super(id, nome, telefone, dataNascimento);
        setFuncao(funcao);
    }

    public FuncaoFuncionariosENUM getFuncao() {
        return funcao;
    }

    public void setFuncao(FuncaoFuncionariosENUM funcao) {
        this.funcao = funcao;
    }
    
}
