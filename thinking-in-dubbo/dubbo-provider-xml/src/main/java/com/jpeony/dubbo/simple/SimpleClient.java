package com.jpeony.dubbo.simple;

import com.alibaba.dubbo.config.ApplicationConfig;
import com.alibaba.dubbo.config.ReferenceConfig;
import com.jpeony.dubbo.service.ProviderService;

/**
 * @author yihonglei
 */
public class SimpleClient {

    public ProviderService buildRemoteService(String remoteUrl) {
        ReferenceConfig<ProviderService> referenceConfig = new ReferenceConfig<>();
        referenceConfig.setInterface(ProviderService.class);
        referenceConfig.setUrl(remoteUrl);
        referenceConfig.setApplication(new ApplicationConfig("client-app"));

        return referenceConfig.get();
    }

    public static void main(String[] args) {
        SimpleClient client = new SimpleClient();
        ProviderService providerService = client.buildRemoteService("dubbo://127.0.0.1:20880/com.jpeony.dubbo.service.ProviderService");
        System.out.println(providerService.sayHello("hello"));
    }
}
