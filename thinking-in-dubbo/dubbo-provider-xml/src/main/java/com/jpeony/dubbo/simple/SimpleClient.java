package com.jpeony.dubbo.simple;

import com.alibaba.dubbo.config.ApplicationConfig;
import com.alibaba.dubbo.config.ReferenceConfig;
import com.alibaba.dubbo.config.RegistryConfig;
import com.jpeony.dubbo.service.ProviderService;

/**
 * @author yihonglei
 */
public class SimpleClient {

    /**
     * 无注册中心
     */
    public ProviderService buildRemoteServiceOrigin(String remoteUrl) {
        ReferenceConfig<ProviderService> referenceConfig = new ReferenceConfig<>();
        referenceConfig.setInterface(ProviderService.class);
        referenceConfig.setUrl(remoteUrl);
        referenceConfig.setApplication(new ApplicationConfig("client-app"));

        return referenceConfig.get();
    }

    /**
     * 有注册中心，默认负载方式为随机调用
     */
    public ProviderService buildRemoteServiceRegistry() {
        ReferenceConfig<ProviderService> referenceConfig = new ReferenceConfig<>();
        referenceConfig.setInterface(ProviderService.class);
        referenceConfig.setApplication(new ApplicationConfig("client-app"));
        referenceConfig.setRegistry(new RegistryConfig("zookeeper://127.0.0.1:2181"));

        return referenceConfig.get();
    }

    public static void main(String[] args) {
        SimpleClient client = new SimpleClient();
        // 原始调用
//        ProviderService providerService = client.buildRemoteServiceOrigin("dubbo://127.0.0.1:20880/com.jpeony.dubbo.service.ProviderService");
        // 注册中心
        ProviderService providerService = client.buildRemoteServiceRegistry();
        System.out.println(providerService.sayHello("hello"));
    }
}
