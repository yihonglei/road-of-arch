package com.jpeony.springmvc.controller;
import java.util.Date;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;
/**
 * springMVC模型数据处理方式
 */
@Controller
@RequestMapping("/springDMD")
@SessionAttributes(value={"user"},types={String.class})
/**
 * 模型数据处理
 * @author yihonglei
 */
public class DealModelDataController {
    private static final String SUCCESS = "successModel";
    //1.================ModelAndView=============
    /**
     * 处理方法返回值类型为ModelAndView时，方法体可以通过该对象添加模型数据。
     */
    @RequestMapping("/testModelAndView")
    public ModelAndView testModelAndView() {
        String viewName = SUCCESS;//视图名字
        ModelAndView modelAndView = new ModelAndView();
        //通过setViewName指定跳转视图
        modelAndView.setViewName(viewName);
       //添加数据到ModelAndView中
        modelAndView.addObject("time", new Date());

        return modelAndView;
    }
    //2.================Map及Model================
    /**
     * 目标方法可以添加Map类型或Model类型的参数
     */
    @RequestMapping("/testMap")
    public String testMap(Map<String,Object> map) {
        map.put("username", "Make it");
        return SUCCESS;
    }
    //3.================@SessionAttributes========
    /**
     * 通过注解@SessionAttributes，根据属性名(user),或属性值类型(admin),
     * 把数据放在会话(session)中，实现数据共享
     *
     * 这里的键值user与类开头@SessionAttributes中的名字一致，把user对象放在session中，
     * 实现数据共享
     */
    @RequestMapping("/testSessionAttributes")
    public String testSessionAttributest(Map<String,Object> map) {
        map.put("user", "[username=hh,password=123456]");
        map.put("staff","admin");
        return SUCCESS;
    }
}
