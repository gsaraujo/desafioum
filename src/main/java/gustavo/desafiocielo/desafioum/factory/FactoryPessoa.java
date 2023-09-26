package gustavo.desafiocielo.desafioum.factory;

import gustavo.desafiocielo.desafioum.product.Fisica;
import gustavo.desafiocielo.desafioum.product.Juridica;
import gustavo.desafiocielo.desafioum.product.Pessoa;

class FactoryPessoa {

    public Pessoa getPessoa(Character tipoPessoa, int mcc, String cpf, String nome, String email, String cnpj, String razaoSocial) {
        return switch (tipoPessoa) {
            case 'J' -> new Juridica(mcc, cpf, nome, email, cnpj, razaoSocial);
            case 'P' -> new Fisica(mcc, cpf, nome, email);
            default -> null;
        };

    }
}