package dev.jv.DesafioItau.service;


import dev.jv.DesafioItau.dto.TransacaoDTO;
import dev.jv.DesafioItau.repository.TransacaoRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

@Service
public class TransacaoService {

    private TransacaoRepository repository;

    public TransacaoService(TransacaoRepository repository) {
        this.repository = repository;
    }

    public void validarTransacao(TransacaoDTO data){

        if(data.getValor().compareTo(BigDecimal.ZERO) < 0){
            throw new IllegalArgumentException("Erro: O valor não pode ser negativo.");
        }

        if(data.getDataHora().isAfter(OffsetDateTime.now())){
            throw new IllegalArgumentException("Erro: A transação não pode acontecer no futuro.");
        }

    }

}
