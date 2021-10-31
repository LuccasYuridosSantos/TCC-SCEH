package br.com.tcc.sceh.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.tcc.sceh.model.SolicitacaoRecurso;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface SolicitacaoRecursoRepository extends JpaRepository<SolicitacaoRecurso, Long>{

    List<SolicitacaoRecurso> findByDataProgramadaEquals(final LocalDate dataProgramada);

    List<SolicitacaoRecurso> findByUrgenteEquals(final Boolean dataProgramada);
}
