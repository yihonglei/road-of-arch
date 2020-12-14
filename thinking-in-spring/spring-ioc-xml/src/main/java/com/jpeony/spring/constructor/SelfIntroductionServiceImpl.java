package com.jpeony.spring.constructor;

import com.jpeony.spring.common.HelloService;

/**
 * @author yihonglei
 */
public class SelfIntroductionServiceImpl implements SelfIntroductionService {
    private HelloService helloService;

    /**
     * 构造器注入Bean
     */
    public SelfIntroductionServiceImpl(HelloService helloService) {
        this.helloService = helloService;
    }

    @Override
    public void selfIntroduction() {
        // 向大家打招呼
        helloService.sayHello("大家好!");
    }

}
