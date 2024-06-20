package com.juliomesquita.application.common.services;

import com.juliomesquita.application.common.interfaces.AbstractCrudMapper;
import com.juliomesquita.application.common.interfaces.AbstractCrudRepository;
import com.juliomesquita.application.common.interfaces.AbstractCrudService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public abstract class AbstractCrudServiceImpl<T, ID, R>
        implements AbstractCrudService<T, ID, R> {

    protected final AbstractCrudRepository<T, ID> repository;
    protected final AbstractCrudMapper<T, R> mapper;

    public AbstractCrudServiceImpl(
            AbstractCrudRepository<T, ID> repository,
            AbstractCrudMapper<T, R> mapper
    ) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public Mono<T> save(R request) {
        return this.repository.save(
                this.mapper.toEntity(request)
        );
    }

    @Override
    public Mono<T> findById(ID id) {
        return this.repository.findById(id);
    }

    @Override
    public Flux<T> findAll() {
        return this.repository.findAll().switchIfEmpty(Flux.empty());
    }

    @Override
    public Mono<Page<T>> findAllPageable(Pageable pageable) {
        return this.repository.findAllBy(pageable)
                .collectList()
                .zipWith(this.repository.count())
                .map(t -> new PageImpl<>(t.getT1(), pageable, t.getT2()));
    }

    @Override
    public Mono<T> update(ID id, R request) {
        return this.repository.findById(id)
                .flatMap(t -> {
                    T entityUpdate = this.mapper.toEntityUpdate(t, request);
                    return this.repository.save(entityUpdate);
                });
    }

    @Override
    public Mono<Void> delete(ID id) {
        return this.repository.deleteById(id);
    }
}
