package br.com.tcc.sceh.repository;

import br.com.tcc.sceh.model.RecursoHospitalar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RecursoHospitalarRepository extends JpaRepository<RecursoHospitalar, Long>{

    List<RecursoHospitalar> findByNomeContainingIgnoreCase(String nomeRecurso);
    List<RecursoHospitalar> findAllByAtivoTrueAndSolicitacaoFalse();
    List<RecursoHospitalar> findAllBySolicitacaoIsTrue();
	
}
