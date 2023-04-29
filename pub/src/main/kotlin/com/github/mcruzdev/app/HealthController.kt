package com.github.mcruzdev.app

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/health")
class HealthController {

    private val logger: Logger = LoggerFactory.getLogger(HealthController::class.java)

    @GetMapping("/readiness")
    @ResponseStatus(HttpStatus.OK)
    fun readiness() {
        logger.info("readiness");
    }


    @GetMapping("/liveness")
    @ResponseStatus(HttpStatus.OK)
    fun liveness() {
        logger.info("liveness");
    }
}