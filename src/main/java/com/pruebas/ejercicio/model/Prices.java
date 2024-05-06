package com.pruebas.ejercicio.model;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.sql.Timestamp;

@Data
@Entity
//@NamedQuery(name="Prices.findByBrandAndProductAndFecha",
//query="Select e from Prices e" +
//        " where e.brandId = :brand and e.productId = :product" +
//        " and :fecha between e.startDate and e.endDate")
@Table(name = "PRICES")
public class Prices{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @Column(name = "BRAND_ID", nullable = false)
    private Long brandId;
    @Column(name="START_DATE", nullable=false, unique=false)
    private Timestamp startDate;
    @Column(name="END_DATE", nullable=false, unique=false)
    private Timestamp endDate;
    @Column(name="PRICE_LIST", nullable=false, unique=false)
    private String priceList;
    @Column(name="PRODUCT_ID", nullable=false, unique=false)
    private String productId;
    @Column(name="PRIORITY", nullable=false, unique=false)
    private Integer priority;
    @Column(name="PRICE", nullable=false, unique=false)
    private BigDecimal price;
    @Column(name="CURR", nullable=false, unique=false)
    private String curr;

}
