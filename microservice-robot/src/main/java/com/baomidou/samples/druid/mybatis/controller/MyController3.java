package com.baomidou.samples.druid.mybatis.controller;

import com.alibaba.csp.sentinel.Entry;
import com.alibaba.csp.sentinel.SphU;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.baomidou.samples.druid.mybatis.controller.myuser.RemoteClientMyUser;
import com.baomidou.samples.druid.mybatis.service.message.JsoupService;
import com.baomidou.samples.druid.mybatis.structrue.CallResult;
import com.baomidou.samples.druid.mybatis.utils.RobotUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.awt.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Slf4j
@RefreshScope
@RestController
public class MyController3 {


    @Autowired
    @Qualifier("skip")
    private List<String> skip;

    @Autowired
    JsoupService jsoupService;


    @SuppressWarnings("all")
    @Autowired
    RemoteClientMyUser remoteClientMyUser;



    @RequestMapping(value="", method={RequestMethod.GET})
    public CallResult index() throws Exception {
        return CallResult.success("----通过feign 调用33-----");
    }
}

