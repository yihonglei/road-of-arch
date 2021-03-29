package com.jpeony.dubbo.service.impl;

import com.jpeony.dubbo.service.ProviderService;

/**
 * xml 方式服务提供者实现类
 *
 * @author yihonglei
 */
public class ProviderServiceImpl implements ProviderService {
    @Override
    public String sayHello(String word) {
        return word;
    }
}
