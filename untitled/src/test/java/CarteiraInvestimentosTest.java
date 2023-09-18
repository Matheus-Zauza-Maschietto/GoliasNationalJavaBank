import domain.Ativo;
import domain.ContaCorrente;
import domain.Endereco;
import domain.PessoaFisica;
import enums.EstadosCivies;
import enums.TipoDeAtivo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

public class CarteiraInvestimentosTest {

    @Test
    public void adicionarAtivosTest(){
        PessoaFisica matheus = new PessoaFisica(new Endereco("", "", "", "", "", ""),
                "Matheus", LocalDate.of(2004, 2, 10), "088.555.439.62",
                EstadosCivies.SOLTEIRO);
        ContaCorrente conta = new ContaCorrente(2000d, matheus);
        conta.getCarteiraInvestimentos().comprarAtivo(1000d, "F3S", TipoDeAtivo.ACAO);
        conta.getCarteiraInvestimentos().comprarAtivo(60d, "F3S", TipoDeAtivo.ACAO);
        Assertions.assertEquals(2, conta.getCarteiraInvestimentos().getInvestimentos().size());
    }

    @Test
    public void buscarValorTotalAtivosTest(){
        PessoaFisica matheus = new PessoaFisica(new Endereco("", "", "", "", "", ""),
                "Matheus", LocalDate.of(2004, 2, 10), "088.555.439.62",
                EstadosCivies.SOLTEIRO);
        ContaCorrente conta = new ContaCorrente(2000d, matheus);
        conta.getCarteiraInvestimentos().comprarAtivo(1000d, "F3S", TipoDeAtivo.ACAO);
        conta.getCarteiraInvestimentos().comprarAtivo(100d, "F3S", TipoDeAtivo.MOEDA_ESTRANGEIRA);
        Assertions.assertEquals(1100, conta.getCarteiraInvestimentos().getValorTotalAtivos());
    }

    @Test
    public void buscarValorTotalAtivosPorTipoTest(){
        PessoaFisica matheus = new PessoaFisica(new Endereco("", "", "", "", "", ""),
                "Matheus", LocalDate.of(2004, 2, 10), "088.555.439.62",
                EstadosCivies.SOLTEIRO);
        ContaCorrente conta = new ContaCorrente(2000d, matheus);
        conta.getCarteiraInvestimentos().comprarAtivo(1000d, "F3S", TipoDeAtivo.ACAO);
        conta.getCarteiraInvestimentos().comprarAtivo(100d, "F3S", TipoDeAtivo.MOEDA_ESTRANGEIRA);

        Assertions.assertEquals(1000, conta.getCarteiraInvestimentos().getValorTotalAtivoPorTipo(TipoDeAtivo.ACAO));
    }

    @Test
    public void deletarAtivoTest(){
        PessoaFisica matheus = new PessoaFisica(new Endereco("", "", "", "", "", ""),
                "Matheus", LocalDate.of(2004, 2, 10), "088.555.439.62",
                EstadosCivies.SOLTEIRO);
        ContaCorrente conta = new ContaCorrente(2000d, matheus);
        conta.getCarteiraInvestimentos().comprarAtivo(1000d, "F3S", TipoDeAtivo.ACAO);
        conta.getCarteiraInvestimentos().comprarAtivo(100d, "F3S", TipoDeAtivo.MOEDA_ESTRANGEIRA);

        Ativo ativoDelecao = conta.getCarteiraInvestimentos().getInvestimentos().get(0);
        conta.getCarteiraInvestimentos().venderAtivo(ativoDelecao.getIdentificador());

        Assertions.assertEquals(1, conta.getCarteiraInvestimentos().getInvestimentos().size());
    }
}
