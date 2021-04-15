package com.jpeony.common;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public final class SpringBeanFactory implements ApplicationContextAware {
  private static ApplicationContext context;
  
  public static <T> T getBean(Class<T> c) {
    return (T)context.getBean(c);
  }
  
  public static <T> T getBean(String name, Class<T> clazz) {
    return (T)context.getBean(name, clazz);
  }
  
  @Override
  public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
    context = applicationContext;
  }
}