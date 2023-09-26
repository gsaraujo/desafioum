package gustavo.desafiocielo.desafioum;

import gustavo.desafiocielo.desafioum.product.Fisica;
import gustavo.desafiocielo.desafioum.product.Juridica;
import gustavo.desafiocielo.desafioum.repository.PessoaRepository;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;


public class LoadDatabase {

    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

    @Bean
    CommandLineRunner initFisica(PessoaRepository repository) {
        return args-> {
            log.info("Preloading " + repository.save(new Fisica(1234,"57182979080","Pessoa da Silva","email@email.com" )));
            log.info("Preloading " + repository.save(new Fisica(4567,"21582706085","Pessoa Santos","santos@email.com" )));
            log.info("Preloading " + repository.save(new Fisica(8988,"79372668052","Pessoa Pessoa","pessoa@email.com" )));
            log.info("Preloading " + repository.save(new Fisica(1454,"48004270026","Pessoa da Pessoa","pdapessoa@email.com" )));
        };
    }

    @Bean
    CommandLineRunner initJuridica(PessoaRepository repository){
        return args -> {
            log.info("Preloading " + repository.save(new Juridica(1234,"58919081077","Pessoa da Anonima","anonima@email.com", "97468806000140", "paulo bonfa ringling brothers capillar consultants")));
            log.info("Preloading " + repository.save(new Juridica(1234,"57519044009","Pessoa da Conhecida","conhecida@email.com", "15414117000199", "Portas e cia")));
            log.info("Preloading " + repository.save(new Juridica(1234,"81700440063","Pessoa da Desconhecida","desconhecida@email.com", "09483811000165", "Janelas e cia")));
            log.info("Preloading " + repository.save(new Juridica(1234,"88697699096","Pessoa da Sem Conhecer","semconhecer@email.com", "50495742000103", "Piscinas e cia")));
            log.info("Preloading " + repository.save(new Juridica(1234,"09176589064","Pessoa Para Conhecer","conhecer@email.com", "19737925000148", "Madeira e cia")));
        };
    }


}
