package br.com.tcc.sceh.controller;

import br.com.tcc.sceh.model.entity.RecursoHospitalar;
import br.com.tcc.sceh.model.requests.SolicitacaoRequest;
import br.com.tcc.sceh.repository.RecursoHospitalarRepository;
import br.com.tcc.sceh.service.RecursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/solicitacao")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class SolicitacaoController {

	private RecursoHospitalarRepository repository;
	private RecursoService recursoService;

	@Autowired
	public SolicitacaoController(final RecursoHospitalarRepository repository, final RecursoService recursoService) {
		this.repository = repository;
		this.recursoService = recursoService;
	}

	@GetMapping
	public ResponseEntity<List<RecursoHospitalar>> buscarTodasSolicitacoes(){
		return ResponseEntity.ok(repository.findAllBySolicitacaoIsTrue());
	}

	@GetMapping("/nome/{nome}")
	public ResponseEntity<List<RecursoHospitalar>> buscarTodasSolicitacoesPorNome(@PathVariable String nome){
		return ResponseEntity.ok(repository.findAllBySolicitacaoIsTrueAndNomeContainingIgnoreCase(nome));
	}

	@GetMapping("/hospital/{cnpj}")
	public ResponseEntity<List<RecursoHospitalar>> buscarTodasSolicitacoesPorCnpjHospital(@PathVariable String cnpj){
		return ResponseEntity.ok(repository
				.findAllBySolicitacaoIsTrueAndHospitalCnpjContainingIgnoreCase(cnpj));
	}

	@GetMapping("/id/{codigoRecurso}")
	public ResponseEntity<RecursoHospitalar> buscarPorCodigoSolicitacao(@PathVariable final Long codigoRecurso){
		return repository.findById(codigoRecurso)
				.map(ResponseEntity::ok)
				.orElse(ResponseEntity.notFound().build());
	}

	@PostMapping("/cadastrar")
	public ResponseEntity<RecursoHospitalar> cadastrarSolicitacao(@RequestBody SolicitacaoRequest request){

		var recurso = recursoService.converterSolicitacaoRequest(request);
		var response = recursoService.upsert(recurso);

		return ResponseEntity.status(HttpStatus.CREATED).body(response);
	}

	@PutMapping("/atualizar")
	public ResponseEntity<RecursoHospitalar> atualizarSolicitacao(@RequestBody SolicitacaoRequest request){

		var response = recursoService.upsert(recursoService.converterSolicitacaoRequest(request));

		return ResponseEntity.status(HttpStatus.CREATED).body(response);
	}

	@DeleteMapping("/deletar/{codigoRequisicao}")
	public ResponseEntity<Void> deletarRequisi????o(@PathVariable final Long codigoRequisicao){
		recursoService.deletarRrecurso(codigoRequisicao);
		return ResponseEntity.noContent().build();
	}

}
