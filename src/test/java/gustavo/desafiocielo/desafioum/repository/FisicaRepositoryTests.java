package gustavo.desafiocielo.desafioum.repository;

import gustavo.desafiocielo.desafioum.models.Fisica;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
public class FisicaRepositoryTests {

    @Autowired
    private FisicaRepository fisicaRepository;

    @Test public void FisicaRepository_saveFisica_ReturnPessoaSalva() {

        Fisica fisica = Fisica.builder()
                .nome("NOME DA PESSOA")
                .cpf("58554552569")
                .mcc("5878")
                .email("ble")
                .build();

        Fisica fisicaSalva = fisicaRepository.save(fisica);

        Assertions.assertThat(fisicaSalva).isNotNull();
        Assertions.assertThat(fisicaSalva.getCpf()).hasSize(11);


    }

}
