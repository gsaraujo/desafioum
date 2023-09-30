package gustavo.desafiocielo.desafioum.controller;


import gustavo.desafiocielo.desafioum.exception.FisicaNaoEncontradaException;
import gustavo.desafiocielo.desafioum.models.Fisica;
import gustavo.desafiocielo.desafioum.repository.FisicaRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Física")
@RestController
@RequestMapping("/api/")
public class FisicaController {

    private final FisicaRepository fisicaRepository;

    FisicaController(FisicaRepository fisicaRepository) {
        this.fisicaRepository = fisicaRepository;
    }

    @PostMapping("/fisica")
    @Operation(summary = "Nova pessoa", description = "Endpoint para cadastro de novas pessoas físicas")
    Fisica novaFisica(@RequestBody Fisica fisica) {
        if(!fisicaRepository.existsById(fisica.getCpf())) {
            return fisicaRepository.save(fisica);
        }
        else {
            throw new FisicaNaoEncontradaException(fisica.getCpf());
        }

    }

    @Operation(summary = "Busca de pessoas físicas", description = "Endpoint para buscar todas as pessoas físicas cadastradas")
    @GetMapping("/fisica")
    List<Fisica> todasFisicas() {
        return fisicaRepository.findAll();
    }

    @Operation(summary = "Buscar pessoa física", description = "Endpoint para buscar pessoa física pelo CPF")
    @GetMapping("/fisica/{cpf}")
    Fisica pesquisaFisica(@PathVariable String cpf) {
        return fisicaRepository.findById(cpf)
                .orElseThrow(() -> new FisicaNaoEncontradaException(cpf));
    }

    @Operation(summary = "Atualização de pessoa física", description = "Endpoint para atualização de dados de pessoa física")
    @PutMapping("/fisica/{cpf}")
    Fisica atualizaFisica(@RequestBody Fisica novaFisica, @PathVariable String cpf) {
        return fisicaRepository.findById(cpf)
                .map(fisica -> {
                    fisica.setCpf(novaFisica.getCpf());
                    fisica.setNome(novaFisica.getNome());
                    fisica.setMcc(novaFisica.getMcc());
                    fisica.setEmail(novaFisica.getEmail());
                    return fisicaRepository.save(fisica);
                })
                .orElseThrow(()-> new FisicaNaoEncontradaException(novaFisica.getCpf()));
    }

    @Operation(summary = "Exclusão de pessoa física", description = "Endpoint para exclusão de pessoa física")
    @DeleteMapping("/fisica")
    void deleteFisica(@PathVariable String cpf) {
        fisicaRepository.deleteById(cpf);
    }


}
