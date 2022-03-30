package es.upm.dit.isst.followmeapi.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import es.upm.dit.isst.followmeapi.model.Traza;

public interface TrazaRepository extends CrudRepository<Traza, Integer> {
    List<Traza> findByIdPedido(Integer idPedido);
}
