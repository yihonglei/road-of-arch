package com.jpeony.order;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * order服务，FeignClient标注服务提供者信息
 *
 * @author yihonglei
 */
@FeignClient(name = "eureka-provider-order", fallback = OrderApiFallBack.class, path = "/order")
public interface OrderApi {

    @RequestMapping("/queryOrderInfo")
    String queryOrdersByUserId();

}