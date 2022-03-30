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
    ResponseEntity<Pedido> create(@RequestBody Pedido newTFG) throws URISyntaxException {
        Pedido result = pedidoRepository.save(newTFG);
        return ResponseEntity.created(new URI("/tfgs/" + result.getNumeroSeguimiento())).body(result);
    }

    @GetMapping("/pedidos/{id}")
    ResponseEntity<Pedido> read(@PathVariable String id) {
        return pedidoRepository.findById(id).map(pedido -> ResponseEntity.ok().body(pedido)).orElse(new ResponseEntity<Pedido>(HttpStatus.NOT_FOUND));
    }

    @PutMapping("/tfgs/{id}")
    ResponseEntity<Pedido> update(@RequestBody Pedido newPedido, @PathVariable String id) {
        return pedidoRepository.findById(id).map(pedido -> {
            pedido.setOrigen(newPedido.getOrigen());
            pedido.setDestino(newPedido.getDestino());
            pedido.setFecha(newPedido.getFecha());
            pedido.setProducto(newPedido.getProducto());
            pedido.setCorreo(newPedido.getCorreo());
            pedido.setIdRepartidor(newPedido.getIdRepartidor());
            pedido.setTrazas(newPedido.getTrazas());
            pedido.setEmpresa(newPedido.getEmpresa());
            pedidoRepository.save(pedido);
            return ResponseEntity.ok().body(pedido);
          }).orElse(new ResponseEntity<Pedido>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("pedidos/{id}")
    ResponseEntity<Pedido> delete(@PathVariable String id) {
      pedidoRepository.deleteById(id);
      return ResponseEntity.ok().body(null);
    }
}
