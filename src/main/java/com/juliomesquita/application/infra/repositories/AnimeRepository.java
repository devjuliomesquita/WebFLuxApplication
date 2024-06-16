package com.juliomesquita.application.infra.repositories;

import com.juliomesquita.application.domain.entities.Anime;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnimeRepository extends ReactiveCrudRepository<Anime, Integer> {
}
