package dev.jv.DesafioItau.configuration;


import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.validation.annotation.Validated;

@Validated
@ConfigurationProperties(prefix = "estatistica")
public record EstatisticaProperties(
        @NotNull(message = "Segundos dentro de aplication.yml não pode ser nula")
        @Positive(message = "estatistica.segundos deve ser no mínimo 1 segundo")
        Integer segundos) {
}
