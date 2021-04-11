package com.example.vacinazup.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.vacinazup.models.Vacina;

public interface VacinaRepository extends CrudRepository <Vacina,String>{
	Vacina findByCodigo(long codigo);

}
