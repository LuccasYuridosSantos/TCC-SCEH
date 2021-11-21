package br.com.tcc.sceh.controller;

import br.com.tcc.sceh.model.entity.RecursoHospitalar;
import br.com.tcc.sceh.model.requests.RecursoRequest;
import br.com.tcc.sceh.repository.RecursoHospitalarRepository;
import br.com.tcc.sceh.service.RecursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
@RequestMapping("/recurso")
public class RecursoController {

    private RecursoHospitalarRepository recursoRepository;
    private RecursoService recursoService;

    @Autowired
    public RecursoController(final RecursoHospitalarRepository recursoRepository, final RecursoService recursoService) {
        this.recursoRepository = recursoRepository;
        this.recursoService = recursoService;
    }

    @GetMapping
    public ResponseEntity<List<RecursoHospitalar>> buscarTodosRecursosAtivos(){
        return ResponseEntity.ok(recursoRepository.findAllByAtivoTrueAndSolicitacaoFalse());
    }

    @GetMapping("/{codigoRecurso}")
    public ResponseEntity<RecursoHospitalar> buscarPorCodigoRecurso(@PathVariable final Long codigoRecurso){
        return recursoRepository.findById(codigoRecurso)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/nome/{nomeRecurso}")
    public ResponseEntity<List<RecursoHospitalar>> buscarPorCodigoRecurso(@PathVariable final String nomeRecurso){
        return ResponseEntity.ok(recursoRepository.findByNomeContainingIgnoreCase(nomeRecurso));
    }

    @PostMapping("/cadastrar")
    public ResponseEntity<RecursoHospitalar> cadastrarRecursoHospitalar(@RequestBody final RecursoRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(recursoService.upsert(recursoService.converteRecursoRequest(request)));
    }

    @PutMapping("/atualizar")
    public ResponseEntity<RecursoHospitalar> atualizarRecursoHospitalar(@RequestBody final RecursoRequest request) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(recursoService.upsert(recursoService.converteRecursoRequest(request)));
    }

    @DeleteMapping("/deletar/{codigoRecurso}")
    public ResponseEntity<Void> deletarRecurso(@PathVariable final Long codigoRecurso){
        recursoRepository.deleteById(codigoRecurso);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
