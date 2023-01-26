package main.controllers;

public abstract class APessoa {
    
    private String identificador;
    private String nome;
    private String telefone;
    private String dataNascimento;

    public APessoa(String id, String nome, String telefone, String dataNascimento) {
        this.identificador = id;
        this.nome = nome;
        this.telefone = telefone;
        this.dataNascimento = dataNascimento;
    }

    public String getIdentificador() {
        return identificador;
    }
    public void setIdentificador(String identificador) {
        this.identificador = identificador;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getTelefone() {
        return telefone;
    }
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
    public String getDataNascimento() {
        return dataNascimento;
    }
    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    @Override
    public String toString() {
        String str = String.format("* Identificador: %s | Nome: %s", identificador, nome);
        return str;
    }
    
}
