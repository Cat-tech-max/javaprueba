package com.pruebas.ejercicio.dto;

import lombok.Data;

import java.math.BigDecimal;
import java.sql.Timestamp;


@Data
public class SearchDTO {

    private String id;
    private String product;
    private String fecha;
}

