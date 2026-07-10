package dev.jv.DesafioItau.controller;


import dev.jv.DesafioItau.dto.TransacaoDTO;
import dev.jv.DesafioItau.repository.TransacaoRepository;
import dev.jv.DesafioItau.service.TransacaoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@Slf4j
@RestController
@RequestMapping("/transacao")
public class TransacaoController {

    private TransacaoService transacaoService;
    private TransacaoRepository repository;

    public TransacaoController(TransacaoService transacaoService, TransacaoRepository repository) {
        this.transacaoService = transacaoService;
        this.repository = repository;
    }

    @PostMapping
    public ResponseEntity<String> adicionarTransacao(@RequestBody TransacaoDTO data) {
        try {
            transacaoService.validarTransacao(data);
            log.info("Transição validada.");
            repository.salvarData(data);
            log.info("Transição incluída, calcule ela nos proxímos 60 segundos");
            return ResponseEntity.status(HttpStatus.CREATED).build();
        } catch (IllegalArgumentException exception) {
            log.error("Erro a validar um ou mais campos enviados, tente novamente.");
            return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).build();
        } catch (Exception e) {
            log.error("Erro ao processar um ou mais campos enviados,tente novamente", e);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @DeleteMapping
    public ResponseEntity<?> deletarTransacoes() {
        try {
            repository.deletarDados();
            log.info("Transação deletada");
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            log.error("Erro ao deletar uma transação", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

}
