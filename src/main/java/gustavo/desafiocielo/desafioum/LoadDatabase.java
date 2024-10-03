package gustavo.desafiocielo.desafioum;

import gustavo.desafiocielo.desafioum.models.Fisica;
import gustavo.desafiocielo.desafioum.models.Juridica;
import gustavo.desafiocielo.desafioum.repository.FisicaRepository;
import gustavo.desafiocielo.desafioum.repository.JuridicaRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class LoadDatabase {

    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

    @Bean
    CommandLineRunner initFisica(FisicaRepository repository) {
        return args-> {
            log.info("Preloading " + repository.save(new Fisica("57182979080", "1234","Pessoa da Silva","wjwj" )));
            log.info("Preloading " + repository.save(new Fisica("21582706085", "4567","Pessoa Santos","wjwu" )));
            log.info("Preloading " + repository.save(new Fisica("79372668052","8988","Pessoa Pessoa","w" )));
            log.info("Preloading " + repository.save(new Fisica("48004270026","1454","Pessoa da Pessoa","123" )));
        };
    }

    @Bean
    CommandLineRunner initJuridica(JuridicaRepository repository){
        return args -> {
            log.info("Preloading " + repository.save(new Juridica("50495742000103","Piscinas e cia","88697699096","1234", "Pessoa da Sem Conhecer", "semconhecer@email.com")));
            log.info("Preloading " + repository.save(new Juridica("19737925000148", "Madeira e cia","09176589064","1234","Pessoa Para Conhecer", "conhecer@email.com")));
        };
    }


}
