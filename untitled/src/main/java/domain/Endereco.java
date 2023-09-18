package domain;

public class Endereco {
    private String rua;
    private String bairro;
    private String cidade;
    private String UF;
    private String numero;
    private String CEP;
    private String complemento;

    public Endereco(String rua, String bairro, String cidade, String UF, String numero, String CEP){
        this.rua = rua;
        this.bairro = bairro;
        this.numero = numero;
        this.cidade = cidade;
        this.UF = UF;
        this.CEP = CEP;
    }

    public Endereco(String rua, String bairro, String cidade, String UF, String numero, String CEP, String complemento){
        this.rua = rua;
        this.bairro = bairro;
        this.numero = numero;
        this.cidade = cidade;
        this.UF = UF;
        this.complemento = complemento;
        this.CEP = CEP;
    }

    public String getRua() {
        return rua;
    }

    public String getBairro() {
        return bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public String getUF() {
        return UF;
    }

    public String getNumero() {
        return numero;
    }

    public String getCEP() {
        return CEP;
    }

    public String getComplemento() {
        return complemento;
    }
}
