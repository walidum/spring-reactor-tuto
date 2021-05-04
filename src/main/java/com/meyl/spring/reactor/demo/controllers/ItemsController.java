package com.meyl.spring.reactor.demo.controllers;

import com.meyl.spring.reactor.demo.model.Item;
import org.reactivestreams.Publisher;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.time.Instant;

@RestController
public class ItemsController {
    @GetMapping(value = "/items", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Publisher<Item> greetingPublisher() {
        Flux<Item> flux = Flux.<Item>generate(item ->
                item.next(new Item("This is  @" + Instant.now().toString())))
                .delayElements(Duration.ofSeconds(1));
        return flux;
    }
}
