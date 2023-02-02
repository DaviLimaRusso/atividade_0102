package service;

import model.Conta;
import org.junit.Assert;
import org.junit.Test;

public class ContaServiceTest {

    @Test
    public void deveSerPossivelCriarUmaConta() {

        // Dado
        ContaService contaService = new ContaService();

        // Quando
        Conta conta = new Conta (1,1);

        // Então
        Assert.assertTrue(conta.getAgencia() == 1);
        Assert.assertTrue(conta.getNumero() == 1);
    }

    @Test
    public void contaDeveIniciarComSaldoZero() {

        // Dado
        ContaService contaService = new ContaService();

        // Quando
        Conta conta = new Conta (1,1);

        // Então
        Assert.assertEquals(0.0, conta.getSaldo(),0.1);

    }

    @Test
    public void deveSerPossivelDepositar() {

        // Dado
        ContaService contaService = new ContaService();

        // Quando
        Conta conta = new Conta (1,1);
        contaService.depositar(conta,10.0);

        // Então
        Assert.assertNotEquals(0.0, conta.getSaldo(), 0.1);

    }

    @Test
    public void deveSerPossivelSacar() {

        // Dado
        ContaService contaService = new ContaService();
        Conta conta = new Conta (1,1);
        contaService.depositar(conta,50.0);

        // Quando
        contaService.sacar(conta, 30.0);

        // Então
        Assert.assertEquals(20.0, conta.getSaldo(), 0.1);
        Assert.assertFalse(conta.getSaldo() == 50.0);
    }

    @Test
    public void deveTransferirEntreContas() {

        // Dado
        ContaService contaService = new ContaService();
        Conta conta1 = new Conta (1,1);
        Conta conta2 = new Conta (2, 2);
        contaService.depositar(conta1,50.0);

        // Quando
        contaService.transferir(conta1, conta2, 20.0);

        // Então
        Assert.assertEquals(20.0, conta2.getSaldo(), 0.1);
        Assert.assertNotSame(conta1, conta2);

    }

}