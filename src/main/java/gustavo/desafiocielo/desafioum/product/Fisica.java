package gustavo.desafiocielo.desafioum.product;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
public class Fisica extends Pessoa {

    private @Id String cpf;
    public Fisica(int mcc, String cpf, String nome, String email) {
        this.mcc = mcc;
        this.cpf = cpf;
        this.nome = nome;
        this.email = email;
    }

}