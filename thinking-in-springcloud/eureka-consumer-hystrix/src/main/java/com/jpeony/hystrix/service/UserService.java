package com.jpeony.hystrix.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * 用户服务
 *
 * @author yihonglei
 */
@Service
public class UserService {
    @Autowired
    private RestTemplate restTemplate;

    /**
     * 调用订单服务，查询用户订单信息
     */
    @HystrixCommand(fallbackMethod = "queryOrderInfoFallback")
    public String queryOrderInfo() {
        ResponseEntity<String> responseEntity =
                restTemplate.getForEntity("http://EUREKA-PROVIDER-ORDER/order/queryOrderInfo", String.class);

        return responseEntity.getBody();
    }

    /**
     * 当服务调不通时，会调用fallbackMethod对应的容错方法
     */
    public String queryOrderInfoFallback() {
        // 处理业务逻辑
        return "error-hystrix-test";
    }
}
