import domain.Ativo;
import enums.TipoDeAtivo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AtivoTest {
    @Test
    public void gerarJurosAtivoTest(){
        Ativo ativo = new Ativo(TipoDeAtivo.ACAO, "GDJ4", 1000d);
        ativo.gerarJuros();
        Assertions.assertEquals(1050d, ativo.getValorTotalAtivo());
    }
}
