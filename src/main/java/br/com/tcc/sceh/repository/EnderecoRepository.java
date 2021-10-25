package br.com.tcc.sceh.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.tcc.sceh.model.Endereco;

import java.util.List;

@Repository
public interface EnderecoRepository extends JpaRepository<Endereco, Long>{

	List<Endereco> findByCepContainingIgnoreCase(final String cep);
	
}
