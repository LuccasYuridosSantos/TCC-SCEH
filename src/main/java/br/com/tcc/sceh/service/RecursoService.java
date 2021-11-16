package br.com.tcc.sceh.service;

import br.com.tcc.sceh.model.RecursoHospitalar;
import br.com.tcc.sceh.model.requests.RecursoRequest;
import br.com.tcc.sceh.model.requests.SolicitacaoRequest;
import br.com.tcc.sceh.repository.FuncionarioRepository;
import br.com.tcc.sceh.repository.HospitalRepository;
import br.com.tcc.sceh.repository.RecursoHospitalarRepository;
import br.com.tcc.sceh.utils.ScehUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RecursoService {

	private RecursoHospitalarRepository repository;
	private HospitalRepository hospitalRepository;
	private FuncionarioRepository funcionarioRepository;

	@Autowired
	public RecursoService(final RecursoHospitalarRepository repository, final HospitalRepository hospitalRepository,
			final FuncionarioRepository funcionarioRepository) {
		this.repository = repository;
		this.hospitalRepository = hospitalRepository;
		this.funcionarioRepository = funcionarioRepository;
	}

	public RecursoHospitalar upsert(RecursoHospitalar recursoHospitalar){
		return  repository.save(recursoHospitalar);
	}

	public RecursoHospitalar converterSolicitacaoRequest(SolicitacaoRequest solicitacaoRequest){
		if(solicitacaoRequest == null){
			ScehUtils.lancarException("Requisição invalida");
		}
		final RecursoHospitalar recurso = new RecursoHospitalar();
		if(solicitacaoRequest.getCodigoRecurso() != null){
			recurso.setCodigoRecurso(solicitacaoRequest.getCodigoRecurso());
		}
		recurso.setQuantidade(solicitacaoRequest.getQuantidade());
		recurso.setNome(solicitacaoRequest.getNome());
		recurso.setMarca(solicitacaoRequest.getMarca());
		recurso.setFabricante(solicitacaoRequest.getFabricante());
		recurso.setDescricao(solicitacaoRequest.getDescricao());
		recurso.setUrgencia(solicitacaoRequest.getUrgencia());
		recurso.setAtivo(false);
		recurso.setSolicitacao(true);

		hospitalRepository.findById(solicitacaoRequest.getCodigoHospital())
				.ifPresent(recurso::setHospital);
		funcionarioRepository.findById(solicitacaoRequest.getCodigoFuncionario())
				.ifPresent(recurso::setFuncionario);

		return recurso;
	}

	public RecursoHospitalar converteRecursoRequest(RecursoRequest request){
		if(request == null){
			ScehUtils.lancarException("Requisição invalida");
		}
		final RecursoHospitalar recurso = new RecursoHospitalar();
		if(request.getCodigoRecurso() != null){
			recurso.setCodigoRecurso(request.getCodigoRecurso());
		}
		recurso.setQuantidade(request.getQuantidade());
		recurso.setNome(request.getNome());
		recurso.setMarca(request.getMarca());
		recurso.setFabricante(request.getFabricante());
		recurso.setDescricao(request.getDescricao());
		recurso.setDataFabricacao(request.getDataFabricacao());
		recurso.setDataValidade(request.getDataValidade());
		recurso.setLote(request.getLote());
		recurso.setAtivo(true);
		recurso.setSolicitacao(false);

		hospitalRepository.findById(request.getCodigoHospital())
				.ifPresent(recurso::setHospital);
		funcionarioRepository.findById(request.getCodigoFuncionario())
				.ifPresent(recurso::setFuncionario);

		return recurso;
	}

}
