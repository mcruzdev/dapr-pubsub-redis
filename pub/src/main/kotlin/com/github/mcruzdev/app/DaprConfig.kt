package com.github.mcruzdev.app;

import io.dapr.client.DaprClient;
import io.dapr.client.DaprClientBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class DaprConfig {

    @Bean
    fun daprClient(): DaprClient {
        return DaprClientBuilder()
            .build()
    }
}
