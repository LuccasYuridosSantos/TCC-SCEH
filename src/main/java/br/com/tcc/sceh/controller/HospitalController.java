package br.com.tcc.sceh.controller;

import br.com.tcc.sceh.model.Hospital;
import br.com.tcc.sceh.repository.HospitalRepository;
import br.com.tcc.sceh.service.HospitalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/hospital")
public class HospitalController {
    private HospitalService hospitalService;
    private HospitalRepository hospitalRepository;

    @Autowired
    public HospitalController(HospitalService hospitalService, HospitalRepository hospitalRepository) {
        this.hospitalService = hospitalService;
        this.hospitalRepository = hospitalRepository;
    }


    @RequestMapping(method = RequestMethod.GET, value = "/listar-todos")
    public ResponseEntity<List<Hospital>> buscarHospitais(){
    	
    	List<Hospital> hospitais = new ArrayList<>();
    	
    	Optional<List<Hospital>> procureTodos = hospitalRepository.procureTodos();
    	
    	if(procureTodos.isPresent()) {
    		hospitais.addAll(procureTodos.get());
    	}
    	
        return ResponseEntity.status(HttpStatus.OK).body(hospitais);
    }

    @GetMapping("/{codigoHospital}")
    public ResponseEntity<Hospital> buscarHospitalPorId(@PathVariable final Long codigoHospital){
        return hospitalRepository.findById(codigoHospital)
                .map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/nomeFantasia/{nomeFantasia}")
    public ResponseEntity<List<Hospital>> buscarHospitalPeloNomeFantasia(@PathVariable final String nomeFantasia) {
        return ResponseEntity.ok(hospitalRepository.findByNomeFantasiaContainingIgnoreCase(nomeFantasia));
    }

    @PostMapping("/cadastrar")
    public ResponseEntity<Hospital> cadastrarHospital(@RequestBody final Hospital hospitalRequest){
        hospitalService.ValidacaoHospital(hospitalRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(hospitalRepository.save(hospitalRequest));
    }

    @PutMapping("/atualizar")
    public ResponseEntity<Hospital> atualizarHospital(@RequestBody final Hospital hospitalRequest){
        hospitalService.ValidacaoHospital(hospitalRequest);
        return ResponseEntity.status(HttpStatus.OK).body(hospitalRepository.save(hospitalRequest));
    }
}
