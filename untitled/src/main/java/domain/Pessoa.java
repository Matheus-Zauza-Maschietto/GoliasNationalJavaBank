package domain;

import java.time.LocalDate;
import java.time.LocalDateTime;

public abstract class Pessoa {
    protected Endereco endereco;
    protected String nome;
    protected LocalDate dataInicioDeExistencia;
    public Pessoa(Endereco endereco, String nome, LocalDate dataInicioDeExistencia){
        this.endereco = endereco;
        this.nome = nome;
        this.dataInicioDeExistencia = dataInicioDeExistencia;
    }
}
