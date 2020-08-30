package com.baomidou.samples.druid.mybatis.controller;

import com.baomidou.samples.druid.mybatis.structrue.CallResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RefreshScope
@RestController
public class CallController {

    @Autowired
    HelloService helloService;

    @RequestMapping(value="/index", method={RequestMethod.GET})
    public CallResult orderLayer() throws Exception {
       return helloService.index();
    }


}

