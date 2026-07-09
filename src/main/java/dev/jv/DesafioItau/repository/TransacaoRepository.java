package dev.jv.DesafioItau.repository;

import dev.jv.DesafioItau.dto.EstatiscasDTO;
import dev.jv.DesafioItau.dto.TransacaoDTO;
import org.springframework.stereotype.Repository;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.DoubleSummaryStatistics;
import java.util.List;

@Repository
public class TransacaoRepository {

    List<TransacaoDTO> dataList = new ArrayList<>();

    public void salvarData(TransacaoDTO data){
        dataList.add(data);
    }

    public void limparDados () {

    }

    public void deletarDados(){
        dataList.clear();
    }

    public EstatiscasDTO estatisticas(OffsetDateTime horaAtual){
        // Terminar os metodos de calcular estatisticas
        DoubleSummaryStatistics operacoes = new DoubleSummaryStatistics();
//        Long count = dataList.stream().count();
//        double avg =  dataList.stream(). /count;
//        double min = dataList.stream().min();
       EstatiscasDTO dados = new EstatiscasDTO(23L, 23,23,23,23);

       return dados;

    }

}
