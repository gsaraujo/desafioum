package gustavo.desafiocielo.desafioum.exception;

public class PessoaNaoEncontradaException extends RuntimeException{

    public PessoaNaoEncontradaException(String cpf) {
        super("Não foi possível encontrar ninguém com CPF " + cpf);
    }
}
