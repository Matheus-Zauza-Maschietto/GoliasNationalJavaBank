package domain;

import enums.OperacaoBancaria;
import exceptions.BankException;
import service.ExtratoService;

public abstract class ContaBancaria implements interfaces.ContaBancaria {
    protected Double saldo;
    protected Pessoa responsavel;
    protected ExtratoService extratoService;
    protected CarteiraInvestimentos carteiraInvestimentos;

    public ContaBancaria(Double saldo, Pessoa responsavel){
        this.saldo = saldo;
        this.responsavel = responsavel;
        extratoService = new ExtratoService(this);
        this.carteiraInvestimentos = new CarteiraInvestimentos(this);
    }

    public Double getSaldo(){
        return this.saldo;
    }
    public Pessoa getResponsavel(){
        return this.responsavel;
    }
    public CarteiraInvestimentos getCarteiraInvestimentos(){
        return this.carteiraInvestimentos;
    }


    public void receberTransferencia(Double valor){
        if(valor <= 0)
            throw new BankException("Transferência com valor invalido !");
        this.saldo += valor;
        this.extratoService.adicionarTransacao(valor, OperacaoBancaria.RECEBIMENTO_DE_TRANSFERENCIA, this);
    }

    public void sacar(Double valor){
        if(this.saldo < valor)
            throw new BankException("Você não possui saldo suficiente !");

        this.saldo -= valor;
        this.extratoService.adicionarTransacao(valor, OperacaoBancaria.SAQUE);
    }

    public void depositar(Double valor){
        if(valor <= 0)
            throw new BankException("Tentativa de deposito de valor invalido !");

        this.saldo += valor;
        this.extratoService.adicionarTransacao(valor, OperacaoBancaria.DEPOSITO);
    }

    public void transferir(ContaBancaria contaReceptora, Double valor){
        if(valor > this.saldo)
            throw new BankException("Não foi possivel enviar a transferência pois você não possui saldo suficiente !");
        else if(valor <= 0d)
            throw new BankException("Não foi possivel enviar a transferência pois o valor é invalido !");

        contaReceptora.receberTransferencia(valor);
        this.saldo -= valor;
        this.extratoService.adicionarTransacao(valor, OperacaoBancaria.TRANSFERENCIA, contaReceptora);
    }
}
