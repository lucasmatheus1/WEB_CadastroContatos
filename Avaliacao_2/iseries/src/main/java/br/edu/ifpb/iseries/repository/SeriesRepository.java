package br.edu.ifpb.iseries.repository;

import br.edu.ifpb.iseries.models.Series;
import org.springframework.data.repository.CrudRepository;

public interface SeriesRepository extends CrudRepository<Series, String> {
}
