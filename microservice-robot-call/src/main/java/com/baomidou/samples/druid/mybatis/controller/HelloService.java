package com.baomidou.samples.druid.mybatis.controller;

import com.baomidou.samples.druid.mybatis.structrue.CallResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name="microservice-robot")
@Component
public interface HelloService {

    @RequestMapping(value = "/microservice-robot", method = RequestMethod.GET)
    public CallResult index();
}
