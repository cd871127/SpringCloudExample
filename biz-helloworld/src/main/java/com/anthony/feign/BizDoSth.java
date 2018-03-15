package com.anthony.feign;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(value = "biz-dosth")
public interface BizDoSth {
    @RequestMapping(value = "/do/{message}")
    String helloWorld(@PathVariable(value = "message") String message);
}
