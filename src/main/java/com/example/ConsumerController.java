package com.example;

import org.apache.log4j.Logger;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * Created by wanganbang on 6/28/16.
 */

@RestController
public class ConsumerController {
    private static final Logger log = Logger.getLogger(SpringRibbonDemoApplication.class);

    @Resource
    ComputService computService;
    @Resource
    private DiscoveryClient client;

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public @ResponseBody String add(){
        log.info("add function running ... " + client.getServices());
        return  computService.addService();
    }
}
