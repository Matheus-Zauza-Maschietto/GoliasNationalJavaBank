import domain.*;
import enums.OperacaoBancaria;
import enums.EstadosCivies;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import service.ExtratoService;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class ExtratoServiceTest {
    @Test
    public void insercaoDeTransacaoTest(){
        PessoaFisica matheus = new PessoaFisica(new Endereco("", "", "", "", "", ""),
                "Matheus", LocalDate.of(2004, 2, 10), "088.555.439.62",
                EstadosCivies.SOLTEIRO);
        ContaCorrente conta = new ContaCorrente(1000d, matheus);
        ExtratoService extratoService = new ExtratoService(conta);
        extratoService.adicionarTransacao(100d, OperacaoBancaria.TRANSFERENCIA);

        Assertions.assertEquals(1, extratoService.getTransacaoList().size());
    }

    @Test
    public void buscarPorIntervaloTest(){
        PessoaFisica matheus = new PessoaFisica(new Endereco("", "", "", "", "", ""),
                "Matheus", LocalDate.of(2004, 2, 10), "088.555.439.62",
                EstadosCivies.SOLTEIRO);
        ContaCorrente conta = new ContaCorrente(1000d, matheus);
        ExtratoService extratoService = new ExtratoService(conta);
        extratoService.adicionarTransacao(100d, OperacaoBancaria.TRANSFERENCIA);

        LocalDateTime dataInicio = LocalDateTime.now();
        try{

            Thread.sleep(2000);
            extratoService.adicionarTransacao(100d, OperacaoBancaria.SAQUE);
            extratoService.adicionarTransacao(100d, OperacaoBancaria.DEPOSITO);
            Thread.sleep(2000);
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
        LocalDateTime dataFinal = LocalDateTime.now();
        extratoService.adicionarTransacao(100d, OperacaoBancaria.FINANCIAMENTO);

        Assertions.assertEquals(2, extratoService.transacoesPorIntervaloData(dataInicio, dataFinal).size());
    }
}
