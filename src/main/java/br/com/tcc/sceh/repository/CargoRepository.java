package br.com.tcc.sceh.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.tcc.sceh.model.Cargo;

import java.util.List;

@Repository
public interface CargoRepository extends JpaRepository<Cargo, Long>{
	List<Cargo> findByNomeCargoContainingIgnoreCase(final String nomeCargo);
}
