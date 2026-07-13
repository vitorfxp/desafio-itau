package dev.jv.DesafioItau.controller;


import dev.jv.DesafioItau.docs.EstatiscaControllerDoc;
import dev.jv.DesafioItau.configuration.EstatisticaProperties;
import dev.jv.DesafioItau.dto.EstatiscasDTO;
import dev.jv.DesafioItau.repository.TransacaoRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.OffsetDateTime;

@Slf4j
@RestController
@RequestMapping("/estatistica")
public class EstatisticaController implements EstatiscaControllerDoc {

    private final EstatisticaProperties estatisticaProperties;
    private final TransacaoRepository transacaoRepository;


    public EstatisticaController(EstatisticaProperties estatisticaProperties, TransacaoRepository transacaoRepository) {
        this.estatisticaProperties = estatisticaProperties;
        this.transacaoRepository = transacaoRepository;
    }

    @GetMapping
    public ResponseEntity<EstatiscasDTO> calcularOperacoes() {
        try {
            final var horaAtual = OffsetDateTime.now().minusSeconds(estatisticaProperties.segundos());
            EstatiscasDTO dados = transacaoRepository.estatisticas(horaAtual);

            if (dados.getCount() == 0) {
                log.error("Não há transação nos últimos 60 segundos");
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
            }

            log.info("Calculando estatistícas das transações nos últimos:" + horaAtual.getSecond());
            return ResponseEntity.status(HttpStatus.OK).body(dados);
        } catch (Exception e) {
            log.error("Erro ao calcular estatísticas.");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }
}
