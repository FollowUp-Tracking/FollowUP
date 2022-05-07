package es.upm.dit.isst.followmeapi.Controller;

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

import es.upm.dit.isst.followmeapi.Repository.PedidoRepository;
import es.upm.dit.isst.followmeapi.model.Pedido;

@RestController
public class PedidoController {
    
    private final PedidoRepository pedidoRepository;
    public static final Logger log = LoggerFactory.getLogger(PedidoController.class);
    
    public PedidoController(PedidoRepository p) {
        this.pedidoRepository = p;
    }
    
    @GetMapping("/pedidos")
    List<Pedido> readAll() {
        return (List<Pedido>) pedidoRepository.findAll();
    }

    @PostMapping("/pedidos")
    ResponseEntity<Pedido> create(@RequestBody Pedido newPedido) throws URISyntaxException {
        Pedido result = pedidoRepository.save(newPedido);
        return ResponseEntity.created(new URI("/pedidos/" + result.getNumeroSeguimiento())).body(result);
    }

    @GetMapping("/pedidos/{id}")
    ResponseEntity<Pedido> read(@PathVariable String id) {
        return pedidoRepository.findById(id).map(pedido -> ResponseEntity.ok().body(pedido)).orElse(new ResponseEntity<Pedido>(HttpStatus.NOT_FOUND));
    }

    @PutMapping("/pedidos/{id}")
    ResponseEntity<Pedido> update(@RequestBody Pedido newPedido, @PathVariable String id) {
        return pedidoRepository.findById(id).map(pedido -> {
            pedido.setCliente(newPedido.getCliente());
            pedido.setVendedor(newPedido.getVendedor());
            pedido.setRepartidor(newPedido.getRepartidor());
            pedido.setVehiculo(newPedido.getVehiculo());
            pedido.setEstado(newPedido.getEstado());
            pedidoRepository.save(pedido);
            return ResponseEntity.ok().body(pedido);
          }).orElse(new ResponseEntity<Pedido>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("pedidos/{id}")
    ResponseEntity<Pedido> delete(@PathVariable String id) {
      pedidoRepository.deleteById(id);
      return ResponseEntity.ok().body(null);
    }

    @GetMapping("/pedidos/cliente/{usuario}")
    List<Pedido> readCliente(@PathVariable String usuario) {
        return (List<Pedido>) pedidoRepository.findByCliente(usuario);
    }

    @GetMapping("/pedidos/vendedor/{usuario}")
    List<Pedido> readVendedor(@PathVariable String usuario) {
        return (List<Pedido>) pedidoRepository.findByVendedor(usuario);
    }

    @GetMapping("/pedidos/repartidor/{usuario}")
    List<Pedido> readRepartidor(@PathVariable String usuario) {
        return (List<Pedido>) pedidoRepository.findByRepartidor(usuario);
    }
}
