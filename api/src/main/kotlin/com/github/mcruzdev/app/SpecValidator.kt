package com.github.mcruzdev.app

import io.dapr.client.DaprClient
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service
import reactor.core.publisher.Mono

@Service
class SpecValidator(
    private val daprClient: DaprClient
) {

    private val logger: Logger = LoggerFactory.getLogger(SpecValidator::class.java)

    fun validate(schema: String): Mono<Void> {
        logger.info("schema is valid")
        logger.info("sending event")
        return daprClient.publishEvent("pubsub", "script", schema)
            .doOnSuccess {
                logger.info("event sent")
            }
            .doOnError {
                logger.error("error while sending event")
            }
    }
}