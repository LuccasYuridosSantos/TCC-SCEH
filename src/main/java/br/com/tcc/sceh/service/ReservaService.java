package br.com.tcc.sceh.service;

import br.com.tcc.sceh.model.RecursoHospitalar;
import br.com.tcc.sceh.model.Reserva;
import br.com.tcc.sceh.repository.RecursoHospitalarRepository;
import br.com.tcc.sceh.repository.ReservaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.stream.Collectors;

@Service public class ReservaService {

	private ReservaRepository reservaRepository;
	private RecursoHospitalarRepository recursoRepository;

    @Autowired
    public ReservaService(final ReservaRepository reservaRepository, final RecursoHospitalarRepository recursoRepository) {
        this.reservaRepository = reservaRepository;
        this.recursoRepository = recursoRepository;
    }

	public Reserva salvarReserva(final Reserva reservaRequest) {
		final Reserva reserva = new Reserva();
		if (reservaRequest.getCodigoReserva() != null) {
			reserva.setCodigoReserva(reserva.getCodigoReserva());
		}
		reserva.setQuantidade(reservaRequest.getQuantidade());
		reserva.setDataReserva(reservaRequest.getDataReserva());
		reserva.setDataRetirada(reservaRequest.getDataRetirada());
		reserva.setSolicitante(reservaRequest.getSolicitante());
		reserva.setEntregador(reservaRequest.getEntregador());
		reserva.setRecursoHospitalars(new ArrayList<>());
		if (!CollectionUtils.isEmpty(reservaRequest.getRecursoHospitalars())) {
			reserva.getRecursoHospitalars().addAll(reservaRequest.getRecursoHospitalars().stream().map(r -> {
				RecursoHospitalar recurso = recursoRepository.findById(r.getCodigoRecurso()).orElse(null);
				if (recurso != null) {
					recurso.getReservas().add(reserva);
				}
				return recurso;
			}).collect(Collectors.toList()));
		}

		return reservaRepository.save(reserva);
	}
}
