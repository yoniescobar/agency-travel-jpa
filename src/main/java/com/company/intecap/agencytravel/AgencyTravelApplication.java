package com.company.intecap.agencytravel;

import com.company.intecap.agencytravel.domain.repositories.FlyRepository;
import com.company.intecap.agencytravel.domain.repositories.HotelRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Slf4j // log es una variable de tipo Logger, que se usa para imprimir mensajes en la consola
public class AgencyTravelApplication implements CommandLineRunner {

	@Autowired // spring a partir de la version 5, recomienda realizar la inyeccion de dependencias por medio de constructores
	private HotelRepository hotelRepository;

	@Autowired
	private FlyRepository flyRepository;

	public static void main(String[] args) {
		SpringApplication.run(AgencyTravelApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
	/*
		var fly = flyRepository.findById(10L).get(); // se obtiene el vuelo con id 10
		var hotel = hotelRepository.findById(1L).get(); // se obtiene el hotel con id 1

		log.info("fly: {}", fly); // se imprime el vuelo en la consola
		log.info("hotel: {}", hotel); // se imprime el hotel en la consola
	*/
	}
}
