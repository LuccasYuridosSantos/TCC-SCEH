package br.com.tcc.sceh.controller;

import br.com.tcc.sceh.model.entity.Telefone;
import br.com.tcc.sceh.repository.TelefoneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/telefone")
public class TelefoneController {

    private TelefoneRepository telefoneRepository;

    @Autowired
    public TelefoneController(TelefoneRepository telefoneRepository) {
        this.telefoneRepository = telefoneRepository;
    }

    @GetMapping
    public ResponseEntity<List<Telefone>> buscarHospitais(){
        return ResponseEntity.ok(telefoneRepository.findAll());
    }

    @GetMapping("/{codigoTelefone}")
    public ResponseEntity<Telefone> buscarHospitalPorId(@PathVariable final Long codigoTelefone){
        return telefoneRepository.findById(codigoTelefone)
                .map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/cadastrar")
    public ResponseEntity<Telefone> cadastrarHospital(@RequestBody final Telefone hospitalRequest){
        return ResponseEntity.status(HttpStatus.CREATED).body(telefoneRepository.save(hospitalRequest));
    }

    @PutMapping("/atualizar")
    public ResponseEntity<Telefone> atualizarTelefone(@RequestBody final Telefone hospitalRequest){
        return ResponseEntity.status(HttpStatus.OK).body(telefoneRepository.save(hospitalRequest));
    }
    
}
