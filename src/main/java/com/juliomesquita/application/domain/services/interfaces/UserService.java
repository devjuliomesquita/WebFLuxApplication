package com.juliomesquita.application.domain.services.interfaces;

import com.juliomesquita.application.domain.entities.UserEntity;
import com.juliomesquita.application.infra.dtos.request.UserRequest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.UUID;

public interface UserService {
//    Crud
    Mono<UserEntity> save(UserRequest request);
    Mono<UserEntity> findById(UUID uuid);
    Flux<UserEntity> findAll();
    Mono<Page<UserEntity>> findAllPageable(Pageable pageable);
    Mono<UserEntity> update(UUID uuid, UserRequest request);
    Mono<UserEntity> delete(UUID uuid);
}
