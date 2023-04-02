package com.jpeony.zookeeper;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;

@SpringBootTest(classes = ZkApiApplication.class)
public abstract class AbstractSimpleTest extends AbstractTestNGSpringContextTests {

}
