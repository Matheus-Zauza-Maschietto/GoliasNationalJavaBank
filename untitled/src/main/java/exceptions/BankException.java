package exceptions;

public class BankException extends RuntimeException{
    public BankException(String messagem){
        super(messagem);
    }
}
