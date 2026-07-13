package dev.jv.DesafioItau.docs;

import dev.jv.DesafioItau.dto.EstatiscasDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;

@Tag(
        name = "Estatística",
        description = "EndPoints responsáveis por realizar as operações com as transações."
)
public interface EstatiscaControllerDoc {

    @Operation(
            summary = "Calcula todas as operações",
            description = "Todas as operações são calculadas (somente transações dos últimos 60 segundos), sendo as operações média, mínimo e máximo, contabliza todas as transações, etc."
    )
    @ApiResponse(
            responseCode = "200",
            description = "Retorna os dados das transações já calculados."
    )
    @ApiResponse(
            responseCode = "400",
            description = "Erro ao calcular estatísticas."
    )
    public ResponseEntity<EstatiscasDTO> calcularOperacoes();

}
