package br.com.tcc.sceh.service;

import br.com.tcc.sceh.model.entity.Reserva;
import br.com.tcc.sceh.repository.RecursoHospitalarRepository;
import br.com.tcc.sceh.repository.ReservaRepository;
import br.com.tcc.sceh.utils.ScehUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ReservaService {

	private RecursoHospitalarRepository recursoRepository;
	private ReservaRepository reservaRepository;

	@Autowired
	public ReservaService(final RecursoHospitalarRepository recursoRepository, final ReservaRepository reservaRepository) {
		this.recursoRepository = recursoRepository;
		this.reservaRepository = reservaRepository;
	}

	public Reserva cadastrarReserva(Reserva reserva){
		//para reserva um recurso preciso avaliar se o recurso tem quantidade suficiente para ser reservado;
		verificarRecurso(reserva);
		List<Reserva> reservasjaRealizadas =
				reservaRepository.findByDataEntregaIsNullAndRecursoHospitalarEquals(reserva.getRecursoHospitalar());
		long soma = 0L;
		for (Reserva re: reservasjaRealizadas){
			soma += re.getQuantidade();
		}

		if((soma + reserva.getQuantidade()) > reserva.getRecursoHospitalar().getQuantidade()){
			ScehUtils.lancarException("Não Foi possivel cadastrar a reserva, a quantidade do recurso é inferior ao "
					+ "solicitado");
		}

		return reservaRepository.save(reserva);
	}

	public Reserva atualizarReservaEntregue(Reserva reserva){
		// Com a reserva entregue precisamos abater a quantidade dos recursos diponiveis
		verificarRecurso(reserva);
		if(reserva.getRecursoHospitalar() == null || reserva.getDataEntrega() == null){
			ScehUtils.lancarException("Não foi possivel atualizar a reserva, por favor verifique os dados informado");
		}
		var recurso = reserva.getRecursoHospitalar();

		if((recurso.getQuantidade() - reserva.getQuantidade()) < 0){
			ScehUtils.lancarException("Não foi possivel atualizar a reserva");
		}
		recurso.setQuantidade(recurso.getQuantidade() - reserva.getQuantidade());

		if(recurso.getQuantidade() == 0){
			recurso.setAtivo(false);
		}
		reserva.setRecursoHospitalar(recursoRepository.save(recurso));
		return reservaRepository.save(reserva);
	}

	private void verificarRecurso(final Reserva reserva) {
		if(reserva != null && reserva.getRecursoHospitalar() != null){
			recursoRepository.findById(reserva.getRecursoHospitalar().getCodigoRecurso()).ifPresent(reserva::setRecursoHospitalar);
		}
	}

	public List<Reserva> buscarReservasPorRecurso(final Long codigoRecurso) {
		var recurso = recursoRepository.findById(codigoRecurso);
		if(recurso.isPresent()){
			List<Reserva> reservasjaRealizadas = new ArrayList<>();
			reservasjaRealizadas = reservaRepository.findByDataEntregaIsNullAndRecursoHospitalarEquals(recurso.get());
			return reservasjaRealizadas;
		}

		return List.of();
	}
}
