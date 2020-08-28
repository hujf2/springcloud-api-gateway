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
public class MyController2 {



    @RequestMapping(value="/product", method={RequestMethod.GET})
    public CallResult orderLayer() throws Exception {
        Entry entry = null;

        try {
            entry = SphU.entry("testQPS1_orderLayer");
        } catch (BlockException e) {
            log.info("当前访问人数过多，请稍后重试！--orderLayer");
            return CallResult.failure("当前访问人数过多，请稍后重试！--orderLayer");
        } finally {
            if (entry != null){
                entry.exit();
            }
        }

        log.info("testQPS1 success!--orderLayer");
        return CallResult.success("testQPS1 success!--orderLayer");

    }
}

