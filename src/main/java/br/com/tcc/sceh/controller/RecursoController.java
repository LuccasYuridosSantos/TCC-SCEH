package br.com.tcc.sceh.controller;

import br.com.tcc.sceh.model.RecursoHospitalar;
import br.com.tcc.sceh.repository.RecursoHospitalarRepository;
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

    @Autowired
    public RecursoController(RecursoHospitalarRepository recursoRepository) {
        this.recursoRepository = recursoRepository;
    }

    @GetMapping
    public ResponseEntity<List<RecursoHospitalar>> buscarTodosRecursos(){
        return ResponseEntity.ok(recursoRepository.findAll());
    }

    @GetMapping("/{codigoRecurso}")
    public ResponseEntity<RecursoHospitalar> buscarPorCodigoRecurso(@PathVariable final Long codigoRecurso){
        return recursoRepository.findById(codigoRecurso)
                .map(resp -> ResponseEntity.ok(resp))
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/nome/{nome}")
    public ResponseEntity<List<RecursoHospitalar>> buscarPorCodigoRecurso(@PathVariable final String nomeRecurso){
        return ResponseEntity.ok(recursoRepository.findByNomeContainingIgnoreCase(nomeRecurso));
    }

    @PostMapping("/cadastrar")
    public ResponseEntity<RecursoHospitalar> cadastrarRecursoHospitalar(@RequestBody final RecursoHospitalar recurso) {
        return ResponseEntity.status(HttpStatus.CREATED).body(recursoRepository.save(recurso));
    }

    @PutMapping("/atualizar")
    public ResponseEntity<RecursoHospitalar> atualizarRecursoHospitalar(@RequestBody final RecursoHospitalar recurso) {
        return ResponseEntity.status(HttpStatus.OK).body(recursoRepository.save(recurso));
    }

    @DeleteMapping("/deletar/{codigoRecurso}")
    public ResponseEntity<Void> deletarRecurso(@PathVariable final Long codigoRecurso){
        recursoRepository.deleteById(codigoRecurso);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
