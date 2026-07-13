package dev.jv.DesafioItau.docs;

import dev.jv.DesafioItau.dto.TransacaoDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

@Tag(
        name = "Transações",
        description = "EndPoints responsáveis por criar e adicionar as transações em uma lista, com validações e logs."
)
public interface TransacaoControllerDoc {

    @Operation(
            summary = "Cria novas transações.",
            description = "Recebe uma transação válida e adiciona no repository criado em memória."
    )
    @ApiResponse(
            responseCode = "201",
            description = "A transação foi criada com sucesso."
    )
    @ApiResponse(
            responseCode = "422",
            description = "Erro de validação no JSON recebido."
    )
    @ApiResponse(
            responseCode = "400",
            description = "JSON inválido."
    )
    ResponseEntity<String> adicionarTransacao(@RequestBody TransacaoDTO data);



    @Operation(
            summary = "Deleta as transações.",
            description = "Deleta todas as transações em memória."
    )
    @ApiResponse(
            responseCode = "200",
            description = "As transações foram deletadas com sucesso."
    )
    public ResponseEntity<?> deletarTransacoes();
}
