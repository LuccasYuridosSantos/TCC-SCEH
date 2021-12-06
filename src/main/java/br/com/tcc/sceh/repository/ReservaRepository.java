package br.com.tcc.sceh.repository;

import br.com.tcc.sceh.model.entity.RecursoHospitalar;
import br.com.tcc.sceh.model.entity.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ReservaRepository extends JpaRepository<Reserva, Long>{

    List<Reserva> findAllByDataEntregaNull();
    List<Reserva> findByDataReservaLike(final LocalDate dataReserva);
    List<Reserva> findByDataRetiradaLike(final LocalDate dataReserva);
    List<Reserva> findByDataEntregaIsNullAndRecursoHospitalarEquals(final RecursoHospitalar recurso);
    List<Reserva> findAllByDataEntregaIsNullAndHospitalCnpjContainingIgnoreCase(final String cnpj);
}
