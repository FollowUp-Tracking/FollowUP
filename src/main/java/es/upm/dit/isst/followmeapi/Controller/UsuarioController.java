package es.upm.dit.isst.followmeapi.controller;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import es.upm.dit.isst.followmeapi.model.Usuario;
import es.upm.dit.isst.followmeapi.repository.UsuarioRepository;

@RestController
public class UsuarioController {
    private final UsuarioRepository usuarioRepository;
    public static final Logger log = LoggerFactory.getLogger(UsuarioController.class);
    
    public UsuarioController(UsuarioRepository u){
        this.usuarioRepository=u;
    }

    @GetMapping("/usuarios")
    List<Usuario> readAll() {
        return (List<Usuario>) usuarioRepository.findAll();
    }

    @PostMapping("/usuarios")
    ResponseEntity<Usuario> create(@RequestBody Usuario newUsuario) throws URISyntaxException {
        Usuario result = usuarioRepository.save(newUsuario);
        return ResponseEntity.created(new URI("/usuario/" + result.getId())).body(result);
    }

    @GetMapping("/usuarios/{id}")
    ResponseEntity<Usuario> read(@PathVariable Integer id) {
        return usuarioRepository.findById(id).map(usuario -> ResponseEntity.ok().body(usuario)).orElse(new ResponseEntity<Usuario>(HttpStatus.NOT_FOUND));
    }

    @PutMapping("/usuarios/{id}")
    ResponseEntity<Usuario> update(@RequestBody Usuario newUsuario, @PathVariable Integer id) {
        return usuarioRepository.findById(id).map(usuario -> {
            usuario.setUsername(newUsuario.getUsername());
            usuario.setEmail(newUsuario.getEmail());
            usuario.setPassword(newUsuario.getPassword());
            usuario.setRol(newUsuario.getRol());
            usuarioRepository.save(usuario);
            return ResponseEntity.ok().body(usuario);
          }).orElse(new ResponseEntity<Usuario>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("usuarios/{id}")
    ResponseEntity<Usuario> delete(@PathVariable Integer id) {
      usuarioRepository.deleteById(id);
      return ResponseEntity.ok().body(null);
    }
}