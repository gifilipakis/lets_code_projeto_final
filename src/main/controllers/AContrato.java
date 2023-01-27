package main.controllers;

import java.util.UUID;
import main.models.Veiculos;
import main.validators.ContratosValidator;

public abstract class AContrato {
    
    private final String numProtocolo = UUID.randomUUID().toString();
    private String tipoContrato;
    private APessoa contratante;
    private APessoa funcionario;
    private Veiculos veiculo;
    private IPaymentStrategy estrategiaPagamento;
    private double valorTotal;
    private int numParcelas;
    private double valorParcela = getValorTotal()/numParcelas;

    public AContrato(APessoa cliente, APessoa funcionario, Veiculos veiculo, 
                     IPaymentStrategy estrategiaPagamento, int numParcelas){
        this.contratante = cliente;
        this.funcionario = funcionario;
        this.veiculo = veiculo;
        this.estrategiaPagamento = estrategiaPagamento;
        this.numParcelas = numParcelas;
    }

    public void validateContrato(AContrato contrato) {
        ContratosValidator contratoValidator = new ContratosValidator();
        contratoValidator.validateContract(contrato);
    };

    public String getNumProtocolo() {
        return numProtocolo;
    }
    public APessoa getContratante() {
        return contratante;
    }
    public void setContratante(APessoa contratante) {
        this.contratante = contratante;
    }
    public APessoa getFuncionario() {
        return funcionario;
    }
    public void setFuncionario(APessoa funcionario) {
        this.funcionario = funcionario;
    }
    public Veiculos getVeiculo() {
        return veiculo;
    }
    public void setVeiculo(Veiculos veiculo) {
        this.veiculo = veiculo;
    }
    public IPaymentStrategy getFormaPagamento() {
        return estrategiaPagamento;
    }
    public void setFormaPagamento(IPaymentStrategy estrategiaPagamento) {
        this.estrategiaPagamento = estrategiaPagamento;
    }

    public String getTipoContrato() {
        return tipoContrato;
    }

    public void setTipoContrato(String tipoContrato) {
        this.tipoContrato = tipoContrato;
    }

    public IPaymentStrategy getEstrategiaPagamento() {
        return estrategiaPagamento;
    }

    public void setEstrategiaPagamento(IPaymentStrategy estrategiaPagamento) {
        this.estrategiaPagamento = estrategiaPagamento;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public int getNumParcelas() {
        return numParcelas;
    }

    public void setNumParcelas(int numParcelas) {
        this.numParcelas = numParcelas;
    }

    public double getValorParcela() {
        return valorParcela;
    }

    @Override
    public String toString() {
        String str = String.format("* Protocolo: %s | Nome do Cliente: %s", numProtocolo, contratante.getNome());
        return str;
    }

}
