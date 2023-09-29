package gustavo.desafiocielo.desafioum.controller;


import gustavo.desafiocielo.desafioum.models.Fisica;
import gustavo.desafiocielo.desafioum.repository.FisicaRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Tag(name = "Fisica")
@RestController
@RequestMapping("/api/")
public class FisicaController {

    private final FisicaRepository fisicaRepository;

    FisicaController(FisicaRepository fisicaRepository) {
        this.fisicaRepository = fisicaRepository;
    }

    @PostMapping("/fisica")
    @Operation(summary = "Nova pessoa", description = "Endpoint para cadastro de novas pessoas fisícias")
    Fisica novaFisica(@RequestBody Fisica fisica) {
        return fisicaRepository.save(fisica);
    }

    @Operation(summary = "Busca de pessoas fisícas", description = "Endpoint para buscar todas as pessoas fisícas cadastradas")
    @GetMapping("/fisica")
    List<Fisica> todasFisicas() {
        return fisicaRepository.findAll();
    }

    @Operation(summary = "Buscar pessoa fisíca", description = "Buscar pessoa fisíca pelo CPF")
    @GetMapping("/fisica/{cpf}")
    Optional<Fisica> pesquisaFisica(@PathVariable String cpf) {
        return fisicaRepository.findById(cpf); //.orElseThrow(() -> new PessoaNaoEncontradaException(cpf));
    }


}
