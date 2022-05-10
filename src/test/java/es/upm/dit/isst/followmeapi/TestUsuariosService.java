package es.upm.dit.isst.followmeapi;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import es.upm.dit.isst.followmeapi.Repository.UsuarioRepository;
import es.upm.dit.isst.followmeapi.model.Usuario;

@SpringBootTest
public class TestUsuariosService {
    
    @Autowired
    private UsuarioRepository repo;

    @Test
    final void testUsuarios(){
        Usuario usuario = new Usuario();
        usuario.setId(0);
        usuario.setEmail("prueba@gmail.com");
        usuario.setEnable(true);
        usuario.setPassword("12345");
        usuario.setRol("ROLE_CLI");
        usuario.setUsername("prueba");

        Usuario usuario1 = repo.save(usuario);
        int id = usuario1.getId();

        Optional<Usuario> usuario2 = repo.findById(id);
        assertTrue(usuario2.get().getEnable());

        usuario.setEmail("profe@gmail.com");
        repo.save(usuario);
        usuario2 = repo.findById(id);
        assertNotEquals(usuario2.get().getEmail(), "prueba@gmail.com");

        repo.delete(usuario);
        usuario2 = repo.findById(id);
        assertFalse(usuario2.isPresent());
    }
}