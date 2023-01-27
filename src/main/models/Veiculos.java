package main.models;

import java.io.Serializable;

import main.enums.CategoriasVeiculosENUM;
import main.enums.StatusDoVeiculoENUM;
import main.enums.TipoDeVeiculoENUM;

public class Veiculos implements Serializable {

    private TipoDeVeiculoENUM tipoVeiculo;
    private String identificador;
    private StatusDoVeiculoENUM status = StatusDoVeiculoENUM.DISPONIVEL;
    private double valorDiario;
    private String marca;
    private CategoriasVeiculosENUM categoria;
    private double valorCompra = valorDiario*20;

    public Veiculos(TipoDeVeiculoENUM tipoVeiculo, String identificador, String marca, CategoriasVeiculosENUM categoria) {
        this.tipoVeiculo = tipoVeiculo;
        this.identificador = identificador;
        this.marca = marca;
        this.categoria = categoria;
        setValorDiario();
    }
    
    public TipoDeVeiculoENUM getTipoVeiculo() {
        return tipoVeiculo;
    }
    public void setTipoVeiculo(TipoDeVeiculoENUM tipoVeiculo) {
        this.tipoVeiculo = tipoVeiculo;
    }
    public StatusDoVeiculoENUM getStatus() {
        return status;
    }
    public void setStatus(StatusDoVeiculoENUM status) {
        this.status = status;
    }
    public String getIdentificador() {
        return identificador;
    }
    public void setIdentificador(String identificador) {
        this.identificador = identificador;
    }
    
    public double getValorDiario() {
        return valorDiario;
    }
    
    public void setValorDiario() {
        if(this.categoria == CategoriasVeiculosENUM.PREMIUN) {
            this.valorDiario = 200;
        } else if(this.categoria == CategoriasVeiculosENUM.CLASSIC) {
            this.valorDiario = 150;
        } else {
            this.valorDiario = 100;
        }
    }
    
    public String getMarca() {
        return marca;
    }
    
    public void setMarca(String marca) {
        this.marca = marca;
    }
    
    public CategoriasVeiculosENUM getCategoria() {
        return categoria;
    }
    
    public void setCategoria(CategoriasVeiculosENUM categoria) {
        this.categoria = categoria;
    }
    
    public double getValorCompra() {
        return valorCompra;
    }
    
    public void setValorCompra(double valorCompra) {
        this.valorCompra = valorCompra;
    }
    
    @Override
    public String toString() {
        String str = String.format("* Identificador: %s | Tipo: %s", identificador, tipoVeiculo);
        return str;
    }

}
