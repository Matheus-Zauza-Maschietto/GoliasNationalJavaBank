import domain.ContaPoupanca;
import domain.ContaPoupanca;
import domain.Endereco;
import domain.PessoaFisica;
import enums.EstadosCivies;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

public class ContaPoupancaTest {
    @Test
    public void gerarJurosTest(){
        PessoaFisica joao = new PessoaFisica(new Endereco("", "", "", "", "", ""),
                "Joao", LocalDate.of(2004, 2, 10), "088.555.439.62",
                EstadosCivies.SOLTEIRO);

        ContaPoupanca contaJoao = new ContaPoupanca(1000d, joao);
        contaJoao.gerarJuros();
        Assertions.assertEquals(1100, contaJoao.getSaldo());

    }
}
