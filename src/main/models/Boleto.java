package main.models;


public class Boleto {
    
    private String codigoDeBarras;
    private String nomePagador;
    private String dataVencimento;
    private double valor;

    public Boleto(String codigoDeBarras, String nomePagador, String dataVencimento) {
        this.codigoDeBarras = codigoDeBarras;
        this.nomePagador = nomePagador;
        this.dataVencimento = dataVencimento;
    }

    public String getCodigoDeBarras() {
        return codigoDeBarras;
    }

    public void setCodigoDeBarras(String codigoDeBarras) {
        this.codigoDeBarras = codigoDeBarras;
    }

    public String getNomePagador() {
        return nomePagador;
    }

    public void setNomePagador(String nomePagador) {
        this.nomePagador = nomePagador;
    }

    public String getDataVencimento() {
        return dataVencimento;
    }

    public void setDataVencimento(String dataVencimento) {
        this.dataVencimento = dataVencimento;
    }

    @Override
    public String toString() {
        String blt = codigoDeBarras+" | "+nomePagador+" | "+dataVencimento;
        return blt;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

}
