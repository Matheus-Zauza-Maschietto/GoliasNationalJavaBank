package interfaces;

import domain.ContaBancaria;

public interface ContaSalario {
    void criarPortabilidade(ContaBancaria contaPortabilidade);
    void receberTransferencia(Double valor);
}
