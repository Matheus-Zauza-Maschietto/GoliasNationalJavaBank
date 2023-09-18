package domain;

import enums.OperacaoBancaria;
import exceptions.BankException;

public class ContaSalario extends ContaBancaria implements interfaces.ContaSalario {
    private PessoaJuridica empregador;
    private ContaBancaria contaPortabilidade;
    public ContaSalario(Double saldo, Pessoa responsavel, PessoaJuridica empregador){
        super(saldo, responsavel);
        this.empregador = empregador;
    }
    public PessoaJuridica getEmpregador(){
        return this.empregador;
    }
    public ContaBancaria getContaPortabilidade(){
        return this.contaPortabilidade;
    }

    public void criarPortabilidade(ContaBancaria contaPortabilidade){
        this.contaPortabilidade = contaPortabilidade;
    }

    @Override
    public void receberTransferencia(Double valor){
        if(valor <= 0)
            throw new BankException("Tentativa de deposito de valor invalido !");

        this.saldo += valor;

        if(this.contaPortabilidade != null)
            this.transferir(this.contaPortabilidade, valor);

        this.extratoService.adicionarTransacao(valor, OperacaoBancaria.PORTABILIDADE, contaPortabilidade);
    }
}

