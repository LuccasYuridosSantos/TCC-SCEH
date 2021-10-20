package br.com.tcc.sceh.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.tcc.sceh.model.RecursoHospitalar;

@Repository
public interface RecursoHospitalarRepository extends JpaRepository<RecursoHospitalar, String>{
	
}
