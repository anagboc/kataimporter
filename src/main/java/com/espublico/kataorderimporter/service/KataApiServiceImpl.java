package com.espublico.kataorderimporter.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.espublico.kataorderimporter.exception.ImporterException;
import com.espublico.kataorderimporter.model.ApiResponse;

import reactor.core.publisher.Mono;

/**
 * Implementation of the {@link KataApiService} interface.
 *
 * @author Andreu Aguilar
 * @version 1.0
 * @since 2024-01-22
 */
@Service
public class KataApiServiceImpl implements KataApiService {

	private static final Logger logger = LoggerFactory.getLogger(KataApiServiceImpl.class);
	
	private static final int MAX_RETRIES = 3;
    private static final long RETRY_INTERVAL_MILLIS = 6000;

	@Autowired
	private WebClient.Builder webClientBuilder;
	
	/**
     * Makes a synchronous API call and handles the response.
     *
     * @param apiUrl The URL of the API.
     * @return The API response.
     * @throws ImporterException if all retries fail.
     */
	public ApiResponse apiCall(String apiUrl) {
		
        for (int attempt = 1; attempt <= MAX_RETRIES; attempt++) {
            try {
                ApiResponse apiResponse = webClientBuilder.build().get().uri(apiUrl).retrieve()
                        .onStatus(status -> status.isError(),
                                clientResponse -> Mono.error(new ImporterException(
                                        "KataApiServiceImpl.apiCall(): Http Api response " + clientResponse.statusCode()
                                                + ", body: " + clientResponse.bodyToMono(String.class).block())))
                        .bodyToMono(ApiResponse.class).block();

                return apiResponse;
            } catch (Exception e) {
                String messageError = "KataApiServiceImpl.apiCall() - Attempt " + attempt + " failed: " + e.getMessage();
                logger.error(messageError);

                if (attempt < MAX_RETRIES) {
                    sleep(RETRY_INTERVAL_MILLIS);
                } else {
                    throw new ImporterException("All attempts to call API failed.");
                }
            }
        }
        return null;
    }
	

    private void sleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

}
