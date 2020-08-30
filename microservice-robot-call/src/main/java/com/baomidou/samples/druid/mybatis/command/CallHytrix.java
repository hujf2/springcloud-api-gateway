package com.baomidou.samples.druid.mybatis.command;

import com.baomidou.samples.druid.mybatis.structrue.CallResult;
import com.netflix.hystrix.HystrixCommandKey;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;



@Slf4j
@RefreshScope
@RestController
public class CallHytrix {

    @Autowired
    RestTemplate restTemplate;

    @RequestMapping(value="/goodboy", method={RequestMethod.GET})
    public CallResult orderLayer() throws Exception {
       return new CustomCommand(restTemplate).execute();
    }


    @RequestMapping(value="/goodboy2", method={RequestMethod.GET})
    @HystrixCommand(fallbackMethod = "hystrixErr",
            // 配置线程池
            threadPoolProperties = {
                    @HystrixProperty(name = "coreSize", value = "1"),
                    @HystrixProperty(name = "queueSizeRejectionThreshold", value = "1") },
            // 配置命令执行相关的，示例：超时时间
            commandProperties = {
                    @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "100") })
    public CallResult getDictList() {
        CallResult rs = restTemplate.getForObject("http://microservice-robot/microservice-robot/goodboy", CallResult.class);
        return rs;
    }


    public CallResult hystrixErr() {
        return CallResult.failure("降级2=----");
    }



}

