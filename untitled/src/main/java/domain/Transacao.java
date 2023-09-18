package domain;

import enums.OperacaoBancaria;

import java.time.LocalDateTime;

public class Transacao {
    private ContaBancaria contaResponsavel;
    private LocalDateTime momentoDaTransacao;
    private OperacaoBancaria operacaoBancaria;
    private Double valor;
    private ContaBancaria contaDestino;
    public Transacao(OperacaoBancaria operacaoBancaria, Double valor, ContaBancaria contaResponsavel){
        this.contaResponsavel = contaResponsavel;
        this.valor = valor;
        this.momentoDaTransacao = LocalDateTime.now();
        this.operacaoBancaria = operacaoBancaria;
    }

    public Transacao(OperacaoBancaria operacaoBancaria, Double valor, ContaBancaria contaResponsavel, ContaBancaria contaDestino){
        this.contaResponsavel = contaResponsavel;
        this.valor = valor;
        this.momentoDaTransacao = LocalDateTime.now();
        this.operacaoBancaria = operacaoBancaria;
        this.contaDestino = contaDestino;
    }

    public ContaBancaria getContaDestino(){
        return this.contaDestino;
    }

    public ContaBancaria getContaResponsavel(){
        return this.contaResponsavel;
    }

    public LocalDateTime getMomentoDaTransacao() {
        return momentoDaTransacao;
    }

    public OperacaoBancaria getOperacaoBancaria() {
        return operacaoBancaria;
    }

    public Double getValor() {
        return valor;
    }
}
