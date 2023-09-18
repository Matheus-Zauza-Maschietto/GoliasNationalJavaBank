package domain;

import enums.TipoDeAtivo;

import java.util.UUID;

public class Ativo {
    private TipoDeAtivo tipo;
    private String nome;
    private Double valorTotalAtivo;
    private UUID identificador;

    public Ativo(TipoDeAtivo tipo, String nome, Double valorTotalAtivo){
        this.tipo = tipo;
        this.nome = nome;
        this.valorTotalAtivo = valorTotalAtivo;
        this.identificador = UUID.randomUUID();
    }

    public TipoDeAtivo getTipo(){
        return this.tipo;
    }
    public String getNome(){
        return this.nome;
    }
    public Double getValorTotalAtivo(){
        return this.valorTotalAtivo;
    }
    public UUID getIdentificador(){
        return this.identificador;
    }

    public void gerarJuros(){
        this.valorTotalAtivo += (this.valorTotalAtivo/100)*this.tipo.getJuros();
    }
}
