package br.com.tcc.sceh.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.tcc.sceh.model.entity.Funcionario;

import java.util.List;
import java.util.Optional;

@Repository
public interface FuncionarioRepository extends JpaRepository<Funcionario, Long>{
    List<Funcionario> findByNomeContainingIgnoreCase(final String nomeFuncionario);
    Optional<Funcionario> findByUsername(final String username);
}
