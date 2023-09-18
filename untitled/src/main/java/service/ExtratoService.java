package service;

import domain.ContaBancaria;
import domain.Transacao;
import enums.OperacaoBancaria;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ExtratoService {
    private List<Transacao> transacaoList = new ArrayList<>();
    private ContaBancaria contaResponsavel;
    public ExtratoService(ContaBancaria contaResponsavel){
        this.contaResponsavel = contaResponsavel;
    }

    public List<Transacao> transacoesPorIntervaloData(LocalDateTime dataInicial, LocalDateTime dataFinal){
        return transacaoList.stream().filter((transacao) -> transacao.getMomentoDaTransacao().isAfter(dataInicial) && transacao.getMomentoDaTransacao().isBefore(dataFinal)).toList();
    }

    public void adicionarTransacao(Double valor, OperacaoBancaria operacaoBancaria){
        transacaoList.add(new Transacao(operacaoBancaria, valor, this.contaResponsavel));
    }

    public void adicionarTransacao(Double valor, OperacaoBancaria operacaoBancaria, ContaBancaria contaParalela){
        transacaoList.add(new Transacao(operacaoBancaria, valor, this.contaResponsavel, contaParalela));
    }

    public List<Transacao> getTransacaoList(){
        return this.transacaoList;
    }

    public ContaBancaria getContaResponsavel(){
        return this.contaResponsavel;
    }
}
