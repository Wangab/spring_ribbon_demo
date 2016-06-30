package com.example;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * Created by wanganbang on 6/30/16.
 */
@Service
public class ComputService {
    private static final Logger loger = Logger.getLogger(ComputService.class);

    @Resource
    RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "fallBack")
    public String addService(){
        return restTemplate.getForObject("http://SERVICE-PROVIDER/add?A=1&B=2", String.class);
    }

    public String fallBack(){
        loger.warn("调用服务失败，短路器执行");
        return "service error";
    }
}
