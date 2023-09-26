package gustavo.desafiocielo.desafioum.product;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@NoArgsConstructor
public class Juridica extends Pessoa {

    private @Id String cnpj;
    private String razaoSocial;
    private String cpf;

    public Juridica(int mcc, String cpf, String nome, String email, String cnpj, String razaoSocial) {
        this.mcc = mcc;
        this.cpf = cpf;
        this.nome = nome;
        this.email = email;
        this.cnpj = cnpj;
        this.razaoSocial = razaoSocial;
    }


}