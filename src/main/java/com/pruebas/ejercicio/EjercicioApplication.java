package com.pruebas.ejercicio;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class EjercicioApplication  {

	private static final Logger LOGGER = LogManager.getLogger(EjercicioApplication.class);

	public static void main(String[] args)
	{
		SpringApplication.run(EjercicioApplication.class, args);

	}
}