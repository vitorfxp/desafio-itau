package dev.jv.DesafioItau.controller;


import dev.jv.DesafioItau.configuration.EstatisticaProperties;
import dev.jv.DesafioItau.dto.EstatiscasDTO;
import dev.jv.DesafioItau.repository.TransacaoRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.OffsetDateTime;

// Controller de estatistica
@RestController
@RequestMapping("/estatistica")
public class EstatisticaController {

    private final EstatisticaProperties estatisticaProperties;
    private final TransacaoRepository transacaoRepository;


    public EstatisticaController(EstatisticaProperties estatisticaProperties, TransacaoRepository transacaoRepository) {
        this.estatisticaProperties = estatisticaProperties;
        this.transacaoRepository = transacaoRepository;
    }

    @GetMapping
    public ResponseEntity<EstatiscasDTO> calcularOperacoes(){
        final var horaAtual = OffsetDateTime.now().minusSeconds(estatisticaProperties.segundos());

        EstatiscasDTO coisas = new EstatiscasDTO(23L,23, 23,23,23 );

        return ResponseEntity.status(HttpStatus.OK).body(coisas);
    }
}
