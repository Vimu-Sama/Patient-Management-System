package com.vimarsh.api_gateway.filter;

import io.netty.handler.codec.http.websocketx.extensions.WebSocketClientExtensionHandler;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.web.reactive.function.client.WebClient;

public class JwtValidationGatewayFilterFactory extends AbstractGatewayFilterFactory {

    private final WebClient webClient ;

    public JwtValidationGatewayFilterFactory(WebClient.Builder builder,
                                             @Value("${auth.service.url}") String authUrl){
        webClient = builder.baseUrl(authUrl).build() ;
    }


    @Override
    public GatewayFilter apply(Object config) {
        return null;
    }
}
