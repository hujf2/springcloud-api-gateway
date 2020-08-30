package com.baomidou.samples.druid.mybatis.controller;

import com.baomidou.samples.druid.mybatis.controller.myuser.RemoteClientMyUser;
import com.baomidou.samples.druid.mybatis.service.message.JsoupService;
import com.baomidou.samples.druid.mybatis.structrue.CallResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Random;

@Slf4j
@RefreshScope
@RestController
public class MyController4 {



    @RequestMapping(value="/goodboy", method={RequestMethod.GET})
    public CallResult index() throws Exception {
        int timeOut = 0;
        Random random = new Random();
        timeOut = random.nextInt(150);

        Thread.sleep(timeOut);
        log.info("----测试hytrix特性-----这次休眠了 {} 秒",timeOut);
        return CallResult.success("----测试hytrix特性-----这次休眠了" + timeOut + " s");
    }
}

