package tests;

import main.controllers.AContrato;
import main.controllers.APessoa;
import main.controllers.ICRUDTests;
import main.controllers.IDataBaseManagement;
import main.controllers.IPaymentStrategy;
import main.databases.ContratosDataBase;
import main.enums.CategoriasVeiculosENUM;
import main.enums.FuncaoFuncionariosENUM;
import main.enums.TipoDeVeiculoENUM;
import main.models.Cliente;
import main.models.ContratoAluguel;
import main.models.CreditCard;
import main.models.Funcionario;
import main.models.Veiculos;
import main.paymentStrategies.CreditCardPayment;

public class ContratosCRUDTests implements ICRUDTests<AContrato> {
    
    private static ICRUDTests<AContrato> contratosTest = new ContratosCRUDTests();
    private static APessoa cliente = new Cliente("00000000000", "João", "0000-0000", "01/01");
    private static APessoa funcionario = new Funcionario("123456", "Ana", "0000-0000", "01/01", FuncaoFuncionariosENUM.VENDEDOR);
    private static Veiculos veiculo = new Veiculos(TipoDeVeiculoENUM.CARRO, "AABB", "Fiat", CategoriasVeiculosENUM.ECONOMIC);
    private static CreditCard card = new CreditCard("1234", "05/05", "123", 100000);
    private static IPaymentStrategy paymentStrategy = new CreditCardPayment(card);

    private static AContrato contrato = new ContratoAluguel(cliente, funcionario, veiculo, paymentStrategy, 7, 12);
    private static String id = contrato.getNumProtocolo();
    private static IDataBaseManagement<AContrato> database = new ContratosDataBase();
    public static void main(String[] args) {

        // Standard tests
        contratosTest.givenObjectAndDatabase_whenInsert_thenReturnInsertionConfirmation(contrato, database);
        contratosTest.givenIdAndDatabase_whenDelete_thenReturnDeletionConfirmation(id, database);
        contratosTest.givenIdAndDatabase_whenDelete_thenReturnElementNotFound(id, database);
        contratosTest.givenIdAndDatabase_whenSelectById_thenElementNotFound("54947df8-0e9e-4471-a2f9-9af509fb5889", database);
        // Teste não aplicável para o caso de contratos
        // contratosTest.givenObjectAndDatabase_whenInsert_thenReturnElementAlreadyExists(contrato, database);
        
        // Specific tests
        contratosTest.givenIdAndDatabase_whenSelectedById_thenReturnObjectAsString(database);

    }
    
    // Teste não aplicável para o caso de contratos
    @Override
    public void givenObjectAndDatabase_whenInsert_thenReturnIdentifierIsInvalid(IDataBaseManagement<AContrato> database) {}

    @Override
    public void givenIdAndDatabase_whenSelectedById_thenReturnObjectAsString(IDataBaseManagement<AContrato> database) {
        System.out.println("--> Executanto givenIdAndDatabase_whenSelectedById_theSucceed");
        
        AContrato contrato = new ContratoAluguel(cliente, funcionario, veiculo, paymentStrategy, 7, 12);
        String numProtocolo = contrato.getNumProtocolo();
        database.insert(contrato);
        
        String expected = "* Protocolo: "+numProtocolo+" | Nome do Cliente: João";
        String actual = database.selectById(numProtocolo);
        assertEquals(expected, actual);
    }


}
