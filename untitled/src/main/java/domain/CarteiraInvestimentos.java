package domain;

import enums.TipoDeAtivo;
import exceptions.BankException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class CarteiraInvestimentos {
    private List<Ativo> investimentos = new ArrayList<>();
    private ContaBancaria contaResponsavel;
    public CarteiraInvestimentos(ContaBancaria contaResponsavel){
        this.contaResponsavel = contaResponsavel;
    }

    public List<Ativo> getInvestimentos(){
        return this.investimentos;
    }

    public Double getValorTotalAtivos(){
        Double valorTotal = 0d;
        for (Ativo ativo: investimentos) {
            valorTotal += ativo.getValorTotalAtivo();
        }
        return valorTotal;
    }

    public Double getValorTotalAtivoPorTipo(TipoDeAtivo tipo){
        Double valorTotal = 0d;
        for (Ativo ativo: investimentos) {
            if(ativo.getTipo() == tipo)
                valorTotal += ativo.getValorTotalAtivo();
        }
        return valorTotal;
    }

    public void comprarAtivo(Double valor, String nome, TipoDeAtivo tipo){
        if(valor > this.contaResponsavel.saldo)
            throw new BankException("Você não possui saldo suficiente para comprar essa valor de ativo !");
        else if (valor <= 0)
            throw new BankException("Valor invalido !");

        this.investimentos.add(new Ativo(tipo, nome, valor));
        this.contaResponsavel.saldo -= valor;
    }

    public void venderAtivo(UUID identificador){
        Optional<Ativo> ativoParaDelecao = this.investimentos.stream().filter(ativo -> ativo.getIdentificador().compareTo(identificador) == 0).findFirst();
        ativoParaDelecao.ifPresent(ativo -> this.investimentos.remove(ativo));
    }
}
