package br.com.tcc.sceh.controller;

import br.com.tcc.sceh.model.RecursoHospitalar;
import br.com.tcc.sceh.model.Reserva;
import br.com.tcc.sceh.repository.RecursoHospitalarRepository;
import br.com.tcc.sceh.repository.ReservaRepository;
import br.com.tcc.sceh.service.ReservaService;
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
@RequestMapping("/reserva")
public class ReservaController {

    private ReservaRepository reservaRepository;
    private ReservaService reservaService;

    @Autowired
    public ReservaController(ReservaRepository reservaRepository, ReservaService reservaService) {
        this.reservaRepository = reservaRepository;
        this.reservaService = reservaService;
    }

    @GetMapping
    public ResponseEntity<List<Reserva>> buscarReservas(){
        return ResponseEntity.ok(reservaRepository.findAllByDataEntregaNull());
    }

    @GetMapping("/{codigoReserva}")
    public ResponseEntity<Reserva> buscarPorCodigoReserva(@PathVariable final Long codigoReserva){
        return reservaRepository.findById(codigoReserva)
                .map(resp -> ResponseEntity.ok(resp))
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/dataReserva/{dataReserva}")
    public ResponseEntity<List<Reserva>> buscarPorDataReserva(@PathVariable final LocalDate dataReserva){
        return ResponseEntity.ok(reservaRepository.findByDataReservaLike(dataReserva));
    }

    @GetMapping("/dataRetirada/{dataRetirada}")
    public ResponseEntity<List<Reserva>> buscarPorDataRetirada(@PathVariable final LocalDate dataRetirada){
        return ResponseEntity.ok(reservaRepository.findByDataRetiradaLike(dataRetirada));
    }

    @PostMapping("/cadastrar")
    public ResponseEntity<Reserva> cadastrarReserva(@RequestBody final Reserva reserva) {
        var resp = reservaService.cadastrarReserva(reserva);
        return ResponseEntity.status(HttpStatus.CREATED).body(resp);
    }

    @PutMapping("/atualizar")
    public ResponseEntity<Reserva> atualizarReserva(@RequestBody final Reserva reserva) {
        var responseReserva = reservaService.atualizarReservaEntregue(reserva);
        return ResponseEntity.status(HttpStatus.CREATED).body(responseReserva);
    }

    @DeleteMapping("/deletar/{codigoReserva}")
    public ResponseEntity<Void> deletarRecurso(@PathVariable final Long codigoReserva){
        reservaRepository.deleteById(codigoReserva);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
