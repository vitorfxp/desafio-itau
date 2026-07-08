package dev.jv.DesafioItau.controller;


import dev.jv.DesafioItau.dto.EstatiscasDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// Controller de estatistica
@RestController
@RequestMapping("/estatistica")
public class EstatisticaController {

    @GetMapping
    public ResponseEntity<EstatiscasDTO> calcularOperacoes(){
        // service brabo para fazer as operações com as transações
        EstatiscasDTO coisas = new EstatiscasDTO(23L,23, 23,23,23 );
        return ResponseEntity.status(HttpStatus.OK).body(coisas);
    }
}
