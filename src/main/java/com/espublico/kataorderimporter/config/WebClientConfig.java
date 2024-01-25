package com.espublico.kataorderimporter.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

/**
 * {@code WebClientConfig} is a Spring configuration class responsible for providing
 * a configured instance of {@code WebClient.Builder}.
 *
 * @author Andreu Aguilar
 * @version 1.0
 * @since 2024-01-22
 */
@Configuration
public class WebClientConfig {
	
	/**
     * Creates and returns a configured instance of {@code WebClient.Builder}.
     *
     * @return The configured {@code WebClient.Builder} instance.
     */
	@Bean
    public WebClient.Builder webClientBuilder() {
        return WebClient.builder();
    }

}
