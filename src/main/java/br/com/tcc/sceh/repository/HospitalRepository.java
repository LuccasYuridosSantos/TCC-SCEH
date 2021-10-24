package br.com.tcc.sceh.repository;

import br.com.tcc.sceh.model.Hospital;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface HospitalRepository extends JpaRepository<Hospital, Long>{

	Optional<Hospital> findByCodigoHospital(Long aLong);

	List<Hospital> findByNomeFantasiaContainingIgnoreCase(String nomeHospital);
	
}
