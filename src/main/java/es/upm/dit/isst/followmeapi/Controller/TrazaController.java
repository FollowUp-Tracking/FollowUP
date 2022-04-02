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

import es.upm.dit.isst.followmeapi.model.Traza;
import es.upm.dit.isst.followmeapi.repository.TrazaRepository;

@RestController
public class TrazaController {
    
    private final TrazaRepository trazaRepository;
    public static final Logger log = LoggerFactory.getLogger(TrazaController.class);
    
    public TrazaController(TrazaRepository t) {
        this.trazaRepository = t;
    }

    @GetMapping("/trazas")
    List<Traza> readAll() {
        return (List<Traza>) trazaRepository.findAll();
    }

    @PostMapping("/trazas")
    ResponseEntity<Traza> create(@RequestBody Traza newTraza) throws URISyntaxException {
        Traza result = trazaRepository.save(newTraza);
        return ResponseEntity.created(new URI("/traza/" + result.getId())).body(result);
    }

    @GetMapping("/trazas/{id}")
    ResponseEntity<Traza> read(@PathVariable Integer id) {
        return trazaRepository.findById(id).map(traza -> ResponseEntity.ok().body(traza)).orElse(new ResponseEntity<Traza>(HttpStatus.NOT_FOUND));
    }

    @PutMapping("/trazas/{id}")
    ResponseEntity<Traza> update(@RequestBody Traza newTraza, @PathVariable Integer id) {
        return trazaRepository.findById(id).map(traza -> {
            traza.setLatitud(newTraza.getLatitud());
            traza.setLongitud(newTraza.getLongitud());
            traza.setFecha(newTraza.getFecha());
            traza.setPedido(newTraza.getPedido());
            trazaRepository.save(traza);
            return ResponseEntity.ok().body(traza);
          }).orElse(new ResponseEntity<Traza>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("trazas/{id}")
    ResponseEntity<Traza> delete(@PathVariable Integer id) {
      trazaRepository.deleteById(id);
      return ResponseEntity.ok().body(null);
    }
}
