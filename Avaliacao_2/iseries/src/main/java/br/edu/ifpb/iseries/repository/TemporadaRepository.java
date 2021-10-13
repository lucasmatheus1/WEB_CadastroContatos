package br.edu.ifpb.iseries.repository;

import br.edu.ifpb.iseries.models.Serie;
import br.edu.ifpb.iseries.models.Temporada;
import org.springframework.data.repository.CrudRepository;

public interface TemporadaRepository extends CrudRepository<Temporada, String> {

    Iterable<Temporada> findBySerie(Serie serie);

    Temporada findById(long id);
}
