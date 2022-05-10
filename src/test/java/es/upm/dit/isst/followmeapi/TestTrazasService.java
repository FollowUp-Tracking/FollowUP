package es.upm.dit.isst.followmeapi;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import es.upm.dit.isst.followmeapi.Repository.TrazaRepository;
import es.upm.dit.isst.followmeapi.model.Traza;

@SpringBootTest
public class TestTrazasService {

    @Autowired
    private TrazaRepository repo;

    @Test
    final void testTrazas(){
        Traza traza = new Traza();
        traza.setId(0);
        traza.setFecha(null);
        traza.setLatitud(50.0);
        traza.setLongitud(60.0);
        traza.setNumeroSeguimiento("EA001");
    
        Traza traza1 = repo.save(traza);
        int id = traza1.getId();

        Optional<Traza> traza2 = repo.findById(id);
        assertEquals(traza2.get().getLatitud(), 50.0);

        traza.setNumeroSeguimiento("EA002");
        repo.save(traza);
        traza2 = repo.findById(id);
        assertNotEquals(traza2.get().getNumeroSeguimiento(), "EA001");

        repo.delete(traza);
        traza2 = repo.findById(id);
        assertFalse(traza2.isPresent());
    }
}