package com.miranbesen.microservices.currency_exchange_service;

import io.github.resilience4j.retry.annotation.Retry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class CircuitBreakerController {

    private Logger logger =
            LoggerFactory.getLogger(CircuitBreakerController.class);

    @GetMapping("/sample-api")
//    Retry: Basarisiz isteklerde sample-api ayarlarina gore metodu tekrar dener.
//    @Retry(name = "sample-api", fallbackMethod = "hardcodedResponse")
//    CircuitBreaker: Hata orani artarsa devreyi acar ve fallback cevabina yonlendirir.
//    @CircuitBreaker(name = "default", fallbackMethod = "hardcodedResponse")
//    RateLimiter: Belirli bir zaman araliginda kabul edilecek istek sayisini sinirlar.
//    @RateLimiter(name = "default")
//    Bulkhead: Ayni anda calisabilecek istek sayisini sinirlayarak sistemi korur.
//    @Bulkhead(name = "sample-api")
    public String sampleApi() {
        logger.info("Sample api call received");

        ResponseEntity<String> forEntity =
                new RestTemplate().getForEntity("http://localhost:8080/some-api",
                        String.class);

        return forEntity.getBody();
    }


    public String hardcodedResponse(Exception ex) {
        return "fallback-response";
    }
}
