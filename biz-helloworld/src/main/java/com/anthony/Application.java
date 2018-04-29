package com.anthony;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.*;

@EnableEurekaClient
@SpringBootApplication
@RestController
public class Application {

    @Value("${server.port}")
    private String port;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @RequestMapping("helloWorld")
    public String helloWorld() {
        return "helloWorld from " + port;
    }

    @RequestMapping(value = {"complexHelloWorld/{message}", "complexHelloWorld"}, method = RequestMethod.GET)
    public String complexHelloWorld(@PathVariable(required = false) String message, @RequestParam(value = "param", required = false) String param) {
        String res = "ComplexHelloWorld from " +
                port;
        if (null != message)
            res += "\nmessage: " + message;

        if (null != param)
            res += "\nparam: " + param;

        return res;
    }

}
