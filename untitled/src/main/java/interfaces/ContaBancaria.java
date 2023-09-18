package interfaces;

public interface ContaBancaria {
    void sacar(Double valor);
    void depositar(Double valor);
    void transferir(domain.ContaBancaria contaReceptora, Double valor);
    void receberTransferencia(Double valor);
}
