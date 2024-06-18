package com.juliomesquita.application.infra.controller;

import com.juliomesquita.application.domain.entities.UserEntity;
import com.juliomesquita.application.domain.services.interfaces.UserService;
import com.juliomesquita.application.infra.controller.documentation.UserControllerDoc;
import com.juliomesquita.application.infra.dtos.request.UserRequest;
import com.juliomesquita.application.infra.utils.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping(value = "/api")
@RequiredArgsConstructor
public class UserController implements UserControllerDoc {
    private final UserService userService;

    @Override
    public Mono<ResponseEntity<ApiResponses>> createUser(UserRequest request) {
        Mono<UserEntity> save = this.userService.save(request);
        Mono<ResponseEntity<ApiResponses>> responseEntityMono = save
                .flatMap(userEntity -> {
                    ApiResponses response = ApiResponses.builder()
                            .data(userEntity)
                            .message("Usuário criado.")
                            .responseCode(HttpStatus.CREATED)
                            .build();
                    return Mono.just(new ResponseEntity<>(response, response.responseCode()));
                });
        return responseEntityMono;
    }
}
