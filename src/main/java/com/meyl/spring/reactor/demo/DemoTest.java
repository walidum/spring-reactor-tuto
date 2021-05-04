package com.meyl.spring.reactor.demo;

import com.meyl.spring.reactor.demo.model.Province;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.time.Duration;
import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DemoTest {
    private static final Logger logger = LoggerFactory.getLogger(DemoTest.class);
    private static String baseUrl = "http://localhost:8080";
    private static WebClient client = WebClient.create(baseUrl);

    public static void main(String[] args) {
        Instant start = Instant.now();
        List<Mono<Province>> list = Stream.of(9, 16, 19, 23, 31, 39)
                .map(i -> client.get().uri("/province/{id}", i)
                        .retrieve().bodyToMono(Province.class))
                .collect(Collectors.toList());

        Mono.when(list).block();

        logTime(start);
    }

    private static void logTime(Instant start) {
        logger.debug("Elapsed time: " + Duration.between(start, Instant.now()).toMillis() + "ms");
    }
}
