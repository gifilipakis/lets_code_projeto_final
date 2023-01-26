package main.models;

import main.controllers.AContrato;
import main.controllers.APessoa;
import main.controllers.IPaymentStrategy;

public class ContratoAluguel extends AContrato {

    private int qntDias;

    public ContratoAluguel(APessoa cliente, APessoa funcionario, Veiculos veiculo, IPaymentStrategy estrategiaPagamento, int qntDias, int numParcelas) {
        super(cliente, funcionario, veiculo, estrategiaPagamento, numParcelas);
        setTipoContrato("ALUGUEL");
        setQntDias(qntDias);
        setValorTotal(veiculo.getValorDiario()*qntDias);
    }

    public int getQntDias() {
        return qntDias;
    }

    public void setQntDias(int qntDias) {
        this.qntDias = qntDias;
    }

}
