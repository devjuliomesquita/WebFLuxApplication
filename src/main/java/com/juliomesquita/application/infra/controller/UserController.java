package com.juliomesquita.application.infra.controller;

import com.juliomesquita.application.domain.services.interfaces.UserService;
import com.juliomesquita.application.infra.dtos.request.UserRequest;
import com.juliomesquita.application.infra.utils.ApiResponses;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import java.util.UUID;

@RestController
@RequestMapping(value = "/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping(produces = {"application/json"})
    public Mono<ResponseEntity<ApiResponses>> createUser(
            @RequestBody @Valid UserRequest request
    ) {
        return this.userService.save(request)
                .flatMap(userEntity -> {
                    ApiResponses response = ApiResponses.builder()
                            .data(userEntity)
                            .message("Usuário criado.")
                            .responseCode(HttpStatus.CREATED)
                            .build();
                    return Mono.just(new ResponseEntity<>(response, response.responseCode()));
                });
    }

    @GetMapping(value = {"/{uuid}"}, produces = {"application/json"})
    public Mono<ResponseEntity<ApiResponses>> findUserById(@PathVariable("uuid") UUID uuid) {
        return this.userService.findById(uuid)
                .flatMap(userEntity -> {
                    ApiResponses response = ApiResponses.builder()
                            .data(userEntity)
                            .message("Usuário retornado com sucesso.")
                            .responseCode(HttpStatus.OK)
                            .build();
                    return Mono.just(ResponseEntity.ok(response));
                });
    }

    @GetMapping(produces = {"application/json"})
    public Mono<ResponseEntity<ApiResponses>> findAllUsers() {
        return this.userService.findAll()
                .collectList()
                .map(entityList -> {
                    ApiResponses response = ApiResponses.builder()
                            .data(entityList)
                            .message("Usuários retornado com sucesso.")
                            .responseCode(HttpStatus.OK)
                            .build();
                    return ResponseEntity.ok(response);
                });
    }

    @GetMapping(value = "/page", produces = {"application/json"})
    public Mono<ResponseEntity<ApiResponses>> findAllUsersPage(
            @RequestParam(name = "page", required = false, defaultValue = "0") Integer page,
            @RequestParam(name = "perPage", required = false, defaultValue = "10") Integer perPage
    ) {
        return this.userService.findAllPageable(PageRequest.of(page, perPage))
                .flatMap(userEntity -> {
                    ApiResponses response = ApiResponses.builder()
                            .data(userEntity)
                            .message("Usuários retornado com sucesso.")
                            .responseCode(HttpStatus.OK)
                            .build();
                    return Mono.just(ResponseEntity.ok(response));
                });
    }

    @PutMapping(value = "/{uuid}", produces = {"application/json"})
    public Mono<ResponseEntity<ApiResponses>> updateUser(
            @PathVariable("uuid") UUID uuid,
            @RequestBody @Valid UserRequest request
    ) {
        return this.userService.update(uuid, request)
                .flatMap(userEntity -> {
                    ApiResponses responses = ApiResponses.builder()
                            .data(userEntity)
                            .message("Usuário atualizado com sucesso.")
                            .responseCode(HttpStatus.OK)
                            .build();
                    return Mono.just(ResponseEntity.ok(responses));
                });
    }

    @DeleteMapping(value = "/{uuid}", produces = {"application/json"})
    public Mono<ResponseEntity<ApiResponses>> deleteUser(
            @PathVariable("uuid") UUID uuid
    ) {
        return this.userService.delete(uuid)
                .flatMap(userEntity -> {
                    ApiResponses responses = ApiResponses.builder()
                            .data(userEntity)
                            .message("Usuário deletado com sucesso.")
                            .responseCode(HttpStatus.OK)
                            .build();
                    return Mono.just(ResponseEntity.ok(responses));
                });

    }
}
