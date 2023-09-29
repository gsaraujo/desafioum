package gustavo.desafiocielo.desafioum.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class PessoaNaoEncontradaAdvice {

    @ResponseBody
    @ExceptionHandler(PessoaNaoEncontradaException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String fisicaNaoEncontradaHandler(PessoaNaoEncontradaException ex) {
        return ex.getMessage();
    }


}
