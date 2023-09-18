package domain;

import enums.EstadosCivies;

import java.time.LocalDate;

public class PessoaFisica extends Pessoa{
    private String Cpf;
    private EstadosCivies estadoCivil;

    public PessoaFisica(Endereco endereco, String nome, LocalDate dataInicioDeExistencia, String Cpf, EstadosCivies estadoCivil){
        super(endereco, nome, dataInicioDeExistencia);
        this.Cpf = Cpf;
        this.estadoCivil = estadoCivil;
    }

    public String getCpf() {
        return Cpf;
    }

    public EstadosCivies getEstadoCivil() {
        return estadoCivil;
    }
}
