package es.upm.dit.isst.followmeapi.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import es.upm.dit.isst.followmeapi.model.Pedido;

public interface PedidoRepository extends CrudRepository<Pedido, String> {
    List<Pedido> findByIdVendedor(Integer vendedor);
    List<Pedido> findByIdCliente(Integer cliente);
}
