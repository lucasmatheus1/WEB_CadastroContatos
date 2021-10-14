package br.edu.ifpb.iseries.repository;

import br.edu.ifpb.iseries.models.Episodio;
import br.edu.ifpb.iseries.models.Temporada;
import org.springframework.data.repository.CrudRepository;

public interface EpisodioRepository extends CrudRepository<Episodio, String> {

    Iterable<Episodio> findByTemporada(Temporada temporada);

    Episodio findById(long id);
}
