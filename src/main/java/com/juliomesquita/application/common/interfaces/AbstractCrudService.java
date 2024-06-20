package com.juliomesquita.application.common.interfaces;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface AbstractCrudService<T, ID, R> {
    Mono<T> save(R request);

    Mono<T> findById(ID id);

    Flux<T> findAll();

    Mono<Page<T>> findAllPageable(Pageable pageable);

    Mono<T> update(ID id, R request);

    Mono<Void> delete(ID id);
}
