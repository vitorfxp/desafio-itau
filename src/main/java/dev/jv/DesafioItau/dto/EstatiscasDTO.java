package dev.jv.DesafioItau.dto;


import lombok.Getter;

@Getter
public class EstatiscasDTO {
    private final Long count;
    private final double avg;
    private final double max;
    private final double min;
    private final double sum;

    public EstatiscasDTO(Long count, double avg, double max, double min, double sum) {
        this.count = count;
        this.avg = avg;
        this.max = max;
        this.min = min;
        this.sum = sum;
    }
}
