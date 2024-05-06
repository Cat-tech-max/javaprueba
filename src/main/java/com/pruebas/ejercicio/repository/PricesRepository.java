package com.pruebas.ejercicio.repository;

import com.pruebas.ejercicio.model.Prices;

import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.List;


@Repository
@Primary
public interface PricesRepository extends JpaRepository<Prices, Long> {
    @Query("select p from Prices p" +
            " where p.brandId = :brand and p.productId = :product" +
            " and :fecha between p.startDate and p.endDate")
    public List<Prices> findByBrandAndProductAndFecha(@Param("brand") String brand,
                                                      @Param("product") String product,
                                                      @Param("fecha") Timestamp fecha);
}
