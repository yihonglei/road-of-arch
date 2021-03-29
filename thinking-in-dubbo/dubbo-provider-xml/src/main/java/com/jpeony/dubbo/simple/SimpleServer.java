package com.jpeony.dubbo.simple;

import com.alibaba.dubbo.config.ApplicationConfig;
import com.alibaba.dubbo.config.ProtocolConfig;
import com.alibaba.dubbo.config.RegistryConfig;
import com.alibaba.dubbo.config.ServiceConfig;
import com.jpeony.dubbo.service.ProviderService;
import com.jpeony.dubbo.service.impl.ProviderServiceImpl;

/**
 * @author yihonglei
 */
public class SimpleServer {
    public void openService(int port) {
        // 服务配置
        ServiceConfig serviceConfig = new ServiceConfig();
        serviceConfig.setProtocol(new ProtocolConfig("dubbo", port));
        serviceConfig.setRegistry(new RegistryConfig("zookeeper://127.0.0.1:2181"));
        serviceConfig.setApplication(new ApplicationConfig("server-app"));
        serviceConfig.setInterface(ProviderService.class);
        serviceConfig.setRef(new ProviderServiceImpl());

        // 暴露服务
        serviceConfig.export();

        System.out.println("服务已开启：" + port);
    }

    public static void main(String[] args) {
        // port 如果传 -1，自动从 20880 开始递增，生成多个服务进程，实现集群效果，客服端可以通过 负载均衡自动调用
        new SimpleServer().openService(20880);

        try {
            Thread.sleep(100000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
