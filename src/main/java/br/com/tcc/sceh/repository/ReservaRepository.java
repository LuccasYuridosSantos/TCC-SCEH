package br.com.tcc.sceh.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.tcc.sceh.model.Reserva;

@Repository
public interface ReservaRepository extends JpaRepository<Reserva, Long>{

}
