package com.juliomesquita.application;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.reactivestreams.Subscription;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

@Slf4j
@DisplayName("Test Mono")
public class MonoTest {
    @Test
    @DisplayName("Teste do Mono Subscriber")
    public void testMonoSubscriber() {
        String name = "júlio mesquita";
        Mono<String> mono = Mono.just(name).log();

        mono.subscribe();
        log.info("<-><-><-><-><-><-><-><-><-><-><->");
        StepVerifier.create(mono)
                .expectNext(name)
                .verifyComplete();

    }

    @Test
    @DisplayName("Teste do Mono Subscriber Consumer")
    public void testMonoSubscriberConsumer() {
        String name = "júlio mesquita";
        Mono<String> mono = Mono.just(name).log();

        mono.subscribe(s -> log.info("Nome enviado {}", s));
        log.info("<-><-><-><-><-><-><-><-><-><-><->");
        StepVerifier.create(mono)
                .expectNext(name)
                .verifyComplete();

    }

    @Test
    @DisplayName("Teste do Mono Subscriber Consumer Error")
    public void testMonoSubscriberConsumerError() {
        String name = "júlio mesquita";
        Mono<String> mono = Mono.just(name)
                .map(s -> {
                    log.info("Chegou aqui");
                    throw new RuntimeException("Teste mono com falhas.");
                });

        mono.subscribe(s -> log.info("Nome enviado {}", s),
                s -> log.error("Aguma coisa quebrou.")
        );
        mono.subscribe(s -> log.info("Nome enviado {}", s),
                Throwable::printStackTrace
        );
        log.info("<-><-><-><-><-><-><-><-><-><-><->");
        StepVerifier.create(mono)
                .expectError(RuntimeException.class)
                .verify();

    }

    @Test
    @DisplayName("Teste do mono Subscriber Consumer completed")
    public void testMonoSubscriberConsumerCompleted() {
        String name = "Júlio Rei Delas";
        Mono<String> mono = Mono.just(name)
                .log()
                .map(String::toLowerCase);

        mono.subscribe(s -> log.info("O valor enviado é {}", s),
                Throwable::printStackTrace,
                () -> log.info("Finalizou")
        );
        StepVerifier.create(mono)
                .expectNext(name.toLowerCase())
                .verifyComplete();
    }

    @Test
    @DisplayName("Teste do mono Subscriber Consumer Subscription ")
    public void testMonoSubscriberConsumerSubscription() {
        String name = "Júlio Rei Delas";
        Mono<String> mono = Mono.just(name)
                .log()
                .map(String::toLowerCase);

        mono.subscribe(s -> log.info("O valor enviado é {}", s),
                Throwable::printStackTrace,
                () -> log.info("Finalizou"),
                Subscription::cancel
        );
        StepVerifier.create(mono)
                .expectNext(name.toLowerCase())
                .verifyComplete();
    }

}
