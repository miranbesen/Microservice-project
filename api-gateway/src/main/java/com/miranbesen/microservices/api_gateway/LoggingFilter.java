package com.miranbesen.microservices.api_gateway;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

// @Component sayesinde Spring bu class'i otomatik olarak bean olarak olusturur.
@Component
// GlobalFilter, bu filter'in gateway'e gelen tum istekler icin calismasini saglar.
public class LoggingFilter implements GlobalFilter {

    // Bu logger, gateway'e gelen isteklerle ilgili bilgileri konsola/log dosyasina yazmak icin kullanilir.
    private Logger logger = LoggerFactory.getLogger(LoggingFilter.class);


    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        // exchange, gateway'e gelen HTTP istegini ve olusacak cevabi temsil eder.
        // Burada gelen istegin path bilgisi loglanir. Ornek: /currency-exchange/from/USD/to/TRY
        logger.info("Path of request received(alınan) -> {}", exchange.getRequest().getPath());
        // chain.filter(exchange), istegin gateway filter zincirindeki sonraki adima devam etmesini saglar.
        // Bu satir olmazsa istek ilgili servise yonlendirilmez.
        return chain.filter(exchange);
    }
}
