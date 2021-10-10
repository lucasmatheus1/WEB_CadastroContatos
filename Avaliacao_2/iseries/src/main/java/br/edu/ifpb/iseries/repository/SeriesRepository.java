package br.edu.ifpb.iseries.repository;

import br.edu.ifpb.iseries.models.Serie;
import org.springframework.data.repository.CrudRepository;

public interface SeriesRepository extends CrudRepository<Serie, String> {

    Serie findById(long id);

}
