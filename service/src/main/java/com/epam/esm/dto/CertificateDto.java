package com.epam.esm.dto;

import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Data
public class CertificateDto {

    private Long id;
    @NotBlank
    private String name;
    @NotBlank
    private String description;
    @DecimalMin(value = "0.0")
    private BigDecimal price;
    @Positive
    private Integer duration;
    private LocalDateTime create;
    private LocalDateTime update;
    private List<@Valid TagDto> tags;

}

