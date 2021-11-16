package br.com.tcc.sceh.controller;

import br.com.tcc.sceh.model.Funcionario;
import br.com.tcc.sceh.model.FuncionarioLogin;
import br.com.tcc.sceh.repository.FuncionarioRepository;
import br.com.tcc.sceh.service.FuncionarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/funcionario")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class FuncionarioController {

    private FuncionarioRepository funcionarioRepository;
    private FuncionarioService funcionarioService;

    @Autowired
    public FuncionarioController(FuncionarioRepository funcionarioRepository, FuncionarioService funcionarioService) {
        this.funcionarioRepository = funcionarioRepository;
        this.funcionarioService = funcionarioService;
    }

    @PostMapping("/logar")
    public ResponseEntity<FuncionarioLogin> autenticar(@RequestBody Optional<FuncionarioLogin> user){
        return funcionarioService.logar(user).map(resp -> ResponseEntity.ok().body(resp))
                .orElse(ResponseEntity.status(HttpStatus.UNAUTHORIZED).build());
    }


    @GetMapping
    public ResponseEntity<List<Funcionario>> buscarTodosFuncionarios() {
        return ResponseEntity.ok(funcionarioRepository.findAll());
    }

    @GetMapping("/{codigoFuncionario}")
    public ResponseEntity<Funcionario> buscarFuncionarioPeloCodigoFuncionario(@PathVariable final Long codigoFuncionario) {
        return funcionarioRepository.findById(codigoFuncionario)
                .map(resp -> ResponseEntity.status(HttpStatus.OK).body(resp))
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/nome/{nome}")
    public ResponseEntity<List<Funcionario>> buscarFuncionarioPeloNome(@PathVariable final String nome) {
        return ResponseEntity.ok(funcionarioRepository.findByNomeContainingIgnoreCase(nome));
    }

    @PostMapping("/cadastrar")
    public ResponseEntity<Funcionario> cadastrarFuncionario(@Validated @RequestBody final Funcionario funcionario){
        funcionarioService.verificarFuncionario(funcionario);
        return ResponseEntity.status(HttpStatus.CREATED).body(funcionarioService.cadastrarFuncionario(funcionario));
    }

    @PutMapping("/atualizar")
    public ResponseEntity<Funcionario> atualizarFuncionario(@Validated @RequestBody final Funcionario funcionario){
        return ResponseEntity.status(HttpStatus.OK).body(funcionarioRepository.save(funcionario));
    }

    @DeleteMapping("/{codigoFuncionario}")
    public ResponseEntity<Void> deletarFuncionario(@PathVariable Long codigoFuncionario) {
        funcionarioRepository.deleteById(codigoFuncionario);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }


}
