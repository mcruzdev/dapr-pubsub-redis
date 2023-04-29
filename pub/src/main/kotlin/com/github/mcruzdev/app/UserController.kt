package com.github.mcruzdev.app;

import io.dapr.client.DaprClient
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import reactor.core.publisher.Mono
import java.util.*

@RestController
@RequestMapping("/users")
class UserController(
    private val daprClient: DaprClient
) {

    private val logger: Logger = LoggerFactory.getLogger(UserController::class.java)

    @PostMapping
    @ResponseStatus(HttpStatus.ACCEPTED)
    fun create(@RequestBody req: UserRequest): Mono<Void> {
        logger.info("[flow:createUser] request $req")
        return daprClient.publishEvent("pubsub", "users", UserEvent(name = req.name))
            .doOnSuccess {
                logger.info("event sent")
            }
            .doOnError {
                logger.error("error while sending event")
            }
    }
}

data class UserRequest(
    val name: String
)

data class UserEvent(
    val id: UUID = UUID.randomUUID(),
    val name: String = "John Doe"
)