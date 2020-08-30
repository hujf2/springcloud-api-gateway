package com.baomidou.samples.druid.mybatis;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceAutoConfigure;
import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@EnableCircuitBreaker
@Slf4j
@EnableFeignClients
@EnableDiscoveryClient
@ComponentScan("com.baomidou.samples.druid.mybatis.*")
@SpringBootApplication(exclude  = DruidDataSourceAutoConfigure.class)
@MapperScan("com.baomidou.samples.druid.mybatis.mapper")
public class FeignCallApplication {

  @LoadBalanced
  @Bean
  public RestTemplate restTemplate() {
    return new RestTemplate();
  }


  public static void main(String[] args) {
    SpringApplication.run(FeignCallApplication.class, args);
  }

}