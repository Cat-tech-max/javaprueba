package com.pruebas.ejercicio.dto;

import lombok.Data;
import java.math.BigDecimal;
import java.sql.Timestamp;

@Data
public class PricesDTO {
    private Long id;
    private Long brandId;
    private Timestamp startDate;
    private Timestamp endDate;
    private String priceList;
    private String productId;
    private Integer priority;
    private BigDecimal price;
    private String curr;
}

