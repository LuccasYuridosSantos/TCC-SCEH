package br.com.tcc.sceh.controller;

import br.com.tcc.sceh.model.entity.Usuario;
import br.com.tcc.sceh.repository.UsuarioRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
@RequestMapping("/usuario")
public class UsuarioController {

	private static final Logger LOGGER = LoggerFactory.getLogger(UsuarioController.class);

	private UsuarioRepository usuarioRepository;

	@Autowired
	public UsuarioController(UsuarioRepository usuarioRepository) {
		this.usuarioRepository = usuarioRepository;
	}

	@GetMapping
	public ResponseEntity<List<Usuario>> getAllUsers() {
		LOGGER.debug("Buscando usuarios");
		return ResponseEntity.ok(usuarioRepository.findAll());
	}

	@GetMapping("/{codigoUsuario}")
	public ResponseEntity<Usuario> getUsuarioById(@PathVariable final long codigoUsuario){
		LOGGER.debug("Buscando usuario com id = {}", codigoUsuario);
		return usuarioRepository.findById(codigoUsuario)
				.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
	}

	@PostMapping("/cadastrar")
	public ResponseEntity<Usuario> saveUsuario(@RequestBody Usuario usuario){
		usuario.setStatusUsuario("ATIVO");
		LOGGER.debug("Cadastrando usuario");
		return ResponseEntity.status(HttpStatus.CREATED).body(usuarioRepository.save(usuario));
	}

	@PutMapping("/atualizar")
	public ResponseEntity<Usuario> atualizarUsuario(@RequestBody final Usuario usuario){
		LOGGER.debug("Atualizando Usuario Cadastrado");
		return ResponseEntity.status(HttpStatus.OK).body(usuarioRepository.save(usuario));
	}
}
