package com.github.mcruzdev.script;

import io.dapr.Topic;
import io.dapr.client.domain.CloudEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/")
public class Controller {

    private static final Logger LOGGER = LoggerFactory.getLogger(Controller.class);

    @PostMapping("/users")
    @Topic(pubsubName = "pubsub", name = "users")
    @ResponseStatus(HttpStatus.OK)
    public void handle(@RequestBody CloudEvent<String> event) {
        LOGGER.info("handling event data: {}", event.getData());
    }

    @GetMapping("/health/readiness")
    @ResponseStatus(HttpStatus.OK)
    public void readiness() {
        LOGGER.info("readiness");
    }


    @GetMapping("/health/liveness")
    @ResponseStatus(HttpStatus.OK)
    public void liveness() {
        LOGGER.info("liveness");
    }
}
