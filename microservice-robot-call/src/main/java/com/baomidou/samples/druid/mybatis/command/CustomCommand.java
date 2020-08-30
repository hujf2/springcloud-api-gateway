package com.baomidou.samples.druid.mybatis.command;

import com.baomidou.samples.druid.mybatis.structrue.CallResult;
import com.netflix.hystrix.*;
import org.springframework.web.client.RestTemplate;

public class CustomCommand extends HystrixCommand<CallResult> {

    private RestTemplate restTemplate;

    @Override
    protected CallResult run() throws Exception {
        CallResult rs = restTemplate.getForObject("http://microservice-robot/microservice-robot/goodboy", CallResult.class);
        return rs;
    }

    @Override
    protected CallResult getFallback() {
        return CallResult.failure("服务降级了");
    }

    protected CustomCommand( RestTemplate restTemplate){
        super(
                Setter.withGroupKey(HystrixCommandGroupKey.Factory.asKey("study-hystrix"))
                         .andCommandKey(HystrixCommandKey.Factory.asKey("CallPhoneController"))
                         .andThreadPoolKey(HystrixThreadPoolKey.Factory.asKey("studyTheadPool"))
                         .andCommandPropertiesDefaults(HystrixCommandProperties.Setter()
                                                        .withExecutionTimeoutInMilliseconds(100)
                                                        .withCircuitBreakerSleepWindowInMilliseconds(5000))
                         .andThreadPoolPropertiesDefaults(HystrixThreadPoolProperties.Setter()
                                                           .withCoreSize(1)
                                                           .withMaxQueueSize(2)
                         )


        );
        this.restTemplate = restTemplate;
    }


}
