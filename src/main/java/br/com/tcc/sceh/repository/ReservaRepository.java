package br.com.tcc.sceh.repository;

import br.com.tcc.sceh.model.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ReservaRepository extends JpaRepository<Reserva, Long>{

    List<Reserva> findByDataReservaLike(final LocalDate dataReserva);
    List<Reserva> findByDataRetiradaLike(final LocalDate dataReserva);
}
