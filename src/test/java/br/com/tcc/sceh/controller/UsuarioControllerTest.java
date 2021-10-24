package br.com.tcc.sceh.controller;

import br.com.tcc.sceh.helper.UsuarioBuilder;
import br.com.tcc.sceh.model.Usuario;
import br.com.tcc.sceh.repository.UsuarioRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;

@RunWith(MockitoJUnitRunner.class)
public class UsuarioControllerTest {

    @InjectMocks
    private UsuarioController controller;

    @Mock
    private UsuarioRepository repository;


    @Test
    public void testeCriandoUsuarioComSucesso() {

        final Usuario usuarioMock = UsuarioBuilder.builder().usuarioCompleto().build();

        Mockito.when(repository.save(usuarioMock)).thenReturn(usuarioMock);

        ResponseEntity<Usuario> usuarioResponse = controller.saveUsuario(usuarioMock);


        Mockito.verify(repository, times(1)).save(any(Usuario.class));
        Assert.assertEquals(usuarioMock, usuarioResponse.getBody());

    }

    @Test
    public void testeBuscandoUsuarioComSucesso() {

        final Usuario usuarioMock = UsuarioBuilder.builder().usuarioCompleto().build();

        Mockito.when(repository.save(usuarioMock)).thenReturn(usuarioMock);

        ResponseEntity<Usuario> usuarioResponse = controller.saveUsuario(usuarioMock);


        Mockito.verify(repository, times(1)).save(any(Usuario.class));
        Assert.assertEquals(usuarioMock, usuarioResponse.getBody());

    }

    @Test
    public void buscandoUsuariosComSucesso(){
        final Usuario usuarioMock = UsuarioBuilder.builder().usuarioCompleto().build();

        Mockito.when(repository.findAll()).thenReturn(List.of(usuarioMock));

        ResponseEntity<List<Usuario>> usuarioResponse = controller.getAllUsers();


        Mockito.verify(repository, times(1)).findAll();
        Assert.assertEquals(List.of(usuarioMock), usuarioResponse.getBody());

    }

    @Test
    public void buscandoUsuarioPeloCodigoUsuarioComSucesso(){
        final Usuario usuarioMock = UsuarioBuilder.builder().usuarioCompleto().build();

        Mockito.when(repository.findById(1L)).thenReturn(Optional.ofNullable(usuarioMock));

        ResponseEntity<Usuario> usuarioResponse = controller.getUsuarioById(1L);


        Mockito.verify(repository, times(1)).findById(1L);
        Assert.assertEquals(usuarioMock, usuarioResponse.getBody());
        Assert.assertEquals(HttpStatus.OK, usuarioResponse.getStatusCode());

    }

    @Test
    public void buscandoUsuarioPeloCodigoUsuarioQueNaoExite(){

        Mockito.when(repository.findById(1L)).thenReturn(Optional.empty());

        ResponseEntity<Usuario> usuarioResponse = controller.getUsuarioById(1L);


        Mockito.verify(repository, times(1)).findById(1L);
        Assert.assertNull(usuarioResponse.getBody());
        Assert.assertEquals(HttpStatus.NOT_FOUND, usuarioResponse.getStatusCode());

    }



}
