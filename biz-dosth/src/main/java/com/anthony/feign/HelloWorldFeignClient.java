package com.anthony.feign;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

//value指向需要调用的服务
@FeignClient(value = "biz-helloworld")
public interface HelloWorldFeignClient {

    /**
     * RequestMapping和被调用的controller完全一样就可以了
     * 方法参数和返回值需要和被调接口一致
     */
    @RequestMapping(value = "/helloWorld")
    String helloWorld();


    /**
     * PathVariable要指定value
     * value中只能有一个值
     */
    @RequestMapping(value = "complexHelloWorld/{message}", method = RequestMethod.GET)
    String complexHelloWorld1(@PathVariable(value = "message",required = false) String message, @RequestParam(value = "param", required = false) String param);
    @RequestMapping(value = "complexHelloWorld", method = RequestMethod.GET)
    String complexHelloWorld2(@RequestParam(value = "param", required = false) String param);
}
