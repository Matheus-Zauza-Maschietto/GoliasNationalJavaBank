package enums;

public enum TipoDeAtivo {
    ACAO(5d),
    TITULO_DE_RENDA_FIXA(13d),
    FUNDO_DE_INVESTIMENTO(9.5d),
    IMOVEL(3d),
    COMODITIE(6d),
    CRIPTOMOEDA(17d),
    MOEDA_ESTRANGEIRA(2d);
    private Double juros;
    TipoDeAtivo(Double juros){
        this.juros = juros;
    }
    public Double getJuros(){
        return this.juros;
    }
}
