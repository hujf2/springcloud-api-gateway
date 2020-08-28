package com.baomidou.samples.druid.mybatis;

import com.alibaba.csp.sentinel.slots.block.RuleConstant;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRule;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRuleManager;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Configuration
public class FlowConfig {
    private static final String LIMIT_KEY = "testQPS1";

    @PostConstruct
    public void initFlowQpsRule(){

        FlowRule flowRule = new FlowRule();
        //设置QPS
        flowRule.setCount(1);
        flowRule.setRefResource(LIMIT_KEY);
        //对QPS限流
        flowRule.setGrade(RuleConstant.FLOW_GRADE_QPS);
        flowRule.setLimitApp("default");

        List<FlowRule> flowRuleList = new ArrayList<>();
        flowRuleList.add(flowRule);

        FlowRuleManager.loadRules(flowRuleList);
    }
}
