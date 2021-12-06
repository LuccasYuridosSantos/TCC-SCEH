package br.com.tcc.sceh.repository;

import br.com.tcc.sceh.model.entity.RecursoHospitalar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RecursoHospitalarRepository extends JpaRepository<RecursoHospitalar, Long>{

    List<RecursoHospitalar> findByNomeContainingIgnoreCase(final String nomeRecurso);
    List<RecursoHospitalar> findAllByAtivoTrueAndSolicitacaoFalse();
    List<RecursoHospitalar> findAllByAtivoTrueAndSolicitacaoFalseAndAndHospitalCnpjNotContainingIgnoreCase(final String cnpj);
    List<RecursoHospitalar> findAllBySolicitacaoIsTrue();
    List<RecursoHospitalar> findAllByAtivoTrueAndSolicitacaoFalseAndHospitalCnpjContainingIgnoreCase(final String cnpj);
    List<RecursoHospitalar> findAllBySolicitacaoIsTrueAndHospitalCnpjContainingIgnoreCase(final String cnpj);
    List<RecursoHospitalar> findAllBySolicitacaoIsTrueAndNomeContainingIgnoreCase(final String nomeRecurso);
	
}
