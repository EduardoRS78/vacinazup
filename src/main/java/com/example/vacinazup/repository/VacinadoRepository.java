package com.example.vacinazup.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.vacinazup.models.Vacina;
import com.example.vacinazup.models.Vacinado;

public interface VacinadoRepository extends CrudRepository<Vacinado, String> {
			
	Iterable<Vacinado> findByVacina(Vacina vacina);
	Vacinado findByCod(Long cod);
}
