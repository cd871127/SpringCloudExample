package com.anthony.feign;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/")
public class HelloWorldController {

    @Value("${server.port}")
    private String port;

    @Resource
    private HelloWorldFeignClient helloWorldFeignClient;

    @RequestMapping("helloWorld")
    public String helloWorld() {

        return "helloWorld from" + port + "\n" + helloWorldFeignClient.helloWorld();
    }

    @RequestMapping(value = {"complexHelloWorld/{message}", "complexHelloWorld"}, method = RequestMethod.GET)
    public String complexHelloWorld(@PathVariable(required = false) String message, @RequestParam(value = "param", required = false) String param) {
        String res;
        if (message == null)
            res = helloWorldFeignClient.complexHelloWorld2(param);
        else
            res = helloWorldFeignClient.complexHelloWorld1(message, param);

        return "ComplexHelloWorld from " + port + "\n" + res;
    }
}
