package main.models;

import main.controllers.AContrato;
import main.controllers.APessoa;
import main.controllers.IPaymentStrategy;

public class ContratoCompra extends AContrato {

    public ContratoCompra(APessoa cliente, APessoa funcionario, Veiculos veiculo, IPaymentStrategy estrategiaPagamento, int numParcelas) {
        super(cliente, funcionario, veiculo, estrategiaPagamento, numParcelas);
        setTipoContrato("COMPRA");
        setValorTotal(veiculo.getValorCompra());
    }

}
