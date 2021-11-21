package br.com.tcc.sceh.helper;

import br.com.tcc.sceh.enums.Permissao;
import br.com.tcc.sceh.model.entity.Usuario;

public class UsuarioBuilder {
    private Usuario usuario = new Usuario();

    private UsuarioBuilder(){}

    public static UsuarioBuilder builder(){
        return new UsuarioBuilder();
    }

    public Usuario build() {
        return usuario;
    }

    public UsuarioBuilder usuarioCompleto(){
        usuario.setCodigoUsuario(1L);
        usuario.setSenha("Test");
        usuario.setStatusUsuario("ATIVO");
        usuario.setPermissao(Permissao.ADM);
        usuario.setUserName("Test");
        usuario.setEmail("test@email.com");
        return this;
    }

}
