package domain;

import enums.OperacaoBancaria;
import exceptions.BankException;

public class ContaPoupanca extends ContaBancaria implements interfaces.ContaPoupanca {
    private Pessoa responsavelSecundario;
    private Double taxaDeJuros = 10d;


    public ContaPoupanca(Double saldo, Pessoa responsavel){
        super(saldo, responsavel);
    }

    public ContaPoupanca(Double saldo, Pessoa responsavel, Pessoa responsavelSecundario){
        super(saldo, responsavel);

        if(saldo < 50d)
            throw new BankException("Não é permitido abrir uma conta poupança com menos de 50 R$");

        this.responsavelSecundario = responsavelSecundario;
    }

    public Double getTaxaDeJuros() {
        return taxaDeJuros;
    }

    public void gerarJuros(){
        double jurosMensal = (this.saldo/100)*this.taxaDeJuros;
        this.saldo += jurosMensal;
        this.extratoService.adicionarTransacao(jurosMensal, OperacaoBancaria.RECEBIMENTO_DIVIDENDOS);
    }
}
