import domain.ContaCorrente;
import domain.Endereco;
import domain.Financiamento;
import domain.PessoaFisica;
import enums.EstadosCivies;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class FinanciamentoTest {
    @Test
    public void quantidadeParcelaRestantesTest(){
        PessoaFisica matheus = new PessoaFisica(new Endereco("", "", "", "", "", ""), "Matheus", LocalDate.of(2004, 2, 10), "088.555.439.62", EstadosCivies.SOLTEIRO);
        ContaCorrente conta = new ContaCorrente(1000d, matheus);
        Financiamento financiamento = new Financiamento(1000d, 100d, LocalDateTime.now(), conta, "Emprestimo para compra de carro");

        financiamento.pagarParcela();

        Assertions.assertEquals(9, financiamento.getQuantidadeParcelasRestantes());
    }

    @Test
    public void quantidadeTotalDeParcelaTest(){
        PessoaFisica matheus = new PessoaFisica(new Endereco("", "", "", "", "", ""),
                "Matheus", LocalDate.of(2004, 2, 10), "088.555.439.62",
                EstadosCivies.SOLTEIRO);
        ContaCorrente conta = new ContaCorrente(1000d, matheus);

        Financiamento financiamento = new Financiamento(900d, 400d, LocalDateTime.now(), conta,"Emprestimo para compra de carro");

        financiamento.pagarParcela();
        financiamento.pagarParcela();
        Assertions.assertEquals(3, financiamento.getQuantidadeParcelasTotais());
    }

    @Test
    public void pagamentoDeParcelaTest(){
        PessoaFisica matheus = new PessoaFisica(new Endereco("", "", "", "", "", ""),
                "Matheus", LocalDate.of(2004, 2, 10), "088.555.439.62",
                EstadosCivies.SOLTEIRO);
        ContaCorrente conta = new ContaCorrente(1000d, matheus);

        Financiamento financiamento = new Financiamento(1000d, 100d,  LocalDateTime.now(), conta, "Emprestimo para compra de carro");

        financiamento.pagarParcela();

        Assertions.assertEquals(900, financiamento.getValor());
    }
}
