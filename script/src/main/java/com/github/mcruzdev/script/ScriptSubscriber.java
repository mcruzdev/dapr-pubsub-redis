package com.github.mcruzdev.script;

import io.dapr.Topic;
import io.dapr.client.domain.CloudEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ScriptSubscriber {

    private static final Logger LOGGER = LoggerFactory.getLogger(ScriptSubscriber.class);

    @PostMapping("/script")
    @Topic(pubsubName = "pubsub", name = "script")
    @ResponseStatus(HttpStatus.OK)
    public void handle(@RequestBody CloudEvent<String> event) {
        LOGGER.info("handling event data: {}", event.getData());
    }
}
