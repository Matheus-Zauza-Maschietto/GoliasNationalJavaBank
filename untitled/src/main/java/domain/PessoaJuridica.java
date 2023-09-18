package domain;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class PessoaJuridica extends Pessoa{
    private String CNPJ;
    private Double capitalInicial;

    public PessoaJuridica(Endereco endereco, String nome, LocalDate dataInicioDeExistencia, String CNPJ, Double capitalInicial){
        super(endereco, nome , dataInicioDeExistencia);
        this.capitalInicial = capitalInicial;
        this.CNPJ = CNPJ;
    }

    public String getCNPJ(){
        return this.CNPJ;
    }

    public Double getCapitalInicial(){
        return this.capitalInicial;
    }
}
