package com.github.mcruzdev.app;

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Mono
import java.util.*

@RestController
@RequestMapping("/specs")
class SpecValidatorController(
    private val specValidator: SpecValidator
) {

    private val logger: Logger = LoggerFactory.getLogger(SpecValidatorController::class.java)

    @PostMapping
    fun create(@RequestBody req: SpecRequest): Mono<ResponseEntity<*>> {
        logger.info("[flow:createSpec] request $req")
        return specValidator.validate("$req")
            .flatMap {
                Mono.just(ResponseEntity.ok(SpecResponse()))
            }
    }
}

data class SpecResponse(
    val id: UUID = UUID.randomUUID()
)

data class SpecRequest(
    val version: String, val url: String, val stages: List<SpecStage>
)

data class SpecStage(
    val duration: Int, val target: Int
)