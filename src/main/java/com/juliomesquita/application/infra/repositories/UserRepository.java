package com.juliomesquita.application.infra.repositories;

import com.juliomesquita.application.domain.entities.UserEntity;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

import java.util.UUID;

@Repository
public interface UserRepository extends
        ReactiveCrudRepository<UserEntity, UUID>
//        ReactiveSortingRepository<UserEntity, UUID>
{
    Flux<UserEntity> findAllBy(Pageable pageable);
}
