import domain.*;
import enums.EstadosCivies;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

public class ContaSalarioTest {
    @Test
    public void criarPortabilidadeDeContaTest(){
        Endereco enderecoPadrao = new Endereco("", "", "", "", "", "");
        PessoaFisica matheus = new PessoaFisica(enderecoPadrao, "Matheus", LocalDate.of(2004, 2, 10),
                                                "088.555.439.62", EstadosCivies.SOLTEIRO);

        PessoaJuridica benner = new PessoaJuridica(enderecoPadrao, "Benner", LocalDate.now(), "292348943092390", 20090000d);

        ContaCorrente contaBenner = new ContaCorrente(1000000d, benner);
        ContaSalario contaSalarioMatheus = new ContaSalario(600d, matheus, benner);
        ContaCorrente contaMatheusBB = new ContaCorrente(0d, matheus);

        contaSalarioMatheus.criarPortabilidade(contaMatheusBB);

        contaBenner.transferir(contaSalarioMatheus, 5400d);

        Assertions.assertEquals(5400d, contaMatheusBB.getSaldo());
        Assertions.assertEquals(600d, contaSalarioMatheus.getSaldo());
    }

    @Test
    public void transferenciaParaSalarioSemPortabilidadeTest(){
        Endereco enderecoPadrao = new Endereco("", "", "", "", "", "");
        PessoaFisica matheus = new PessoaFisica(enderecoPadrao, "Matheus", LocalDate.of(2004, 2, 10),
                "088.555.439.62", EstadosCivies.SOLTEIRO);

        PessoaJuridica benner = new PessoaJuridica(enderecoPadrao, "Benner", LocalDate.now(), "292348943092390", 20090000d);

        ContaCorrente contaBenner = new ContaCorrente(1000000d, benner);
        ContaSalario contaSalarioMatheus = new ContaSalario(600d, matheus, benner);
        ContaCorrente contaMatheusBB = new ContaCorrente(0d, matheus);

        contaBenner.transferir(contaSalarioMatheus, 5400d);

        Assertions.assertEquals(0, contaMatheusBB.getSaldo());
        Assertions.assertEquals(6000, contaSalarioMatheus.getSaldo());
    }
}
