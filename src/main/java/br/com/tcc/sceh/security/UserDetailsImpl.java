package br.com.tcc.sceh.security;

import br.com.tcc.sceh.model.Funcionario;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

public class UserDetailsImpl implements UserDetails {

	private static final long serialVersionUID = 1L;

	private String username;
	private String senha;

	public UserDetailsImpl(Funcionario funcionario) {
		this.username = funcionario.getUsername();
		this.senha = funcionario.getSenha();
	}

	@Override public Collection<? extends GrantedAuthority> getAuthorities() {
		return null;
	}

	@Override public String getPassword() {
		return senha;
	}

	@Override public String getUsername() {
		return username;
	}

	@Override public boolean isAccountNonExpired() {
		return false;
	}

	@Override public boolean isAccountNonLocked() {
		return false;
	}

	@Override public boolean isCredentialsNonExpired() {
		return false;
	}

	@Override public boolean isEnabled() {
		return false;
	}
}
