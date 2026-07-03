package dev.jv.DesafioItau.controller;


import dev.jv.DesafioItau.dto.TransacaoDTO;
import dev.jv.DesafioItau.repository.TransacaoRepository;
import dev.jv.DesafioItau.service.TransacaoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
            repository.salvarData(data);
            return ResponseEntity.status(HttpStatus.CREATED).build();
        } catch (IllegalArgumentException exception) {
            return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @DeleteMapping
    public ResponseEntity deletarTransacoes() {
        repository.deletarDados();
        return ResponseEntity.status(HttpStatus.OK).build();
    }

}
