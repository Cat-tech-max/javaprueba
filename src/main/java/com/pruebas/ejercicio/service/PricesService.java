package com.pruebas.ejercicio.service;

import com.pruebas.ejercicio.dto.SearchDTO;
import com.pruebas.ejercicio.model.Prices;
import java.util.List;


public interface PricesService {
    List<Prices> obtenerPrecios(SearchDTO entrada);
}
