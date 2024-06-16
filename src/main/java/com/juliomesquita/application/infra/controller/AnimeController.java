package com.juliomesquita.application.infra.controller;

import com.juliomesquita.application.domain.entities.Anime;
import com.juliomesquita.application.domain.services.AnimeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/animes")
@RequiredArgsConstructor
public class AnimeController {
    private final AnimeService animeService;

    @PostMapping
    public Mono<Anime> create(Anime anime) {
        return this.animeService.createAnime(anime);
    }


    @GetMapping(value = "/{id}")
    public Mono<Anime> findById(@PathVariable(value = "id") Integer id) {
        return this.animeService.findById(id)
                .switchIfEmpty(this.monoResponseStatusNotFound())
                .log();
    }

    @GetMapping
    public Flux<Anime> listAll() {
        return this.animeService.findAll().log();
    }

    @DeleteMapping(value = "/{id}")
    public void deleteAnime(@PathVariable(value = "id") Integer id) {
        this.animeService.deleteAnime(id);
    }

    private <T> Mono<T> monoResponseStatusNotFound() {
        return Mono.error(new ResponseStatusException(HttpStatus.NOT_FOUND, "Anime não encontrado"));
    }
}
