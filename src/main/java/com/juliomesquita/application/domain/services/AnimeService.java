package com.juliomesquita.application.domain.services;

import com.juliomesquita.application.domain.entities.Anime;
import com.juliomesquita.application.infra.repositories.AnimeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class AnimeService {
    private final AnimeRepository animeRepository;

    public Mono<Anime> createAnime(Anime anime){
        return this.animeRepository.save(anime);
    }

    public Mono<Anime> findById(Integer id){
        return this.animeRepository.findById(id);
    }

    public Flux<Anime> findAll(){
        return this.animeRepository.findAll();
    }

//    public Mono<Anime> updateAnime(Integer id, String name) {
//        Mono<Anime> anime = this.findById(id);
//        anime.subscribe(a -> {
//            a.setName(name);
//            this.animeRepository.save(a);
//        });
//        return ;
//    }

    public void deleteAnime(Integer id){
        this.animeRepository.deleteById(id);
    }
}