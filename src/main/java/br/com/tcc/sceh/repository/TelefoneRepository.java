package br.com.tcc.sceh.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.tcc.sceh.model.entity.Telefone;

@Repository
public interface TelefoneRepository extends JpaRepository<Telefone, Long>{
	Telefone findByDddAndNumero(final String ddd, final String numero);
}
