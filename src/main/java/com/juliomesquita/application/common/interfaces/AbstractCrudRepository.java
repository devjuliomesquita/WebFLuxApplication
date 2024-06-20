package com.juliomesquita.application.common.interfaces;

import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;

public interface AbstractCrudRepository<T, ID> extends ReactiveCrudRepository<T, ID> {
    Flux<T> findAllBy(Pageable pageable);
}
