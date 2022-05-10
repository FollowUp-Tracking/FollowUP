package es.upm.dit.isst.followmeapi.Repository;


import java.util.List;

import org.springframework.data.repository.CrudRepository;
import es.upm.dit.isst.followmeapi.model.Pedido;

public interface PedidoRepository extends CrudRepository<Pedido, String> {
    List<Pedido> findByCliente(String cliente);
    List<Pedido> findByVendedor(String vendedor);
    List<Pedido> findByRepartidor(String repartidor);
    List<Pedido> findByVehiculo(String vehiculo);
}
