package br.com.tcc.sceh.security;

import br.com.tcc.sceh.repository.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDatailsServiceImpl implements UserDetailsService {

	@Autowired
	private FuncionarioRepository funcionarioRepository;

	@Override
	public UserDetails loadUserByUsername(final String username) throws UsernameNotFoundException{
		var funcionario = funcionarioRepository.findByUsername(username);
		funcionario.orElseThrow(()-> new UsernameNotFoundException(username + "não encontrado"));

		return funcionario.map(UserDetailsImpl::new).get();
	}
}
