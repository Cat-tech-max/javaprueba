package com.pruebas.ejercicio.service;

import com.pruebas.ejercicio.dto.SearchDTO;
import com.pruebas.ejercicio.model.Prices;
import com.pruebas.ejercicio.repository.PricesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.sql.Timestamp;
import java.util.List;

@Service
public class PricesServiceImpl implements PricesService {
    //private static final Logger LOGGER = LogManager.getLogger(PricesServiceImpl.class);
    @Autowired
    private PricesRepository repo;

    @Override
    public List<Prices> obtenerPrecios(SearchDTO entrada) {
        List<Prices> data = null;
        if (entrada != null) {
            data = repo.findByBrandAndProductAndFecha(entrada.getId(), entrada.getProduct(), Timestamp.valueOf(entrada.getFecha()));
        }
        return data;
    }
}