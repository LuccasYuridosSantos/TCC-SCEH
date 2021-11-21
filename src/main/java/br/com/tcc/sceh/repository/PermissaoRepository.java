package br.com.tcc.sceh.repository;

import br.com.tcc.sceh.model.entity.Permissao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PermissaoRepository extends JpaRepository<Permissao, Long>{
    List<Permissao> findByNomeIgnoreCase(String nomePermissao);
}
