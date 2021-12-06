package br.com.tcc.sceh.controller;

import br.com.tcc.sceh.model.entity.Hospital;
import br.com.tcc.sceh.model.requests.HospitalRequest;
import br.com.tcc.sceh.repository.HospitalRepository;
import br.com.tcc.sceh.service.HospitalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/hospital")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class HospitalController {
    private HospitalService hospitalService;
    private HospitalRepository hospitalRepository;

    @Autowired
    public HospitalController(HospitalService hospitalService, HospitalRepository hospitalRepository) {
        this.hospitalService = hospitalService;
        this.hospitalRepository = hospitalRepository;
    }


    @GetMapping
    public List<Hospital> buscarHospitais(){
        return hospitalRepository.findAll();
    }

    @GetMapping("/{codigoHospital}")
    public ResponseEntity<Hospital> buscarHospitalPorId(@PathVariable final Long codigoHospital){
        return hospitalRepository.findById(codigoHospital)
                .map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/cnpj/{cnpj}")
    public ResponseEntity<Hospital> buscarHospitalPorCnpj(@PathVariable final String cnpj){
        return hospitalRepository.findByCnpj(cnpj)
                .map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/nomeFantasia/{nomeFantasia}")
    public ResponseEntity<List<Hospital>> buscarHospitalPeloNomeFantasia(@PathVariable final String nomeFantasia) {
        return ResponseEntity.ok(hospitalRepository.findByNomeFantasiaContainingIgnoreCase(nomeFantasia));
    }

    @PostMapping("/cadastrar")
    public ResponseEntity<Hospital> cadastrarHospital(@RequestBody final HospitalRequest request){
        var hospital = hospitalService.preCadastroHospital(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(hospitalRepository.save(hospital));
    }

    @PutMapping("/atualizar")
    public ResponseEntity<Hospital> atualizarHospital(@RequestBody final Hospital request){
        hospitalService.validacaoHospital(request);
        return ResponseEntity.status(HttpStatus.OK).body(hospitalRepository.save(request));
    }
}
