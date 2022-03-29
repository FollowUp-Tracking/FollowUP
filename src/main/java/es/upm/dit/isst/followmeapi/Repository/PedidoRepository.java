package es.upm.dit.isst.followmeapi.Repository;

import org.springframework.data.repository.CrudRepository;
import es.upm.dit.isst.followmeapi.model.Pedido;

public interface PedidoRepository extends CrudRepository<Pedido, Long> {
    
}
