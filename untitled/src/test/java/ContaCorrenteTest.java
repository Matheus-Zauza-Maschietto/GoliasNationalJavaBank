import domain.ContaCorrente;
import domain.Endereco;
import domain.PessoaFisica;
import enums.EstadosCivies;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

public class ContaCorrenteTest {
    @Test
    public void criacaoDeFinanciamentoTest(){
        PessoaFisica matheus = new PessoaFisica(new Endereco("", "", "", "", "", ""),
                "Matheus", LocalDate.of(2004, 2, 10), "088.555.439.62",
                EstadosCivies.SOLTEIRO);
        ContaCorrente conta = new ContaCorrente(1000d, matheus);
        conta.realizarFinanciamento(1000d, 100d, "Financimento minha casa minha vida");

        Assertions.assertEquals("Financimento minha casa minha vida", conta.getFinanciamentosList().get(0).getApelido());
    }
}
