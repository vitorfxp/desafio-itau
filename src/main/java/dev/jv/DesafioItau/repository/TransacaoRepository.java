package dev.jv.DesafioItau.repository;

import dev.jv.DesafioItau.dto.EstatiscasDTO;
import dev.jv.DesafioItau.dto.TransacaoDTO;
import org.springframework.stereotype.Repository;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.stream.DoubleStream;

@Repository
public class TransacaoRepository {

    List<TransacaoDTO> dataList = new ArrayList<>();

    public void salvarData(TransacaoDTO data) {
        dataList.add(data);
    }

    public void limparDados() {

    }

    public void deletarDados() {
        dataList.clear();
    }

    public EstatiscasDTO estatisticas(OffsetDateTime horaAtual) {

        if (dataList.isEmpty()) {
            return new EstatiscasDTO(0L, 0.0, 0.0, 0.0, 0.0);
        }


        final var summary = dataList.stream()
                .filter(t -> t.getDataHora().isAfter(horaAtual) || t.getDataHora().isEqual(horaAtual))
                .mapToDouble(t -> t.getValor().doubleValue())
                .summaryStatistics();

        return new EstatiscasDTO(summary.getCount(), summary.getAverage(), summary.getMax(), summary.getMin(), summary.getSum());

    }

}
