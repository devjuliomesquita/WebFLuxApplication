package com.juliomesquita.application.domain.services.implementation;

import com.juliomesquita.application.domain.entities.UserEntity;
import com.juliomesquita.application.domain.services.interfaces.UserService;
import com.juliomesquita.application.infra.dtos.request.UserRequest;
import com.juliomesquita.application.infra.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Override
    public Mono<UserEntity> save(UserRequest request) {
        return this.userRepository.save(UserEntity.builder()
                .email(request.email())
                .active(true)
                .build());
    }

    @Override
    public Mono<UserEntity> findById(UUID uuid) {
        return this.userRepository.findById(uuid);
    }

    @Override
    public Flux<UserEntity> findAll() {
        return this.userRepository.findAll().switchIfEmpty(Flux.empty());
    }

    @Override
    public Mono<Page<UserEntity>> findAllPageable(Pageable pageable) {
        return this.userRepository.findAllBy(pageable)
                .collectList()
                .zipWith(this.userRepository.count())
                .map(u -> new PageImpl<>(u.getT1(), pageable, u.getT2()));
    }

    @Override
    public Mono<UserEntity> update(UUID uuid, UserRequest request) {
        return this.userRepository.findById(uuid)
                .flatMap(userEntity -> {
                    userEntity.setEmail(request.email());
                    return this.userRepository.save(userEntity);
                });
    }

    @Override
    public Mono<UserEntity> delete(UUID uuid) {
         return this.userRepository.findById(uuid)
                 .flatMap(userEntity -> {
                    userEntity.setActive(false);
                    return this.userRepository.save(userEntity);
                 });
    }
}


