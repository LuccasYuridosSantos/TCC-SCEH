package br.com.tcc.sceh.controller;

import br.com.tcc.sceh.model.Endereco;
import br.com.tcc.sceh.repository.EnderecoRepository;
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
@RequestMapping("/endereco")
public class EnderecoController {

    private EnderecoRepository enderecoRepository;

    @Autowired
    public EnderecoController(EnderecoRepository enderecoRepository) {
        this.enderecoRepository = enderecoRepository;
    }

    @GetMapping
    public ResponseEntity<List<Endereco>> buscarEnderecos() {
        return ResponseEntity.ok(enderecoRepository.findAll());
    }

    @GetMapping("/{codigoEndereco}")
    public ResponseEntity<Endereco> buscarEnderecoPorCodigoEndereco(@PathVariable final Long codigoEndereco){
        return enderecoRepository.findById(codigoEndereco)
                .map(resp -> ResponseEntity.ok().body(resp))
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/cep/{cep}")
    public ResponseEntity<List<Endereco>> buscarEnderecoPorCep(@PathVariable final String cep){
        return ResponseEntity.ok(enderecoRepository.findByCepContainingIgnoreCase(cep));
    }

    @PostMapping("/cadastrar")
    public ResponseEntity<Endereco> cadastrarEndereco(@RequestBody final Endereco endereco) {
        return ResponseEntity.status(HttpStatus.CREATED).body(enderecoRepository.save(endereco));
    }

    @PutMapping("/atualizar")
    public ResponseEntity<Endereco> atualizarEndereco(@RequestBody final Endereco endereco) {
        return ResponseEntity.status(HttpStatus.OK).body(enderecoRepository.save(endereco));
    }

    @DeleteMapping("/{codigoEndereco}")
    public ResponseEntity<Void>  deletarEndereco(@PathVariable final Long codigoEndereco){
        enderecoRepository.deleteById(codigoEndereco);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
