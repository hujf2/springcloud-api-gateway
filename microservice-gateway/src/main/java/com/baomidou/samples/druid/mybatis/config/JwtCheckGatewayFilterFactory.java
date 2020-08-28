package com.baomidou.samples.druid.mybatis.config;

import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.http.HttpHeaders;
import org.springframework.http.server.reactive.ServerHttpResponse;
import reactor.core.publisher.Mono;


public class JwtCheckGatewayFilterFactory extends AbstractGatewayFilterFactory<JwtCheckGatewayFilterFactory.Config> {
    public JwtCheckGatewayFilterFactory(){
        super(Config.class);
    }

    @Override
    public GatewayFilter apply(Config config) {
        return (exchange, chain) -> {
            String jwtToken = exchange.getRequest().getHeaders().getFirst("Authorization");
            //
            if (jwtToken != null) {
                return chain.filter(exchange);
            }

            //
            ServerHttpResponse response = exchange.getResponse();
            //
            HttpHeaders httpHeaders = response.getHeaders();
            httpHeaders.add("Content-Type", "application/json; charset=UTF-8");
            httpHeaders.add("Content-Type", "no-store, no-cache, must-revalidate, max-age=0");
            //
            String warningStr = "未登录或登录超时";
            DataBuffer body = response.bufferFactory().wrap(warningStr.getBytes());
            return response.writeWith(Mono.just(body));

        };


    }




    public static class Config{
      //
    }












}
