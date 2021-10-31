package br.com.tcc.sceh.controller;

import br.com.tcc.sceh.model.Reserva;
import br.com.tcc.sceh.model.SolicitacaoRecurso;
import br.com.tcc.sceh.repository.ReservaRepository;
import br.com.tcc.sceh.repository.SolicitacaoRecursoRepository;
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

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/solicitacao")
public class SolicitacaoController {

    private SolicitacaoRecursoRepository solicitacaoRepository;

    @Autowired
    public SolicitacaoController(final SolicitacaoRecursoRepository solicitacaoRepository) {
        this.solicitacaoRepository = solicitacaoRepository;
    }

    @GetMapping
    public ResponseEntity<List<SolicitacaoRecurso>> buscarReservas(){
        return ResponseEntity.ok(solicitacaoRepository.findAll());
    }

    @GetMapping("/{codigoSolicitacao}")
    public ResponseEntity<SolicitacaoRecurso> buscarPorCodigoReserva(@PathVariable final Long codigoSolicitacao){
        return solicitacaoRepository.findById(codigoSolicitacao)
                .map(resp -> ResponseEntity.ok(resp))
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/dataProgramada/{dataProgramada}")
    public ResponseEntity<List<SolicitacaoRecurso>> buscarPorDataReserva(@PathVariable final LocalDate dataProgramada){
        return ResponseEntity.ok(solicitacaoRepository.findByDataProgramadaEquals(dataProgramada));
    }

    @GetMapping("/dataRetirada/{dataRetirada}")
    public ResponseEntity<List<SolicitacaoRecurso>> buscarPorDataRetirada(@PathVariable final boolean urgencia){
        return ResponseEntity.ok(solicitacaoRepository.findByUrgenteEquals(urgencia));
    }

    @PostMapping("/cadastrar")
    public ResponseEntity<SolicitacaoRecurso> cadastrarSolicitacao(@RequestBody final SolicitacaoRecurso solicitacao) {
        return ResponseEntity.status(HttpStatus.CREATED).body(solicitacaoRepository.save(solicitacao));
    }

    @PutMapping("/atualizar")
    public ResponseEntity<SolicitacaoRecurso> atualizarSolicitacao(@RequestBody final SolicitacaoRecurso solicitacao) {
        return ResponseEntity.status(HttpStatus.CREATED).body(solicitacaoRepository.save(solicitacao));
    }

    @DeleteMapping("/deletar/{codigoSolicitacao}")
    public ResponseEntity<Void> deletarRecurso(@PathVariable final Long codigoSolicitacao){
        solicitacaoRepository.deleteById(codigoSolicitacao);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
