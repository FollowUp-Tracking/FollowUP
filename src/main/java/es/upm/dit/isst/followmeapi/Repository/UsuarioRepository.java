package es.upm.dit.isst.followmeapi.Repository;

import org.springframework.data.repository.CrudRepository;
import es.upm.dit.isst.followmeapi.model.Usuario;

public interface UsuarioRepository extends CrudRepository<Usuario, Integer> {
    
}
