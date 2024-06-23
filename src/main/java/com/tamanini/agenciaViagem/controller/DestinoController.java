package com.tamanini.agenciaViagem.controller;

import com.tamanini.agenciaViagem.DTO.DestinoDTO;
import com.tamanini.agenciaViagem.service.DestinoService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.geo.Point;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/destinos")
@RequiredArgsConstructor
public class DestinoController {

    @Autowired
    private final DestinoService destinoService;

    // Cria um destino
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public DestinoDTO criarDestino(@RequestBody DestinoDTO destinoDTO) {
        return destinoService.criarDestino(destinoDTO);
    }

    // Busca todos os destinos disponíveis
    @GetMapping("/")
    @ResponseStatus(HttpStatus.OK)
    public List<DestinoDTO> buscarTodosDestinos() {
        return destinoService.buscarTodosDestinos();
    }

    // Busca destino por nome
    @GetMapping("/{nome}")
    @ResponseStatus(HttpStatus.OK)
    public DestinoDTO buscarDestinoPorNome(@PathVariable String nome) {
        return destinoService.buscarDestinoPorNome(nome);
    }

    // Busca destino por localização
    @GetMapping("/{localizacao}")
    @ResponseStatus(HttpStatus.OK)
    public DestinoDTO buscarDestinoPorLocalizacao(@PathVariable Point localizacao) {
        return destinoService.buscarDestinoPorLocalizacao(localizacao);
    }

    // Busca informações detalhadas sobre um destino
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public DestinoDTO buscarDestino(@PathVariable Long id) {
        return destinoService.buscarDestino(id);
    }

    // Inclui nova nota no cálculo da média do destino
    @PatchMapping("/{id}/avaliacao")
    public ResponseEntity<String> atualizarAvaliacao(@PathVariable Long id, @RequestBody Double nota) {
        boolean sucesso = destinoService.atualizarAvaliacao(id, nota);
        if (sucesso) {
            return ResponseEntity.ok("Avaliação atualizada com sucesso!");
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Faz a exclusão do destino especificado
    @DeleteMapping("/excluir/{id}")
    public ResponseEntity<String> excluirDestino(@PathVariable Long id) {
        boolean sucesso = destinoService.excluirDestino(id);
        if (sucesso) {
            return ResponseEntity.ok("Destino excluído com sucesso!");
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
