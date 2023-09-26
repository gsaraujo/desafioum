package gustavo.desafiocielo.desafioum.repository;

import gustavo.desafiocielo.desafioum.product.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PessoaRepository extends JpaRepository<Pessoa, String> {

}
