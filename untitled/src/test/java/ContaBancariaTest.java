import domain.ContaCorrente;
import domain.Endereco;
import domain.PessoaFisica;
import enums.EstadosCivies;
import exceptions.BankException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

public class ContaBancariaTest {
    @Test
    public void sacarValorValidoTest(){
        PessoaFisica matheus = new PessoaFisica(new Endereco("", "", "", "", "", ""),
                "Matheus", LocalDate.of(2004, 2, 10), "088.555.439.62",
                EstadosCivies.SOLTEIRO);
        ContaCorrente conta = new ContaCorrente(1000d, matheus);
        conta.sacar(500d);

        Assertions.assertEquals(500, conta.getSaldo());
    }

    @Test
    public void sacarValorInvalidoTest(){
        PessoaFisica matheus = new PessoaFisica(new Endereco("", "", "", "", "", ""),
                "Matheus", LocalDate.of(2004, 2, 10), "088.555.439.62",
                EstadosCivies.SOLTEIRO);
        ContaCorrente conta = new ContaCorrente(1000d, matheus);

        Assertions.assertThrows(BankException.class, () -> {conta.sacar(2000d);});
    }

    @Test
    public void depositarValorValidoTest(){
        PessoaFisica matheus = new PessoaFisica(new Endereco("", "", "", "", "", ""),
                "Matheus", LocalDate.of(2004, 2, 10), "088.555.439.62",
                EstadosCivies.SOLTEIRO);
        ContaCorrente conta = new ContaCorrente(1000d, matheus);
        conta.depositar(500d);

        Assertions.assertEquals(1500, conta.getSaldo());
    }

    @Test
    public void depositarValorInvalidoTest(){
        PessoaFisica matheus = new PessoaFisica(new Endereco("", "", "", "", "", ""),
                "Matheus", LocalDate.of(2004, 2, 10), "088.555.439.62",
                EstadosCivies.SOLTEIRO);
        ContaCorrente conta = new ContaCorrente(1000d, matheus);
        conta.depositar(500d);

        Assertions.assertThrows(BankException.class, () -> {conta.depositar(-100d);});
    }

    @Test
    public void transferirValorValidoTest(){
        PessoaFisica matheus = new PessoaFisica(new Endereco("", "", "", "", "", ""),
                "Matheus", LocalDate.of(2004, 2, 10), "088.555.439.62",
                EstadosCivies.SOLTEIRO);

        PessoaFisica joao = new PessoaFisica(new Endereco("", "", "", "", "", ""),
                "Joao", LocalDate.of(2004, 2, 10), "088.555.439.62",
                EstadosCivies.SOLTEIRO);

        ContaCorrente contaMatheus = new ContaCorrente(1000d, matheus);
        ContaCorrente contaJoao = new ContaCorrente(0d, joao);

        contaMatheus.transferir(contaJoao, 300d);

        Assertions.assertEquals(300, contaJoao.getSaldo());
        Assertions.assertEquals(700, contaMatheus.getSaldo());
    }

    @Test
    public void transferirValorInvalidoTest(){
        PessoaFisica matheus = new PessoaFisica(new Endereco("", "", "", "", "", ""),
                "Matheus", LocalDate.of(2004, 2, 10), "088.555.439.62",
                EstadosCivies.SOLTEIRO);

        PessoaFisica joao = new PessoaFisica(new Endereco("", "", "", "", "", ""),
                "Joao", LocalDate.of(2004, 2, 10), "088.555.439.62",
                EstadosCivies.SOLTEIRO);

        ContaCorrente contaMatheus = new ContaCorrente(1000d, matheus);
        ContaCorrente contaJoao = new ContaCorrente(0d, joao);

        Assertions.assertThrows(BankException.class, () -> {contaMatheus.transferir(contaJoao, 1900d);});
    }


}
