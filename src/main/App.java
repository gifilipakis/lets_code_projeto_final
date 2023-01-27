package main;

import main.controllers.IPaymentStrategy;
import main.controllers.AContrato;
import main.controllers.APessoa;
import main.enums.CategoriasVeiculosENUM;
import main.enums.FuncaoFuncionariosENUM;
import main.enums.TipoDeVeiculoENUM;
import main.models.Boleto;
import main.models.Cliente;
import main.models.ContratoAluguel;
import main.models.ContratoCompra;
import main.models.CreditCard;
import main.models.DebitCard;
import main.models.Funcionario;
import main.models.Pix;
import main.models.ServicePayment;
import main.models.Veiculos;
import main.paymentStrategies.BoletoPayment;
import main.paymentStrategies.CreditCardPayment;
import main.paymentStrategies.DebitCardPayment;
import main.paymentStrategies.PixPayment;


public class App {

    public static void main(String[] args) throws Exception {

        APessoa cliente1 = new Cliente("00000000000", "Ana", "1234", "01/01");
        APessoa funcionario1 = new Funcionario("000000", "João", "1111", "02/02", FuncaoFuncionariosENUM.VENDEDOR);
        Veiculos veiculo1 = new Veiculos(TipoDeVeiculoENUM.CARRO, "AABB", "Fiat", CategoriasVeiculosENUM.PREMIUN);
        
        CreditCard creditCard = new CreditCard("1234", "04/24", "213", 3000);
        IPaymentStrategy estrategia_pagamento_credito = new CreditCardPayment(creditCard);
        
        DebitCard debitCard = new DebitCard("4321", "05/27", "123", 5000);
        IPaymentStrategy estrategia_pagamento_debito = new DebitCardPayment(debitCard);

        Boleto boleto = new Boleto("1234", "Maria", "06/23");
        IPaymentStrategy estrategia_pagamento_boleto = new BoletoPayment(boleto);

        Pix pix = new Pix("chavePix12345");
        IPaymentStrategy estrategia_pagamento_pix = new PixPayment(pix);

        //////////////////////////////////////
        System.out.println("---->Aluguel com Cartão de Crédito");
        AContrato contrato_aluguel_1 = new ContratoAluguel(cliente1, funcionario1, veiculo1, estrategia_pagamento_credito, 7, 4);
        ServicePayment.processOrder(contrato_aluguel_1);
        System.out.println();

        /////////////////////////////////////
        System.out.println("---->Aluguel com Cartão de Débito");
        AContrato contrato_aluguel_2 = new ContratoAluguel(cliente1, funcionario1, veiculo1, estrategia_pagamento_debito, 7, 1);
        ServicePayment.processOrder(contrato_aluguel_2);

        /////////////////////////////////////
        System.out.println("---->Compra com Cartão de Débito");
        AContrato contrato_aluguel_3 = new ContratoCompra(cliente1, funcionario1, veiculo1, estrategia_pagamento_debito, 1);
        ServicePayment.processOrder(contrato_aluguel_3);
        System.out.println();
                
        /////////////////////////////////////
        System.out.println("---->Compra com Cartão de Crédito");
        AContrato contrato_aluguel_4 = new ContratoCompra(cliente1, funcionario1, veiculo1, estrategia_pagamento_credito, 12);
        ServicePayment.processOrder(contrato_aluguel_4);
        System.out.println();

        //////////////////////////////////////
        System.out.println("---->Compra com Boleto");
        AContrato contrato_aluguel_5 = new ContratoCompra(cliente1, funcionario1, veiculo1, estrategia_pagamento_boleto, 12);
        ServicePayment.processOrder(contrato_aluguel_5);
        System.out.println();

        //////////////////////////////////////
        System.out.println("---->Compra com Pix");
        AContrato contrato_aluguel_6 = new ContratoCompra(cliente1, funcionario1, veiculo1, estrategia_pagamento_pix, 12);
        ServicePayment.processOrder(contrato_aluguel_6);
        System.out.println();

    }

}
