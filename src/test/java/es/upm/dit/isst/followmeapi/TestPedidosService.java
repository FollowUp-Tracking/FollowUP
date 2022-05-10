package es.upm.dit.isst.followmeapi;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import es.upm.dit.isst.followmeapi.Repository.PedidoRepository;
import es.upm.dit.isst.followmeapi.model.Pedido;

@SpringBootTest
public class TestPedidosService {
    
    @Autowired
    private PedidoRepository repo;

    @Test
    final void testPedidos(){
        Pedido pedido = new Pedido();
        pedido.setNumeroSeguimiento("pedido1");
        pedido.setCliente("jaime");
        pedido.setEstado(1);
        pedido.setLatitudDestino(50.0);
        pedido.setLongitudDestino(60.0);
        pedido.setRepartidor("pablo");
        pedido.setVehiculo("coche");
        pedido.setVendedor("Mercadona");

        repo.save(pedido);

        Optional<Pedido> pedido2 = repo.findById("pedido1");
        assertEquals(pedido2.get().getCliente(), pedido.getCliente());
        assertEquals(pedido2.get().getLatitudDestino(), 50.0);

        pedido.setCliente("sergio");
        repo.save(pedido);
        pedido2 = repo.findById("pedido1");
        assertNotEquals(pedido2.get().getCliente(), "jaime");
        pedido.setCliente("jaime");
        repo.save(pedido);

        assertNotNull(repo.findByRepartidor("pablo"));

        repo.delete(pedido);
        pedido2 = repo.findById("pedido1");
        assertFalse(pedido2.isPresent());
    }
}