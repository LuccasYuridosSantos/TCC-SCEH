package br.com.tcc.sceh.controller;

import br.com.tcc.sceh.model.entity.Permissao;
import br.com.tcc.sceh.repository.PermissaoRepository;
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
@RequestMapping("/permissao")
public class PermissaoController {

    private final PermissaoRepository permissaoRepository;

    @Autowired
    public PermissaoController(PermissaoRepository permissaoRepository) {
        this.permissaoRepository = permissaoRepository;
    }

    @GetMapping
    public ResponseEntity<List<Permissao>> buscarHospitais(){
        return ResponseEntity.ok(permissaoRepository.findAll());
    }

    @GetMapping("/{codigoPermissao}")
    public ResponseEntity<Permissao> buscarHospitalPorId(@PathVariable final Long codigoPermissao){
        return permissaoRepository.findById(codigoPermissao)
                .map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/nome/{nomePermissao}")
    public ResponseEntity<List<Permissao>> buscarPermmissaoPorNome(@PathVariable final String nomePermissao){
        return ResponseEntity.ok().body(permissaoRepository.findByNomeIgnoreCase(nomePermissao));
    }

    @PostMapping("/cadastrar")
    public ResponseEntity<Permissao> cadastrarHospital(@RequestBody final Permissao permissaoRequest){
        return ResponseEntity.status(HttpStatus.CREATED).body(permissaoRepository.save(permissaoRequest));
    }

    @PutMapping("/atualizar")
    public ResponseEntity<Permissao> atualizarTelefone(@RequestBody final Permissao permissaoRequest){
        return ResponseEntity.status(HttpStatus.OK).body(permissaoRepository.save(permissaoRequest));
    }

    @DeleteMapping("/deletar/{codigoPermissao}")
    public ResponseEntity<Void> deletarPermissao(@PathVariable final Long codigoPermissao){
        permissaoRepository.deleteById(codigoPermissao);
        return ResponseEntity.noContent().build();
    }
    
}
