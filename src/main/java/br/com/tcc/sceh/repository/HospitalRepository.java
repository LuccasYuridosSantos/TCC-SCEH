package br.com.tcc.sceh.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.tcc.sceh.model.Hospital;

@Repository
public interface HospitalRepository extends JpaRepository<Hospital, String>{
	
	public Optional<List<Hospital>> findByNomeFantasia(String nomeHospital);
	
}
