package gustavo.desafiocielo.desafioum.controller;


import gustavo.desafiocielo.desafioum.models.Juridica;
import gustavo.desafiocielo.desafioum.repository.JuridicaRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Tag(name = "Juridica")
@RestController
@RequestMapping("/api/")
public class JuridicaController {

    private final JuridicaRepository JuridicaRepository;

    JuridicaController(JuridicaRepository JuridicaRepository) {
        this.JuridicaRepository = JuridicaRepository;
    }

    @PostMapping("/juridica")
    @Operation(summary = "Nova pessoa jurídica", description = "Endpoint para cadastro de novas pessoas jurídicas")
    Juridica novaJuridica(@RequestBody Juridica Juridica) {
        return JuridicaRepository.save(Juridica);
    }

    @Operation(summary = "Busca de pessoas jurídicas", description = "Endpoint para buscar todas as pessoas jurídicas cadastradas")
    @GetMapping("/juridica")
    List<Juridica> todasJuridicas() {
        return JuridicaRepository.findAll();
    }

    @Operation(summary = "Buscar pessoa jurídica", description = "Endpoint para buscar pessoa jurídica pelo CNPJ")
    @GetMapping("/juridica/{cnpj}")
    Optional<Juridica> pesquisaJuridica(@PathVariable String cnpj) {
        return JuridicaRepository.findById(cnpj); //.orElseThrow(() -> new FisicaNaoEncontradaException(cpf));
    }


}
