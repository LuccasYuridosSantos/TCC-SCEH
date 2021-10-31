package br.com.tcc.sceh.controller;

import br.com.tcc.sceh.model.Cargo;
import br.com.tcc.sceh.repository.CargoRepository;
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
@RequestMapping("/cargo")
public class CargoController {

    private CargoRepository cargoRepository;

    @Autowired
    public CargoController(CargoRepository cargoRepository) {
        this.cargoRepository = cargoRepository;
    }

    @GetMapping()
    public ResponseEntity<List<Cargo>> buscarCargos() {
        return ResponseEntity.ok().body(cargoRepository.findAll());
    }

    @GetMapping("/{codigoCargo}")
    public ResponseEntity<Cargo> buscarCargoPorCodigoCargo(@PathVariable final Long codigoCargo) {
        return cargoRepository.findById(codigoCargo)
                .map(resp -> ResponseEntity.ok(resp))
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/nomeCargo/{nomeCargo}")
    public ResponseEntity<List<Cargo>> buscarCargoPorNomeCargo(@PathVariable final String nomeCargo) {
        return ResponseEntity.ok(cargoRepository.findByNomeCargoContainingIgnoreCase(nomeCargo));
    }

    @PostMapping("/cadastrar")
    public ResponseEntity<Cargo> cadastrarCargo(@RequestBody final Cargo cargo) {
        return ResponseEntity.status(HttpStatus.CREATED).body(cargoRepository.save(cargo));
    }

    @PutMapping("/atualizar")
    public ResponseEntity<Cargo> atualizarCargo(@RequestBody final Cargo cargo) {
        return ResponseEntity.status(HttpStatus.OK).body(cargoRepository.save(cargo));
    }

    @DeleteMapping("/deletar/{codigoCargo}")
    public ResponseEntity<Void> deletarCargo(@RequestBody final Long codigoCargo) {
        cargoRepository.deleteById(codigoCargo);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
