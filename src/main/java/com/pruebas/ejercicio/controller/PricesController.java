package com.pruebas.ejercicio.controller;

import com.pruebas.ejercicio.dto.SearchDTO;
import com.pruebas.ejercicio.service.PricesService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/prices")
public class PricesController {
    private static final Logger LOGGER = LogManager.getLogger(PricesController.class);
    @Autowired
    private PricesService servicio;

    @GetMapping("/getInfo")
    public ResponseEntity<List> obtenerInfo(@RequestParam String id, @RequestParam String product,  @RequestParam String fecha) {
        SearchDTO entrada = new SearchDTO();
        entrada.setId(id);
        entrada.setProduct(product);
        entrada.setFecha(fecha);
        List entidadPrecios = servicio.obtenerPrecios(entrada);


        if (entidadPrecios != null) {

            return ResponseEntity.ok(entidadPrecios);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}

