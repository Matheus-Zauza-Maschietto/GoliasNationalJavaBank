package domain;

import exceptions.BankException;

import java.time.LocalDateTime;
import java.util.UUID;

public class Financiamento {
    private UUID identificador;
    private String apelido;
    private Double valor;
    private Double valorParcela;
    private int quantidadeParcelasTotais;
    private LocalDateTime dataDeInicio;
    private ContaCorrente contaResponsavel;

    public Financiamento(Double valor, Double valorParcela, LocalDateTime dataDeInicio, ContaCorrente contaResponsavel, String apelido){
        this.apelido = apelido;
        this.dataDeInicio = dataDeInicio;
        this.valorParcela = valorParcela;
        this.identificador = UUID.randomUUID();
        this.contaResponsavel = contaResponsavel;
        quantidadeParcelasTotais = (int)Math.ceil(valor/valorParcela);
        this.valor = valor;
    }

    public UUID getIdentificador(){ return this.identificador; }
    public String getApelido(){
        return this.apelido;
    }
    public Double getValor(){
        return this.valor;
    }
    public Double getValorParcela(){
        return this.valorParcela;
    }
    public LocalDateTime getDataDeInicio(){
        return this.dataDeInicio;
    }
    public int getQuantidadeParcelasTotais(){
        return this.quantidadeParcelasTotais;
    }
    public int getQuantidadeParcelasRestantes(){
        return (int)Math.ceil(this.valor/this.valorParcela);
    }

    public void pagarParcela(){
        if(contaResponsavel.saldo < valorParcela)
            throw new BankException("Você não possui saldo suficiente para pagar a parcela !");
        else if(valorParcela > valor){
            contaResponsavel.saldo -= valor;
            valor = 0d;
        }
        else{
            valor -= valorParcela;
            contaResponsavel.saldo -= valorParcela;
        }
    }
}
