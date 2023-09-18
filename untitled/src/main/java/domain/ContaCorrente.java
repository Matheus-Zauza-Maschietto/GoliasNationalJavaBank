package domain;

import enums.OperacaoBancaria;
import exceptions.BankException;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ContaCorrente extends ContaBancaria implements interfaces.ContaCorrente{
    private Double anuidade = 50d;
    private Pessoa responsavelSecundario;
    private List<Financiamento> financiamentosList = new ArrayList<>();

    public ContaCorrente(Double saldo, Pessoa responsavelPrimario){
        super(saldo, responsavelPrimario);
    }

    public ContaCorrente(Double saldo, Pessoa responsavelPrimario, Pessoa responsavelSecundario){
        super(saldo, responsavelPrimario);
        this.responsavelSecundario = responsavelSecundario;
    }

    public List<Financiamento> getFinanciamentosList() { return financiamentosList; }
    public Double getAnuidade(){
        return this.anuidade;
    }
    public Pessoa getResponsavelSecundario(){
        return this.responsavelSecundario;
    }

    public void realizarFinanciamento(Double valor, Double valorParcela, String apelido){
        if(valor <= 0)
            throw new BankException("Emprestimo com valor invalido !");

        this.financiamentosList.add(new Financiamento(valor, valorParcela, LocalDateTime.now(), this, apelido));
        this.extratoService.adicionarTransacao(valor, OperacaoBancaria.FINANCIAMENTO);
    }

}
