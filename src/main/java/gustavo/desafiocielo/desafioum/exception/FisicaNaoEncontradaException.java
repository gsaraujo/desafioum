package gustavo.desafiocielo.desafioum.exception;

public class FisicaNaoEncontradaException extends RuntimeException{

    public FisicaNaoEncontradaException(String cpf) {
        super("Não foi possível encontrar ninguém com CPF " + cpf);
    }
}
