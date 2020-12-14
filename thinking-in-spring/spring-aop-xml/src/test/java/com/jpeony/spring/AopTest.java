package com.jpeony.spring;

import com.jpeony.spring.aop.ConferenceService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author yihonglei
 */
public class AopTest {

    @Test
    public void testAopXml() {
        // 根据配置文件创建IOC容器
        ApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext.xml");
        // 从容器中获取Bean
        ConferenceService conferenceService = (ConferenceService) context.getBean("conferenceService");
        // 调用Bean方法
        conferenceService.conference();
    }

}
